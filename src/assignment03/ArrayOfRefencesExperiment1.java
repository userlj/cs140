package assignment03;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ArrayOfRefencesExperiment1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Rectangle[] array1 = {new Rectangle(10,10,50,50),
                new Rectangle(60,60,50,50),
                new Rectangle(110,110,50,50)};
        JFrame frame1 = new JFrame("Shows Array1");
        frame1.add(new RectangleComponent(array1, 2));
        frame1.setSize(400,400);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        
        Rectangle[] array2 = array1.clone();
        
        array2[0] = new Rectangle(10,10,60,60);
        array2[1] = new Rectangle(60,60,65,65);
        array2[2] = new Rectangle(110,110,70,70);
        
        JFrame frame2 = new JFrame("Shows Array2");
        frame2.add(new RectangleComponent(array2, 3));
        frame2.setSize(400,400);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);        
//        array2[0].setSize(60, 60);
//        array2[1].setSize(65, 65);
//        array2[2].setSize(70, 70);

    }
}