import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;

public class FontDialog extends JDialog implements ListSelectionListener, ActionListener
{
	private JList font,fontStyle,fontSize;
	private JLabel preview;
	private JButton ok,cancel;
	private String [] fontName = {"Monospaced","Serif","SansSerif","TimesRoman","Helvetica","Courier","Dialog","DialogInput","ZapfDingbats"};
	private String [] fontStyleName = {"Regular","Bold","Italic","Bold Italic"};
	private String [] fontSizeValue = {"8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
	private Font setFont = new Font(null,Font.PLAIN,10 );
	private int style = 0;
	private int size = 8;
	private String name = "null";
	
	public FontDialog(JFrame fr, boolean mode)
	{
		super(fr,mode);
		setTitle("Font");
		setSize(400,400);
		setLocationRelativeTo(fr);
		setLayout(new FlowLayout());
		preview = new JLabel("AaBbYyZz");
		preview.setPreferredSize(new Dimension(200,150));
		preview.setBorder(BorderFactory.createTitledBorder("Sample"));
		
		font = new JList(fontName);
		font.setVisibleRowCount(4);
		font.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		font.addListSelectionListener(this);
		fontStyle = new JList(fontStyleName);
		fontStyle.setVisibleRowCount(4);
		fontStyle.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		fontStyle.addListSelectionListener(this);
		fontSize = new JList(fontSizeValue);
		fontSize.setVisibleRowCount(4);
		fontSize.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		fontSize.addListSelectionListener(this);
		
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		ok.addActionListener(this);
		cancel.addActionListener(this);
		add(new JScrollPane(font));
		add(new JScrollPane(fontStyle));
		add(new JScrollPane(fontSize));
		add(preview);
		add(ok);
		add(cancel);
	}
	public void valueChanged( ListSelectionEvent event )
	{
		if(fontStyle.getSelectedIndex() == 0)
		{	
			style = Font.PLAIN;
		}
		else if(fontStyle.getSelectedIndex() == 1)
		{
			style = Font.BOLD;
		}
		else if(fontStyle.getSelectedIndex() == 2)
		{
			style = Font.ITALIC;
		}
		else if(fontStyle.getSelectedIndex() == 3)
		{
			style = Font.ITALIC + Font.BOLD;
		}
		if(event.getSource()==fontSize)
		size = Integer.parseInt(fontSizeValue[fontSize.getSelectedIndex()]);
		if(event.getSource()==font)
		name = fontName[font.getSelectedIndex()];
		setFont = new Font(name,style,size );
		preview.setFont(setFont);
	} 
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == cancel)
			setFont = getFontSet();
		super.dispose();
	}
	public static void main(String [] arg)
	{
		JFrame aa = new JFrame();
		new FontDialog(aa, true).setVisible(true);
		aa.pack();
		aa.setVisible(true);
	}
	public Font getFontSet()
	{
		return setFont;
	}
}