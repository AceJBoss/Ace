import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class Login extends JFrame
{
	private JLabel mat, pass,error;
	private JTextField matric;
	private JPasswordField password;
	private JButton login, reset;
	private GridBagLayout layout;
	private GridBagConstraints cont;
	private JPanel pan;
	private ArrayList<String[]> student;
	
	public Login()
	{
		super("Login Page");
		layout = new GridBagLayout();
		cont = new GridBagConstraints();
		student = new ArrayList<>();
		addRow();
		
		pan = new JPanel(layout);
		pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Login Page", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
			
		mat = new JLabel("Matric No: ");
		cont.fill = GridBagConstraints.BOTH;
		addComponent(mat,0,0,1,1);
		pass = new JLabel("Password: ");
		addComponent(pass,1,0,1,1);
		error = new JLabel();
		error.setHorizontalAlignment(JLabel.CENTER);
		error.setForeground(Color.red);
		addComponent(error,2,0,1,2);
		
		matric = new JTextField(10);
		addComponent(matric,0,1,1,1);
		password = new JPasswordField(10);
		addComponent(password,1,1,1,1);
		
		login = new JButton("Login");
		login.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(matric.getText().equals("admin") && password.getText().equals("12345"))
				{
					new Admin().setVisible(true);
					Login.super.dispose();
				}
				else
				{
					for(int i= 0; i< student.size(); i++)
					{
						if(student.get(i)[1].equals(matric.getText()) && student.get(i)[3].equals(password.getText()))
						{
							new StudentPage(student.get(i)[0], student.get(i)[2]).setVisible(true);
							Login.super.dispose();
							break;
						}
						if(!(student.get(student.size()-1)[1].equals(matric.getText()) && student.get(student.size()-1)[3].equals(password.getText())))
							error.setText("Invalid Matric / password");
					}
				}
			}
		});
		addComponent(login,3,0,1,1);
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				matric.setText("");
				password.setText("");
				error.setText("");
			}
		});
		addComponent(reset,3,1,1,1);
		
		add(pan);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	private void addComponent(Component comp, int y, int x, int nor, int noc )
	{
		cont.gridy = y;
		cont.gridx = x;
		cont.gridwidth = noc;
		cont.gridheight = nor;
		layout.setConstraints(comp, cont);
		pan.add(comp);
	}
	public static void main(String [] arg)
	{
		new Login().setVisible(true);
	}
	private void addRow()
	{
		try
		{
			FileInputStream fis = new FileInputStream("project/files/student.txt");
			DataInputStream dis = new DataInputStream(fis);
			String [] record;
			while(true)
			{
				record = new String[4];
				record[0] = dis.readUTF();
				dis.readUTF();
				record[1] = dis.readUTF() ;
				dis.readUTF();
				dis.readUTF();
				dis.readUTF();
				record[2] = dis.readUTF();
				record[3] = dis.readUTF();
				student.add(record);
			}
		}
		catch(EOFException e)
		{
			return;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}