import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.awt.event.*;
import java.net.*;

public class MobileEmulator extends JFrame
{

private JButton [] noKeys;
private JButton lGoto,rGoto,call,endCall,cNavU,cNavD,cNavL,cNavR;
private String [] keys = {"<html>1<sub>abc</sub></html>","<html>2<sub>abc</sub></html>","<html><sub>def</sub>3</html>","<html>4<sub>ghi</sub></html>","<html>5<sub>jkl</sub></html>","<html><sub>mno</sub>6</html>","<html>7<sub>pqrs</sub></html>","<html>8<sub>tuv</sub></html>","<html><sub>wxyz</sub>9</html>","*","0","#"};
private String [] kkk = {"1","2","3","4","5","6","7","8","9","*","0","#"};
private String [][] number = {{"ismummy","08139263853"},{"Emergency","911"},{"bcd","87383873"},{"ismummy","08139263853"},{"Customer Agent","781287"},{"bcd","87383873"},{"ismummy","08139263853"},{"ade","781287"},{"bcd","87383873"},{"ismummy","08139263853"},{"ade","781287"},{"bcd","87383873"}};
private int numOption = 0;
private static JPanel numPanel, navPanel,disPanel,lNavPanel,rNavPanel,cNavPanel,contactPanel;
private JLabel title,screen,numP,numD;
private JTextArea display;
private ImageIcon rOption,lOption,dial,end,cUp,cDown,cRight,cLeft,scrn;
private Clip introClip;
private URL url;

public MobileEmulator()
{
	super("MOBILE EMULATOR");
	addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent e)
		{
		
			int ok = JOptionPane.showConfirmDialog(getContentPane(),"Are you sure u wana close?","Save",JOptionPane.YES_NO_OPTION);
			
			if(ok == JOptionPane.YES_OPTION)
				System.exit(0);
			
				
		}
	});
	setLayout(new FlowLayout());
	setSize(150,370);
	setResizable(false);
	getContentPane().setBackground(Color.BLUE);
	setLocation(300,100);
	numPanel = new JPanel();
	numPanel.setLayout(new GridLayout(4,3,5,5));
	
	noKeys = new JButton[keys.length];
	
	for(int i= 0; i<keys.length; i++)
	{
		noKeys[i] = new JButton(keys[i]);
		noKeys[i].setForeground(Color.WHITE);
		noKeys[i].setBackground(Color.BLACK);
		noKeys[i].addActionListener(new KeyHandler());
		noKeys[i].setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		numPanel.add(noKeys[i]);
		
	}
	
	lOption = new ImageIcon(getClass().getResource("image/button.PNG"));
	dial = new ImageIcon(getClass().getResource("image/dial.PNG"));
	//center = new ImageIcon(getClass().getResource("image/center.PNG"));
	rOption = new ImageIcon(getClass().getResource("image/button.PNG"));
	end = new ImageIcon(getClass().getResource("image/end.PNG"));
	cUp = new ImageIcon(getClass().getResource("image/cUp.PNG"));
	cDown = new ImageIcon(getClass().getResource("image/cDown.PNG"));
	cLeft = new ImageIcon(getClass().getResource("image/cLeft.PNG"));
	cRight = new ImageIcon(getClass().getResource("image/cRight.PNG"));
	
	lGoto = new JButton(lOption);
	lGoto.setBorder(BorderFactory.createEmptyBorder());
	
	rGoto = new JButton(rOption);
	rGoto.setBorder(BorderFactory.createEmptyBorder());
	rGoto.addActionListener(new KeyHandler());
	
	call = new JButton(dial);
	call.setBorder(BorderFactory.createEmptyBorder());
	call.addActionListener(new KeyHandler());
	
	endCall = new JButton(end);
	endCall.setBorder(BorderFactory.createEmptyBorder());
	endCall.addActionListener(new KeyHandler());
	
	cNavU = new JButton(cUp);
	cNavU.addActionListener(new KeyHandler());
	
	cNavD = new JButton(cDown);
	cNavD.addActionListener(new KeyHandler());
	cNavL = new JButton(cLeft);
	
	cNavR = new JButton(cRight);
	cNavU.setBorder(BorderFactory.createEmptyBorder());
	cNavD.setBorder(BorderFactory.createEmptyBorder());
	cNavL.setBorder(BorderFactory.createEmptyBorder());
	cNavR.setBorder(BorderFactory.createEmptyBorder());
	
	lNavPanel = new JPanel();
	lNavPanel.setLayout(new GridLayout(2,1,0,0));
	
	lNavPanel.add(lGoto);
	lNavPanel.add(call);
	
	rNavPanel = new JPanel();
	rNavPanel.setLayout(new GridLayout(2,1,0,0));
	rNavPanel.add(rGoto);
	rNavPanel.add(endCall);
	
	cNavPanel = new JPanel();
	cNavPanel.setLayout(new BorderLayout());
	cNavPanel.add(cNavU, BorderLayout.NORTH);
	cNavPanel.add(cNavD, BorderLayout.SOUTH);
	cNavPanel.add(cNavL, BorderLayout.WEST);
	cNavPanel.add(cNavR, BorderLayout.EAST);
	
	
	
	
	navPanel = new JPanel();
	navPanel.setLayout(new BorderLayout());
	navPanel.add(lNavPanel, BorderLayout.WEST);
	navPanel.add(rNavPanel, BorderLayout.EAST);
	navPanel.add(cNavPanel, BorderLayout.CENTER);
	
	disPanel = new JPanel();
	disPanel.setLayout(new BorderLayout());
	
	title = new JLabel("NOKIA");
	scrn = new ImageIcon(getClass().getResource("image/PG.PNG"));
	screen = new JLabel(scrn);
	title.setHorizontalAlignment(JLabel.CENTER);
	display = new JTextArea(7,10);
	display.setEditable(false);
	display.setFont(new Font(null, Font.BOLD, 14));
	disPanel.add(title, BorderLayout.NORTH);
	disPanel.add(screen, BorderLayout.CENTER);
	display.setMargin(new Insets(5,5,5,5));
	display.setLineWrap(true);
	display.setWrapStyleWord(true);
	add(disPanel);
	add(navPanel);
	add(numPanel);
}


