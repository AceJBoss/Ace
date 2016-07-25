import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

public class TableD extends JFrame
{

	private JLabel mat,title,no,sex;
	private JPanel p1,p2,p3,pall;
	private JButton add, delete, submit;
	private JTextField matF,phoneF,sexF;
	private JScrollPane scrollPane;
	private DefaultTableModel dtm;
	private JTable tab;
	public TableD()
	{
	
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		pall = new JPanel();
		setSize(300,300);
		
		p1.setLayout(new GridLayout(1,2));
		p2.setLayout(new GridLayout(3,2));
		p3.setLayout(new BorderLayout());
		
		matF = new JTextField();
		phoneF = new JTextField();
		sexF = new JTextField();
		
		mat = new JLabel("Matric No: ");
		no = new JLabel("Phone No: ");
		sex = new JLabel("Sex (M/F)");
		
		p2.add(mat);
		p2.add(matF);
		p2.add(no);
		p2.add(phoneF);
		p2.add(sex);
		p2.add(sexF);
		
		title = new JLabel("CSE17");
		title.setHorizontalAlignment(JLabel.CENTER);
		
		submit = new JButton("Submit");
		submit.setHorizontalAlignment(JButton.CENTER);
		
		p3.add(title, BorderLayout.NORTH);
		p3.add(p2, BorderLayout.CENTER);
		p3.add(submit, BorderLayout.SOUTH);
		p3.setVisible(false);
		
		add = new JButton("Add Record");
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				p3.setVisible(true);
				repaint();
			}
		});
		delete = new JButton("Delete Record");
		delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			 int rw = tab.getSelectedRow();
			  if(rw<0)
			  {
			     JOptionPane.showMessageDialog(TableD.this,"SELECT ROW TO DELETE","IFORMATION",JOptionPane.ERROR_MESSAGE);
				 return;
			  }
			  else{
			   dtm.removeRow(tab.getSelectedRow());
			  }
			}
		});
		
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				dtm.addRow(new String [] {matF.getText(), phoneF.getText(), sexF.getText()});
				p3.setVisible(false);
				matF.setText("");
				phoneF.setText("");
				sexF.setText("");
			}
		});
		p1.add(add);
		p1.add(delete);
		dtm = new DefaultTableModel();
		dtm.addColumn("MATRIC");
		dtm.addColumn("PHONE");
		dtm.addColumn("MATRIC");
		String[]rec1 = {"123456","07030090562","M"};
		dtm.addRow(rec1);
		String[]rec2 = {"123456","07030090562","M"};
		dtm.addRow(rec2);
		String[]rec3 = {"123456","07030090562","M"};
		dtm.addRow(rec3);
		tab = new JTable(dtm);
		scrollPane = new JScrollPane(tab);
		
		add(p1, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		//add(pall, BorderLayout.CENTER);
		
	}
	
	public static void main(String [] args)
	{
		new TableD().setVisible(true);
	}
	

}