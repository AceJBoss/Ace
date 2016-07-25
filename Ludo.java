import java.awt.*;
import javax.swing.*;

public class Ludo extends JApplet
{
	public void init()
	{
	
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//rectangle u1/ red
		g.setColor(Color.red);
		g.fillRect(20,20,240,240);
		//left vertical
		g.drawLine(20,260,20,380);
		g.drawLine(60,260,60,380);
		g.drawLine(100,260,100,380);
		g.drawLine(140,260,140,380);
		g.drawLine(180,260,180,380);
		g.drawLine(220,260,220,380);
		g.drawLine(260,260,260,380);
		//home in and out
		g.fillRect(60,260,40,80);
		g.fillRect(100,300,200,40);
		//seeds
		g.setColor(Color.black);
		g.fillOval(60,60,40,40);
		g.fillOval(140,60,40,40);
		g.fillOval(60,140,40,40);
		g.fillOval(140,140,40,40);
		
		//rectangle u2 / blue
		g.setColor(Color.blue);
		g.fillRect(380,20,240,240);
		//up horizontal
		g.drawLine(260,20,380,20);
		g.drawLine(260,60,380,60);
		g.drawLine(260,100,380,100);
		g.drawLine(260,140,380,140);
		g.drawLine(260,180,380,180);
		g.drawLine(260,220,380,220);
		g.drawLine(260,260,380,260);
		//home in and out
		g.fillRect(300,60,80,40);
		g.fillRect(300,100,40,200);
		//seeds
		g.setColor(Color.black);
		g.fillOval(420,60,40,40);
		g.fillOval(500,60,40,40);
		g.fillOval(420,140,40,40);
		g.fillOval(500,140,40,40);
		
		//rectangle d1/ yellow
		g.setColor(Color.yellow);
		g.fillRect(20,380,240,240);
		//down horizontal
		g.drawLine(260,380,380,380);
		g.drawLine(260,420,380,420);
		g.drawLine(260,460,380,460);
		g.drawLine(260,500,380,500);
		g.drawLine(260,540,380,540);
		g.drawLine(260,580,380,580);
		g.drawLine(260,620,380,620);
		//home in and out
		g.fillRect(260,540,80,40);
		g.fillRect(300,380,40,200);
		//seeds
		g.setColor(Color.black);
		g.fillOval(60,420,40,40);
		g.fillOval(140,420,40,40);
		g.fillOval(60,500,40,40);
		g.fillOval(140,500,40,40);
		
		//rectangle d2 / green
		g.setColor(Color.green);
		g.fillRect(380,380,240,240);
		//right vertical
		g.drawLine(380,260,380,380);
		g.drawLine(420,260,420,380);
		g.drawLine(460,260,460,380);
		g.drawLine(500,260,500,380);
		g.drawLine(540,260,540,380);
		g.drawLine(580,260,580,380);
		g.drawLine(620,260,620,380);
		//home in and out
		g.fillRect(540,300,40,80);
		g.fillRect(380,300,200,40);
		//seeds
		g.setColor(Color.black);
		g.fillOval(420,420,40,40);
		g.fillOval(500,420,40,40);
		g.fillOval(420,500,40,40);
		g.fillOval(500,500,40,40);
		
		//rectangle center & divisor
		g.setColor(Color.black);
		g.fillRect(260,260,120,120);
		g.drawLine(300,20,300,620);
		g.drawLine(340,20,340,620);
		g.drawLine(20,300,620,300);
		g.drawLine(20,340,620,340);
		
		
		
		
	}
}