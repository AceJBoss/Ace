import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventD extends JFrame implements MouseMotionListener, MouseListener
{
	private JLabel status;
	private JPanel eventPanel;
	private String string;
	
	public MouseEventD()
	{
		setLayout(new BorderLayout());
		setSize(300,300);
		status = new JLabel();
		status.setHorizontalAlignment(JLabel.CENTER);
		eventPanel = new JPanel();
		eventPanel.addMouseMotionListener(this);
		eventPanel.addMouseListener(this);
		
		add(status, BorderLayout.SOUTH);
		add(eventPanel, BorderLayout.CENTER);
		
	}
	public void mouseEntered(MouseEvent me)
	{
		string = "Mouse Entered At X: " + me.getX()  +" Y: " +me.getY();
	}
	public void mouseExited(MouseEvent me)
	{
		string = "Mouse Exited At X: " + me.getX()  +" Y: "+ me.getY();
		status.setText(string);
	}
	public void mousePressed(MouseEvent me)
	{
		string = "Mouse Pressed At X: " + me.getX()  +" Y: " +me.getY();
		status.setText(string);
	}
	public void mouseReleased(MouseEvent me)
	{
		string = "Mouse Released At X: " + me.getX()  +" Y: " +me.getY();
		status.setText(string);
	}
	public void mouseMoved( MouseEvent event )
	{
		string = "Mouse Moved At X: " + event.getX()  +" Y: " +event.getY();
		status.setText(string);
	}
	public void mouseDragged(MouseEvent me)
	{
		string = "Mouse Dragged At X: " + me.getX()  +" Y: " +me.getY();
		status.setText(string);
	}
	public void mouseClicked(MouseEvent me)
	{
		string = "Mouse Clicked At X: " + me.getX()  +" Y: " +me.getY();
		status.setText(string);
	}
	 public static void main(String [] ard)
	{
		new MouseEventD().setVisible(true);
	} 
}