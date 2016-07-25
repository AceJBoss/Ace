import java.awt.*;
public class ThreadTest 
{

	public static void main(String[]args)
	{
		int min = 5;
		try
		{
		while(min >0)
		{
		for(int i=30-1; i>0; i--)
		{
			System.out.println(min + ":" + i);
			Thread.sleep(1000);	
			if(i==1)
			{
				--min;
			}
		}
		}
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
	}
}