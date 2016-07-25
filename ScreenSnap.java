import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class ScreenSnap extends JPanel
{
	private Robot rob;
	private BufferedImage bi;
	private int x,y,width,height;
	private JLabel image;
	private int i;
	
	public ScreenSnap()
	{
		
		image = new JLabel();
		image.setIcon(new ImageIcon(getClass().getResource("images/c.jpg")));
		this.addMouseMotionListener(new MouseAdapter()
		{
			public void mouseDragged(MouseEvent me)
			{
				setWidth(me.getX() - x);
				setHeight(me.getY() - y);
			}
		});
		this.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				setX(me.getX());
				setY(me.getY());
				
			}
			public void mouseReleased(MouseEvent me)
			{
				setWidth(me.getX() - x);
				setHeight(me.getY() - y);
				
				
				try
				{
					rob = new Robot();
					  
					Rectangle area = new Rectangle(x,y,width,height);
					BufferedImage bi = rob.createScreenCapture(area);
					try
					{
						File f = new File("images\\screen\\Screen_Snap"+ i + ".png");
						ImageIO.write(bi, "png", f);
						 ++i;
					}
					catch(Exception se)
					{
						se.printStackTrace();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		add(image);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.RED);
		g.drawRect(x,y,width,height);
		repaint();
	}
	public void setWidth(int newW)
	{
		width = newW;
		repaint();
	}
	public void setHeight(int newH)
	{
		height = newH;
		repaint();
	}
	public void setX(int newX)
	{
		x = newX;
		repaint();
	}
	public void setY(int newY)
	{
		y = newY;
		repaint();
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(200,200);
	}
	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}
	public static void main(String [] args)
	{
		JFrame a = new JFrame();
		a.setContentPane(new ScreenSnap());
		a.pack();
		a.setVisible(true);
	}
}