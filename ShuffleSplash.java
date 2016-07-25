import javax.swing.*;
import java.awt.*;

public class ShuffleSplash extends JFrame
{
	private JLabel image,label;
	private JProgressBar bar;
	private String [] name = {"SHUFFLE GAME I", "POWERED BY: ", "ISMAIL OLALALEKAN","ISMUMMY : 08139263853","olalekan.civil@gmail.com"};
	private int num;
	
	public ShuffleSplash()
	{
		image = new JLabel();
		Image im = getToolkit().createImage("shuffle/images/SPLASH.PNG");
		image.setIcon(new ImageIcon(im));
		image.setBounds(0,0,1000,600);
		
		bar = new JProgressBar(0,10);
		bar.setBounds(0,570,1000,10);
		bar.setForeground(Color.blue);
		bar.setBackground(Color.green);
		
		label = new JLabel();
		label.setFont(new Font("Arial", Font.BOLD,24));
		label.setForeground(Color.white);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBounds(0,570,1000,50);
		
		add(label);
		add(bar);
		add(image);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	private void iterate()
	{
		try
		{
			while(num <= 10)
			{
				Thread.sleep(1000);
				switch(num)
				{
					case 1 :
					case 6 : label.setText(name[0]);
						break;
					case 2 :
					case 7 : label.setText(name[1]);
						 break;
					case 3 :
					case 8 : label.setText(name[2]);
						break;
					case 4 :
					case 9 : label.setText(name[3]);
						 break;
					case 5 :
					case 10 : label.setText(name[4]);
						 break;
				}
				bar.setValue(num);
				++num;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String [] args)
	{
		ShuffleSplash a = new ShuffleSplash();
		a.setVisible(true);
		a.iterate();
	}
}