import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;

public class Student extends JFrame
{
	private JLabel fnam, lnam, mat,phon, mail, gen, pass, retry, error;
	private JTextField fname,lname, matric, phone, email;
	private JPasswordField password, rPass;
	private JComboBox gender;
	private JButton submit, reset, home;
	private GridBagLayout layout;
	private GridBagConstraints cont;
	private JPanel pan;
	private String [] sex = {"M","F"};
	private String pix;
	
	public Student()
	{
		super("Add Student");
		layout = new GridBagLayout();
		cont = new GridBagConstraints();
		
		pan = new JPanel(layout);
		pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Add Student", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
		
		fnam  = new JLabel("First Name: ");
		cont.fill = GridBagConstraints.BOTH;
		addComponent(fnam, 0,0,1,1);
		lnam = new JLabel("Last Name: ");
		addComponent(lnam, 1,0,1,1);
		mat = new JLabel("Matric No: ");
		addComponent(mat, 2,0,1,1);
		phon = new JLabel("Mobile No: ");
		addComponent(phon, 3,0,1,1);
		mail = new JLabel("Email Add: ");
		addComponent(mail, 4,0,1,1);
		gen = new JLabel("Select Sex: ");
		addComponent(gen, 5,0,1,1);
		pass = new JLabel("Password :");
		addComponent(pass ,6,0,1,1);
		retry = new JLabel("Retry Pass: ");
		addComponent(retry,7,0,1,1);
		error = new JLabel();
		error.setForeground(Color.RED);
		error.setHorizontalAlignment(JLabel.CENTER);
		addComponent(error,8,0,3,1);
		
		
		fname = new JTextField(10);
		fname.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
			
			}
			public void focusLost(FocusEvent fe)
			{
				if(!fname.getText().matches("[a-zA-Z]+"))
				{	
					fname.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				else
				{
					fname.setBackground(Color.white);
					error.setText("");
				}
			}
		});
		addComponent(fname,0,1,1,1);
		lname = new JTextField(10);
		lname.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
			
			}
			public void focusLost(FocusEvent fe)
			{
				if(!lname.getText().matches("[a-zA-Z]+([\\s'-\\.][a-zA-Z])*"))
				{	
					lname.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				else
				{
					lname.setBackground(Color.white);
					error.setText("");
				}
			}
		});
		addComponent(lname,1,1,1,1);
		matric = new JTextField(10);
		matric.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
			
			}
			public void focusLost(FocusEvent fe)
			{
				if(!matric.getText().matches("\\d{6}"))
				{	
					matric.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				else
				{
					matric.setBackground(Color.white);
					error.setText("");
				}
			}
		});
		addComponent(matric,2,1,1,1);
		phone = new JTextField(10);
		phone.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
			
			}
			public void focusLost(FocusEvent fe)
			{
				if(!phone.getText().matches("\\d{11}|\\+[2-9]\\d{12}|[2-9]\\d{12}"))
				{	
					phone.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				else
				{
					phone.setBackground(Color.white);
					error.setText("");
				}
			}
		});
		addComponent(phone,3,1,1,1);
		email = new JTextField(10);
		email.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
			
			}
			public void focusLost(FocusEvent fe)
			{
				if(!email.getText().matches("([a-zA-Z0-9]\\.*)+@([a-zA-Z]+\\.+)*[a-zA-Z]+\\.[a-zA-Z]+"))
				{	
					email.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				else
				{
					email.setBackground(Color.white);
					error.setText("");
				}
			}
		});
		addComponent(email,4,1,1,1);
		password = new JPasswordField(10);
		password.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
			
			}
			public void focusLost(FocusEvent fe)
			{
				if(!password.getText().matches("[a-zA-Z0-9]+"))
				{	
					password.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				else
				{
					password.setBackground(Color.white);
					error.setText("");
				}
			}
		});
		addComponent(password,6,1,1,1);
		rPass = new JPasswordField(10);
		rPass.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
			
			}
			public void focusLost(FocusEvent fe)
			{
				if(!rPass.getText().equals(password.getText()))
				{	
					rPass.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				else
				{
					rPass.setBackground(Color.white);
					error.setText("");
				}
			}
		});
		addComponent(rPass,7,1,1,1);
		
		gender = new JComboBox(sex);
		addComponent(gender,5,1,1,1);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(!fname.getText().matches("[a-zA-Z]+"))
				{	
					fname.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				if(!lname.getText().matches("[a-zA-Z]+([\\s'-\\.][a-zA-Z])*"))
				{	
					lname.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				if(!matric.getText().matches("\\d{6}"))
				{	
					matric.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				if(!phone.getText().matches("\\d{11}|\\+[2-9]\\d{12}|[2-9]\\d{12}"))
				{	
					phone.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				if(!email.getText().matches("([a-zA-Z0-9]\\.*)+@([a-zA-Z]+\\.+)*[a-zA-Z]+\\.[a-zA-Z]+"))
				{	
					email.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				if(!password.getText().matches("[a-zA-Z0-9]+"))
				{	
					password.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				if(!rPass.getText().equals(password.getText()))
				{	
					rPass.setBackground(Color.red);
					error.setText("error in field(s)");
				}
				
				if(error.getText().equals(""))
				{
					addRecord();
					fname.setText("");
					fname.setBackground(Color.white);
					lname.setText("");
					lname.setBackground(Color.white);
					matric.setText("");
					matric.setBackground(Color.white);
					phone.setText("");
					phone.setBackground(Color.white);
					email.setText("");
					email.setBackground(Color.white);
					password.setText("");
					password.setBackground(Color.white);
					rPass.setText("");
					rPass.setBackground(Color.white);
					error.setText("");
				}
			}
		});
		addComponent(submit,9,0,1,1);
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				fname.setText("");
				fname.setBackground(Color.white);
				lname.setText("");
				lname.setBackground(Color.white);
				matric.setText("");
				matric.setBackground(Color.white);
				phone.setText("");
				phone.setBackground(Color.white);
				email.setText("");
				email.setBackground(Color.white);
				password.setText("");
				password.setBackground(Color.white);
				rPass.setText("");
				rPass.setBackground(Color.white);
				error.setText("");
				
			}
		});
		addComponent(reset,9,1,1,1);
		home = new JButton("Home");
		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new Admin().setVisible(true);
				Student.super.dispose();
			}
		});
		addComponent(home,9,2,1,1);
		
		add(pan);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	private void addComponent(Component comp, int r, int c, int noc, int nor)
	{
		cont.gridx = c;
		cont.gridy = r;
		cont.gridwidth = noc;
		cont.gridheight = nor;
		layout.setConstraints(comp, cont);
		pan.add(comp);
	}
	private void addRecord()
	{
		try
		{	
			FileOutputStream fos = new FileOutputStream("project/files/student.txt", true);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF(fname.getText());
			dos.writeUTF(lname.getText());
			dos.writeUTF(matric.getText());
			dos.writeUTF(phone.getText());
			dos.writeUTF(email.getText());
			dos.writeUTF(sex[gender.getSelectedIndex()]);
			if(sex[gender.getSelectedIndex()].equals("M"))
				pix = "project/images/male.PNG";
			else
				pix = "project/images/female.PNG";
			dos.writeUTF(pix);
			dos.writeUTF(password.getText());
			dos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String []  args)
	{
		new Student().setVisible(true);
		
	}
}