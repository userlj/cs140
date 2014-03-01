package assignment03;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class RectangleComponent extends JComponent {
    private static final long serialVersionUID = 3860845091356485268L;
    private Rectangle[] array;
    private int stroke;
    
    public RectangleComponent(Rectangle[] array, int stroke) {
        this.array = array;
        this.stroke = stroke;
    }

    public void paintComponent(Graphics g) {  
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(stroke));
      for(int i = 0; i < array.length; i++) {
          g2.draw(array[i]);
      }
   }
}