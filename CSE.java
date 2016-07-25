//file demo3
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

public class CSE extends JFrame
{
	private JTextArea numbers;
	private JTextField input;
	private JPanel pan;
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private JLabel label;
	private ArrayList<String> number;
	private JButton add;
	
	public CSE()
	{
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		number = new ArrayList<>();
		
		pan = new JPanel();
		pan.setLayout(layout);
		
		label = new JLabel("Enter your number");
		constraints.gridx = GridBagConstraints.REMAINDER;
		addComponent(label);
		
		input = new JTextField(10);
		input.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent ke)
			{	
				numbers.setText("");
				if(input.getText().matches("\\d{1,13}"))
				{
					for(int i=0; i<number.size(); i++)
					{
						if(number.get(i).startsWith(input.getText()))
						{
							numbers.append(number.get(i)+"\n");
						}
					}
					if(numbers.getText().equals(""))
					{
						numbers.setText("Not Found!");
					}
				}
				else
					numbers.setText("Invalid Number");
			}
		});
		constraints.gridx = GridBagConstraints.REMAINDER;
		addComponent(input);
		
		numbers = new JTextArea(5,10);
		numbers.setEditable(false);
		constraints.gridx = GridBagConstraints.REMAINDER;
		addComponent(new JScrollPane(numbers));
		
		add = new JButton("Add Number");
		constraints.gridx = GridBagConstraints.REMAINDER;
		add.setVisible(true);
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				number.add(input.getText());
				addNumber();
			}
		});
		addComponent(add);
		
		add(pan);
		try
			{
				Scanner input = new Scanner(new File("000.txt"));
				while(input.hasNext())
				{
					String line = input.nextLine();
					if(!number.contains(line))
						number.add(line);
				}
				input.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}
	private void addComponent(Component comp)
	{
		layout.setConstraints(comp, constraints);
		pan.add(comp);
	}
	private void addNumber()
	{
		try
		{
		FileWriter fw = new FileWriter("000.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0; i<number.size(); i++)
		{
			bw.write(number.get(i) + " \n");
		}
		bw.close();
		}
		catch(Exception e)
		{
		}
	}
	public static void main(String [] args)
	{
		CSE a = new CSE();
		a.pack();
		a.setVisible(true);
		a.setLocationRelativeTo(null);
		a.setSize(150,200);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}