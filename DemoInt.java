import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class DemoInt extends JFrame
{
	private JSplitPane jsp;
	static JDesktopPane jdp;
	private JPanel p1;
	private JButton btn;
	
	public DemoInt()
	{
		//super("")
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				int ok = JOptionPane.showConfirmDialog(null,"Save","Are you sure u wana close?",JOptionPane.YES_NO_OPTION);
				if(ok==JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
				else
				{
					return;
				}
			}
		});
		jsp = new JSplitPane();
		jsp.setOrientation(JSplitPane.VERTICAL_SPLIT);
		jdp = new JDesktopPane();
		p1 = new JPanel();
		btn = new JButton("CALL NEW IFRAME");
		p1.add(btn);
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				displayInts();
			}
		});
		jsp.setTopComponent(p1);
		jsp.setBottomComponent(jdp);
		setSize(600,500);
		getContentPane().add(jsp);
	}
	public void displayInts()
	{
		Dimension size;
		Demos dos;
		DemoInt.jdp.removeAll();
		size = DemoInt.jdp.getSize();
		dos = new Demos();
		dos.setBounds(0,0,size.width,size.height);
		dos.setVisible(true);
		DemoInt.jdp.add(dos);
		
	}
	public static void main(String[]args)
	{
		new DemoInt().setVisible(true);
	}
}