import java.awt.*;

/** An example of coordinate translations and
 *  rotations with Java2D in Java 1.2.
 *  1998 Marty Hall, http://www.apl.jhu.edu/~hall/java/
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
    WindowUtilities.openInJFrame(new RotationExample(), 380, 400);
  }
}


import java.awt.*;

/** An example of Stroke (pen) widths with Java2D in Java 1.2.
 *  1998 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */

public class StrokeThicknessExample extends FontExample {
  public void paintComponent(Graphics g) {
    clear(g);
    Graphics2D g2d = (Graphics2D)g;
    drawGradientCircle(g2d);
    drawBigString(g2d);
    drawThickCircleOutline(g2d);
  }

  protected void drawThickCircleOutline(Graphics2D g2d) {
    g2d.setPaint(Color.blue);
    g2d.setStroke(new BasicStroke(8)); // 8-pixel wide pen
    g2d.draw(getCircle());
  }

  public static void main(String[] args) {
    WindowUtilities.openInJFrame(new StrokeThicknessExample(),
                                 380, 400);
  }
}



import java.awt.*;

/** An example of using local fonts with Java2D in Java 1.2.
 *  1998 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */

public class FontExample extends GradientPaintExample {
  public FontExample() {
    GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    setFont(new Font("Goudy Handtooled BT", Font.PLAIN, 100));
  }

  protected void drawBigString(Graphics2D g2d) {
    g2d.setPaint(Color.black);
    g2d.drawString("Java 2D", 25, 215);
  }

  public void paintComponent(Graphics g) {
    clear(g);
    Graphics2D g2d = (Graphics2D)g;
    drawGradientCircle(g2d);
    drawBigString(g2d);
  }

  public static void main(String[] args) {
    WindowUtilities.openInJFrame(new FontExample(), 380, 400);
  }
}
 

// This example also requires GradientPaintExample.java, 
// ShapeExample.java, WindowUtilities.java, and ExitListener.java 
// from the previous example on Gradient2d Colors.
