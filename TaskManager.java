import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TaskManager extends JFrame
{
private JTabbedPane pane;
private JMenuBar bar;
private JMenu fl,opt,vw;
private JLabel lbl,lbl2;
private JButton next,prv;
private JTextField from,to;
private JTextArea msgDp;
private String [] msg = {"Hello There!","Are you there!","Come, I want you", "Hello World!", "This is Original"};
private String [] btnimg = {"a.PNG","b.PNG","c.PNG"};
private JButton [] iconMenu;
private int option = 0;
private JMenuItem nw;
private JPanel p1,p2,p3,p4,p5,p6;
private JButton lbl3;
private JToolBar tb;
private JPanel pan,o;
ImageIcon im,img2,img3;
private ImageIcon [] icon;
	public TaskManager()
	{
	
	   setSize(350,350);
	   setTitle("TASK MANAGER");
	   tb = new JToolBar();
	   pan = new JPanel();
	   pan.setLayout(new BorderLayout());
	   bar = new JMenuBar();
	   fl = new JMenu("File");
	   fl.setMnemonic('F');
	   nw = new JMenuItem("New");
	   fl.add(nw);
	   nw.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{	
			
			new FindRep(null,true).setVisible(true);
		}
	   });
	   opt = new JMenu("Option");
	   vw =  new JMenu("View");
	   bar.add(fl);bar.add(opt);bar.add(vw);
	   setJMenuBar(bar);
	   
	   im = new ImageIcon(getClass().getResource("images/a.jpg"));
	   lbl = new JLabel(im);
	   
	   iconMenu = new JButton[btnimg.length];
	   icon = new ImageIcon[btnimg.length];
	   for(int i = 0; i< btnimg.length; i++){
		icon[i] = new ImageIcon(getClass().getResource("img/" + btnimg[i]));
		iconMenu[i] = new JButton(icon[i]);
		iconMenu[i].setContentAreaFilled(false);
		iconMenu[i].setBorderPainted(false);
		tb.add(iconMenu[i]);
	}
	pan.add(tb, BorderLayout.NORTH);
	   
	   pane = new JTabbedPane();
	   p1 = new JPanel();
	   p1.add(lbl);
	   p2 = new JPanel();
	   p3 = new JPanel();
	   p4 = new JPanel();
	   p5 = new JPanel();
	   p6 = new JPanel();
	   
	   
	   p2.setLayout(new GridLayout(3,1,5,0));
	   
	   from = new JTextField(String.format("%d", option+1), 3);
	   to = new JTextField(String.format("%d", msg.length) , 3);
	   lbl2 = new JLabel("of");
	   p4.add(from);
	   p4.add(lbl2);
	   p4.add(to);
	   
	   
	   
	   msgDp = new JTextArea(10,10);
	   msgDp.setText(msg[option]);
	   p5.add(msgDp);
	   
	   next = new JButton("Next");
	   next.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent e){
			msgDp.setText(msg[++option]);
			if(option > 3)
			next.setEnabled(false);
			if(option > 0)
			prv.setEnabled(true);
			from.setText(String.format("%d", option+1));
			
			
	   }
	   });
	   prv = new JButton("Previous");
	   prv.setEnabled(false);
	   prv.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent e){
	   
			
			
			msgDp.setText(msg[--option]);
			if(option > 0 && option < 4)
			next.setEnabled(true);
			if(option == 0)
			prv.setEnabled(false);
			from.setText(String.format("%d", option+1));
			
			
	   }
	   });
	   p6.add(prv);
	   p6.add(next);
	   p2.add(p4);
	   p2.add(p5);
	   p2.add(p6);
	   
	   img2 = new ImageIcon(getClass().getResource("images/b.jpg"));
	   img3 = new ImageIcon(getClass().getResource("images/c.jpg"));
	   lbl3 = new JButton(img2);
	   lbl3.setRolloverIcon(img3);
	   
	   p3.add(lbl3);
	  // 
	  
	   
	   
	   pane.addTab("Processes",p1);
	   pane.addTab("Performance",p2);
	   pane.addTab("App History",p3);
	   pan.add(pane,BorderLayout.CENTER);
	   o.add(pan);
	   add(o);
	}
	public static void main(String[]args)
	{
		new TaskManager().setVisible(true);
	}
}