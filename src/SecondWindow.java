import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;

public class SecondWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondWindow frame = new SecondWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Result of Searching");
		lblNewLabel.setBounds(128, 6, 191, 33);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 50, 438, 222);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(6, 261, 438, -206);
		contentPane.add(lblNewLabel_1);
		
	}
}
