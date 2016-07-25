import java.util.Calendar;
import javax.swing.JApplet;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ApplicantApplet extends JApplet implements Runnable
{
    static JPanel panel;
    JLabel labelAppId,labelAppName,labelAppPosition;
    JTextField textAppField,textAppName;
    JComboBox comboAppPosition;
    Thread datimeThread;
    Date date;
    GregorianCalendar calendar;
    String strDate,strTime,strStatus;
    
    public void init()
    {
    
    panel =new JPanel();
    getContentPane().add(panel);
    labelAppId = new JLabel("Applicant ID");
    labelAppName = new JLabel("Applicant Name"); 
    labelAppPosition = new JLabel("Position");
    textAppField = new JTextField(5);
    textAppName = new JTextField(5);
    String position[] = {"Manager","Executive","Associate"};
    comboAppPosition = new JComboBox(position);
    panel.add(labelAppId);
    panel.add(textAppField);
    panel.add(labelAppName);
    panel.add(textAppName);
    panel.add(labelAppPosition);
    panel.add(comboAppPosition);
    dateTime();
    
    }
    
    public void dateTime()
    {
        datimeThread = new Thread(this);
        datimeThread.start();
    }
    
    public void run()
    {
    
        while(datimeThread != null)
        {
        display();
        try
        {
        datimeThread.sleep(1000);           
     }
     catch(InterruptedException e)
     {
     showStatus("Thread interrupted");
     }
     
    }
    
    }
    
    public void display()
    {
	date = new Date();

    calendar = new GregorianCalendar();
    calendar.setTime(date);
	//calendar.set(Calendar.WEEK_OF_YEAR, (calendar.get(Calendar.WEEK_OF_YEAR) + 36));
	calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR) + 280));
	
	strTime = calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
    strDate = calendar.get(Calendar.DAY_OF_MONTH)+ "/" + (calendar.get(Calendar.MONTH) + 1) +  "/" + calendar.get(Calendar.YEAR) + "/" ;
    strStatus= strTime + "  " + strDate;
    showStatus(strStatus);
    }
    
  }
