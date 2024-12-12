package driver;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.ConverterPanel;

/**
 * Michala Ouverson - mmouverson1
 * CIS171 <21708>
 * Apr 28, 2024
 */
public class StartProgram {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new ConverterPanel();
		
		frame.add(panel);
		
		frame.setSize(250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
