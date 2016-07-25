import java.util.*;
import java.text.*;

public class Dates
{
public static void main(String [] args)
{
	Date d = new Date();
	DateFormat frm = DateFormat.getDateTimeInstance();
	
	Scanner input = new Scanner(System.in);
	System.out.println("Enter first year");
	int y1 = input.nextInt();
	System.out.println("Enter first month");
	int m1 = input.nextInt();
	System.out.println("Enter first day");
	int d1 = input.nextInt();
	
	System.out.println("Enter second year");
	int y2 = input.nextInt();
	System.out.println("Enter second month");
	int m2 = input.nextInt();
	System.out.println("Enter second day");
	int d2 = input.nextInt();
	try
	{
		
		Date date1 = new Date(y1 , m1 , d1);
		Date date2 = new Date(y2, m2, d2);
		
		GregorianCalendar calendar1 = new GregorianCalendar();
		calendar1.setTime(date1);
		
		GregorianCalendar calendar2 = new GregorianCalendar();
		calendar2.setTime(date2);
		
		int year = calendar2.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);
		int month = calendar2.get(Calendar.MONTH) - calendar1.get(Calendar.MONTH);
		int day = calendar2.get(Calendar.DAY_OF_MONTH) - calendar1.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + "-" + month + "-" + day);
		System.out.println(d);
	}
	catch(Exception e)
	{
	}
}
}