import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
import java.net.*;

public class Shuffle extends JFrame
{
	private JLabel background, player, q[], score, time,category, letter[], ads;
	private Image bg, hm,en,cl, pr, ad, sh,qu;
	private String playerName, game;
	private JTextField input;
	private JButton home, previous, advance, shuffle, enter, clear,submit, play;
	private JProgressBar live;
	private ArrayList<String> words;
	private ArrayList<char [] > shuffled;
	private int option, liveValue,min, scoreValue, timeBonus;
	private JPanel panel;
	private Random rand;
	private boolean flag,wordFlag;
	private URL url;
	private Clip clip;
	
	Thread yle;
	
	public Shuffle(String name, String game)
	{
		super("SHUFFLE GAME I");
		this.setIconImage(new ImageIcon(getClass().getResource("shuffle/images/S.PNG")).getImage());
		
		playerName = name.toUpperCase();
		words = new ArrayList<>();
		shuffled = new ArrayList<>();
		this.game = game;
		liveValue = 5;
		rand = new Random();
		flag = true;
		wordFlag = true;
		min = 5;
		ads = new JLabel();
		
		//game backgroound
		background = new JLabel();
		background.setPreferredSize(new Dimension(1000,600));
		bg = getToolkit().createImage("shuffle/images/BG.PNG");
		background.setIcon(new ImageIcon(bg));
		
		//questions panel
		panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(270,315,615,150);
		
		//player name
		player = new JLabel(playerName);
		player.setFont(new Font("Arial", Font.BOLD,24));
		player.setForeground(Color.white);
		player.setHorizontalAlignment(JLabel.CENTER);
		player.setBounds(55,95,190,50);
		
		//player score
		score = new JLabel();
		score.setFont(new Font("Arial", Font.BOLD,24));
		score.setForeground(Color.white);
		score.setBounds(150,400,190,50);
		
		//play again
		play = new JButton();
		Image im = getToolkit().createImage("shuffle/images/play.PNG");
		play.setIcon(new ImageIcon(im));
		play.setBounds(30,463,204,49);
		//play event
		play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				flag = false;
				playAgain();
			}
		});
		
		//game time
		time = new JLabel();
		time.setFont(new Font("Arial", Font.BOLD,24));
		time.setForeground(Color.white);
		time.setBounds(890,30,190,50);
		
		//user input
		input = new JTextField(43);
		input.setFont(new Font("Arial", Font.BOLD,24));
		input.setForeground(Color.white);
		input.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		input.setBackground(Color.black);
		input.setHorizontalAlignment(JTextField.CENTER);
		input.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent ef)
			{
				wordFlag = false;
			}
			public void focusLost(FocusEvent ef)
			{
				wordFlag = true;
			}
		});
		input.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke)
			{
				setClip("shuffle/clip/click.au");
			}
		});
		input.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(input.getText().equals(""))
				{
					getToolkit().beep();
				}
				else
				{	
					if(flag)
					{
						setClip("shuffle/clip/enter.au");
						q[option].setText(input.getText().toUpperCase());
					}
					else
					{
						getToolkit().beep();
						new Message(Shuffle.this, true, "<html>Game Over!<br/>Start a new Game<br/>If u'l like to continue</html>").setVisible(true);
					}
				}
			}
		});
		input.setBounds(422,125,280,43);
		
		//home button
		home = new JButton();
		hm = getToolkit().createImage("shuffle/images/home.PNG");
		home.setIcon(new ImageIcon(hm));
		home.setBounds(38,41,140,50);
		//home effect
		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Shuffle.super.dispose();
				new ShuffleRun().setVisible(true);
			}
		});
		
		//game category
		category = new JLabel(game.toUpperCase());
		category.setFont(new Font("Arial", Font.BOLD,24));
		category.setForeground(Color.red);
		category.setHorizontalAlignment(JLabel.CENTER);
		category.setBounds(600,260,200,50);
		
		//enter button
		enter = new JButton();
		en = getToolkit().createImage("shuffle/images/enter.PNG");
		enter.setIcon(new ImageIcon(en));
		enter.setBounds(350,202,152,53);
		//enter event
		enter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(input.getText().equals(""))
				{
					getToolkit().beep();
				}
				else
				{	
					if(flag)
					{
						setClip("shuffle/clip/enter.au");
						q[option].setText(input.getText().toUpperCase());
					}
					else
					{
						getToolkit().beep();
						new Message(Shuffle.this, true, "<html>Game Over!<br/>Start a new Game<br/>If u'l like to continue</html>").setVisible(true);
					}
				}
			}
		});
		
		//clear button
		clear = new JButton();
		cl = getToolkit().createImage("shuffle/images/clear.PNG");
		clear.setIcon(new ImageIcon(cl));
		clear.setBounds(588,202,152,53);
		//clear event
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(input.getText().equals(""))
				{
					getToolkit().beep();
				}
				else
					input.setText("");
			}
		});
		
		//previous button
		previous = new JButton();
		pr = getToolkit().createImage("shuffle/images/previous.PNG");
		previous.setIcon(new ImageIcon(pr));
		previous.setBounds(207,520,171,49);
		//previous event
		previous.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(option ==0)
					getToolkit().beep();
				else
				{
					--option;
					setClip("shuffle/clip/prev.au");
					printWord();
					input.setText(q[option].getText().toUpperCase());
				}
			}
		});
		
		//advance button
		advance = new JButton();
		ad = getToolkit().createImage("shuffle/images/advance.PNG");
		advance.setIcon(new ImageIcon(ad));
		advance.setBounds(620,519,171,49);
		//advance event
		advance.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				
				if(option == 4)
					getToolkit().beep();
				else
				{
					++option;
					setClip("shuffle/clip/next.au");
					printWord();
					input.setText(q[option].getText().toUpperCase());
				}
			}
		});
				
		//submit button
		submit = new JButton();
		Image i = getToolkit().createImage("shuffle/images/submit.PNG");
		submit.setIcon(new ImageIcon(i));
		submit.setBounds(795,495,141,49);
		//submit event
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(q[0].getText()!= "" && q[1].getText()!= "" && q[2].getText()!= "" && q[3].getText()!= "" && q[4].getText()!= "")
				{
					if(flag)
					{
						flag = false;
						setScore();
					}
				}
				else
				{
					if(flag)
					{
						getToolkit().beep();
						new Message(Shuffle.this,true, "<html>You still have time<br/> to complete this attempt!</html>").setVisible(true);
						flag = true;
					}
				}
			}
		});
		//shuffle button
		shuffle = new JButton();
		sh = getToolkit().createImage("shuffle/images/shuffle.PNG");
		shuffle.setIcon(new ImageIcon(sh));
		shuffle.setBounds(418,490,192,49);
		//shuffle event
		shuffle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(liveValue == 0)
					getToolkit().beep();
				else
				{
					--liveValue;
					setClip("shuffle/clip/next.au");
					live.setValue(liveValue * 20);
					shuffle();
					printWord();
				}
			}
		});
		
		//live bar
		live = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
		live.setStringPainted(true);
		live.setValue(liveValue * 20);
		live.setBackground(Color.red);
		live.setForeground(new Color(47,84,34));
		live.setFont(new Font("Arial", Font.BOLD,24));
		live.setBounds(885,121, 60,325);
		
		//get word()
		getGame();
		loadWord();
		printWord();
		bgSound();
		ads();
		time();
		userInput();
		
		//add to frame
		this.add(ads);
		add(player);
		add(score);
		add(play);
		add(time);
		add(input);
		add(home);
		add(enter);
		add(category);
		add(clear);
		add(previous);
		add(advance);
		add(submit);
		add(shuffle);
		add(live);
		add(panel);
		add(background);
		
		this.setSize(1016,639);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}
	private void userInput()
	{
		//user input 1
		q = new JLabel[5];
		int y = 190;
		for(int i=0; i<5; i++)
		{
			q[i] = new JLabel();
			q[i].setFont(new Font("Arial", Font.BOLD,20));
			q[i].setText("");
			q[i].setForeground(Color.white);
			q[i].setBounds(80,y,190,50);
			this.add(q[i]);
			y += 35;
		}
	}
	public void bgSound()
	{
		new Thread()
		{
			public void run()
			{
				try
				{	
					while(flag)
					{
						setClip("shuffle/clip/start.au");
						Thread.sleep(4000);
						clip.stop();
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
	protected void playAgain()
	{
		//start fresh session
		flag = true;
		score.setText("");
		input.setText("");
		option = 0;
		timeBonus = 0;
		scoreValue = 0;
		liveValue = 5;
		live.setValue(liveValue * 20);
		userInput();
		min = 5;
		userInput();
		loadWord();
		printWord();
		bgSound();
		time();
	}
	private void getGame()
	{
		try
		{
			Scanner g = new Scanner(new File("shuffle/files/" + game + "_words.shu"));
			
			while(g.hasNext())
			{
				words.add(g.next());
			}
			g.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	private void loadWord()
	{
		Collections.shuffle(words);
		shuffled.clear();
		for(int i=0; i<5; i++)
		{
			char [] word = words.get(i).toCharArray();
			shuffled.add(word);
		}
		shuffle();
	}
	private void printWord()
	{
		//wordFlag = true;
		new Thread()
		{
			public void run()
			{
				try
				{	
					while(wordFlag)
					{
						panel.removeAll();
						int x = 40;
						int y = 40;
						letter = new JLabel[shuffled.get(option).length];
						for(int i=0; i<shuffled.get(option).length; i++)
						{
							letter[i] = new JLabel();
							Image im = getToolkit().createImage("shuffle/images/" + shuffled.get(option)[i] + ".PNG");
							im = im.getScaledInstance(50,50,Image.SCALE_SMOOTH);
							letter[i].setIcon(new ImageIcon(im));
							letter[i].setBounds(x,y + rand.nextInt(50),50,50);
							x += 50;
							panel.add(letter[i]);
						}
						panel.repaint();
						Thread.sleep(1000);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
	private void shuffle()
	{	
		for(int i=0; i< 5; i++)
		{
			char temp;
			for(int j= 0; j< shuffled.get(i).length; j++)
			{
				int a = rand.nextInt(shuffled.get(i).length);
				temp = shuffled.get(i)[j];
				shuffled.get(i)[j] = shuffled.get(i)[a];
				shuffled.get(i)[a]= temp;
			}
		}
	}
	public void time()
	{
		new Thread()
		{
			public void run()
			{
				while(flag)
				{	
					
					try
					{
						--min;
						for(int i=59; i>= 0; i--)
						{
							timeBonus = (min *60) + i;
							if(!flag)
							{
								break;
							}
							time.setText(min + " : " + i);
							Thread.sleep(1000);
						}
						if(min == 0)
						{
							flag = false;
							setScore();
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
			}
		}.start();
	}
	private void setScore()
	{
		for(int i=0; i<5; i++)
		{
			if(q[i].getText().equalsIgnoreCase(words.get(i)))
			++scoreValue;
		}
		double t = ((double) timeBonus/300.0) * 30;
		double l = ((double) liveValue/5.0) * 10;
		double s = ((double) scoreValue/5.0) * 60;
		double sum = t + l + s;
		
		if(sum > 50)
		{
			setClip("shuffle/clip/win.au");
		}
		else 
			setClip("shuffle/clip/loss.au");
		score.setText(""+(int)sum);
		wordFlag = false;
		int a = new Message(Shuffle.this, true, (int) t, (int) l, (int) sum ).getValue();
		if(a==0)
		{
			Shuffle.super.dispose();
			clip.stop();
			new ShuffleRun().setVisible(true);
		}
		else if(a == 1)
		{
			playAgain();
		}
		
	}
	private void setClip(String sound)
	{
		try
		{
			url = this.getClass().getClassLoader().getResource(sound);
			AudioInputStream as  = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(as);
			
			if(clip!=null)
			{
				clip.start();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
					ads.setBounds(0,555,1000,50);
					rand = new Random();
		
					while(true)
					{
						for(int i= 0; i<15; i++)
						{
							ads.setText("SHUFFLE GAME I" );
							ads.setForeground(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
							ads.setFont(new Font(null, Font.BOLD, (15+i)));
							Thread.sleep(100);
						}
						Thread.sleep(2000);
						for(int i= 0; i<15; i++)
						{
							ads.setText("Developed By: ABOLADE, AKINTOMIWA P.K.A {JBOSS}" );
							ads.setForeground(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
							ads.setFont(new Font(null, Font.BOLD, (10+i)));
							Thread.sleep(100);
						}
						Thread.sleep(2000);
						String enq = "For enquiries and more app: 07030090562/tommybosgust@gmail.com";
						for(int i=0; i<enq.length()+1; i++)
						{
							ads.setText(enq.substring(0,i));
							ads.setForeground(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
							Thread.sleep(100);
						}
						Thread.sleep(3000);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
	public static void main(String [] arg)
	{
		new Shuffle("LEKAN","computer").setVisible(true);
	}
}