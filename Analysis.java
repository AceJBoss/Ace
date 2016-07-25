import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

public class Analysis extends JFrame
{
	private JTabbedPane tab;
	private JPanel glo,mtn,airtel;
	private JTable table;
	private DefaultTableModel dtm;
	
	public Analysis()
	{
		
		tab = new JTabbedPane(JTabbedPane.LEFT);
		glo();
		mtn();
		airtel();
		tab.addTab("GLO", glo);
		tab.addTab("MTN", mtn);
		tab.addTab("Airtel", airtel);
		add(tab);
		this.pack();
	}
	private void glo()
	{
		glo = new JPanel();
		dtm = new DefaultTableModel();
		dtm.addColumn("s/n");
		dtm.addColumn("mins");
		dtm.addColumn("Total Cost");
		double min = 3.50;
		int cost = 1320;
		double sumMin = 0 ;
		double sumCost = 0;
		
		for(int i = 0; i< 20 ; i++)
		{
			String [] a = {""+(i+1),""+min,""+(min * cost)} ;
			sumMin += min;
			sumCost += (min * cost);
			dtm.addRow(a);
			min += 3;
			
		}
		String [] a = {"Total",""+sumMin,""+sumCost} ;
		dtm.addRow(a);
		table = new JTable(dtm);
		glo.add(table);
	}
	private void mtn()
	{
		mtn = new JPanel();
		dtm = new DefaultTableModel();
		dtm.addColumn("s/n");
		dtm.addColumn("mins");
		dtm.addColumn("Total Cost");
		double min = 3.50;
		int cost = 1440;
		double sumMin = 0 ;
		double sumCost = 0;
		
		for(int i = 0; i< 20 ; i++)
		{
			String [] a = {""+(i+1),""+min,""+(min * cost)} ;
			sumMin += min;
			sumCost += (min * cost);
			dtm.addRow(a);
			min += 3;
			
		}
		String [] a = {"Total",""+sumMin,""+sumCost} ;
		dtm.addRow(a);
		table = new JTable(dtm);
		mtn.add(table);
	}
	private void airtel()
	{
		airtel = new JPanel();
		dtm = new DefaultTableModel();
		dtm.addColumn("s/n");
		dtm.addColumn("mins");
		dtm.addColumn("Total Cost");
		double min = 3.50;
		int cost = 1080;
		double sumMin = 0 ;
		double sumCost = 0;
		
		for(int i = 0; i< 20 ; i++)
		{
			String [] a = {""+(i+1),""+min,""+(min * cost)} ;
			sumMin += min;
			sumCost += (min * cost);
			dtm.addRow(a);
			min += 3;
			
		}
		String [] a = {"Total",""+sumMin,""+sumCost} ;
		dtm.addRow(a);
		table = new JTable(dtm);
		airtel.add(table);
	}
	public static void main(String [] args)
	{
		new Analysis().setVisible(true);
	}
}