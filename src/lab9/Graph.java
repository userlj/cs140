package lab9;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * A component that draws a graphs of the
 * paths provided by the class that calls this one
 * @author CS 140
 */
public class Graph extends JComponent {
   
    private Path2D.Double path = new Path2D.Double();
    private double[] x;
    private double[] y;
    private Path2D.Double path1 = new Path2D.Double();
    private double[] x1;
    private double[] y1;
    // radius of dot on graph
    private int r = 5;
   
    public Graph(double[] x, double[] y,
            double[] x1, double[] y1) {
        this.x = x;
        this.y = y;
        if(x.length != y.length) {
            JOptionPane.showMessageDialog(this, "Cannot make a graph." +
                    "\nArrays have different length");
        }
        path.moveTo(x[0], y[0]);
        for(int i = 1; i < x.length; i++) {
            path.lineTo(x[i], y[i]);
        }
        this.x1 = x1;
        this.y1 = y1;
        if(x1.length != y1.length) {
            JOptionPane.showMessageDialog(this, "Cannot make a graph." +
                    "\nArrays have different length");
        }
        path1.moveTo(x1[0], y1[0]);
        for(int i = 1; i < x1.length; i++) {
            path1.lineTo(x1[i], y1[i]);
        }
    }


    /**
     * Implementation of the paintComponent method
     * for this component. It draws a sequence of
     * straight lines between the points in the
     * paths provided to the component
     */
    @Override
    public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLUE);
        g2.draw(path);
        g2.setColor(Color.BLACK);
        for(int i = 0; i < x.length; i++)
        g2.fill(new Ellipse2D.Double(x[i]-r,y[i]-r,2*r,2*r));

        g2.setColor(Color.GREEN);
        g2.draw(path1);
        g2.setColor(Color.RED);
        for(int i = 0; i < x1.length; i++)
        g2.fill(new Ellipse2D.Double(x1[i]-r,y1[i]-r,2*r,2*r));

    }
}