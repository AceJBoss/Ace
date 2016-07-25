import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class Test extends JFrame implements ItemListener
{
	private ArrayList<String[]> question;
	private ArrayList<String[]> currentQuestion;
	private JTextField questionLabel;
	private JRadioButton optiona,optionb,optionc,optiond;
	private ButtonGroup [] group;
	private JButton [] button;
	private JPanel cPan,nePan,nwPan,wPan, container,north;
	private GridBagLayout cLayout;
	private GridBagConstraints cCont;
	private Random rand;
	private JLabel name,pix,error,unse;
	private JProgressBar score;
	private JButton submit, home, timer,logout;
	private int grade;
	private String n,p;
	private Thread t;
	
	public Test(String nam, String dp)
	{
		super("ELearning CBT Program Develop By ISMAIL OLALEKAN R.(08139263853)");
		question = new ArrayList<>();
		currentQuestion = new ArrayList<>();
		n = nam;
		p = dp;
		
		container = new JPanel(new BorderLayout());
		container.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Student Test Page", TitledBorder.CENTER, TitledBorder.TOP));
		
		centerPanel();
		northPanel();
		
		container.add(new JScrollPane(cPan), BorderLayout.CENTER);
		container.add(north, BorderLayout.EAST);
		
		add(container);
		this.setSize(900,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	private void northPanel()
	{
		nePanel();
		nwPanel();
		westPanel();
		
		north = new JPanel(new GridLayout(0,1,2,2));
		north.setBorder(BorderFactory.createRaisedBevelBorder());
		JPanel container = new JPanel(new GridLayout(0,1,5,5));
		container.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Test Result", TitledBorder.CENTER, TitledBorder.TOP));
		
		score = new JProgressBar(0,100);
		score.setForeground(Color.GREEN);
		score.setStringPainted(true);
		score.setFont(new Font(null, Font.BOLD, 14));
		score.setBackground(Color.red);
		score.setVisible(false);
		score.setPreferredSize(new Dimension(250,30));
		
		error = new JLabel();
		error.setForeground(Color.red);
		error.setHorizontalAlignment(JLabel.CENTER);
		
		timer = new JButton();
		timer.setBackground(Color.BLACK);
		timer.setFont(new Font(null, Font.BOLD, 20));
		timer.setHorizontalAlignment(JLabel.CENTER);
		timer.setForeground(Color.GREEN);
		
		container.add(timer);
		container.add(error);
		container.add(score);
		container.add(score);
		
		north.add(nePan);
		north.add(nwPan);
		north.add(wPan);
		north.add(container);
		time();
	}
	private void westPanel()
	{
		wPan = new JPanel();
		JPanel container = new JPanel(new GridLayout(0,2,25,5));
		
		submit = new JButton("Submit");
		
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				submit();
				t.stop();
			}
		});
		home = new JButton("Try Again");
		home.setEnabled(false);
		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				 Test.super.dispose();
				t.stop();
				new Test("Ismummy", "Project/images/admin.jpg").setVisible(true);
			}
		});
		
		logout = new JButton("Logout");
		
		
		unse = new JLabel();
		JButton y = new JButton("Answered");
		y.setEnabled(false);
		y.setBackground(Color.YELLOW);
		JButton r = new JButton("Wrong!");
		r.setEnabled(false);
		r.setBackground(Color.RED);
		JButton g = new JButton("Correct!");
		g.setEnabled(false);
		g.setBackground(Color.GREEN);
		JButton n = new JButton("NOt Ans");
		n.setEnabled(false);
		
		
		//container.add(timer);
		
		container.add(submit);
		container.add(n);
		
		container.add(home);
		container.add(y);
		
		container.add(logout);
		container.add(g);
		container.add(unse);
		container.add(r);
		wPan.add(container);
		wPan.setBorder(BorderFactory.createRaisedBevelBorder());
		//wPan.setPreferredSize(new Dimension(200,100));
	}
	private void nwPanel()
	{
		JPanel container = new JPanel(new GridLayout(0,5,2,2));
		nwPan = new JPanel();
		button = new JButton[currentQuestion.size()];
		for(int i = 0; i< currentQuestion.size(); i++)
		{
			button[i] = new JButton(""+ (i+1));
			container.add(button[i]);
		}
		nwPan.add(container);
		nwPan.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Question Navigation", TitledBorder.CENTER, TitledBorder.TOP),BorderFactory.createLoweredBevelBorder()));
	}
	private void nePanel()
	{
		nePan = new JPanel();
		JPanel container = new JPanel(new BorderLayout());
		name = new JLabel(n);
		pix = new JLabel();
		Image i = getToolkit().createImage(p);
		i = i.getScaledInstance(120,120, Image.SCALE_SMOOTH);
		pix.setIcon(new ImageIcon(i));
		
		container.add(name, BorderLayout.NORTH);
		container.add(pix, BorderLayout.CENTER);
		nePan.add(container);
	}
	private void centerPanel()
	{
		cLayout = new GridBagLayout();
		cCont = new GridBagConstraints();
		rand = new Random();
		
		cPan = new JPanel(cLayout);
		loadQustion();
		generateQuestion();
		setQuestion();
	}
	private void loadQustion()
	{
		try
		{
			FileInputStream fis = new FileInputStream("project/files/question.txt");
			DataInputStream dis = new DataInputStream(fis);
			String [] question;
			
			while(true)
			{
				question = new String[6];
				question[0] = dis.readUTF();
				question[1] = dis.readUTF();
				question[2] = dis.readUTF();
				question[3] = dis.readUTF();
				question[4] = dis.readUTF();
				question[5] = dis.readUTF();
				this.question.add(question);
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
	private void generateQuestion()
	{
		int qIndex = rand.nextInt(question.size());
		currentQuestion.add(question.get(qIndex));
		group = new ButtonGroup[question.size()];
		for(int j=1; j<question.size(); j++)
		{	
			boolean cont = true;
			while (cont)
			{
				qIndex = rand.nextInt(question.size());
				for(int b=0; b< currentQuestion.size(); b++)
				{
					cont =currentQuestion.get(b)[0].contains(question.get(qIndex)[0]);
					if(cont)
						break;
				}
			}
			currentQuestion.add(question.get(qIndex));
		}
	}
	private void setQuestion()
	{
		for(int i=0; i< currentQuestion.size(); i++)
		{
			questionLabel = new JTextField();
			questionLabel.setEditable(false);
			questionLabel.setBackground(Color.white);
			questionLabel.setFont(new Font(null, Font.BOLD, 20));
			questionLabel.setText("(" + (i+1) + ") " + currentQuestion.get(i)[0]);
			cCont.fill = GridBagConstraints.BOTH;
			cCont.gridwidth = GridBagConstraints.REMAINDER;
			addComponent(questionLabel);
			optiona = new JRadioButton("(a) " + currentQuestion.get(i)[1]);
			optiona.addItemListener(this);
			optiona.setFont(new Font(null, Font.BOLD, 14));
			optiona.setActionCommand(currentQuestion.get(i)[1]);
			cCont.gridwidth = GridBagConstraints.REMAINDER;
			addComponent(optiona);
			optionb = new JRadioButton("(b) " + currentQuestion.get(i)[2]);
			optionb.addItemListener(this);
			optionb.setFont(new Font(null, Font.BOLD, 14));
			optionb.setActionCommand(currentQuestion.get(i)[2]);
			cCont.gridwidth = GridBagConstraints.REMAINDER;
			addComponent(optionb);
			optionc = new JRadioButton("(c) " + currentQuestion.get(i)[3]);
			optionc.addItemListener(this);
			optionc.setFont(new Font(null, Font.BOLD, 14));
			optionc.setActionCommand(currentQuestion.get(i)[3]);
			cCont.gridwidth = GridBagConstraints.REMAINDER;
			addComponent(optionc);
			optiond = new JRadioButton("(d) " + currentQuestion.get(i)[4]);
			optiond.addItemListener(this);
			optiond.setFont(new Font(null, Font.BOLD, 14));
			optiond.setActionCommand(currentQuestion.get(i)[4]);
			cCont.gridwidth = GridBagConstraints.REMAINDER;
			addComponent(optiond);
			
			group[i] = new ButtonGroup();
			group[i].add(optiona);
			group[i].add(optionb);
			group[i].add(optionc);
			group[i].add(optiond);
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		for(int i=0; i< currentQuestion.size(); i++)
		{
			if(group[i].getSelection()!=null)
			{
				button[i].setBackground(Color.YELLOW);
			}
		}
	}
	private void addComponent(Component comp)
	{
		cLayout.setConstraints(comp, cCont);
		cPan.add(comp);
	}
	public void time()
	{
		t = new Thread(){
		public void run()
		{
		int min = 1;
		try
		{
		while(true)
			{
				--min;
				for(int i=60-1; i>=0; i--)
				{
					timer.setText(min + ":" + i);
					double a = ((double) (min * 60 + i)/(double) (1*60)) * 100;
					if((int)a == 25)
					{
						getToolkit().beep();
						error.setText("You've used more than 75% of your time");
					}
					if((int)a <=25)
					{
						timer.setForeground(Color.red);
					}
					else if((int)a <=50)
						timer.setForeground(Color.yellow);
					else if((int)a <=100)
						timer.setForeground(Color.green);

					t.sleep(1000);	
				}
				if(min==0)
				{
					getToolkit().beep();
					error.setText("Time up!");
					submit();
					JOptionPane.showMessageDialog(Test.this, "Time up!\nYour attempt have been\nSubmited.");
					break;
				}
					
			}
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
		}
		};
		t.start();
	}
	private void submit()
	{
		for(int i=0; i< currentQuestion.size(); i++)
		{
			if(group[i].getSelection()!=null)
			{
				if(group[i].getSelection().getActionCommand().equals(currentQuestion.get(i)[5]))
				{
					++grade;
					button[i].setBackground(Color.GREEN);
				}
				else
					button[i].setBackground(Color.RED);
				
			}
			else
				button[i].setBackground(Color.RED);
				
				
			Enumeration<AbstractButton> elements = group[i].getElements();
			while (elements.hasMoreElements())
			{
				AbstractButton button = (AbstractButton)elements.nextElement();
				if(button.isSelected())
				{
					//button.setForeground(Color.yellow);
					continue;
				}
				button.setEnabled(false);
			}
		}
		double a = ((double) grade/ (double)currentQuestion.size()) * 100;
		score.setVisible(true);
		score.setValue((int)a);
		submit.setEnabled(false);
		home.setEnabled(true);
	}
	public static void main(String [] args)
	{
		Test t =new Test("Ismummy", "Project/images/admin.jpg");
		t.setVisible(true);
		
	}
}