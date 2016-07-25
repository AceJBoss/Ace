import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ShuffleRun extends JFrame
{
	private JLabel bg;
	private JButton play, score, setting, help, about, more;
	private JTextField input;
	private String [] cat = {"Random","Computer","Education","Bussiness","Sport","History"};
	private JComboBox option;
	private Image bgh;
	
	public ShuffleRun()
	{
		super("SHUFFLE GAME I");
		this.setIconImage(new ImageIcon(getClass().getResource("shuffle/images/S.PNG")).getImage());
		
		bg = new JLabel();
		bgh = getToolkit().createImage("shuffle/images/homebg.PNG");
		bg.setIcon(new ImageIcon(bgh));
		bg.setBounds(0,0,1000,600);
		
		//imput
		input = new JTextField(43);
		input.setFont(new Font("Arial", Font.BOLD,24));
		input.setForeground(Color.white);
		input.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		input.setBackground(Color.black);
		input.setHorizontalAlignment(JTextField.CENTER);
		input.setBounds(470,145,300,40);
		
		//option
		option = new JComboBox(cat);
		option.setBackground(new Color(21,98,148));
		option.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		option.setForeground(Color.red);
		option.setFont(new Font("Arial", Font.BOLD,24));
		option.setBounds(530,215,240,40);
		
		//play
		play = new JButton();
		play.setIcon(new ImageIcon(getClass().getResource("shuffle/images/game.PNG")));
		play.setBounds(73,284,191,122);
		//play event
		play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(input.getText().equals(""))
				{
					new Message(ShuffleRun.this, true, "<html>Enter Player Name!<br/>And Select Category<br/>To Start Game</html>").setVisible(true);
				}
				else
				{
					new Shuffle(input.getText(), cat[option.getSelectedIndex()]).setVisible(true);
					ShuffleRun.super.dispose();
				}
			}
		});
		
		//score
		score = new JButton();
		score.setIcon(new ImageIcon(getClass().getResource("shuffle/images/score.PNG")));
		score.setBounds(404,281,191,122);
		
		//setting
		setting = new JButton();
		setting.setIcon(new ImageIcon(getClass().getResource("shuffle/images/setting.PNG")));
		setting.setBounds(723,284,191,122);
		
		//help
		help = new JButton();
		help.setIcon(new ImageIcon(getClass().getResource("shuffle/images/help.PNG")));
		help.setBounds(73,451,191,122);
		
		//about
		about = new JButton();
		about.setIcon(new ImageIcon(getClass().getResource("shuffle/images/about.PNG")));
		about.setBounds(405,452,191,122);
		
		//more app
		more = new JButton();
		more.setIcon(new ImageIcon(getClass().getResource("shuffle/images/more.PNG")));
		more.setBounds(730,440,191,122);
		
		add(more);
		add(about);
		add(help);
		add(setting);
		add(score);
		add(play);
		add(option);
		add(input);
		add(bg);
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	public static void main(String [] args)
	{
		new ShuffleRun().setVisible(true);
	}
}