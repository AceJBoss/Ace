import java.util.*;
import java.io.*;

public class Sort
{
	Set<String> num,num2;
	public static void main(String [] args)
	{
		Sort a = new Sort();
		a.action();
		a.getEng();
		a.removeEng();
		a.output();
	}
	public void action()
	{
		try
		{
			num = new HashSet<>();
			FileReader fr = new FileReader("CSECLASS17MATRIC.txt");
			Scanner input = new Scanner(fr);
			while(input.hasNext())
			{
				num.add(input.next());
			}
		}
		catch(Exception e)
		{
		}
	}
	public void getEng()
	{
		try
		{
			num2 = new HashSet<>();
			FileReader fr = new FileReader("CSEENG.txt");
			Scanner input = new Scanner(fr);
			while(input.hasNext())
			{
				num2.add(input.next());
			}
		}
		catch(Exception e)
		{
		}
	}
	public void removeEng()
	{
		List<String> in = new ArrayList<>(num2);
		for(int i=0; i<in.size(); i++)
		{
			if(num.contains(in.get(i)))
				num.remove(in.get(i));
		}
	}
	public void output()
	{
		
		try
		{
			FileWriter fw = new FileWriter("CSECLASS17MATRIC.txt");
			List<String> in = new ArrayList<>(num);
			BufferedWriter bw = new BufferedWriter(fw);
			Collections.sort(in);
			for(int i=0; i<num.size(); i++)
			{
				bw.write(in.get(i)+ "\n");
			}
			bw.close();
			System.out.println("Engineering: " + num2.size());
			System.out.println("Science: " + num.size());
		}
		catch(Exception e)
		{}
	}
	
}