package lab9;

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

    public long bubblesortCount(double[] array) {
        long count = 0;
        boolean changed = true; count++;
        while(changed) { count++;
            changed = false; count++;
            count++; // for the "int i = 0"
            for(int i = 0; i < array.length-1 && count++ >= 0; i++, count++){
                count++;
                if(array[i+1]<array[i]) { 
                    array[i] = array[i]+array[i+1]; count++;
                    array[i+1]=array[i]-array[i+1]; count++;
                    array[i] = array[i]-array[i+1]; count++;
                    changed = true; count++;
                }
            }
        }
        return count;
    }
        /**
         * Main method draws a JFrame and places the
         * component with graphs of the time taken by the
         * sorts
         * @param args command line arguments are not used
         */
        public static void main(String[] args) {
            Sorter sorter1 = new InsertionSorter();
            Sorter sorter2 = new MergeSorter();

            JFrame frame = new JFrame();

            Random r = new Random();
            int factor = 30000;
            double[] x = {0,1,2,3,4,5,6,7,8,9};
            double[] y = new double[x.length];
            double[] sample; 
            double[] y1 = new double[x.length];
            double[] copy; 
            for (int i = 1; i < x.length; i++) {
                sample = new double[factor*i];
                for(int j = 0; j < sample.length; j++) {
                    sample[j] = r.nextDouble();
                }
                copy = sample.clone();
                y[i] = sorter1.timedSort(sample);
                System.out.println(y[i]);

                y1[i] = sorter2.timedSort(copy);
                System.out.println(y1[i]);
            }
            for(int i = 1; i < x.length; i++) {
                x[i] = 20 + 500*x[i]/x[x.length-1];
            }
            double max = Math.max(y[y.length-1], y1[y1.length-1]);
            for(int i = 0; i < y.length; i++) {
                y[i] = 550 - 550*y[i]/max;
                y1[i] = 550 - 550*y1[i]/max;
            }
            frame.setSize(540, 600);
            frame.setTitle("Times");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Graph component = new Graph(x,y,x,y1);

            frame.add(component);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }