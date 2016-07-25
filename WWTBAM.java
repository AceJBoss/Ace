import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.swing.border.*;

public class WWTBAM extends JFrame
{
	private JLabel [] point ;
	private JLabel optiona, optionb, optionc ,optiond, bg, score,congrat, ads;
	private JTextArea question;
	private int index;
	private ArrayList<String[]> quiz;
	private String [] grade = {"100","200","300","500","1,000","2,000","4,000","8,000","16,000","32,000","64,000","125,000","250,000","500,000","1 MILLION"};
	private Random rand;
	
	public WWTBAM()
	{
		setIconImage(new ImageIcon(getClass().getResource("shuffle/images/W.PNG")).getImage());
		bg = new JLabel();
		bg.setIcon(new ImageIcon(getClass().getResource("wwtbam/images/wwtbam.PNG")));
		bg.setBounds(0,0,700,500);
		
		congrat = new JLabel();
		congrat.setForeground(Color.white);
		congrat.setBounds(30,70,450,170);
		congrat.setOpaque(false);
		congrat.setHorizontalAlignment(SwingConstants.CENTER);
		ads = new JLabel();
		
		point();
		loop();
		option();
		loadQuestion();
		ads();
		
		this.add(ads);
		this.add(congrat);
		this.add(bg);
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	private void point()
	{
		point = new JLabel[15];
		int y = 182;
		for(int i=14; i>=0; i--)
		{
			point[i] = new JLabel();
			point[i].setHorizontalAlignment(JLabel.LEFT);
			point[i].setBounds(530,y,100,50);//i80
			point[i].setVerticalTextPosition(JLabel.CENTER);
			point[i].setHorizontalTextPosition(JLabel.CENTER);
			this.add(point[i]);
			y += 15;
		}
		point[0].setText(" 1  $100");
		point[0].setForeground(new Color(191,76,30));
		point[1].setText(" 2  $200");
		point[1].setForeground(new Color(191,76,30));
		point[2].setText(" 3  $300");
		point[2].setForeground(new Color(191,76,30));
		point[3].setText(" 4  $500");
		point[3].setForeground(new Color(191,76,30));
		point[4].setText(" 5  $1,000");
		point[4].setForeground(Color.WHITE);
		point[5].setText(" 6  $2,000");
		point[5].setForeground(new Color(191,76,30));
		point[6].setText(" 7  $4,000");
		point[6].setForeground(new Color(191,76,30));
		point[7].setText(" 8  $8,000");
		point[7].setForeground(new Color(191,76,30));
		point[8].setText(" 9  $16,000");
		point[8].setForeground(new Color(191,76,30));
		point[9].setText("10  $32,000");
		point[9].setForeground(Color.WHITE);
		point[10].setText("11  $64,000");
		point[10].setForeground(new Color(191,76,30));
		point[11].setText("12  $125,000");
		point[11].setForeground(new Color(191,76,30));
		point[12].setText("13  $250,000");
		point[12].setForeground(new Color(191,76,30));
		point[13].setText("14  $500,000");
		point[13].setForeground(new Color(191,76,30));
		point[14].setText("15  $1 MILLION");
		point[14].setForeground(Color.WHITE);
		
		score = new JLabel("0");
		score.setFont(new Font("Arial", Font.BOLD, 24));
		score.setHorizontalAlignment(JLabel.LEFT);
		score.setForeground(Color.WHITE);
		score.setBounds(550,155,100,50);
		add(score);
	}
	private void loop()
	{
		new Thread(){public void run()
		{
			ImageIcon a = new ImageIcon("wwtbam/images/bar.PNG");
			point[0].setIcon(a);
			for(int i=1; i<15; i++)
			{
				try
				{
					Color c = point[i].getForeground();
					point[i-1].setIcon(null);
					point[i-1].setForeground(c);
					point[i].setIcon(a);
					point[i].setForeground(Color.black);
					Thread.sleep(100);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			try
			{
				Thread.sleep(500);
				for(int i =13; i>=0; i--)
				{
					Color c = point[i].getForeground();
					point[i+1].setIcon(null);
					point[i+1].setForeground(c);
					point[i].setIcon(a);
					point[i].setForeground(Color.black);
					Thread.sleep(100);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			Collections.shuffle(quiz);
			getQuestion(index);
		}
		}.start();
	}
	private void option()
	{
		optiona = new JLabel();
		optiona.setHorizontalAlignment(JLabel.CENTER);
		optiona.setVerticalTextPosition(JLabel.CENTER);
		optiona.setForeground(Color.WHITE);
		optiona.setHorizontalTextPosition(JLabel.CENTER);
		optiona.setBounds(29,344,229,35);
		//optiona event
		optiona.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				optiona.setIcon(new ImageIcon(getClass().getResource("wwtbam/images/optiona.PNG")));
			}
			public void mouseExited(MouseEvent me)
			{
				optiona.setIcon(null);
			}
			public void mouseClicked(MouseEvent me)
			{
				int a = new Prompt(WWTBAM.this , true).getPrompt();
				if(a == 1)
				{
					submit(index,optiona.getText());
				}
			}
		});
		
		//optionb
		optionb = new JLabel();
		optionb.setHorizontalAlignment(JLabel.CENTER);
		optionb.setVerticalTextPosition(JLabel.CENTER);
		optionb.setForeground(Color.WHITE);
		optionb.setHorizontalTextPosition(JLabel.CENTER);
		optionb.setBounds(265,344,229,35);
		//optionb event
		optionb.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				optionb.setIcon(new ImageIcon(getClass().getResource("wwtbam/images/optionb.PNG")));
			}
			public void mouseExited(MouseEvent me)
			{
				optionb.setIcon(null);
			}
			public void mouseClicked(MouseEvent me)
			{
				int a = new Prompt(WWTBAM.this , true).getPrompt();
				if(a == 1)
				{
					submit(index,optionb.getText());
				}
			}
		});
		
