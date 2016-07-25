import javax.swing.*;
import java.awt.event.*;
import javax.swing.tree.*;
public class TreeDemo extends JFrame
{
	private JSplitPane jsp;
	static JDesktopPane jdp;
	private JPanel p1;
	private JTree tre;
	JLabel lb;
	DefaultMutableTreeNode vc,dean,hod,depts;
	
	public TreeDemo()
	{
		//super("")
		jsp = new JSplitPane();
		jsp.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		jdp = new JDesktopPane();
		lb = new JLabel("<html><font color=red>&larr;</font></html>");
		p1 = new JPanel();
		setSize(600,500);
		vc = new DefaultMutableTreeNode("Vice Chancellor");
		dean = new DefaultMutableTreeNode("Dean");
		hod = new DefaultMutableTreeNode("Head of Dept");
		vc.add(dean);
		dean.add(hod);
		tre = new JTree(vc);
		tre.addMouseListener(new MouseAdapter()
	    {
		public void mouseClicked(MouseEvent me)
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)tre.getLastSelectedPathComponent();
			Object nodes = node.getUserObject();
			if(nodes==vc)
			{
			
			}
			
		}
	  });
		p1.add(tre);
		p1.add(lb);
		jsp.setTopComponent(p1);
		jsp.setBottomComponent(jdp);
		getContentPane().add(jsp);
	}
      
	// public void displayInts()
	// {
		// Dimension size;
		// Demos dos;
		// DemoInt.jdp.removeAll();
		// size = DemoInt.jdp.getSize();
		// dos = new Demos();
		// dos.setBounds(0,0,size.width,size.height);
		// dos.setVisible(true);
		// DemoInt.jdp.add(dos);
		
	// }
	public static void main(String[]args)
	{
		new TreeDemo().setVisible(true);
	}
}