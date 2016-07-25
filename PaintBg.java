import java.awt.*;
import java.applet.*;
import javax.swing.*;

public class PaintBg extends JPanel
{
	private Image im;
	static private JTextField male,female;
	private JButton calculate;
	
	public PaintBg()
	{
		setLayout(null);
		im = getToolkit().createImage("image/home2.PNG");
		im = im.getScaledInstance(310,515, Image.SCALE_SMOOTH);
		
		/* male = new JTextField(10);
		male.setBounds(100,100, 100,100);
		
		calculate = new JButton("vgjv jhjh");
		calculate.setBounds(100,200,100,100);
		this.add(male);
		this.add(calculate); */
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		//g.drawImage(im,0,0,null);
		repaint();
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(310,515);
	}
	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}
}