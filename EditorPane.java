import java.awt.*;
import javax.swing.*;
import java.net.*;

public class EditorPane extends JFrame
{
	private JEditorPane pan;
	private URL url;
	
	public EditorPane()
	{
		try
		{
		url = getClass().getResource("'0xc000000f the boot selection failed because a required device is - Microsoft Community.htm");
		
		pan = new JEditorPane(url);
		add(new JScrollPane(pan));
		this.pack();
		}
		catch(Exception e)
		{
			
		}
	}
	public static void main(String [] args)
	{
		new EditorPane().setVisible(true);
	}
}