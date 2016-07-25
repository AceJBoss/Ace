import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;

public class Register extends JFrame
{
	private JPanel pan;
	private JLabel userL, passL, retryL,submitE;
	private JTextField user;
	private JPasswordField pass, retry;
	private JButton submit, reset;
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	
	public Register()
	{
		super("Registration Page");
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		
		pan = new JPanel(layout);
		pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED),"Register",TitledBorder.CENTER,TitledBorder.ABOVE_TOP));
		
		userL = new JLabel("Username: ");
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(userL, 0,0,1,1);
		passL = new JLabel("Password: ");
		addComponent(passL, 1,0,1,1);
		retryL = new JLabel("Retry Pass: ");
		addComponent(retryL, 2,0,1,1);
		submitE = new JLabel();
		submitE.setForeground(Color.RED);
		submitE.setHorizontalAlignment(JLabel.CENTER);
		addComponent(submitE,3,0,1,2);
		
		user = new JTextField(10);
		user.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
			
			}
			public void focusLost(FocusEvent fe)
			{
				if(!user.getText().matches("[a-zA-Z0-9]+"))
				{
					user.setBackground(Color.RED);
					submitE.setText("Error in field(s)");
				}
				else
				{
					user.setBackground(Color.WHITE);
					submitE.setText("");
				}
			}
		});
		addComponent(user,0,1,1,1);
		pass = new JPasswordField(10);
		pass.setEchoChar('@');
		pass.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
			
			}
			public void focusLost(FocusEvent fe)
			{
				if(!pass.getText().matches("[a-zA-Z0-9]+"))
				{
					pass.setBackground(Color.RED);
					submitE.setText("Error in field(s)");
				}
				else
				{
					pass.setBackground(Color.WHITE);
					submitE.setText("");
				}
			}
		});
		addComponent(pass,1,1,1,1);
		retry = new JPasswordField(10);
		retry.setEchoChar('@');
		retry.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
			
			}
			public void focusLost(FocusEvent fe)
			{
				if(!retry.getText().equals(pass.getText()))
				{
					retry.setBackground(Color.RED);
					submitE.setText("Error in field(s)");
				}
				else
				{
					retry.setBackground(Color.WHITE);
					submitE.setText("");
				}
			}
		});
		addComponent(retry, 2,1,1,1);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(user.getText().matches("[a-zA-Z0-9]+"))
				{
					if(pass.getText().matches("[a-zA-Z0-9]+"))
					{
						if(retry.getText().equals(pass.getText()))
						{
							//what to do
							try
							{
								FileOutputStream fos = new FileOutputStream("files/Register.txt", true);
								DataOutputStream dos = new DataOutputStream(fos);
								dos.writeUTF(user.getText());
								dos.writeUTF(pass.getText());
								dos.close();
								
								user.setText("");
								pass.setText("");
								retry.setText("");
								submitE.setText("");
								user.setBackground(Color.WHITE);
								pass.setBackground(Color.WHITE);
								retry.setBackground(Color.WHITE);
							}
							catch(Exception e)
							{	
								e.printStackTrace();
							}
							
						}
						else
						{
							retry.setBackground(Color.RED);
							submitE.setText("Error in field(s)");
						}
					}
					else
					{
						pass.setBackground(Color.RED);
						submitE.setText("Error in field(s)");
					}
				}
				else
				{
					user.setBackground(Color.RED);
					submitE.setText("Error in field(s)");
				}
				
			}
		});
		addComponent(submit, 4,0,1,1);
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				user.setText("");
				pass.setText("");
				retry.setText("");
				submitE.setText("");
				user.setBackground(Color.WHITE);
				pass.setBackground(Color.WHITE);
				retry.setBackground(Color.WHITE);
			}
		});
		addComponent(reset, 4,1,1,1);
		
		add(pan);
	}
	private void addComponent(Component comp, int y, int x, int nor, int noc)
	{
		constraints.gridy = y;
		constraints.gridx = x;
		constraints.gridwidth = noc;
		constraints.gridheight = nor;
		layout.setConstraints(comp, constraints);
		pan.add(comp);
	}
	public static void main(String [] args)
	{
		Register a = new Register();
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.pack();
		a.setLocationRelativeTo(null);
	}
}