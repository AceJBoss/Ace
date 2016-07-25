import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Message extends JDialog
{
	private JLabel background;
	private Image bg;
	private JLabel label;
	private JLabel time,live, score;
	private JButton ok, home, play;
	private int value;
	
	public Message(JFrame fram, boolean modal, String msg)
	{
		super(fram, modal);
		setLocationRelativeTo(fram);
		this.setIconImage(new ImageIcon(getClass().getResource("shuffle/images/M.PNG")).getImage());
		
		background = new JLabel();
		bg = getToolkit().createImage("shuffle/images/dialogbg.PNG");
		background.setIcon(new ImageIcon(bg));
		background.setBounds(0,0,350,200);
		
		label = new JLabel();
		label.setText(msg.toUpperCase());
		label.setFont(new Font("Arial", Font.BOLD,18));
		label.setForeground(Color.red);
		label.setBounds(50,30,300,150);
		
		ok = new JButton();
		ok.setIcon(new ImageIcon(getClass().getResource("shuffle/images/OK.PNG")));
		ok.setBounds(113,153,119,33);
		//ok event
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Message.super.dispose();
				return;
			}
		});
		
		this.add(ok);
		this.add(label);
		this.add(background);
		this.pack();
		
	}
	public Message(JFrame fram, boolean mode, int tb, int lb, int s)
	{
		super(fram, mode);
		setLocationRelativeTo(fram);
		this.setIconImage(new ImageIcon(getClass().getResource("shuffle/images/S.PNG")).getImage());
		
		background = new JLabel();
		bg = getToolkit().createImage("shuffle/images/OVER.PNG");
		background.setIcon(new ImageIcon(bg));
		background.setBounds(0,0,400,300);
		
		time = new JLabel(""+tb);
		time.setFont(new Font("Arial", Font.BOLD,25));
		time.setForeground(Color.white);
		time.setHorizontalAlignment(JLabel.CENTER);
		time.setBounds(250,98,100,50);
		
		live = new JLabel(""+lb);
		live.setFont(new Font("Arial", Font.BOLD,25));
		live.setForeground(Color.white);
		live.setHorizontalAlignment(JLabel.CENTER);
		live.setBounds(250,135,100,50);
		
		score = new JLabel(""+ s);
		score.setFont(new Font("Arial", Font.BOLD,25));
		score.setForeground(Color.white);
		score.setHorizontalAlignment(JLabel.CENTER);
		score.setBounds(280,175,100,50);
		
		//home
		home = new JButton();
		home.setIcon(new ImageIcon(getClass().getResource("shuffle/images/home.PNG")));
		home.setBounds(28,245,140,50);
		//home event
		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Message.super.dispose();
				value = 0;
			}
		});
		
		//play again
		play = new JButton();
		play.setIcon(new ImageIcon(getClass().getResource("shuffle/images/play.PNG")));
		play.setBounds(184,245,204,49);
		//play event
		play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Message.super.dispose();
				value = 1;
			}
		});
		
		this.add(play);
		this.add(home);
		this.add(score);
		this.add(live);
		this.add(time);
		this.add(background);
		this.pack();
		this.setVisible(true);
	}
	protected int getValue()
	{
		return value;
	}
	public static void main(String [] args)
	{
		new Message(null, true,1,1,1).setVisible(true);
	}
}