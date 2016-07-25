import java.io.*;
import java.util.*;
public class Encode
{
	public Encode()
	{
		try {
		
			File in = new File("lg.txt");
			
			Scanner scan = new Scanner(in);
			
			ArrayList<String> lg = new ArrayList<>();
			
			while(scan.hasNextLine())
			{
				lg.add("<item>" + scan.nextLine() + "</item>");
			}
		
			PrintWriter writer = new PrintWriter("lg1.txt", "UTF-8");
            for (Object a : lg.toArray()) {
                writer.println(a);
            }
            writer.close();
			
        } catch (Exception e) {
           // e.printStakeTrace();
	}	
	}
	public static void main(String [] args)
	{
	new Encode();
	}
}