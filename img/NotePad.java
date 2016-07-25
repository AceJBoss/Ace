import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;

public class NotePad extends JFrame{


private JMenuBar bar,iconBar;
private JMenu [] menu;
private JMenuItem nw,open,save,font;
private String [] menuOptions = {"File","Edit","Search","View","Encoding","Language","Settings","Macro","Run","TextFX","Plugins","Window","?"};
private String [] menuIconOptions = {"a.PNG","b.PNG","c.PNG","d.PNG","e.PNG","f.PNG","g.PNG","h.PNG","i.PNG","j.PNG"};
private JTabbedPane  tab;
private String newTab = "new ";
private JButton [] iconMenu;
private int page = 1;
private JTextArea [] editorFace, editorNo;
private ImageIcon [] icon;
private JPanel [] editorPanel;
private JToolBar tBar;


public NotePad(){

	setTitle(String.format("%s%d -Notepad",newTab,page));
	setSize(1000,700);
	bar = new JMenuBar();
	menu = new JMenu[menuOptions.length];
	iconMenu = new JButton[menuIconOptions.length];
	icon = new ImageIcon[menuIconOptions.length];

	for(int i= 0; i< menuOptions.length; i++){

		menu[i] = new JMenu(menuOptions[i]);
		menu[i].setMnemonic(menuOptions[i].charAt(0));
		bar.add(menu[i]);
	}
	nw = new JMenuItem("New                Ctrl + N");
	open = new JMenuItem("open...");
	open.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{
			JFileChooser fc = new JFileChooser();
			int ok = fc.showOpenDialog(NotePad.this);
			if(ok==JFileChooser.APPROVE_OPTION)
			{	try
			{
			    FileReader fw = new FileReader(fc.getSelectedFile().getAbsolutePath());
				BufferedReader br = new BufferedReader(fw);
				editorFace[page].setText(""+br.read());
			}
			catch(Exception e)
			{
			
			}
			}
		}
	   });
	
	save = new JMenuItem("save");
	save.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{
			JFileChooser fc = new JFileChooser();
			int ok = fc.showSaveDialog(NotePad.this);
			if(ok==JFileChooser.APPROVE_OPTION)
			{	
			  File fy = fc.getSelectedFile();
				try
				{
					FileWriter fw = new FileWriter(fy.getAbsolutePath());
					BufferedWriter br = new BufferedWriter(fw);
					br.write("Diamond");
					setTitle(fy.getName());
				}
			catch(Exception e)
			{
			
			}
			}
		}
	   });
	font = new JMenuItem("Font");
	nw.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{
			setTab(++page);
		}
	   });
	 font.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{
			FontDialog font = new FontDialog(NotePad.this, true);
			font.setVisible(true);
			for(int i = 0; i< page; i++)
			{
				editorFace[i].setFont(font.getFontSet());
			}
		}
	   });
	menu[0].add(nw);
	menu[0].add(open);
	menu[0].add(save);
	menu[0].add(font);
	setJMenuBar(bar);
	tBar = new JToolBar();

	for(int i = 0; i< menuIconOptions.length; i++){
		icon[i] = new ImageIcon(getClass().getResource("img/" + menuIconOptions[i]));
		iconMenu[i] = new JButton(icon[i]);
		iconMenu[i].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		iconMenu[i].setPreferredSize(new Dimension(5,15));

		tBar.add(iconMenu[i]);
	}
	add(tBar, BorderLayout.NORTH);



	tab = new JTabbedPane();
	setTab(page);
	add(tab);

}

private void setTab(int not){
	editorPanel = new JPanel[not];
	editorFace = new JTextArea[not];
	editorNo = new JTextArea[not];
	tab.removeAll();


for(int i = 0; i< not; i++){

	editorPanel[i] = new JPanel();
	editorPanel[i].setLayout(new BorderLayout());

	editorNo[i] = new JTextArea(getWidth(),5);
	editorNo[i].setEnabled(false);
	editorNo[i].setEditable(false);
	editorNo[i].setBackground(Color.LIGHT_GRAY);


	editorFace[i] = new JTextArea();
	editorFace[i].setSize(getWidth(),getHeight());
	editorFace[i].setBackground(Color.WHITE);
	editorPanel[i].add(new JScrollPane(editorFace[i]), BorderLayout.CENTER);
	editorPanel[i].add(editorNo[i], BorderLayout.WEST);
	tab.addTab(String.format("%s%d",newTab,i),editorPanel[i]);


}

}


public static void main(String [] arg){

	new NotePad().setVisible(true);

}
}