import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class DevelopView extends JFrame
{
	String [] monthOfYear = {"January", "February", "March","April","May","June","July","August","September","Octomber","November","December"};
	String [] weekDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	JLabel bg, todayDate;
	JEditorPane display;
	JScrollPane scroll ;
	JButton home;
	Date date;
	GregorianCalendar calendar, pCalendar;
	URL url;
	int year,month,day;
	
	public DevelopView(int y, int m, int d)
	{
		year = y;
		month = m;
		day = d;
		
		date = new Date();
		calendar = new GregorianCalendar();
		calendar.setTime(date);
		
		pCalendar = new GregorianCalendar(year,month,day);
		
		display();
		setBg();
		setTitle();
		
		this.add(home);
		this.add(scroll);
		this.add(todayDate);
		this.add(bg);
		this.setSize(305,480);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void setBg()
	{
		bg = new JLabel();
		bg.setIcon(new ImageIcon(getClass().getResource("Pregnancy/images/bg.PNG")));
		bg.setBounds(0,0,300,450);
		
	}
	private void display()
	{
		try
		{
			int weeks = (calendar.get(Calendar.YEAR) > pCalendar.get(Calendar.YEAR)) ? ((pCalendar.getActualMaximum(Calendar.WEEK_OF_YEAR) - pCalendar.get(Calendar.WEEK_OF_YEAR) ) + calendar.get(Calendar.WEEK_OF_YEAR)) : (calendar.get(Calendar.WEEK_OF_YEAR) - pCalendar.get(Calendar.WEEK_OF_YEAR));
			weeks = (weeks < 4 ?  0: weeks);
			weeks = (weeks > 42 ? 42 : weeks);
			String add = "Pregnancy/web/week" + weeks + ".html";
			url = getClass().getResource(add);
			display = new JEditorPane();
			display.setContentType("text/html");
			display.setPage(url);
			display.setEditable(false);
			display.setOpaque(false);
			scroll = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroll.getViewport().setOpaque(false);
			scroll.setOpaque(false);
			scroll.setBorder(null);
			scroll.setBounds(0,50,300,350);
		}
		catch(Exception e)
		{
		}
	}
	private void setTitle()
	{
		todayDate = new JLabel();
		todayDate.setText(weekDays[calendar.get(Calendar.DAY_OF_WEEK) - 1] + ", " + monthOfYear[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DAY_OF_MONTH)+ ", " + calendar.get(Calendar.YEAR));
		todayDate.setHorizontalAlignment(SwingConstants.CENTER);
		todayDate.setForeground(Color.WHITE);
		todayDate.setFont(new Font(null, Font.BOLD, 18));
		todayDate.setBounds(0,0,300,30);
		
		home = new JButton(new ImageIcon(getClass().getResource("Pregnancy/images/home.PNG")));
		home.setBounds(40,410,200,30);
		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new HomeView(year,month,day).setVisible(true);
				DevelopView.super.dispose();
			}
		});
		
	}
	public static void main(String [] args)
	{
		new DevelopView(2014,9,24).setVisible(true);
	}
}