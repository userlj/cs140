package assignment04;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Book2GUIUpdater {
	
    public static Logger logObj = Logger.getLogger("Book2GUI");
    private static Handler handler;

	private JFrame frame = new JFrame("Book Data");
	private JTextField titleFld = new JTextField(25);
	private JTextField numPgs = new JTextField(25);
	private JPanel reqdPanel  = new JPanel();
	private JCheckBox check = new JCheckBox("Check here ");
	private JTextField bookmarkPage = new JTextField(25);
	private ReadingTracker tracker = new ReadingTracker();
	private ArrayList<Book2> bookList;
	private JButton nextButton = new JButton("Next");
	private JButton exitButton = new JButton("Exit");
	private int currentIndex;

	public Book2GUIUpdater () {
		try {
			bookList = tracker.bookFileReader();
			createAndShowGUI();
            logObj.info("bookList:\n" + bookList + "\n");		//
			if(bookList != null && bookList.size() > 0) {
				showBook(0);
			} else {
				JOptionPane.showMessageDialog(null, 
						"There are no books in the file");				
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, 
					"The books.txt file is not available");
		}
	}

	private void createAndShowGUI() {
		JPanel topPanel = new JPanel();
		JLabel label1 = new JLabel("Make any changes to the book and " +
				"press Next", JLabel.CENTER);
		JLabel label2 = new JLabel("press Exit, when finished", 
				JLabel.CENTER);
		topPanel.setLayout(new GridLayout(2,1));
		topPanel.add(label1);
		topPanel.add(label2);
		frame.add(topPanel, BorderLayout.PAGE_START);
        logObj.info("Added top panel\n");

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(nextButton);
		buttonPanel.add(exitButton);
		frame.add(buttonPanel, BorderLayout.PAGE_END);
		logObj.info("Added button panel\n");		//
		nextButton.addActionListener(new NextListener());
		exitButton.addActionListener(new ExitListener());

		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(0,1));
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(0,1));
		leftPanel.add(new JLabel(" Book Title: ", JLabel.RIGHT));
		leftPanel.add(new JLabel(" Number of Pages: ", JLabel.RIGHT));
		leftPanel.add(new JLabel(" Required: ", JLabel.RIGHT));
		leftPanel.add(new JLabel(" Bookmark Page: ", JLabel.RIGHT));
		frame.add(leftPanel);
		logObj.info("Added leftPanel\n");

		rightPanel.add(titleFld);
		rightPanel.add(numPgs);
		rightPanel.add(reqdPanel);
		reqdPanel.add(check);
		rightPanel.add(bookmarkPage);
		frame.add(rightPanel, BorderLayout.LINE_END);
		logObj.info("Added rightPanel\n");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowCloser());
		frame.setVisible(true);
	}

	private void showBook(int i) {
		currentIndex = i;
		Book2 book = bookList.get(i);
        logObj.info("Index " + i + ", book is " + book + "\n");		//
		titleFld.setText(book.getTitle());
		numPgs.setText(""+book.getPageCount());
		if(book.isRequired()) {
			check.setSelected(true);
		} else {
			check.setSelected(false);
		}
		bookmarkPage.setText(""+book.getBookmark());		
	}

	private void getBookDetailsAndMove() {
		String title = titleFld.getText();
		int pgs = -1;
		while(pgs < 0) {
			try {
				pgs = Integer.parseInt(numPgs.getText().trim());
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "The Number of Pages " +
						"is not entered correctly");
			}
		}
		boolean req = check.isSelected();
		int bookmark = -1;
		while(bookmark < 0) {
			try {
				bookmark = Integer.parseInt(bookmarkPage.getText().trim());
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "The Bookmark Page " +
						"is not entered correctly");
			}
		}
        logObj.info("The book " + bookList.get(currentIndex) + "\n");        
        Book2 temp = new Book2(title, pgs, req, bookmark);
        bookList.set(currentIndex, temp);
        logObj.info("The book " + bookList.get(currentIndex) + "\n");        
        if(currentIndex < bookList.size() - 1) {
            logObj.info("currentIndex  = " + currentIndex 
                    + ", bookList size = " + bookList.size() + "\n");
            currentIndex++;
            showBook(currentIndex);
        } else {
			JOptionPane.showMessageDialog(null, "That was the last book " +
					"we will exit");			
			doExit();
		}
	}

	private void doExit() {
        logObj.info("bookList:\n" + bookList + "\n");
		try {
			if(bookList != null && bookList.size() > 0) {
				tracker.writeBookFile(bookList);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, 
					"The books.txt file could not be opened");
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		        //creates this handler
		        //output will go to file named in argument
		        try {
		            handler = new FileHandler("Book2GUI.log");
		            //SimpleFormatter produces plain text(as opposed to XML)
		            handler.setFormatter(new SimpleFormatter());
		            logObj.addHandler(handler);
		            logObj.setLevel(Level.OFF);
		        } catch (SecurityException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				new Book2GUIUpdater();
			}
		});
	}

	private class NextListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			getBookDetailsAndMove();
		}		
	}

	private class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			doExit();
		}		
	}

	private class WindowCloser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent arg0) {
			doExit();
		}

	}	
}
