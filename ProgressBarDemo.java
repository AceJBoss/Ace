import javax.swing.*;
import java.awt.*;
public class ProgressBarDemo extends JFrame
{
	JPanel pan,loading;
	JProgressBar bar;
	int num;
	JLabel load,page;
	public ProgressBarDemo()
	{
		setSize(200,200);
		setLayout(new BorderLayout());
		pan = new JPanel();
		bar = new JProgressBar(0,1000);
		bar.setStringPainted(true);
		bar.setPreferredSize(new Dimension(getWidth(),10));
		bar.setForeground(Color.GREEN);
		pan.add(bar);
		
		loading = new JPanel();
		load = new JLabel("Loading...");
		page = new JLabel();
		loading.add(load);
		loading.add(page);
		
		add(pan, BorderLayout.CENTER);
		add(loading, BorderLayout.SOUTH);
	}
	public void iterate()
	{
		while(num<=1000)
		{
			bar.setValue(num);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			switch(num)
			{
				case 0: page.setText("Home Page");
					break;
				case 200: page.setText("Profile Page");
					break;
				case 400: page.setText("Test Page");
					break;
				case 600: page.setText("Assignment Page");
					break;
				case 800: page.setText("Course Page");
					break;
				
			}
			num+=100;
		}
	}
	public static void main(String[]args)
	{
		ProgressBarDemo pb = new ProgressBarDemo();
		pb.setVisible(true);
		pb.iterate();
	}
}