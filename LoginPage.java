import java.awt.*;
import javax.swing.*;

public class LoginPage extends JInternalFrame
{
	private ImageIcon std,lct,adm,dft;
	private JLabel current,dp,dftl;
	
	
	public LoginPage(String lm, String un)
	{
		super(lm.toUpperCase() + " PAGE", false,false,false);
		current = new JLabel("WELCOOME TO "+ lm.toUpperCase() + " PAGE "+ un.toUpperCase());
		current.setHorizontalAlignment(JLabel.CENTER);
		dp = new JLabel();
		std = new ImageIcon(getClass().getResource("images/h.jpg")); 
		lct = new ImageIcon(getClass().getResource("images/b.jpg"));
		adm = new ImageIcon(getClass().getResource("images/c.jpg"));
		if(lm.equalsIgnoreCase("admin"))
		  adminPage();
		 else if(lm.equalsIgnoreCase("student"))
			studentPage();
		else if(lm.equalsIgnoreCase("instructor"))
			instructorPage();
		else
			defaultPage();
		
		
		
		
	}
	public void defaultPage()
	{
		dftl = new JLabel();
		dft = new ImageIcon(getClass().getResource("images/f.jpg")); 
		dftl.setIcon(dft);
		add(dftl, BorderLayout.CENTER);
	}
	private void studentPage()
	{
	
		JTabbedPane pane = new JTabbedPane();
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p2 = new JPanel();
		TakeTest test = new TakeTest();
		test.setBounds(0,0,pane.getWidth(),pane.getHeight());
		Profile profile = new Profile();
		profile.setBounds(0,0,pane.getWidth(),pane.getHeight());
		
		dp.setIcon(std);
		p.add(current, BorderLayout.NORTH);
		p.add(dp, BorderLayout.CENTER);
		
		pane.addTab("Student Profile", profile);
		pane.addTab("EBook & References", p1);
		pane.addTab("Course Outline", p2);
		pane.addTab("Take Test", test);
		add(pane);
	
	}
	private void adminPage()
	{
		JTabbedPane pane = new JTabbedPane();
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p2 = new JPanel();
		
		dp.setIcon(adm);
		p.add(current, BorderLayout.NORTH);
		p.add(dp, BorderLayout.CENTER);
		
		pane.addTab("Admin Profile", p);
		pane.addTab("Add Instructor/Student", p1);
		pane.addTab("Add Course", p2);
		pane.addTab("Instructors/Students", p3);
		add(pane);
	}
	private void instructorPage()
	{
		JTabbedPane pane = new JTabbedPane();
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p2 = new JPanel();
		
		dp.setIcon(lct);
		p.add(current, BorderLayout.NORTH);
		p.add(dp, BorderLayout.CENTER);
		
		pane.addTab("Lecturer Profile", p);
		pane.addTab("Add EMaterials", p1);
		pane.addTab("Add Course Outline", p2);
		pane.addTab("Students", p3);
		add(pane);
	}
}