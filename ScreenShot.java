/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomiwa
 */
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ScreenShot 
{
    static int i=0;
  public static void main(String[]args)
  {
      try
      {
          Robot robot = new Robot();
          //Capture a particular area on the screen
          int x = 50;
          int y = 50;
          int w = 250;
          int h = 250;
         
          Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //bt if were to b full screen  Toolkit.getDefaultToolkit().getScreenSize();
          BufferedImage bi = robot.createScreenCapture(area);
          //write generated image to the file
          try
          {
              File f = new File("C:\\dem\\Screen_shot.png");
              ImageIO.write(bi, "png", f);
              System.out.println("Screen shot successfull");
              i++;
          }
          catch(Exception se)
          {
              se.printStackTrace();
          }
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
  }
}
