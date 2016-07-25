import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener
{
	private Random rand;
	public Panel()
	{
		setLayout(null);
		rand = new Random();
		Timer timer = new Timer(1000, this);
        timer.start();
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		for (int a = 0; a < 20; a++) {

            Color color = new Color(rand.nextInt(250), rand.nextInt(250), rand.nextInt(250));
            g.setColor(color);
            g.drawLine(rand.nextInt(getWidth()), rand.nextInt(getHeight()), rand.nextInt(getWidth()), rand.nextInt(getHeight()));
        }
	}
	public void actionPerformed(ActionEvent e) 
	{
		this.setBackground(new Color(rand.nextInt(250), rand.nextInt(250), rand.nextInt(250)));
		repaint();
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(615,150);
	}
}