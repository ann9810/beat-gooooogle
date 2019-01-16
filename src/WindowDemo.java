import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WindowDemo {

	private JLabel label;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowDemo window = new WindowDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		label = new JLabel();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		label = new JLabel("");
		label.setIcon(new ImageIcon(img));
		
		textField = new JTextField();
		textField.setBounds(136, 121, 172, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton Search = new JButton("Search");
		Search.setForeground(Color.BLACK);
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		Search.setBounds(167, 154, 117, 29);
		
		frame.getContentPane().add(Search);
	}
}
