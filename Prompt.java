import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class Prompt extends JDialog implements ActionListener
{
	private JButton yes, no, call;
	private JLabel ans, time;
	private int option;
	private JPanel pan;
	private JTextArea friend;
	private Random rand;
	private String answer;
	
	public Prompt(JFrame frm, boolean mode)
	{
		super(frm, mode);
		
		pan = new JPanel();
		pan.setBackground(Color.BLUE);
		pan.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		pan.setBounds(0,0,250,120);
		pan.setLayout(null);
		
		ans = new JLabel();
		ans.setText("Is that your final answer?");
		ans.setForeground(Color.WHITE);
		ans.setFont(new Font("Arial", Font.BOLD, 16));
		ans.setBounds(20,15,200,20);
		
		yes = new JButton("Yes");
		yes.setBackground(Color.BLUE);
		yes.setForeground(Color.WHITE);
		yes.setFont(new Font("Arial", Font.BOLD, 16));
		yes.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		yes.setBounds(25,60,70,35);
		yes.addActionListener(this);
		
		no = new JButton("No");
		no.setBackground(Color.BLUE);
		no.setForeground(Color.WHITE);
		no.setFont(new Font("Arial", Font.BOLD, 16));
		no.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		no.setBounds(130,60,70,35);
		no.addActionListener(this);
		
		pan.add(ans);
		pan.add(no);
		pan.add(yes);
		
		this.add(pan);
		
		this.setSize(250,120);
		this.setUndecorated(true);
		this.setLocationRelativeTo(frm);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == yes)
			option = 1;
		else
			option = 0;
		Prompt.super.dispose();
		//System.out.println(option);
	}
	private Prompt(JFrame frm, boolean mode, String opt)
	{
		super(frm, mode);
		rand = new Random();
		answer = opt;
		
		pan = new JPanel();
		pan.setBackground(Color.BLUE);
		pan.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		pan.setBounds(0,0,250,200);
		pan.setLayout(null);
		
		friend = new JTextArea();
		friend.setForeground(Color.WHITE);
		friend.setFont(new Font("Arial", Font.BOLD, 16));
		friend.setBounds(10,60,240,90);
		friend.setOpaque(false);
		friend.setEditable(false);
		
		call = new JButton("Hang Up!");
		call.setBackground(Color.white);
		call.setForeground(Color.black);
		call.setFont(new Font("Arial", Font.BOLD, 15));
		call.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		call.setBounds(80,165,100,30);
		call.addActionListener(this);
		
		time = new JLabel("No");
		time.setBackground(Color.black);
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setForeground(Color.WHITE);
		time.setFont(new Font("Arial", Font.BOLD, 16));
		time.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		time.setOpaque(true);
		time.setBounds(80,0,70,50);
		
		pan.add(friend);
		pan.add(time);
		pan.add(call);
		msg();
		time();
		
		this.add(pan);
		this.setSize(250,200);
		this.setUndecorated(true);
		this.setLocationRelativeTo(frm);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	private void msg()
	{
		new Thread()
		{
			public void run()
			{
				try
				{
					String msg ="Friend: I think it's \""+ answer + "\"\nMe: How sure are you?\nFriend: about " + (50+ rand.nextInt(50)) + "%\nMe: k thankz dude\nFriend: You'r welcome man.";
					for(int i=0; i< msg.length(); i++)
					{
						friend.append(""+msg.charAt(i));
						Thread.sleep(100);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
	public void time()
	{
		new Thread()
		{
			public void run()
			{
				try
				{
					for(int i=29; i>=0; i--)
					{
						time.setText(""+ i);
						Thread.sleep(500);
					}
					Prompt.super.dispose();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
	public int getPrompt()
	{
		return option;
	}
	public static void main(String [] args)
	{
		new Prompt(null, true, "A").setVisible(true);
	}
}