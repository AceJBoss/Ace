import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Draw extends JFrame
{
	JSlider slid;
	DrawPanel pan;
	
	public Draw()
	{
		setSize(400,350);
		pan = new DrawPanel();
		pan.setBackground(Color.RED);
		
		slid = new JSlider(JSlider.HORIZONTAL,0,500,10);
		slid.setMajorTickSpacing(10);
		slid.setPaintTicks(true);
		
		slid.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent ce)
			{
				pan.setDiameter(slid.getValue());
			}
		});
		
		add(pan,BorderLayout.CENTER);
		add(slid,BorderLayout.SOUTH);
		
	}
	public static void main(String[]args)
	{
		new Draw().setVisible(true);
	}
}