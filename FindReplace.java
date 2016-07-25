import java.awt.*;
import javax.swing.*;

public class FindReplace extends JDialog
{
	private JPanel buttonPanel,fieldPanel,checkBoxPanel,replacePanel,buttonPan,fieldPan,checkBoxPan,findPan,gotoPanel;
	private JLabel findL,replaceL,findL1;
	private JTextField findF,replaceF,findF1;
	private JTabbedPane tabPane;
	private JButton findB,replaceB,replaceAllB,cancelB,findB1,replaceB1,replaceAllB1,cancelB1;
	private JTextArea editor;
	private JCheckBox matchCase,matchWord, selection,matchCase1,matchWord1, selection1;
	
	public FindReplace(JFrame fr, boolean mode,JTextArea editor, int selection)
	{
		super(fr, mode);
		setLocationRelativeTo(fr);
		setSize(450,200);
		setReplace();
		setFind();
		setGoto();
		tabPane = new JTabbedPane();
		tabPane.addTab("Find", findPan);
		tabPane.addTab("Replace", replacePanel);
		tabPane.addTab("Goto", gotoPanel);
		tabPane.setSelectedIndex(selection);
		
		add(tabPane);
		
	}
	private void setReplace()
	{
		fieldPanel = new JPanel(new BorderLayout());
		
		findL = new JLabel("Find what: ");
		replaceL = new JLabel("Replace with: ");
		
		findF = new JTextField(20);
		replaceF = new JTextField(20);
		
		fieldPanel.add(findL);
		fieldPanel.add(replaceL);
		fieldPanel.add(findF);
		fieldPanel.add(replaceF);
		
		buttonPanel = new JPanel(new GridLayout(4,1,5,0));
		
		findB = new JButton("Find");
		replaceB = new JButton("Replace");
		replaceAllB = new JButton("Replace All");
		cancelB = new JButton("Cancel");
		
		buttonPanel.add(findB);
		buttonPanel.add(replaceB);
		buttonPanel.add(replaceAllB);
		buttonPanel.add(cancelB);
		
		checkBoxPanel = new JPanel();
		
		matchCase = new JCheckBox("Match Case");
		matchWord = new JCheckBox("Match Word");
		selection = new JCheckBox("In Selection");
		
		checkBoxPanel.add(matchWord);
		checkBoxPanel.add(matchCase);
		checkBoxPanel.add(selection);
		
		replacePanel = new JPanel(new BorderLayout());
		
		replacePanel.add(fieldPanel, BorderLayout.CENTER);
		replacePanel.add(buttonPanel, BorderLayout.EAST);
		replacePanel.add(checkBoxPanel, BorderLayout.SOUTH);
		
	}
	private void setFind()
	{
		fieldPan = new JPanel(new FlowLayout());
		
		findL1 = new JLabel("Find what: ");
		
		findF1 = new JTextField(20);
				
		fieldPan.add(findL1);
		fieldPan.add(findF1);
		
		buttonPan = new JPanel(new GridLayout(4,1,5,0));
		
		findB = new JButton("Find");
		replaceB = new JButton("Replace");
		replaceAllB = new JButton("Replace All");
		cancelB = new JButton("Cancel");
		
		buttonPan.add(findB);
		buttonPan.add(replaceB);
		buttonPan.add(replaceAllB);
		buttonPan.add(cancelB);
		
		checkBoxPan = new JPanel();
		
		matchCase = new JCheckBox("Match Case");
		matchWord = new JCheckBox("Match Word");
		selection = new JCheckBox("In Selection");
		
		checkBoxPan.add(matchWord);
		checkBoxPan.add(matchCase);
		checkBoxPan.add(selection);
		
		findPan = new JPanel(new BorderLayout());
		
		findPan.add(fieldPan, BorderLayout.CENTER);
		findPan.add(buttonPan, BorderLayout.EAST);
		findPan.add(checkBoxPan, BorderLayout.SOUTH);
		
	}
	private void setGoto()
	{
		gotoPanel = new JPanel();
	}
	public static void main(String [] args)
	{
		JFrame a = new JFrame();
		new FindReplace(a,true,null ,1).setVisible(true);
		a.pack();
		a.setVisible(true);
	}
}