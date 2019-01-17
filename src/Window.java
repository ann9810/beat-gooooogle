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
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JList;

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
		setBounds(100, 100, 1170, 816);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 902, 479);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("/Users/choushinji/git/beat-gooooogle/img/img.png"));
		lblNewLabel.setBackground(new Color(255, 235, 205));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		panel.add(lblNewLabel);
		
		
		
		textField = new JTextField();
		textField.setBounds(68, 495, 581, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		//keyword = textField.getText();
		
		JButton btnSearch = new JButton("search");
		btnSearch.setFont(new Font("Andale Mono", Font.PLAIN, 18));
		btnSearch.setBounds(688, 492, 117, 42);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter the space bar between the keywords!");
		lblNewLabel_1.setFont(new Font("Avenir Next Condensed", Font.BOLD, 24));
		lblNewLabel_1.setBounds(142, 537, 520, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(302, 495, 703, 228);
		lblNewLabel_2.setFont(new Font("Avenir Next Condensed", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(907, 478, 257, 228);
		lblNewLabel_3.setFont(new Font("Avenir Next Condensed", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_3);
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String keyword = textField.getText();
				TreeBuild treeBuild = new TreeBuild(keyword);
				String result = treeBuild.getTree();

				GoogleQ googleQuery = new GoogleQ(keyword);
				HashMap<String, String> re = null;
				try {
					re = googleQuery.query();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//String r = googleQuery.query();
				//SecondWindow secondWindow = new SecondWindow();
				//secondWindow.setVisible(true);
				
				//lblNewLabel.setText(result);
				//lblNewLabel.setIcon(null);
				String ret = re.toString();
				
				lblNewLabel_1.setText("Fllowing is the result of searching.");
				lblNewLabel_2.setText(result);
				lblNewLabel_3.setText(ret);
			}
		});
	}
}
