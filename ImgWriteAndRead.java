/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomiwa
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;
public class ImgWriteAndRead extends JFrame
{
    JPanel p;
    JLabel pix;
    public ImgWriteAndRead()
    {
        p = new JPanel();
        pix = new JLabel("");
        p.add(pix);
        add(p);
      BufferedImage image = null;
        try
        {
            File img = new File("C:\\picture\\l.png");
            image = ImageIO.read(img);
            //writing now....
            ImageIO.write(image, "PNG", new File("C:\\dem\\home.PNG"));
			
			
			Image mg = getToolkit().createImage("C:\\dem\\home.jpg");
            mg = mg.getScaledInstance(132, 136, Image.SCALE_SMOOTH);
            pix.setIcon(new ImageIcon(mg));
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
    }
//    public void paint(Graphics g)
//    {
//        g.
//    }
    public static void main(String[]args)
    {
       ImgWriteAndRead im = new ImgWriteAndRead();
       im.setVisible(true);
       im.setSize(200,300);
    }
}
