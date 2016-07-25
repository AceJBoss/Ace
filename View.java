import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;

public class View extends JFrame
{
	private JTextArea view;
	private JButton button;
	private JPanel pan;
	private GridBagLayout layout;
	private GridBagConstraints cont;
	
	public View()
	{
		super("View");
		layout = new GridBagLayout();
		cont = new GridBagConstraints();
		
		pan = new JPanel(layout);
		
		view = new JTextArea(5,15);
		view.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED),"View", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
		view.setEditable(false);
		cont.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(new JScrollPane(view));
		
		button = new JButton("View");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					FileInputStream fis = new FileInputStream("files/Register.txt");
					DataInputStream dis = new DataInputStream(fis);
					while(true)
					{
						String user = dis.readUTF();
						String pass = dis.readUTF();
						view.append(user +"\t"+ pass +"\n");
					}
				}
				catch(EOFException e)
				{
					return;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		cont.gridwidth = 1;
		addComponent(button);
		add(pan);
	}
	private void addComponent(Component comp)
	{
		layout.setConstraints(comp, cont);
		pan.add(comp);
	}
	public static void main(String [] args)
	{
		View a = new View();
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.pack();
		a.setLocationRelativeTo(null);
	}
}