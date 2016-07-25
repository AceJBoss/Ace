import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.net.*;

public class AppletDemo extends JApplet
{
	AudioClip ac;
	Image im;
	JButton play,stop;
	
	public void init()
	{
	    im = getImage(getCodeBase(),"fred.jpg");
		ac = getAudioClip(getCodeBase(),"win.wav");
		String link  = "yahoo";
		play = new JButton(link);
		play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String link = "http://www."+play.getLabel()+".com";
				try
				{
				   AppletContext apps = getAppletContext();
				   URL u = new URL(link);
				   apps.showDocument(u,"_self");
				}
				catch(Exception e)
				{
					e.getMessage();
				}
				ac.play();
			}
		});
		stop = new JButton("Stop");
		stop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				ac.stop();
			}
		});
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.add(play);
		panel.add(stop);
		
		System.out.println("Initializing...");
	}
	public void start()
	{
		System.out.println("Starting...");
	}
	public void stop()
	{
		System.out.println("Stopping...");
	}
	public void destroy()
	{
		System.out.println("Destroyed...");
	}
	public void paint(Graphics g)
	{
	    g.setColor(Color.RED);
	    g.drawString("gfgvhghghgg",0,25);
		g.setColor(Color.RED);
		g.fillRect(50,70,60,30);
		g.setColor(Color.BLUE);
		g.fillRect(70,90,60,30);
		g.setColor(Color.YELLOW);
		g.fillRect(90,110,60,30);
		
		g.drawOval( 200,70, 100,120);
		g.drawOval(220,90,20,10);
		g.drawOval(260, 90, 20,10);
		g.setColor(Color.BLACK);
		g.fillOval(228,90,10,10);
		g.drawLine(250,95,250,130);
		g.drawOval(235,150,30,10);
		g.drawLine(215,50,240,70);
		g.drawLine(240,70,265,50);
		g.drawLine(240,50,240,70);
		g.fillOval(268,90,10,10);
	}
}