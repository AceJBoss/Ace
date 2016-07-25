import java.util.*;
public class Adding
{
	private Scanner input;
	private int n,x,y;
	
	public Adding()
	{
		input = new Scanner(System.in);
		
		n = input.nextInt();
		for(int i=0; i<n; i++)
		{
			x = Integer.parseInt(String.valueOf(new StringBuilder(input.nextInt()+"").reverse()));
			y = Integer.parseInt(String.valueOf(new StringBuilder(input.nextInt()+"").reverse()));
			
			System.out.println(Integer.parseInt(String.valueOf(new StringBuilder((x+y)+"").reverse())));
		}
		
	}
	public static void main(String [] args)
	{
		new Adding();
	}
}