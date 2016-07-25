import javax.swing.*;
import java.awt.*;

public class DemoClass extends JFrame
{
	JLabel fn,mn,pass,gender,ageLabel;
	JTextField name,matric,password,age;
	JRadioButton male,female;
	JButton submit,cancel;
	ButtonGroup bg;
	JPanel rb;
	
	public DemoClass()
	{
		super("Registration Page");
		fn = new JLabel("Fullname:");
		mn = new JLabel("Matric No.:");
		pass = new JLabel("Password:");
		gender = new JLabel("Gender");
		ageLabel = new JLabel("Age:");
		name = new JTextField(20);
		matric = new JTextField(20);
		password = new JTextField(20);
		age = new JTextField(20);
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		submit = new JButton("Submit");
		cancel = new JButton("Cancel");
		bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);
		rb = new JPanel();
		rb.add(male);
		rb.add(female);
		
		GridLayout layout = new GridLayout(0,2);
		setLayout(layout);
		add(fn);
		add(name);
		add(mn);
		add(matric);
		add(pass);
		add(password);
		add(gender);
		add(rb);
		add(ageLabel);
		add(age);
		add(submit);
		add(cancel);
	}
	public static void main(String [] arg)
	{
		DemoClass app = new DemoClass();
		app.pack();
		app.setVisible(true);
	}
}




