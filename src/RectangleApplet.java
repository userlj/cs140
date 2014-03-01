import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JApplet;

/**
   An applet that draws two rectangles.
*/
public class RectangleApplet extends JApplet
{  
   public void paint(Graphics g)
   {  
      // Prepare for extended graphics
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(3));
      // Construct a rectangle and draw it
      Rectangle box = new Rectangle(5, 10, 50, 60);
      g2.setColor(Color.YELLOW);
      g2.fill(box);
      g2.setColor(Color.RED);
      g2.draw(box);

      // Move rectangle 15 units to the right and 25 units down
      box.translate(15, 25);

      // Draw moved rectangle
      g2.setColor(new Color(0,0,255,150));
      g2.fill(box);
      g2.setColor(Color.RED);
      g2.draw(box);
   }
}

