import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ColorJSlider extends JFrame
{
	private JTextField red,green,blue;
	private JLabel r,g,b,re,ge,be;
	private JSlider rSlide,gSlide,bSlide;
	private JPanel pan;
	private GridBagLayout layout;
	private GridBagConstraints constraint;
	private Color color;
		
	public ColorJSlider()
	{
		super("Color Value");
		layout = new GridBagLayout();
		constraint = new GridBagConstraints();
		pan = new JPanel(layout);
		
		color = new Color(0,0,0);
		
		r = new JLabel("R: ");
		addComponent(r,0,0,1,1);
		
		red = new JTextField("0",5);
		red.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
				re.setText("");
			}
			public void focusLost(FocusEvent fe)
			{
				if(red.getText().matches("\\d{1,3}"))
					rSlide.setValue(Integer.parseInt(red.getText()));
				else
					re.setText("Invalid input!");
					repaint();
			}
		});
		addComponent(red,0,1,1,1);
		
		re = new JLabel();
		re.setForeground(Color.RED);
		addComponent(re,0,2,1,1);
		
		g = new JLabel("G: ");
		addComponent(g,1,0,1,1);
		
		green = new JTextField("0",5);
		green.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
				ge.setText("");
			}
			public void focusLost(FocusEvent fe)
			{
				if(green.getText().matches("\\d{1,3}"))
					gSlide.setValue(Integer.parseInt(green.getText()));
				else
					ge.setText("Invalid input!");
					repaint();
			}
		});
		addComponent(green,1,1,1,1);
		
		ge = new JLabel();
		ge.setForeground(Color.RED);
		addComponent(ge,1,2,1,1);
		
		b = new JLabel("B: ");
		addComponent(b, 2,0,1,1);
		
		blue = new JTextField("0",5);
		blue.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent fe)
			{
				be.setText("");
			}
			public void focusLost(FocusEvent fe)
			{
				if(blue.getText().matches("\\d{1,3}"))
					bSlide.setValue(Integer.parseInt(blue.getText()));
				else
					be.setText("Invalid input!");
					repaint();
			}
		});
		addComponent(blue,2,1,1,1);
		
		be = new JLabel();
		be.setForeground(Color.RED);
		addComponent(be,2,2,1,1);
		
		DrawPanel panel = new DrawPanel();
		panel.setBackground(color);
		addComponent(panel, 3,0,3,1);
		
		rSlide = new JSlider(JSlider.HORIZONTAL,0,255,0);
		rSlide.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent ce)
			{
				red.setText(""+rSlide.getValue());
				color = new Color(rSlide.getValue(), gSlide.getValue(), bSlide.getValue());
				panel.setBackground(color);
				repaint();
			}
		});
		rSlide.setMajorTickSpacing(10);
		rSlide.setPaintTicks(true);
		addComponent(rSlide,4,0,3,1);
		
		gSlide = new JSlider(JSlider.HORIZONTAL,0,255,0);
		gSlide.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent ce)
			{
				green.setText(""+gSlide.getValue());
				color = new Color(rSlide.getValue(), gSlide.getValue(), bSlide.getValue());
				panel.setBackground(color);
				repaint();
			}
		});
		gSlide.setMajorTickSpacing(10);
		gSlide.setPaintTicks(true);
		addComponent(gSlide,5,0,3,1);
		
		bSlide = new JSlider(JSlider.HORIZONTAL,0,255,0);
		bSlide.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent ce)
			{
				blue.setText(""+bSlide.getValue());
				color = new Color(rSlide.getValue(), gSlide.getValue(), bSlide.getValue());
				panel.setBackground(color);
				repaint();
			}
		});
		bSlide.setMajorTickSpacing(10);
		bSlide.setPaintTicks(true);
		addComponent(bSlide,6,0,3,1);
		add(pan);
	}
	private void addComponent(Component comp, int row, int col, int noc,int nor)
	{
		constraint.gridy = row;
		constraint.gridx = col;
		constraint.gridwidth = noc;
		constraint.gridheight = nor;
		layout.setConstraints(comp, constraint);
		pan.add(comp);
	}
	public static void main(String [] args)
	{
	 ColorJSlider a = new ColorJSlider();
	 a.setVisible(true);
	 a.pack();
	 a.setLocationRelativeTo(null);
	
	}
}