		//optionc
		optionc = new JLabel();
		optionc.setHorizontalAlignment(JLabel.CENTER);
		optionc.setVerticalTextPosition(JLabel.CENTER);
		optionc.setForeground(Color.WHITE);
		optionc.setHorizontalTextPosition(JLabel.CENTER);
		optionc.setBounds(29,403,229,35);
		//optionc event
		optionc.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				optionc.setIcon(new ImageIcon(getClass().getResource("wwtbam/images/optionc.PNG")));
			}
			public void mouseExited(MouseEvent me)
			{
				optionc.setIcon(null);
			}
			public void mouseClicked(MouseEvent me)
			{
				int a = new Prompt(WWTBAM.this , true).getPrompt();
				if(a == 1)
				{
					submit(index,optionc.getText());
				}
			}
		});
		
		//option d
		optiond = new JLabel();
		optiond.setHorizontalAlignment(JLabel.CENTER);
		optiond.setVerticalTextPosition(JLabel.CENTER);
		optiond.setForeground(Color.WHITE);
		optiond.setHorizontalTextPosition(JLabel.CENTER);
		optiond.setBounds(265,403,229,35);
		//optiond event
		optiond.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				optiond.setIcon(new ImageIcon(getClass().getResource("wwtbam/images/optiond.PNG")));
			}
			public void mouseExited(MouseEvent me)
			{
				optiond.setIcon(null);
			}
			public void mouseClicked(MouseEvent me)
			{
				int a = new Prompt(WWTBAM.this , true).getPrompt();
				if(a == 1)
				{
					submit(index,optiond.getText());
				}
			}
		});
		
		//trxtarea
		question = new JTextArea();
		question.setFont(new Font("Arial", Font.BOLD, 15));
		question.setForeground(Color.WHITE);
		question.setLineWrap(true);
		question.setOpaque(false);
		question.setEditable(false);
		question.setBounds(100,275,330,50);
		
		this.add(question);
		this.add(optiond);
		this.add(optionc);
		this.add(optionb);
		this.add(optiona);
	}
	private void submit(int in, String text)
	{
		if(text.equals(quiz.get(in)[5]))
		{
			score.setText(grade[in]);
			++index;
			congrat();
		}
	}
	private void congrat()
	{
		new Thread()
		{
			public void run()
			{
				try
				{
					for(int i= 0; i<20; i++)
					{
						congrat.setText("You're Right!");
						congrat.setFont(new Font(null, Font.BOLD, (34+i)));
						Thread.sleep(20);
					}
					Thread.sleep(500);
					congrat.setText("<html>You just won<br/>$"+ grade[index-1] + "</html>" );
					Thread.sleep(1500);
					for(int i= 0; i<20; i++)
					{
						congrat.setText("<html>Get Ready for<br/>the next round!</html>" );
						congrat.setFont(new Font(null, Font.BOLD, (34+i)));
						Thread.sleep(20);
					}
					Thread.sleep(500);
					congrat.setText("");
					getQuestion(index);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
	private void loadQuestion()
	{
		try
		{
			quiz = new ArrayList<>();
			FileInputStream fis = new FileInputStream("wwtbam/files/question.txt");
			DataInputStream dis = new DataInputStream(fis);
			String [] a ;
			while(true)
			{
				a = new String[6];
				for(int i=0; i<6; i++)
				{
					a[i] = dis.readUTF();
				}
				this.quiz.add(a);
			}
		}
		catch(EOFException e)
		{
			return;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void getQuestion(int in)
	{
		question.setText(quiz.get(in)[0]);
		optiona.setText(quiz.get(in)[1]);
		optionb.setText(quiz.get(in)[2]);
		optionc.setText(quiz.get(in)[3]);
		optiond.setText(quiz.get(in)[4]);
	}
	private void ads()
	{
		new Thread()
		{
			public void run()
			{
				try
				{
					ads.setForeground(Color.white);
					ads.setOpaque(false);
					ads.setHorizontalAlignment(SwingConstants.CENTER);
					ads.setBounds(0,450,700,53);
					rand = new Random();
		
					while(true)
					{
						for(int i= 0; i<15; i++)
						{
							ads.setText("WHO WANT TO BE A MILLIONAIRE LAUTECH VERSION" );
							ads.setForeground(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
							ads.setFont(new Font(null, Font.BOLD, (10+i)));
							Thread.sleep(100);
						}
						Thread.sleep(2000);
						for(int i= 0; i<15; i++)
						{
							ads.setText("Developed By: ISMAIL OLALEKAN a.k.a ISMUMMY" );
							ads.setForeground(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
							ads.setFont(new Font(null, Font.BOLD, (10+i)));
							Thread.sleep(100);
						}
						Thread.sleep(2000);
						String enq = "      For enquiries and more app: 08139263853/orismail@student.lautech.edu.ng";
						ads.setHorizontalAlignment(SwingConstants.LEFT);
						for(int i=0; i<enq.length()+1; i++)
						{
							ads.setText(enq.substring(i,enq.length()));
							ads.setForeground(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
							Thread.sleep(100);
						}
						Thread.sleep(3000);
						ads.setHorizontalAlignment(SwingConstants.CENTER);
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
	public static void main(String [] args)
	{
		new WWTBAM().setVisible(true);
	}
}	