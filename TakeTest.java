import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class TakeTest extends JPanel implements ActionListener
{
	private JLabel [] qLabel;
	private JRadioButton [] options;
	private ButtonGroup [] group;
	private String [][] questions = {{"what is 2+2", "5","6","7","4","4"},
									{"Variables of type double represent______floating-point numbers.", "double-precision","double-expression","single-precision","single-expression","double-precision"},
									{"what is 3*3", "5","9","7","8","9"},
									{"what is 5-3", "2","9","7","4","2"},
									{"what is 8/2", "5","6","7","4","4"},
									{"what is 2*2", "5","4","7","8","4"},
									{"what is 3+3", "6","9","7","4","6"},
									{"what is 8-2", "5","6","7","4","6"},
									{"what is 5+3", "5","9","7","8","8"},
									{"what is 5*3", "15","9","7","4","15"},
									{"what is 2/2", "5","1","7","4","1"},
									{"what is 3-3", "5","9","0","8","0"},
									{"what is 5-2", "2","3","7","4","3"},
									{"what is 8/4", "5","2","7","4","2"},
									{"what is 3/3", "1","9","7","8","1"},
									{"what is 2-2", "2","9","0","4","0"},
									{"what is 8-4", "5","4","7","4","4"}};
	private String [][] currentQuestion;
	private JButton submit,retry, next,prv;
	private JLabel north,uScore;
	private JPanel northPan,southPan,center,optionPan[];
	private Random rand;
	private int score = 0;
	
	public TakeTest()
	{	
		setLayout(new BorderLayout());
		rand = new Random();
		southPan = new JPanel();
		northPan = new JPanel();
		
		options = new JRadioButton[4];
		int a = questions.length;
		group = new ButtonGroup[a];
		optionPan = new JPanel[a];
		qLabel = new JLabel[a];
		center = new JPanel(new GridLayout(a*2,0));
		
		submit = new JButton("Submit");
		retry = new JButton("Try Again");
		retry.setEnabled(false);
		retry.addActionListener(this);
		submit.addActionListener(this);
		southPan.add(submit);
		uScore = new JLabel();
		
		southPan.add(retry);
		southPan.add(uScore);
		north = new JLabel("<html><p style='color: #00CED1; font-size:15px'>WELCOME TO KIS E-LEARNING TAKE A TEST PAGE</p></html>");
		northPan.add(north);
		generateQuestion();
		setQuestion();
		add(northPan, BorderLayout.NORTH);
		add(new JScrollPane(center), BorderLayout.CENTER);
		add(southPan, BorderLayout.SOUTH);
		
		
	}
	private void generateQuestion()
	{
		currentQuestion = new String[10][6];
		for(int j=0; j<currentQuestion.length; j++)
		{
			boolean cont = true;
			int qIndex = 0;
			while (cont)
			{
				qIndex = rand.nextInt(questions.length);
				for(int b=0; b< currentQuestion.length; b++)
				{
					cont = Arrays.asList(currentQuestion[b]).contains(questions[qIndex][0]);
					if(cont)
						break;
				}
			}
			for(int i=0; i<currentQuestion[j].length; i++)
			{
				currentQuestion[j][i] = questions[qIndex][i];
			}
		}
	}
	
	private void setQuestion()
	{
		center.removeAll();
		for(int i=0; i< currentQuestion.length; i++)
		{
			qLabel[i] = new JLabel();
			qLabel[i].setText("Q("+(i+1)+"): "+currentQuestion[i][0]);
			qLabel[i].setHorizontalAlignment(JLabel.CENTER);
			qLabel[i].setFont(new Font(null, Font.BOLD, 14));
			group[i] = new ButtonGroup();
			optionPan[i] = new JPanel(new FlowLayout());
			for(int j=0; j< options.length; j++)
			{
				options[j] = new JRadioButton();
				options[j].setText( currentQuestion[i][j+1]);
				options[j].setActionCommand(currentQuestion[i][j+1]);
				options[j].setEnabled(true);
				options[j].setFont(new Font(null, Font.BOLD, 14));
				group[i].add(options[j]);
				optionPan[i].add(options[j]);
			}
			center.add(qLabel[i]);
			center.add(optionPan[i]);
		}
		repaint();
	}
	
	public void actionPerformed(ActionEvent ev)
	{	
		if(ev.getSource() == submit)
		{
			for(int i=0; i<currentQuestion.length; i++)
			{
				if(group[i].getSelection() != null)
					if(group[i].getSelection().getActionCommand().equals(currentQuestion[i][5]))
						++score;
			}
			uScore.setText("Your Score is "+((double)score/(double)currentQuestion.length)*100 + "%");
			submit.setEnabled(false);
			retry.setEnabled(true);
		}
		else if(ev.getSource() == retry)
		{
			generateQuestion();
			setQuestion();
			uScore.setText("");
			score = 0;
			submit.setEnabled(true);
			retry.setEnabled(false);
			this.repaint();
			this.revalidate();
		}
	}
	/* public static void main(String [] ard)
	{
		JFrame aa = new JFrame();
		aa.add(new TakeTest());
		aa.pack();
		aa.setVisible(true);
	} */
}