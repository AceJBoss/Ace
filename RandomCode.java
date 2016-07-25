import java.util.*;
import java.io.*;

public class RandomCode
{
	Set<String> code;
	char character[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	Random rand;
	
	public RandomCode()
	{
		code = new HashSet<>();
		rand = new Random();
	}
	public void generate()
	{
		for(int i=0; i<1000; i++)
		{
			String code = "";
			for(int j=0; j<6; j++)
			{
				code += ""+character[rand.nextInt(62)];
			}
			this.code.add(code);
		}
	}
	public void printCode()
	{
		List<String> code = new ArrayList<>(this.code);
		for(int i=0; i<code.size(); i++)
		{
			System.out.println(code.get(i));
		}
		System.out.println(code.size());
	}
	public static void main(String [] arg)
	{
		RandomCode a = new RandomCode();
		a.generate();
		a.printCode();
	}
}
