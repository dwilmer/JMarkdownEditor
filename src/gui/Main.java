package gui;

import javax.swing.JFrame;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("JMarkdownEditor");
		frame.getContentPane().add(new EditPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setBounds(0, 0, 800, 600);
		frame.setVisible(true);
	}
	
}
