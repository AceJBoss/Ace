import java.util.Formatter;
import java.io.*;
public class FileDemo2
{
    Formatter x;
	public void createFile()
	{
		// try
		// {
			// x = new Formatter("Books.txt");
			// System.out.println("File Created");
		// }
		// catch(Exception e)
		// {
			// System.out.println("File not created");
		// }
		try
			{
				String word = "dlskdskmkdsl";
			    FileWriter fw = new FileWriter("C://javaclass//Book.txt");
				BufferedWriter br = new BufferedWriter(fw);
				br.write(word);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	public void addRec()
	{
		x.format("%s %s %s","10","JBOSS","CSE");
		x.format("%s %s %s","20","ISMUMMY","CSE");
		x.format("%s %s %s","30","JELEKTRON","CSE");
	}
	public void cloze()
	{
		x.close();
	}
	public static void main(String[]args)
	{
		FileDemo2 fd= new FileDemo2();
		fd.createFile();
		//fd.addRec();
		//fd.cloze();
	}
}