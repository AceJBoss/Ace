import java.applet.*;

import java.awt.*;

public class appletDemo2 Extends Applet
{

}
public void init()
	{
		System.out.println("The applet is initialized");
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(BLUE);
		g.drawString("Welcome to Applet" 10, 10);
		g.drawRect(100,100,75,75);
		g.drawOval(50,50,45,45);
		g.drawArc(180,0,0,90);
		g.drawRect(0,15,0,15);
		g.drawLine(0,15);
		g.drawRect(25,20,25,20);
	}