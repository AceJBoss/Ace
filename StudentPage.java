import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class StudentPage extends JFrame
{
	private JButton take,logout;
	private JLabel name,pix;
	private JPanel pan;
	private GridBagLayout layout;
	private GridBagConstraints cont;
	private String n,p;
	
	public StudentPage(String nam, String dp)
	{
		super("Student Page");
		layout = new GridBagLayout();
		cont = new GridBagConstraints();
		n = nam;
		p = dp;
		
		pan = new JPanel(layout);
		pan.setBackground(Color.WHITE);
		
		name = new JLabel("Welcome " + n);
		cont.fill = GridBagConstraints.HORIZONTAL;
		addComponent(name,0,0,1,1);
		pix = new JLabel();
		Image i = getToolkit().createImage(p);
		i = i.getScaledInstance(120,120,Image.SCALE_SMOOTH);
		pix.setIcon(new ImageIcon(i));
		addComponent(pix,1,0,4,1);
		
		take = new JButton("Take Test");
		take.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
			   new Test(n,p).setVisible(true);
			   StudentPage.super.dispose();
			}
			
		});
		addComponent(take, 0,1,1,1);
		logout = new JButton("Logout");
		logout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new Login().setVisible(true);
				StudentPage.super.dispose();
			}
		});
		addComponent(logout,1,1,1,1);
		
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
	public static void main(String [] args)
	{
		new StudentPage("Ismummy", "Project/images/admin.jpg").setVisible(true);
		
	}
}