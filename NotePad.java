import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class NotePad extends JFrame 
{
	private JMenu file,edit,format,view,help;
	private JMenuBar menuBar;
	private JMenuItem newPage,open,save,exit,undo,redo,cut,copy,paste,find,replace,gotoLine,font,background,foreground,about;
	private JToolBar toolBar;
	private ArrayList<JTextArea> editor = new ArrayList<>();
	private JTabbedPane tapPane;
	private JButton [] menuIcon;
	private Image menuIconDp[],rOver,tabIcon;
	private String [] menuIconString = {"new","open","save","cut","copy","paste","undo","redo"};
	private ArrayList<String> undoAction = new ArrayList<>(10);
	private ArrayList<String> redoAction = new ArrayList<>(10);
	private ArrayList<JPanel> editorPanel = new ArrayList<>();
	private JFileChooser fc;
	private JPopupMenu popupMenu;
	
	public NotePad()
	{
		super("-NotePad");
		setLayout(new BorderLayout());
		setSize(900,500);
		setLocationRelativeTo(null);
		
		createMenu();
		createMenuIcon();
		setPopupMenu();
		tapPane = new JTabbedPane();
		tapPane.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				createPopup(me);
			}
			public void mouseReleased(MouseEvent me)
			{
				createPopup(me);
			}
			private void createPopup(MouseEvent me)
			{
				if(me.isPopupTrigger())
				{
					popupMenu.show(me.getComponent(), me.getX(), me.getY());
				}
			}
		});
		setTab();
		fc = new JFileChooser();
		
	}
	private void createMenu()
	{
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		file.setMnemonic('F');
		
		edit = new JMenu("Edit");
		edit.setMnemonic('E');
		
		format = new JMenu("Format");
		format.setMnemonic('T');
		
		view = new JMenu("View");
		view.setMnemonic('V');
		
		help = new JMenu("Help");
		help.setMnemonic('H');
		
		//subMenu method
		createSubMenu();
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		menuBar.add(view);
		menuBar.add(help);
		setJMenuBar(menuBar);
	}
	private void createSubMenu()
	{
		newPage = new JMenuItem("New           Ctrl + N");
		newPage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK));
		open = new JMenuItem("Open            Ctrl + O");
		save = new JMenuItem("Save            Ctrl + S");
		exit = new JMenuItem("Exit            Ctrl + Q");
		undo = new JMenuItem("Undo             Ctrl + Z");
		undo.setEnabled(false);
		redo = new JMenuItem("Redo             Ctrl + Y");
		redo.setEnabled(false);
		cut = new JMenuItem("Cut            Ctrl + X");
		copy = new JMenuItem("Copy            Ctrl + C");
		paste = new JMenuItem("Paste            Ctrl + V");
		find = new JMenuItem("Find            Ctrl + F");
		replace = new JMenuItem("Replace           Ctrl + H");
		gotoLine = new JMenuItem("Goto            Ctrl + G");
		font = new JMenuItem("Font...           ");
		background = new JMenuItem("Background...           ");
		foreground = new JMenuItem("Foreground           ");
		about = new JMenuItem("About NotePad           ");
		
		//file
		file.add(newPage);
		file.add(open);
		file.add(save);
		file.add(exit);
		
		//edit
		edit.add(undo);
		edit.add(redo);
		edit.addSeparator();
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.addSeparator();
		edit.add(find);
		edit.add(replace);
		edit.add(gotoLine);
		
		//format
		format.add(font);
		format.add(background);
		format.add(foreground);
		
		//help
		help.add(about);
		
		//font event
		font.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				FontDialog font = new FontDialog(NotePad.this, true);
				font.setVisible(true);
				editor.get(tapPane.getSelectedIndex()).setFont(font.getFontSet());
			}
	   });
	   
	   //new Page Event
	   newPage.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{
			setTab();
		}
	   });
	   
	   //backgroud event
	   background.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent ae)
			{
				Color cc = JColorChooser.showDialog(NotePad.this,"Choose your Background", Color.WHITE);
				editor.get(tapPane.getSelectedIndex()).setBackground(cc);
			}
		});
		
		//foreground event
		foreground.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent ae)
			{
				Color cc = JColorChooser.showDialog(NotePad.this,"Choose your Background", Color.WHITE);
				editor.get(tapPane.getSelectedIndex()).setForeground(cc);
			}
		});
		
		//exit event
		exit.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
		
		//save event
		save.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent ae)
			{
				
				int ok = fc.showSaveDialog(NotePad.this);
				if(ok==JFileChooser.APPROVE_OPTION)
				{	
				  File fy = fc.getSelectedFile();
					try
					{
						FileWriter fw = new FileWriter(fy.getPath());
						BufferedWriter br = new BufferedWriter(fw);
						br.write(editor.get(NotePad.this.tapPane.getSelectedIndex()).getText());
						br.close();
						setTitle(fy.getAbsolutePath() + "-NotePad");
						tapPane.setTitleAt(tapPane.getSelectedIndex(), fy.getName());
					}
				catch(Exception e)
				{
				
				}
				}
			}
	   });
	   
	   //open event
	   open.addActionListener(new ActionListener()
	   {
			public void actionPerformed(ActionEvent ae)
			{
				
				int ok = fc.showOpenDialog(NotePad.this);
				if(ok==JFileChooser.APPROVE_OPTION)
				{	
				  File fy = fc.getSelectedFile();
					try
					{
						FileReader fr = new FileReader(fy.getPath());
						BufferedReader br = new BufferedReader(fr);
						editor.get(tapPane.getSelectedIndex()).setText(""+br.readLine());
						setTitle(fy.getAbsolutePath() + "-NotePad");
						tapPane.setTitleAt(tapPane.getSelectedIndex(), fy.getName());
						br.close();
					}
					catch(Exception e)
					{
					
					}
				}
			}
	  });
	  
	  //undo event
	  undo.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{
			if(undoAction.size()>1)
			{
				editor.get(tapPane.getSelectedIndex()).setText(undoAction.get(undoAction.size()-2));
				redoAction.add(undoAction.get(undoAction.size()-1));
				redo.setEnabled(true);
				menuIcon[7].setEnabled(true);
				undoAction.remove(undoAction.size()-1);
				undoAction.trimToSize();
			}
			else
				undo.setEnabled(false);
				menuIcon[6].setEnabled(false);
		}
	   });
	   redo.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{
			if(redoAction.size()>0)
			{
				editor.get(tapPane.getSelectedIndex()).setText(redoAction.get(redoAction.size()-1));
				undoAction.add(redoAction.get(redoAction.size()-1));
				undo.setEnabled(true);
				menuIcon[6].setEnabled(true);
				redoAction.remove(redoAction.size()-1);
				redoAction.trimToSize();
			}
			else
				redo.setEnabled(false);
				menuIcon[7].setEnabled(false);
		}
	   });
	   

	}
	private void createMenuIcon()
	{
		toolBar = new JToolBar();
		menuIcon = new JButton[menuIconString.length];
		menuIconDp = new Image[menuIconString.length];
		rOver = getToolkit().createImage("images/images/rOver.PNG");
		rOver = rOver.getScaledInstance(22,22,Image.SCALE_SMOOTH);
		
		for(int i=0; i<menuIconString.length; i++)
		{
			menuIconDp[i] = getToolkit().createImage("images/images/"+menuIconString[i]+".PNG");
			menuIconDp[i] = menuIconDp[i].getScaledInstance(18,18,Image.SCALE_SMOOTH);
			
			menuIcon[i] = new JButton();
			menuIcon[i].setBorder(BorderFactory.createEmptyBorder(0,2,0,2));
			menuIcon[i].setPreferredSize(new Dimension(18,18));
			menuIcon[i].setIcon(new ImageIcon(menuIconDp[i]));
			menuIcon[i].setToolTipText(menuIconString[i]);
			toolBar.add(menuIcon[i]);		
		}
		menuIcon[6].setEnabled(false);
		menuIcon[7].setEnabled(false);
		menuIcon[0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setTab();
			}
		});
		//.setEchoChar('%');
		menuIcon[6].addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{
			if(undoAction.size()>1)
			{
				editor.get(tapPane.getSelectedIndex()).setText(undoAction.get(undoAction.size()-2));
				redoAction.add(undoAction.get(undoAction.size()-1));
				menuIcon[7].setEnabled(true);
				redo.setEnabled(true);
				undoAction.remove(undoAction.size()-1);
				undoAction.trimToSize();
			}
			else
				menuIcon[6].setEnabled(false);
				undo.setEnabled(false);
		}
	   });
	   menuIcon[7].addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{
			if(redoAction.size()>0)
			{
				editor.get(tapPane.getSelectedIndex()).setText(redoAction.get(redoAction.size()-1));
				undoAction.add(redoAction.get(redoAction.size()-1));
				menuIcon[6].setEnabled(true);
				undo.setEnabled(true);
				redoAction.remove(redoAction.size()-1);
				redoAction.trimToSize();
			}
			else
				menuIcon[7].setEnabled(false);
				redo.setEnabled(false);
		}
	   });

		
		add(toolBar, BorderLayout.NORTH);
	}
	private void setTab()
	{
		tabIcon = getToolkit().createImage("images/images/tabIcon.PNG");
		tabIcon = tabIcon.getScaledInstance(25,23, Image.SCALE_SMOOTH);
		JPanel a = new JPanel(new BorderLayout());
		a.setBounds(2,2, getWidth(),getHeight());
		JTextArea b = new JTextArea();
		b.setBackground(Color.WHITE);
		b.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke)
			{
				redoAction.clear();
				redoAction.trimToSize();
				
				if(ke.getKeyCode()==KeyEvent.VK_ENTER)
				{
					undo.setEnabled(true);
					menuIcon[6].setEnabled(true);
					if(undoAction.size() < 10)
					{
						if(!undoAction.contains(editor.get(tapPane.getSelectedIndex()).getText()))
							undoAction.add(editor.get(tapPane.getSelectedIndex()).getText());
							System.out.println(undoAction.size());
					}
					else
					{
						undoAction.remove(0);
						undoAction.trimToSize();
						if(!undoAction.contains(editor.get(tapPane.getSelectedIndex()).getText()))
							undoAction.add(editor.get(tapPane.getSelectedIndex()).getText());
							System.out.println(undoAction.size());
					}
				}
			}
		});
		a.add(new JScrollPane(b) , BorderLayout.CENTER);
		editor.add(b);
		editorPanel.add(a);
		tapPane.addTab(String.format("%s%d","new",editor.size()),new ImageIcon(tabIcon),a,String.format("%s%d","new",editor.size()));
		add(tapPane, BorderLayout.CENTER);
	}
	private void setPopupMenu()
	{
		JMenuItem close = new JMenuItem("Close");
		JMenuItem closeall = new JMenuItem("Close All But This");
		JMenuItem newP = new JMenuItem("New");
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
		newP.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent ae)
		{
			setTab();
		}
	   });
		
		popupMenu = new JPopupMenu();
		popupMenu.add(close);
		popupMenu.add(closeall);
		popupMenu.addSeparator();
		popupMenu.add(newP);
		popupMenu.add(exit);
	}	
	public static void main(String [] args)
	{
		new NotePad().setVisible(true);
	}
	
}