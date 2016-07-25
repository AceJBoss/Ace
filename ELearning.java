import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import java.util.*;


public class ELearning extends JFrame
{

private JSplitPane jsp;
private static JDesktopPane jdp;
private JPanel header,footer,content,lContent;
private JButton login,reset;
private JTextField userName;
private JPasswordField password;
private JLabel user,pass,foot,head,option,lim;
private JComboBox userOption;
private String [] options  = {"  ","Admin","Instructor","Student"};
private ImageIcon limg;
private Image ban;
private Boolean authenticated = false;
private String loginMode = "";
private String [] adminUser = {"admin1"};
private String [] adminPass = {"12345"};
private String [] studentUser = {"std1"};
private String [] studentPass = {"12345"};
private String [] instructorUser = {"inst1"};
private String [] instructorPass = {"12345"};

public ELearning()
{
	setSize(900,650);
	setLocation(200,25);
	//setResizable(false);
	
	
	//header option
	setUndecorated(true);
	header = new JPanel();
	head = new JLabel();
	ban = getToolkit().createImage("images/ban.jpg");
	ban = ban.getScaledInstance(getWidth(),100,Image.SCALE_SMOOTH);
	head.setIcon(new ImageIcon(ban));
	header.add(head);
	
	
	//body options
	jsp = new JSplitPane();
	lContent = new JPanel(new BorderLayout());
	lContent.setPreferredSize(new Dimension(250, getHeight()-150));
	jdp = new JDesktopPane();
	jdp.setBounds(0,0,getWidth()-250, getHeight()-150);
	jsp.setTopComponent(lContent);
	jsp.setBottomComponent(jdp);
	
	
	
	//lContent option
	content = new JPanel(new GridLayout(4,2,2,0));
	option = new JLabel("Select Login Option: ");
	userOption = new JComboBox(options);
	user = new JLabel(options[0] + " Username:");
	userName = new JTextField(10);
	pass = new JLabel(options[0] + " Password:");
	password = new JPasswordField(10);
	password.addKeyListener(new KeyAdapter()
	{
		public void keyPressed(KeyEvent ke)
		{
			if(KeyEvent.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Enter"))
			{
				authenticated = false;
				verifyLogin(loginMode, userName.getText(), password.getText());
				if(authenticated)
				{
					setContent();
					userName.setText("");
					password.setText("");
					loginLcontent();
				}
			}
		}
	});
	login = new JButton("Login");
	reset = new JButton("Reset");
	lim = new JLabel();
	limg = new ImageIcon(getClass().getResource("images/kk.jpg"));
	lim.setIcon(limg);
	
	content.add(option);
	content.add(userOption);
	content.add(user);
	content.add(userName);
	content.add(pass);
	content.add(password);
	content.add(login);
	content.add(reset);
	lContent.add(content,BorderLayout.NORTH);
	lContent.add(lim, BorderLayout.CENTER);
	content.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED),"Login Page", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
	
	//selectbox optiion
	userOption.addItemListener(new ItemListener()
	{
		public void itemStateChanged(ItemEvent ev)
		{
		
			if(ev.getStateChange() == ItemEvent.SELECTED )
			  user.setText(options[userOption.getSelectedIndex()] + " Username:");
			  pass.setText(options[userOption.getSelectedIndex()] + " Password:");
			  loginMode = options[userOption.getSelectedIndex()] ;
			  
		}
	}
	);
	
	//loginEvent Option
	login.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ev)
		{
			authenticated = false;
			verifyLogin(loginMode, userName.getText(), password.getText());
			if(authenticated)
				{
					setContent();
					userName.setText("");
					password.setText("");
					loginLcontent();
				}

				
		}
	});
	
	//resetEvent option
	reset.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ev)
		{
			userName.setText("");
			password.setText("");
		}
	});
	
	
	//footer Option
	footer = new JPanel();
	foot = new JLabel("<html>&copy;2014</html>");
	footer.add(foot);
	
	setContent();
	
	//add panels
	add(header, BorderLayout.NORTH);
	add(jsp, BorderLayout.CENTER);
	add(footer, BorderLayout.SOUTH);
	
}

private void verifyLogin(String lm, String un, String pw)
{
	if(lm.equalsIgnoreCase("Admin"))
	for(int i = 0; i< adminUser.length; i++)
	{
		if(adminUser[i].equalsIgnoreCase(un) && adminPass[i].equalsIgnoreCase(pw))
			authenticated = true;
		
	}
	else if(lm.equalsIgnoreCase("Student"))
	for(int i = 0; i< studentUser.length; i++)
	{
		if(studentUser[i].equalsIgnoreCase(un) && studentPass[i].equalsIgnoreCase(pw))
			authenticated = true;
		
	} 
	else
	for(int i = 0; i< instructorUser.length; i++)
	{
		if(instructorUser[i].equalsIgnoreCase(un) && instructorPass[i].equalsIgnoreCase(pw))
			authenticated = true;
		
	} 
	
	

}
private void loginLcontent()
{

	JButton logout = new JButton("Logout");
	JPanel logp = new JPanel();
	logp.add(logout);
	lContent.remove(content);
	lContent.add(logp, BorderLayout.NORTH);
	logout.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ev)
		{
			lContent.remove(logp);
			lContent.add(content, BorderLayout.NORTH);
			loginMode = "";
			userName.setText("");
			setContent();
			repaint();
		}
	});
}

private void setContent()
{
		LoginPage lp = new LoginPage(loginMode, userName.getText());
		Dimension size;
		ELearning.jdp.removeAll();
		size = ELearning.jdp.getSize();
		lp.setBounds(0,0, size.width, size.height);
		lp.setVisible(true);
		ELearning.jdp.add(lp);

}
/* private void addUser(String mode, String name, String pass)
{
	if(mode.equalsIgnoreCase("admin"))
	{
		adminUser.add(name);
		adminPass.add(pass);
	}
	else if(mode.equalsIgnoreCase("student"))
	{
		studentUser.add(name);
		studentPass.add(pass);
	}
	else if(mode.equalsIgnoreCase("instructor"))
	{
		instructorUser.add(name);
		instructorPass.add(pass);
	}
} */


public static void main(String [] args)
{
	new ELearning().setVisible(true);
}}