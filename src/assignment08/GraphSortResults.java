package assignment08;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
/**
 * Driver class that creates a JFrame to hold the
 * component that shows a drawing of two paths,
 * connecting the points provided by the main method.
 *
 * @author CS 140
 *
 */
public class GraphSortResults {

        /**
         * Main method draws a JFrame and places the
         * component with graphs of the time taken by the
         * sorts
         * @param args command line arguments are not used
         */
        public static void main(String[] args) {
        	// 1 is BLUE, 2 is GREEN, 3 is BLACK, 4 is RED
        	//Sorter sorter1 = new NaiveQuickListSorter();
            Sorter sorter1 = new TextbookQuickSorter();
            Sorter sorter2 = new TextbookMergeSorter();
            //Sorter sorter2 = new InsertionSorter();
            Sorter sorter3 = new NaiveQuickListSorter();
            Sorter sorter4 = new MergeSorter();

            JFrame frame = new JFrame();

            Random r = new Random();
            int factor = 300000;
            double[] x = {0,1,2,3,4,5,6,7,8,9};
            double[] y1 = new double[x.length];
            double[] sample;
            double[] y2 = new double[x.length];
            double[] y3 = new double[x.length];
            double[] y4 = new double[x.length];
            double[] copy2;
            double[] copy3;
            double[] copy4;
            for (int i = 1; i < x.length; i++) {
                sample = new double[factor*i];
                for(int j = 0; j < sample.length; j++) {
                    sample[j] = r.nextDouble();
                }
                //Arrays.sort(sample);
                copy2 = sample.clone();
                copy3 = sample.clone();
                copy4 = sample.clone();
                y1[i] = sorter1.timedSort(sample);
                System.out.println(y1[i]);

                y2[i] = sorter2.timedSort(copy2);
                System.out.println(y2[i]);

                y3[i] = sorter3.timedSort(copy3);
                System.out.println(y3[i]);

                y4[i] = sorter4.timedSort(copy4);
                System.out.println(y4[i]);
            }
            for(int i = 1; i < x.length; i++) {
                x[i] = 20 + 500*x[i]/x[x.length-1];
            }
            double max1 = Math.max(y1[y1.length-1], y2[y2.length-1]);
            double max2 = Math.max(y3[y3.length-1], y4[y4.length-1]);
            double max = Math.max(max1,  max2);
            for(int i = 0; i < y1.length; i++) {
                y1[i] = 550 - 550*y1[i]/max;
                y2[i] = 550 - 550*y2[i]/max;
                y3[i] = 550 - 550*y3[i]/max;
                y4[i] = 550 - 550*y4[i]/max;
            }
            frame.setSize(540, 600);
            frame.setTitle("Times");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Graph component = new Graph(x,y1,x,y2,x,y3,x,y4);
            //Graph component = new Graph(x,y1,x,y3,x,y4);
            //Graph component = new Graph(x,y1,x,y2);
            //Graph component = new Graph(x,y1);

            frame.add(component);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }