import javax.swing.*;
import java.awt.Color;

public class GUIDemo extends JApplet
{
	JLabel title,userLabel,passLabel;
	JTextField username;
	JPasswordField password;
	JButton reset,login;
	JPanel panel;
	
	public void init()
	{
		title = new JLabel("Welcome to Our Login Page GUI Demo");
		title.setForeground(Color.white);
		userLabel = new JLabel("Username:");
		passLabel = new JLabel("Password:");
		username = new JTextField(15);
		password = new JPasswordField(15);
		reset = new JButton("Reset");
		login = new JButton("Login");
		panel = new JPanel();
		panel.setOpaque(true);
		panel.setBackground(Color.BLUE);
		//panel.add(title);
		panel.add(userLabel);
		panel.add(username);
		panel.add(passLabel);
		panel.add(password);
		panel.add(reset);
		panel.add(login);
		add(panel);
	}
}









