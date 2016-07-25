import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JComponent
{
	public int diameter = 10;
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillOval(10,10,diameter,diameter);
	}
	public void setDiameter(int newD)
	{
		diameter = (newD>=10 ? newD : 10);
		repaint();
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(200,50);
	}
	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}
}