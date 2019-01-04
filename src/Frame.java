import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame{

	public Frame() {
		super("BeatGooooogle");
		setSize(1000,1000);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
		setVisible(true);
		
		Container pn = getContentPane(); 
		FlowLayout fy = new FlowLayout();
		pn.setLayout(fy); 
	}
	
	
}
