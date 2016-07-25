import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.awt.event.*;

public class HomeView extends JFrame
{
	String [] monthOfYear = {"January", "February", "March","April","May","June","July","August","September","Octomber","November","December"};
	String [] weekDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private int [] appoint = {4,10,14,16,19,25,28,31,34,36,38,40,41,42};
	JLabel bg, todayDate;
	JEditorPane display;
	Date date;
	JPanel buttonPanel;
	JButton calendarV,appointment,emergency,development;
	GregorianCalendar calendar, pCalendar;
	int year, month,day;
	
	public HomeView(int y, int m, int d)
	{
		year = y;
		month = m;
		day = d;
		date = new Date();
		calendar = new GregorianCalendar();
		calendar.setTime(date);
		pCalendar = new GregorianCalendar(year,month,day);
		
		setBg();
		setTitle();
		setButtons();
		display();
		
		this.add(display);
		this.add(buttonPanel);
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
	private void setButtons()
	{
		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(50,250,250,200);
		
		calendarV = new JButton(new ImageIcon(getClass().getResource("Pregnancy/images/calendar.png")));
		calendarV.setBounds(0,0,200,30);
		calendarV.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new CalendarView(year,month,day).setVisible(true);
				HomeView.super.dispose();
			}
		});
		buttonPanel.add(calendarV);
		
		appointment = new JButton(new ImageIcon(getClass().getResource("Pregnancy/images/appointment.png")));
		appointment.setBounds(0,35,200,30);
		appointment.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new AppointmentView(year,month,day).setVisible(true);
				HomeView.super.dispose();
			}
		});
		buttonPanel.add(appointment);
		
		development = new JButton(new ImageIcon(getClass().getResource("Pregnancy/images/development.png")));
		development.setBounds(0,70,200,30);
		development.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new DevelopView(year,month,day).setVisible(true);
				HomeView.super.dispose();
			}
		});
		buttonPanel.add(development);
		
		emergency = new  JButton(new ImageIcon(getClass().getResource("Pregnancy/images/emergency.png")));
		emergency.setBounds(0,105,200,30);
		buttonPanel.add(emergency);
	}
	private void display()
	{
		
		int weeks = (calendar.get(Calendar.YEAR) > pCalendar.get(Calendar.YEAR)) ? ((pCalendar.getActualMaximum(Calendar.WEEK_OF_YEAR) - pCalendar.get(Calendar.WEEK_OF_YEAR) ) + calendar.get(Calendar.WEEK_OF_YEAR)) : (calendar.get(Calendar.WEEK_OF_YEAR) - pCalendar.get(Calendar.WEEK_OF_YEAR));
		int days = (calendar.get(Calendar.YEAR) > pCalendar.get(Calendar.YEAR)) ? ((pCalendar.getActualMaximum(Calendar.DAY_OF_YEAR) - pCalendar.get(Calendar.DAY_OF_YEAR) ) + calendar.get(Calendar.DAY_OF_YEAR)) : (calendar.get(Calendar.DAY_OF_YEAR) - pCalendar.get(Calendar.DAY_OF_YEAR));
		pCalendar.add(Calendar.DAY_OF_YEAR, 280);
		String dueDate = weekDays[pCalendar.get(Calendar.DAY_OF_WEEK) - 1] + ", " + monthOfYear[pCalendar.get(Calendar.MONTH)] + " " + pCalendar.get(Calendar.DAY_OF_MONTH)+ ", " + pCalendar.get(Calendar.YEAR);
		
		String a = "";
		for(int i=0; i<appoint.length; i++)
		{
			if(appoint[i] == weeks)
			{
				a = "<br>N.B: <font color='white'>You have an Appointment with your mid-wife or doctor this week</font>";
				break;
			}
		}
		String text = "<html> <style type='text/css'>h2 {color:red}" 
			+"<center><h2>Congratulation!<br></center>"
			+"Your pregnancy is: <br>"
			+"<font color='white'>" + weeks + " weeks " +( days % 7 ) + " days</font><br>"
			+"Your Expected Due-Date:<br>"
			+"<font color='white'>" + dueDate + "</font><br>"
			+ a + "</h2>"
			+"</html>";
		display = new JEditorPane();
		display.setContentType("text/html");
		display.setText(text);
		display.setEditable(false);
		display.setOpaque(false);
		display.setBounds(0,10,300,205);
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
		new HomeView(2014,10,27).setVisible(true);
	}
}
