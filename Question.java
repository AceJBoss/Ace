import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;

public class Question extends JFrame
{
	private JLabel question, option1, option2,option3, option4, answer;
	private JTextField quest,optiona,optionb,optionc,optiond, ans;
	private JButton submit, reset, home;
	private GridBagLayout layout;
	private GridBagConstraints cont;
	private JPanel pan;
	
	public Question()
	{
		super("Add Question");
		layout = new GridBagLayout();
		cont = new GridBagConstraints();
		
		pan = new JPanel(layout);
		pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Add Question", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
		
		question  = new JLabel("Question: ");
		cont.fill = GridBagConstraints.BOTH;
		addComponent(question, 0,0,1,1);
		option1 = new JLabel("Option A: ");
		addComponent(option1, 1,0,1,1);
		option2 = new JLabel("Option B: ");
		addComponent(option2, 2,0,1,1);
		option3 = new JLabel("Option C: ");
		addComponent(option3, 3,0,1,1);
		option4 = new JLabel("Option D: ");
		addComponent(option4, 4,0,1,1);
		answer = new JLabel("Answer: ");
		addComponent(answer, 5,0,1,1);
		
		quest= new JTextField(10);
		addComponent(quest,0,1,2,1);
		optiona = new JTextField(10);
		addComponent(optiona,1,1,1,1);
		optionb = new JTextField(10);
		addComponent(optionb,2,1,1,1);
		optionc = new JTextField(10);
		addComponent(optionc,3,1,1,1);
		optiond = new JTextField(10);
		addComponent(optiond,4,1,1,1);
		ans = new JTextField(10);
		addComponent(ans,5,1,1,1);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					FileOutputStream fos = new FileOutputStream("project/files/question.txt", true);
					DataOutputStream dos = new DataOutputStream(fos);
					
					dos.writeUTF(quest.getText());
					dos.writeUTF(optiona.getText());
					dos.writeUTF(optionb.getText());
					dos.writeUTF(optionc.getText());
					dos.writeUTF(optiond.getText());
					dos.writeUTF(ans.getText());
					dos.close();
					quest.setText("");
					optiona.setText("");
					optionb.setText("");
					optionc.setText("");
					optiond.setText("");
					ans.setText("");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		addComponent(submit,6,0,1,1);
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				quest.setText("");
				optiona.setText("");
				optionb.setText("");
				optionc.setText("");
				optiond.setText("");
				ans.setText("");
				
			}
		});
		addComponent(reset,6,1,1,1);
		home = new JButton("Home");
		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new Admin().setVisible(true);
				Question.super.dispose();
			}
		});
		addComponent(home,6,2,1,1);
		
		add(pan);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	private void addComponent(Component comp, int r, int c, int noc, int nor)
	{
		cont.gridx = c;
		cont.gridy = r;
		cont.gridwidth = noc;
		cont.gridheight = nor;
		layout.setConstraints(comp, cont);
		pan.add(comp);
	}
	public static void main(String []  args)
	{
		new Question().setVisible(true);
		
	}
}