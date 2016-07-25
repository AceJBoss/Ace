import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Admin extends JFrame
{
	private JButton aStudent, aQuestion, vStudent, vQuestion, logout;
	private JLabel welcome, pix;
	private GridBagLayout layout;
	private GridBagConstraints cont;
	private JPanel pan;
	
	public Admin()
	{
		super("Admin Page");
		layout = new GridBagLayout();
		cont = new GridBagConstraints();
		
		pan = new JPanel(layout);
		pan.setBackground(Color.WHITE);
		
		welcome = new JLabel("Welcome to Admin Page ");
		cont.fill = GridBagConstraints.BOTH;
		cont.weightx = 1;
		cont.weighty = 1;
		addComponent(welcome, 0,0,1,1);
		
		pix = new JLabel();
		Image im = getToolkit().createImage("Project/images/admin.jpg");
		im = im.getScaledInstance(a);
		pix.setIcon(new ImageIcon(im));
		addComponent(pix, 1,0, 4,1);
		
		aStudent = new JButton("Add Student");
		aStudent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new Student().setVisible(true);
				Admin.super.dispose();
			}
		});
		addComponent(aStudent, 0,1,1,1);
		
		aQuestion = new JButton("Add Question");
		aQuestion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new Question().setVisible(true);
				Admin.super.dispose();
			}
		});
		addComponent(aQuestion, 1,1,1,1);
		
		vStudent = new JButton("View Students");
		vStudent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new VStudent().setVisible(true);
				Admin.super.dispose();
			}
		});
		addComponent(vStudent,2,1,1,1);
		
		vQuestion = new JButton("View Questions");
		vQuestion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new VQuestion().setVisible(true);
				Admin.super.dispose();
			}
		});
		addComponent(vQuestion, 3,1,1,1);
		
		logout = new JButton("Logout");
		logout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new Login().setVisible(true);
				Admin.super.dispose();
			}
		});
		addComponent(logout, 4,1,1,1);
		
		add(pan);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	private void addComponent(Component comp, int r, int c, int nor, int noc)
	{
		cont.gridy = r;
		cont.gridx = c;
		cont.gridwidth = noc;
		cont.gridheight = nor;
		layout.setConstraints(comp, cont);
		pan.add(comp);
	}
	public static void main(String [] args)
	{
		new Admin().setVisible(true);
		
	}
}