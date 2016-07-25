// file demo
import java.io.*;
import java.util.Scanner;
public class FileDemo1
{
	public static void main(String[]args)
	{
		File f = new File("C://javaclass//books.txt");
		String word = "dlskdskmkdsl";
		try
		{
		FileWriter fw = new FileWriter("C://javaclass//Books.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		//bw.write(word);
		bw.write("50 TBoy CSE555");
		bw.close();
		
		FileReader fr = new FileReader("C://javaclass//Bookss.txt");
		BufferedReader br = new BufferedReader(fr);
		System.out.println(br.readLine());
		br.close();
		
		if(f.exists())
		{
			System.out.println(f.getName() + " exist");
			Scanner input = new Scanner(f);
			while(input.hasNext())
			{
			System.out.println("id = " +input.nextInt());
			System.out.println("Name = " + input.next());
			System.out.println("Course = " + input.next());
			}

		}
		else
		{
			System.out.println(f.getName()+" Doesn\'t exist");
		}
		}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
}