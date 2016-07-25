import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalendarView extends JFrame
{
	JLabel [] days , daysOfWeek;
	JLabel bg, todayDate, monthYear;
	JEditorPane display;
	JButton right, left, home;
	Date date;
	GregorianCalendar calendar, pCalendar;
	JPanel calendarPanel;
	String [] dayWeek = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	String [] monthOfYear = {"January", "February", "March","April","May","June","July","August","September","Octomber","November","December"};
	String [] weekDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	int year,month,day;
	
	public CalendarView(int y, int m, int d)
	{
		year = y;
		month = m;
		day = d;
		
		date = new Date();
		calendar = new GregorianCalendar();
		calendar.setTime(date);
		
		pCalendar = new GregorianCalendar(year,month,day);
		calendarPanel = new JPanel();
		calendarPanel.setOpaque(false);
		calendarPanel.setLayout(null);
		calendarPanel.setBounds(40,170,220,280);
		
		display();
		setBg();
		setCalendar();
		
		this.add(display);
		this.add(todayDate);
		this.add(calendarPanel);
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
		
		int weeks = (calendar.get(Calendar.YEAR) > pCalendar.get(Calendar.YEAR)) ? ((pCalendar.getActualMaximum(Calendar.WEEK_OF_YEAR) - pCalendar.get(Calendar.WEEK_OF_YEAR) ) + calendar.get(Calendar.WEEK_OF_YEAR)) : (calendar.get(Calendar.WEEK_OF_YEAR) - pCalendar.get(Calendar.WEEK_OF_YEAR));
		int days = (calendar.get(Calendar.YEAR) > pCalendar.get(Calendar.YEAR)) ? ((pCalendar.getActualMaximum(Calendar.DAY_OF_YEAR) - pCalendar.get(Calendar.DAY_OF_YEAR) ) + calendar.get(Calendar.DAY_OF_YEAR)) : (calendar.get(Calendar.DAY_OF_YEAR) - pCalendar.get(Calendar.DAY_OF_YEAR));
		pCalendar.add(Calendar.DAY_OF_YEAR, 280);
		String dueDate = weekDays[pCalendar.get(Calendar.DAY_OF_WEEK) - 1] + ", " + monthOfYear[pCalendar.get(Calendar.MONTH)] + " " + pCalendar.get(Calendar.DAY_OF_MONTH)+ ", " + pCalendar.get(Calendar.YEAR);
		
		
		String text = "<html> <style type='text/css'>h2 {color:red}" 
			+"<center><h2>Congratulation!<br></center>"
			+"Your pregnancy is: <br>"
			+"<font color='white'>" + weeks + " weeks " +( days % 7 ) + " days</font><br>"
			+"Your Expected Due-Date:<br>"
			+"<font color='white'>" + dueDate + "</font></h2>"
			+"</html>";
		display = new JEditorPane();
		display.setContentType("text/html");
		display.setText(text);
		display.setEditable(false);
		display.setOpaque(false);
		display.setBounds(0,10,300,170);
	}
	private void calendarNav()
	{
		right = new JButton(new ImageIcon(getClass().getResource("Pregnancy/images/r.PNG")));
		right.setContentAreaFilled(false);
		right.setBorder(null);
		right.setBounds(185,0,30,30);
		right.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) + 1));
				setCalendar();
			}
		});
		calendarPanel.add(right);
		
		left = new JButton(new ImageIcon(getClass().getResource("Pregnancy/images/l.PNG")));
		left.setContentAreaFilled(false);
		left.setBorder(null);
		left.setBounds(0,0,30,30);
		left.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) - 1));
				setCalendar();
			}
		});
		calendarPanel.add(left);
		home = new JButton(new ImageIcon(getClass().getResource("Pregnancy/images/home.PNG")));
		home.setBounds(40,245,200,30);
		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new HomeView(year,month,day).setVisible(true);
				CalendarView.super.dispose();
			}
		});
		calendarPanel.add(home);
	}
	private void setTitle()
	{
		todayDate = new JLabel();
		todayDate.setText(weekDays[calendar.get(Calendar.DAY_OF_WEEK) - 1] + ", " + monthOfYear[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DAY_OF_MONTH)+ ", " + calendar.get(Calendar.YEAR));
		todayDate.setHorizontalAlignment(SwingConstants.CENTER);
		todayDate.setForeground(Color.WHITE);
		todayDate.setFont(new Font(null, Font.BOLD, 18));
		todayDate.setBounds(0,0,300,30);
		
		monthYear = new JLabel();
		monthYear.setHorizontalAlignment(SwingConstants.CENTER);
		monthYear.setForeground(Color.BLUE);
		monthYear.setFont(new Font(null, Font.BOLD, 18));
		monthYear.setBounds(30,0,155,30);
		calendarPanel.add(monthYear);
		
		int x = 0;
		daysOfWeek = new JLabel[7];
		
		for(int i=0; i< 7; i++)
		{
			daysOfWeek[i] = new JLabel();
			daysOfWeek[i].setText(dayWeek[i]);
			daysOfWeek[i].setForeground(Color.WHITE);
			daysOfWeek[i].setHorizontalAlignment(SwingConstants.CENTER);
			daysOfWeek[i].setFont(new Font(null, Font.BOLD, 12));
			daysOfWeek[i].setBounds(x,30,30,30);
			x += 31;
			calendarPanel.add(daysOfWeek[i]);
		}
		
	}
	private void setCalendar()
	{
		calendarPanel.removeAll();
		setTitle();
		calendarNav();
		int month =  calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		int year = calendar.get(Calendar.YEAR);
		int months = calendar.get(Calendar.MONTH) + 1;
		
		calendar.add(Calendar.DAY_OF_MONTH, -(currentDay -  1));
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DAY_OF_MONTH, +(currentDay - 1));
		
		monthYear.setText(monthOfYear[months-1] + " " + year);
		
		days = new JLabel[month];
		
		int x = 0;
		int y = 60;
		int j;
		for(int i=1; i< (month + day); i++)
		{
			if(i < day)
			{
				x += 31;
			}
			else
			{	
				j = (i-day);
				days[j] = new JLabel();
				days[j].setText("" + ( (j + 1)));
				days[j].setBounds(x,y,30,30);
				days[j].setHorizontalTextPosition(SwingConstants.CENTER);
				days[j].setForeground((((j+1))==currentDay ? Color.RED : Color.WHITE));
				days[j].setFont(((j+1))==currentDay ? new Font("Arial", Font.BOLD, 15) : new Font("Arial", Font.PLAIN, 15));
				days[j].setToolTipText((((j+1))==currentDay ? "Today's date is: " : "The date is: ") + (j+1) + ", " + monthOfYear[months -1] + ", " + year);
				days[j].setIcon(new ImageIcon(getClass().getResource("Pregnancy/images/" + (j+1) + ".PNG")));
				x += 31;
				
				if(i%7 == 0)
				{
					y += 31;
					x = 0;
				}
				
				calendarPanel.add(days[j]);
			}
		
		}
		repaint();
		revalidate();
	}
	public static void main(String [] args)
	{
		new CalendarView(2014,9,24).setVisible(true);
		
		/* String text = "<html> <style type='text/css'>h1 {color:red} h2 {color:white; text-align:center ; font-size:20} h3 {color:blue; text-align:center ; font-size:18} p {color:white; font-size:18} ul{color:red; font-size:16}</style>" +
			"<center><h1>Congratulation!</h1></center>"
			+"<h2>Your pregnancy is: <br>4 weeks 5 days</h2>"
			+"<h3>First contact with midwife or doctor</h3><p>This is the appointment when you tell your midwife or doctor that you’re pregnant. They should give you information about:</p><ul><li>folic acid and vitamin D supplements</li><li>nutrition, diet and food hygiene</li><li>lifestyle factors, such as smoking, drinking and recreational drug use</li><li>antenatal screening tests, including screening for sickle cell diseases and thalassaemia, the anomaly scan and screening for Down's syndrome, as well as risks, benefits and limits of these tests</li></ul><p>It’s important to tell your midwife or doctor if: </p><ul><li> there were any complications or infections in a previous pregnancy or delivery, such as pre-eclampsia or premature birth</li><li>you're being treated for a chronic disease such as diabetes or high blood pressure</li><li>you or anyone in your family has previously had a baby with an abnormality, for example, spina bifida</li><li> there is a family history of an inherited disease, for example, sickle cell or cystic fibrosis</li></ul></html>";
		 */
	}
}