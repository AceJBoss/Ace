import javax.swing.*;
import java.awt.event.*;
public class Demos extends JInternalFrame
{
	private JPanel p1;
	private JButton btn;
	
	public Demos()
	{
		super("Triggered",true,true,true);
		p1 = new JPanel();
		btn = new JButton("M CALLED");
		p1.add(btn);
		setSize(300,500);
		getContentPane().add(p1);
	}
}