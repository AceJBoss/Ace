import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.awt.event.*;

public class AppointmentView extends JFrame
{
	String [] monthOfYear = {"January", "February", "March","April","May","June","July","August","September","Octomber","November","December"};
	String [] weekDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	JLabel bg, todayDate;
	JEditorPane display;
	JButton home;
	private URL url;
	Date date;
	private JScrollPane scroll ;
	GregorianCalendar calendar, pCalendar;
	int year, month,day;
	private int [] appoint = {4,10,14,16,19,25,28,31,34,36,38,40,41,42};
	
	public AppointmentView(int y, int m, int d)
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
		setButtons();
		
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
			
			int a = 0;
			for(int i=0; i<appoint.length; i++)
			{
				if(appoint[i] == weeks)
				{
					a = i + 1;
					break;
				}
			}
			String add = "Pregnancy/web/appoint" + a + ".html";
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
	private void setButtons()
	{
	
		home = new JButton(new ImageIcon(getClass().getResource("Pregnancy/images/home.PNG")));
		home.setBounds(40,410,200,30);
		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new HomeView(year,month,day).setVisible(true);
				AppointmentView.super.dispose();
			}
		});
		
	}
	private void setTitle()
	{
		todayDate = new JLabel();
		todayDate.setText(weekDays[calendar.get(Calendar.DAY_OF_WEEK) - 1] + ", " + monthOfYear[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DAY_OF_MONTH)+ ", " + pCalendar.get(Calendar.YEAR));
		todayDate.setHorizontalAlignment(SwingConstants.CENTER);
		todayDate.setForeground(Color.WHITE);
		todayDate.setFont(new Font(null, Font.BOLD, 18));
		todayDate.setBounds(0,0,300,30);
		
	}
	public static void main(String [] args)
	{
		new AppointmentView(2014,10,2).setVisible(true);
	}
}
