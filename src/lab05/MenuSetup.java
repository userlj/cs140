package lab05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuSetup {
    private static Model model;
     
    public static void setupBar(JMenuBar menuBar, Model model) {
        MenuSetup.model = model;
        MenuListener suspender = new Suspender();
                        
        JMenu pattern = new JMenu("Pattern");
        pattern.setMnemonic(KeyEvent.VK_P);
        menuBar.add(pattern);
        populatePattern(pattern);   
        pattern.addMenuListener(suspender);
        
        //set the mnemonic to KeyEvent.VK_D
        //call a method populateDimensions
        //add the listener "suspender" as above
        JMenu dimensions = new JMenu("Dimensions");
        pattern.setMnemonic(KeyEvent.VK_D);
        menuBar.add(dimensions);
        populateDimensions(dimensions);   
        pattern.addMenuListener(suspender);
 
        JMenu run = new JMenu("Control");
        pattern.setMnemonic(KeyEvent.VK_R);
        menuBar.add(run);
        populateRun(run);
        run.addMenuListener(suspender);
    }
   
    private static void populateDimensions(JMenu dimensions) {

        JMenuItem rows = new JMenuItem("Rows");
        rows.setMnemonic(KeyEvent.VK_R);
        rows.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        rows.addActionListener(new RowsListener());
        dimensions.add(rows);
       
        JMenuItem columns = new JMenuItem("Columns");
        columns.setMnemonic(KeyEvent.VK_C);
        columns.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        columns.addActionListener(new ColsListener());
        dimensions.add(columns);

        //The animation must be suspended and
        //you must pop up a JOptionPane.showInputDialog
        //and read the new number of rows or columns
        //respectively. The listener continues by
        //calling model.resetRows or model.resetColumns
        //Please verify that resetRows and resetColumns
        //actually work correctly when you test your code

	}

	private static void populatePattern(JMenu menu) {
        JMenuItem glider = new JMenuItem("Glider");
        glider.setMnemonic(KeyEvent.VK_L);
        glider.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        glider.addActionListener(new GliderListener());
        menu.add(glider);
       
        JMenuItem random = new JMenuItem("Random");
        random.setMnemonic(KeyEvent.VK_A);
        random.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        random.addActionListener(new RandomListener());
        menu.add(random);
       
        JMenuItem gosper = new JMenuItem("Gosper Gun");
        gosper.setMnemonic(KeyEvent.VK_G);
        gosper.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        gosper.addActionListener(new GosperListener());
        menu.add(gosper);
       
    }

    private static void populateRun(JMenu menu) {
        JMenuItem pause = new JMenuItem("Pause");
        pause.setMnemonic(KeyEvent.VK_P);
        pause.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        pause.addActionListener(new SuspenderAction());
        menu.add(pause);
       
        JMenuItem go = new JMenuItem("Go");
        go.setMnemonic(KeyEvent.VK_G);
        go.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        go.addActionListener(new GoAgainAction());
        menu.add(go);

        JMenuItem clear = new JMenuItem("Clear");
        clear.setMnemonic(KeyEvent.VK_C);
        clear.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        clear.addActionListener(new ClearAction());
        menu.add(clear);
       
    }

    private static class SuspenderAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
            model.setAnimation(false);           
		}
    	
    }

    private static class GoAgainAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
            model.setAnimation(true);           
		}
    	
    }

    private static class ClearAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
            model.clear();           
		}
    	
    }

    private static class Suspender implements MenuListener {
        @Override
        public void menuCanceled(MenuEvent e) {
            model.setAnimation(true);           
        }

        @Override
        public void menuDeselected(MenuEvent e) {
            model.setAnimation(true);           
        }

        @Override
        public void menuSelected(MenuEvent e) {
            model.setAnimation(false);           
        }
    }
   
    private static class GliderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setAnimation(false);
            model.setupGlider();
            model.setAnimation(true);
        }
       
    }
    private static class RandomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setAnimation(false);
            model.setupRandomStart();
            model.setAnimation(true);
        }       
    }
    
    private static class GosperListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setAnimation(false);
            model.setupGosper();
            model.setAnimation(true);
        }       
    }
    
    private static class RowsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Change Rows     (accelerator is Ctrl-R)
            String newRowsString = JOptionPane.showInputDialog(null, 
                    "New Number of Rows?", "Change",JOptionPane.QUESTION_MESSAGE);
            int newRows = model.getMaxRows();
            try {
                newRows = Integer.parseInt(newRowsString.trim());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, newRowsString + "is not an integer", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            model.resetRows(newRows);
        }       
    }
    
    private static class ColsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Change Columns  (accelerator is Ctrl-C)
            String newColsString = JOptionPane.showInputDialog(null, 
                    "New Number of Columns?", "Change",JOptionPane.QUESTION_MESSAGE);
            int newCols = model.getMaxCols();
            try {
                newCols = Integer.parseInt(newColsString.trim());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, newColsString + "is not an integer", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            model.resetColumns(newCols);
        }       
    }
}