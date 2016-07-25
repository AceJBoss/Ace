import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;

public class VQuestion extends JFrame
{
	private JTable table;
	private DefaultTableModel dtm;
	private JButton add, home;
	private GridBagLayout layout;
	private GridBagConstraints cont;
	private JPanel pan;
	private ArrayList<String[]> question;
	private int count;
	
	public VQuestion()
	{
		super("View Student");
		layout = new GridBagLayout();
		cont = new GridBagConstraints();
		question = new ArrayList<>();
		
		pan = new JPanel(layout);
		pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "View Students", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
		
		dtm = new DefaultTableModel();
		dtm.addColumn("S/N");
		dtm.addColumn("Question");
		dtm.addColumn("Option A");
		dtm.addColumn("Option B");
		dtm.addColumn("Option C");
		dtm.addColumn("Option D");
		dtm.addColumn("Answer");
		addRow();
		for(int i=0; i<question.size(); i++)
		{
			dtm.addRow(question.get(i));
		}
		table = new JTable(dtm);
		cont.gridwidth = GridBagConstraints.REMAINDER;
		cont.fill = GridBagConstraints.BOTH;
		addComponent(new JScrollPane(table));
		
		home = new JButton("Home");
		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new Admin().setVisible(true);
				VQuestion.super.dispose();
			}
		});
		cont.fill = GridBagConstraints.NONE;
		cont.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(home);
		add = new JButton("Add Question");
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new Question().setVisible(true);
				VQuestion.super.dispose();
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
			FileInputStream fis = new FileInputStream("project/files/question.txt");
			DataInputStream dis = new DataInputStream(fis);
			String [] record;
			while(true)
			{
				record  = new String[7];
				record[0] = "" + (++count);
				record[1] = dis.readUTF();
				record[2] = dis.readUTF();
				record[3] = dis.readUTF();
				record[4] = dis.readUTF();
				record[5] = dis.readUTF();
				record[6] = dis.readUTF();
				question.add(record);
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
		new VQuestion().setVisible(true);
		
	}
}