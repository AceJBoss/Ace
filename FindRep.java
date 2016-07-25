import javax.swing.*;
public class FindRep extends JDialog
{
	private JTabbedPane pane;
	private JMenuBar bar;
	private JMenu fl,opt,vw;
	private JPanel p1,p2,p3;
	public FindRep(JFrame fr, boolean modal)
	{
	 super(fr,modal);
	   setSize(300,300);
	   pane = new JTabbedPane();
	   p1 = new JPanel();
	   p2 = new JPanel();
	   p3 = new JPanel();
	   pane.addTab("Processes",p1);
	   pane.addTab("Performance",p2);
	   pane.addTab("App History",p3);
	   add(pane);
	}
	
}