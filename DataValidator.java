import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class DataValidator extends JFrame implements ActionListener
{
	private JLabel fname,lname,matric,phone,email,fnameP,lnameP,matricP,phoneP,emailP;
	private JTextField fnameF,lnameF,matricF,phoneF,emailF;
	private JButton save;
	private JPanel button,data;
	public FileOutputStream fos;
	public DataOutputStream dos;
	private ArrayList<String[]> rec = new ArrayList<>();
    int count;	
	
	public DataValidator()
	{
		super("Bio-Data Validator");
		try
		{
			fos = new FileOutputStream("files\DEMO.txt",true);
			dos = new DataOutputStream(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		data = new JPanel(new GridLayout(5,3,2,0));
		
		fname = new JLabel("Fist Name: ");
		lname = new JLabel("Last Name: ");
		matric = new JLabel("Matric No: ");
		phone = new JLabel("Mobile No: ");
		email = new JLabel("Email Address: ");
		
		fnameP = new JLabel();
		lnameP = new JLabel();
		matricP = new JLabel();
		phoneP = new JLabel();
		emailP = new JLabel();
		fnameP.setForeground(Color.RED);
		lnameP.setForeground(Color.RED);
		matricP.setForeground(Color.RED);
		phoneP.setForeground(Color.RED);
		emailP.setForeground(Color.RED);
		
		fnameF = new JTextField(10);
		fnameF.addKeyListener(new KeyAdapter()
		{
			
			public void keyReleased(KeyEvent ke)
			{
				fnameP.setText("");
				if(!fnameF.getText().matches("[a-zA-Z]+"))
					fnameP.setText("Invalid Input!");
			}
		});
		lnameF = new JTextField(10);
		lnameF.addKeyListener(new KeyAdapter()
		{
			
			public void keyReleased(KeyEvent ke)
			{
				lnameP.setText("");
				if(!lnameF.getText().matches("[a-zA-Z]+([\\s'-\\.][a-zA-Z])*"))
					lnameP.setText("Invalid Input!");
			}
		});
		matricF = new JTextField(10);
		matricF.addKeyListener(new KeyAdapter()
		{
			
			public void keyReleased(KeyEvent ke)
			{
				matricP.setText("");
				if(!matricF.getText().matches("\\d{6}"))
					matricP.setText("Invalid Matric!");
			}
		});
		phoneF = new JTextField(10);
		phoneF.addKeyListener(new KeyAdapter()
		{
			
			public void keyReleased(KeyEvent ke)
			{
				phoneP.setText("");
				if(!phoneF.getText().matches("\\d{11}|\\+[2-9]\\d{12}|[2-9]\\d{12}"))
					phoneP.setText("Invalid Phone no!");
			}
		});
		emailF = new JTextField(10);
		emailF.addKeyListener(new KeyAdapter()
		{
			
			public void keyReleased(KeyEvent ke)
			{
				emailP.setText("");
				if(!emailF.getText().matches("([a-zA-z0-9]\\.*)+@([a-zA-Z]+\\.+)*[a-zA-Z]+\\.[a-zA-Z]+"))
					emailP.setText("Invalid Email!");
			}
		});
		
		data.add(fname);
		data.add(fnameF);
		data.add(fnameP);
		data.add(lname);
		data.add(lnameF);
		data.add(lnameP);
		data.add(matric);
		data.add(matricF);
		data.add(matricP);
		data.add(phone);
		data.add(phoneF);
		data.add(phoneP);
		data.add(email);
		data.add(emailF);
		data.add(emailP);
		
		button = new JPanel();
		save = new JButton("Validate and Save");
		save.addActionListener(this);
		button.add(save);
		
		add(data, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
	}
	public void addRec()
	{
		String [] rec = new String[5];
		
		rec[0] = fnameF.getText();
		rec[1] = lnameF.getText();
		rec[2] = matricF.getText();
		rec[3] = phoneF.getText();
		rec[4] = emailF.getText();
		this.rec.add(rec);
		try
		{
			for(int i=0; i< this.rec.get(count).length; i++)
			{
				dos.writeUTF(this.rec.get(count)[i]);
			}
			
			JOptionPane.showMessageDialog(null,"YES");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String [] args)
	{
		DataValidator aa = new DataValidator();
		aa.pack();
		aa.setVisible(true);
		aa.setLocationRelativeTo(null);
		aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(fnameF.getText().matches("[a-zA-Z]+"))
		{
			if(lnameF.getText().matches("[a-zA-Z]+([\\s'-\\.][a-zA-Z])*"))
			{
				if(matricF.getText().matches("\\d{6}"))
				{
					if(phoneF.getText().matches("\\d{11}|\\+[2-9]\\d{12}|[2-9]\\d{12}"))
					{
						if(emailF.getText().matches("([a-zA-z0-9]\\.*)+@([a-zA-Z]+\\.+)*[a-zA-Z]+\\.[a-zA-Z]+"))
						{
							try
							{
								addRec();
								count++;
								// final Formatter a = new Formatter("files/"+matricF.getText()+".txt");
								// a.format("%s %s %s %s %s", fnameF.getText(),lnameF.getText(),matricF.getText(),phoneF.getText(),emailF.getText());
								// a.close();
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						else
							emailP.setText("Invalid Email!");
					}
					else
						phoneP.setText("Invalid Phone No!");
				}
				else
					matricP.setText("Invalid Matric!");
			}
			else
				lnameP.setText("Invalid Input!");
		}
		else 
			fnameP.setText("Invalid Input!");
	}
}