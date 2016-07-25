import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FileDemo extends JFrame
{
	private JTextArea txt;
	private JButton save;
	private JPanel pan;
	
	public FileDemo()
	{
		txt = new JTextArea(10,20);
		save = new JButton("Save");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				JFileChooser choose = new JFileChooser();
				int ok = choose.showSaveDialog(FileDemo.this);
				if(ok == JFileChooser.APPROVE_OPTION)
				{
					try
					{
					File f = choose.getSelectedFile();
					BufferedWriter bw = new BufferedWriter(new FileWriter(choose.getSelectedFile().getPath()));
					bw.write(txt.getText());
					bw.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		pan = new JPanel(new BorderLayout());
		pan.add(txt, BorderLayout.CENTER);
		pan.add(save, BorderLayout.SOUTH);
		add(pan);
		
	}
	public static void main(String [] args)
	{
		FileDemo a = new FileDemo();
		a.setVisible(true);
		a.pack();
		
	}
}