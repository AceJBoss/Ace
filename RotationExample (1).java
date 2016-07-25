import java.awt.*;

/** An example of translating and rotating the coordinate
 *  system before each drawing.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 */

public class RotationExample extends StrokeThicknessExample {
  private Color[] colors = { Color.white, Color.black };

  public void paintComponent(Graphics g) {
    clear(g);
    Graphics2D g2d = (Graphics2D)g;
    drawGradientCircle(g2d);
    drawThickCircleOutline(g2d);
    // Move the origin to the center of the circle.
    g2d.translate(185.0, 185.0);
    for (int i=0; i<16; i++) {
      // Rotate the coordinate system around current
      // origin, which is at the center of the circle.
      g2d.rotate(Math.PI/8.0);
      g2d.setPaint(colors[i%2]);
      g2d.drawString("Java", 0, 0);
    }
  }

public static void main(String[] args) {
    WindowUtilities.openInJFrame(new RotationExample(),
                                 380, 400);
  }
}