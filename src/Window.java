import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	//public String keyword;
	/**
	 * Launch the application.
	 */
	public static void main(String[]args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 902, 504);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("/Users/choushinji/git/beat-gooooogle/img/img.png"));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		panel.add(lblNewLabel);
		
		
		
		textField = new JTextField();
		textField.setBounds(68, 537, 581, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		//keyword = textField.getText();
		
		JButton btnSearch = new JButton("search");
		btnSearch.setFont(new Font("Andale Mono", Font.PLAIN, 18));
		btnSearch.setBounds(687, 537, 117, 42);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter the space bar between the keywords!");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(96, 578, 579, 33);
		contentPane.add(lblNewLabel_1);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String keyword = textField.getText();
				TreeBuild treeBuild = new TreeBuild(keyword);
				String result = treeBuild.getTree();

				lblNewLabel.setText(result);
				lblNewLabel.setIcon(null);
				lblNewLabel_1.setText("Above is the result of searching.");
				
			}
		});
	}
}
