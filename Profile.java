import java.awt.*;
import javax.swing.*;

public class Profile extends JPanel
{
	private JLabel pix,fn,ln,db,gender,phone,cour,dur,nation,stat,lg,edu;
	private JButton editProfile;
	private JTextField fName,lName,dob,sex,mobile,course,duration,nationality,state,local;
	private Image im;
	private JPanel pixPan,profilePan,editPan,logo;
	private ImageIcon log;
	
	public Profile()
	{
		setLayout(new BorderLayout());
		pixPan = new JPanel(new BorderLayout());
		pixPan.setBorder(BorderFactory.createEmptyBorder(10,10,10,20));
		pix = new JLabel();
		pix.setPreferredSize(new Dimension(110,120));
		pix.setHorizontalAlignment(JLabel.CENTER);
		im = getToolkit().createImage("images/pix.jpg");
		im = im.getScaledInstance(110,120,Image.SCALE_SMOOTH);
		pix.setIcon(new ImageIcon(im));
		pixPan.add(pix, BorderLayout.EAST);
		
		profilePan = new JPanel(new GridLayout(10,0,0,0));
		profilePan.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
		fn = new JLabel("<html><p style='color: red; font-size:10px'>First Name: </p></html>");
		ln = new JLabel("<html><p style='color: red; font-size:10px'>Last Name: </p></html>");
		db = new JLabel("<html><p style='color: red; font-size:10px'>Date Of Birth: </p></html>");
		gender = new JLabel("<html><p style='color: red; font-size:10px'>Gender: </p></html>");
		phone = new JLabel("<html><p style='color: red; font-size:10px'>Mobile no: </p></html>");
		cour = new JLabel("<html><p style='color: red; font-size:10px'>Course Offerring: </p></html>");
		dur = new JLabel("<html><p style='color: red; font-size:10px'>Course Duration: </p></html>");
		nation = new JLabel("<html><p style='color: red; font-size:10px'>Nationality: </p></html>");
		stat = new JLabel("<html><p style='color: red; font-size:10px'>State Of Origin: </p></html>");
		lg = new JLabel("<html><p style='color: red; font-size:10px'>Local Government Area: </p></html>");
		
		fName = new JTextField(10);
		fName.setEditable(false);
		lName = new JTextField(10);
		lName.setEditable(false);
		dob = new JTextField(10);
		dob.setEditable(false);
		sex = new JTextField(10);
		sex.setEditable(false);
		mobile = new JTextField(10);
		mobile.setEditable(false);
		course = new JTextField(10);
		course.setEditable(false);
		duration = new JTextField(10);
		duration.setEditable(false);
		nationality = new JTextField(10);
		nationality.setEditable(false);
		state = new JTextField(10);
		state.setEditable(false);
		local = new JTextField(10);
		local.setEditable(false);
		
		profilePan.add(fn);
		profilePan.add(fName);
		profilePan.add(ln);
		profilePan.add(lName);
		profilePan.add(db);
		profilePan.add(dob);
		profilePan.add(gender);
		profilePan.add(sex);
		profilePan.add(phone);
		profilePan.add(mobile);
		profilePan.add(cour);
		profilePan.add(course);
		profilePan.add(dur);
		profilePan.add(duration);
		profilePan.add(nation);
		profilePan.add(nationality);
		profilePan.add(stat);
		profilePan.add(state);
		profilePan.add(lg);
		profilePan.add(local);
		
		editPan = new JPanel();
		editPan.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		editProfile = new JButton("<html><p style='color: blue; font-style: bold; font-size:10px'>Edit Profile</p></html>");
		editProfile.setHorizontalAlignment(JButton.CENTER);
		editPan.add(editProfile);
		
		logo = new JPanel();
		log = new ImageIcon(getClass().getResource("images/edu.PNG"));
		edu = new JLabel();
		edu.setIcon(log);
		logo.add(edu);
		
		add(pixPan, BorderLayout.NORTH);
		add(profilePan, BorderLayout.CENTER);
		add(editPan, BorderLayout.SOUTH);
		add(logo, BorderLayout.EAST);
	}
	public static void main(String [] atrg)
	{
		JFrame aa = new JFrame("Profile");
		aa.setContentPane(new Profile());
		aa.pack();
		aa.setVisible(true);
	}
}