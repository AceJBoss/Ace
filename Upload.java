import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class Upload extends JFrame
{
	private JLabel up;
	private JButton upb;
	private JFileChooser fc;
	File f;
	Image im;
	public Upload()
	{
		setLayout(new GridLayout(2,1));
		up = new JLabel();
		up.setPreferredSize(new Dimension(300,150));
		upb = new JButton("Upload");
		upb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				fc = new JFileChooser();
				int ok = fc.showOpenDialog(Upload.this);
				if(ok==JFileChooser.APPROVE_OPTION)
				{
					f = fc.getSelectedFile();
					im = getToolkit().createImage(f.getAbsolutePath());
					im = im.getScaledInstance(150,150,Image.SCALE_SMOOTH);
					up.setIcon(new ImageIcon(im));
				}
			}
		});
		add(up);
		add(upb);
	}
	public static void main(String [] arg)
	{
		Upload ap = new Upload();
		ap.pack();
		ap.setVisible(true);
	}
}