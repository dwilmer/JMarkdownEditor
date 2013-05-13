package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.markdownj.MarkdownProcessor;

public class EditPanel extends JPanel{
	private static final long serialVersionUID = 2598276312244050271L;
	private JTextArea editField;
	private JLabel showField;
	
	public EditPanel() {
		this.initComponents();
		this.setThisLayout();
		this.startMirroring();
	}
	
	private void initComponents() {
		this.editField = new JTextArea();
		this.showField = new JLabel();
	}

	private void setThisLayout() {
		this.setLayout(new GridLayout(1, 2));
		this.add(new JScrollPane(editField));
		this.add(new JScrollPane(showField));
		showField.setVerticalAlignment(JLabel.TOP);
	}
	
	private void startMirroring() {
		final MarkdownProcessor processor = new MarkdownProcessor();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					String markdown = editField.getText();
					String html = "<html>" + processor.markdown(markdown) + "</html>";
					showField.setText(html);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException x) {
						// do nothing
					}
				}
			}
		}).start();
	}
}