public static void main(String [] args)
{
	new MobileEmulator().setVisible(true);
}

public void getAudio(String path)
{
	 try
			{	
				 if(introClip != null){
				introClip.stop(); 
				introClip.close();
				}
				
			    url = this.getClass().getClassLoader().getResource(path);
				AudioInputStream ais = AudioSystem.getAudioInputStream(url);
				introClip = AudioSystem.getClip();
				DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
				introClip = (Clip) AudioSystem.getLine(info);
				introClip.open(ais);
				
				if(introClip!=null)
				{
					introClip.start();
					
				}
					
			} 
			catch(Exception e){e.printStackTrace();}
}

private  class KeyHandler implements ActionListener
{
	
	public void actionPerformed(ActionEvent ev)
	{	
		Object so = ev.getSource();
		
		if(so==call)
		{	
		
			for(int i= 0 ; i< number.length; i++)
			{
				for(int j =0; j< number.length; j++)
				{
					 if(display.getText().equals(number[i][1].toString()))
					{
				
						displayMessage("Calling ...\n"+number[i][0]);
						return;
								
					}
					
				}
					
			}
			if(display.getText().startsWith("*") && display.getText().endsWith("#"))
			{
				displayMessage("Requesting\n Please wait ...\n");
				return;
					
			}
			else
			{	
				if(!(display.getText().equals("")))
				displayMessage("Calling ...\n" + display.getText() + "\n");
				else
					homeScreen();
				return;
					
			}
			
		}
		
		for(int i=0; i<noKeys.length; i++)
		{
			if(so==noKeys[i])
			{
				 displayMessage(display.getText()+ kkk[i]);
				 
			}
		}
		
		if(so == endCall)
		{
			homeScreen();
			
		}
		
		if(so == rGoto)
		{	
			if(!(display.getText().equals("")))
			displayMessage(display.getText().substring(0,display.getText().length()-1));
			else
				homeScreen();
				
		}
		if(so ==cNavU )
		{	
			if(numOption>1 )
			{
				numDisplay(--numOption);
			}
		}
		if(so == cNavD)
		{
			if(numOption< number.length-1)
			{
				numDisplay(++numOption);
			}
		}
		
			
		}
	}

private void homeScreen(){
	display.setText("");
	numOption = 0;
	MobileEmulator.disPanel.remove(display);
	MobileEmulator.disPanel.add(screen);
	this.repaint();
	
	
}
private void numDisplay(int pos)
{
		
	displayMessage(number[pos-1][0] + "\n" + number[pos-1][1] + "\n" + number[pos][0] + "\n" + number[pos][1]);
}
private void displayMessage(String details)
{	
	MobileEmulator.disPanel.remove(screen);
	MobileEmulator.disPanel.add(display);
	display.setText(details);
	repaint();
	
}
}