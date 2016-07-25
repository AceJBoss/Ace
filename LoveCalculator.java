import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoveCalculator extends JFrame
{
	private JPanel pan;
	private final JLabel label,percent,frem;
	static private JTextField male,female;
	private final JButton calculate;
	private Image im;
	private int lovePercent;
	
	public LoveCalculator()
	{
		super("Love Calculator");
		im = getToolkit().createImage("image/home2.PNG");
		im = im.getScaledInstance(310,515, Image.SCALE_SMOOTH);
		
		label = new JLabel();
		label.setIcon(new ImageIcon(im));
		
		male = new JTextField(10);
		male.setForeground(new Color(180,95,14));
		male.setFont(new Font(null, Font.BOLD, 20));
		male.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		male.setBounds(140,25, 122,28);
		female = new JTextField(10);
		female.setFont(new Font(null, Font.BOLD, 20));
		female.setForeground(new Color(180,95,14));
		female.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		female.setBounds(140,65, 122,28);
		percent = new JLabel();
		percent.setBounds(130,250,100,50);
		percent.setForeground(new Color(30,5,250));
		percent.setFont(new Font(null, Font.BOLD, 20));
		frem = new JLabel();
		frem.setFont(new Font(null, Font.BOLD, 15));
		frem.setForeground(new Color(222,6,209));
		frem.setBounds(75,220,200,50);
		
		calculate = new JButton("CALCULATE");
		calculate.addActionListener((ActionEvent ae) -> {
                    calculate();
                });
		calculate.setBorder(BorderFactory.createLineBorder(Color.blue, 1, true));
		calculate.setBackground(new Color(39,5,66));
		calculate.setBounds(140,100,110,30);
		this.add(male);
		this.add(percent);
		this.add(frem);
		this.add(female);
		this.add(calculate);
		this.add(label);
		this.pack();
		
	}
	private void calculate()
	{
	
		if(male.getText().equals("") && female.getText().equals(""))
		{
			frem.setText("Enter Couple Name");
		}
		else
		{
			String love = (male.getText() + female.getText()).toLowerCase();
			String newl = "";
			
			for(int i=0; i< love.length(); i++)
			{
				if(!newl.contains(""+love.charAt(i)))
					newl += ""+love.charAt(i) ;
				
			}
			int sum = 0;
			for(int j=0; j< newl.length(); j++)
			{
				sum += (int) newl.charAt(j);
			}
			
			lovePercent = sum % 101;
			
			if(male.getText().contains("ismail") || female.getText().contains("ismail")||male.getText().contains("ismummy") || female.getText().contains("ismummy")||male.getText().contains("lekan") || female.getText().contains("lekan"))
			lovePercent = 90;
			
			percent.setText(lovePercent + "%");
			
			if(lovePercent < 20)
				frem.setText("You're not GOOD! Together");
			else if(lovePercent < 30)
				frem.setText("YOU'RE GROWING!");
			else if(lovePercent < 40)
				frem.setText("YOU CAN WORK IT OUT");
			else if(lovePercent < 50)
				frem.setText("YOU'RE NOT BAD FRIEND!");
			else if(lovePercent < 60)
				frem.setText("ARE YOU GUYZ IN LOVE");
			else if(lovePercent < 70)
				frem.setText("YOU'RE NOT BAD LOVER");
			else if(lovePercent < 80)
				frem.setText("ARE YOU MARRIED ALREADY");
			else if(lovePercent < 100)
				frem.setText("YOU GUYZ ARE SUPERB");
		}
	}
	
	public static void main(String [] args)
	{	
		new LoveCalculator().setVisible(true);
	}
}