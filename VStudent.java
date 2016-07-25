import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;

public class VStudent extends JFrame
{
	private JTable table;
	private DefaultTableModel dtm;
	private JButton add, home;
	private GridBagLayout layout;
	private GridBagConstraints cont;
	private JPanel pan;
	private ArrayList<String[]> student ;
	private int count;
	
	public VStudent()
	{
		super("View Student");
		layout = new GridBagLayout();
		cont = new GridBagConstraints();
		student = new ArrayList<>();
		
		pan = new JPanel(layout);
		pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "View Students", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
		
		dtm = new DefaultTableModel();
		dtm.addColumn("S/N");
		dtm.addColumn("Full Name");
		dtm.addColumn("Matric No");
		dtm.addColumn("Mobile No");
		dtm.addColumn("Email");
		dtm.addColumn("Sex");
		dtm.addColumn("Password");
		addRow();
		for(int i=0; i<student.size(); i++)
		{
			dtm.addRow(student.get(i));
			
		}
		table = new JTable(dtm);
		cont.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(new JScrollPane(table));
		
		home = new JButton("Home");
		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new Admin().setVisible(true);
				VStudent.super.dispose();
			}
		});
		cont.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(home);
		add = new JButton("Add Student");
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new Student().setVisible(true);
				VStudent.super.dispose();
			}
		});
		cont.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(add);
		
		add(pan);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	private void addComponent(Component comp)
	{
		layout.setConstraints(comp, cont);
		pan.add(comp);
	}
	private void addRow()
	{
		try
		{
			FileInputStream fis = new FileInputStream("project/files/student.txt");
			DataInputStream dis = new DataInputStream(fis);
			String [] record;
			while(true)
			{
				record = new String[7];
				record[0] = "" + (++count);
				record[1] = dis.readUTF() + "  " + dis.readUTF();
				record[2] = dis.readUTF();
				record[3] = dis.readUTF();
				record[4] = dis.readUTF();
				record[5] = dis.readUTF();
				dis.readUTF();
				record[6] = dis.readUTF();
				student.add(record);
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
	public static void main(String []  args)
	{
		new VStudent().setVisible(true);
		
	}
}