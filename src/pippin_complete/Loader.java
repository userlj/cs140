package pippin_complete;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Loader {
	private Memory memory;
	private JFrame frame;
	public Loader(Memory memory) {
		this.memory = memory;
	}

	public void load(File file) throws IOException {
		Scanner input = new Scanner(file);
		try {
			boolean incode = true;
			int count = 0;
			while(input.hasNextLong()){
				long ln = input.nextLong();
				if(ln == -1){
					// if the long is -1 then you change from code to data
					incode = false;
				}
				else{
					if (incode){
						memory.setCode(count++, ln);
					}
					else{
						int addr = (int)(ln >> 32);
						int val = (int)(-1 & ln);
						memory.setData(addr, val);
					}
				}
			}
			// while input has a next long: read a long (call it ln)
			// if the long is -1 then you change from code to data
			// if you are incode, then use memory.setCode(count++, ln);
			// otherwise use
			//int addr = (int)(ln >> 32);
			//int val = (int)(-1 & ln);
			//memory.setData(addr, val);
			// if there are exceptions use JOptionPane to report a problem--see Machine for code



		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(
					frame,
					"Data access exception.\n",
					"Warning",
					JOptionPane.OK_OPTION);             
		} catch (CodeAccessException e) {
			JOptionPane.showMessageDialog(
					frame,
					"Data access exception.\n",
					"Warning",
					JOptionPane.OK_OPTION);
		} finally {
			input.close();
		}
	}
}

