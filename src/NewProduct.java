import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewProduct extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewProduct frame = new NewProduct();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 374);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField.setBounds(1142, 26, 78, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(985, 57, 235, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(985, 26, 78, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("\u05D3\u05D2\u05DD :");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(1230, 26, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u05EA\u05D9\u05D0\u05D5\u05E8 :");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label.setBounds(1230, 57, 108, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u05E7\u05D5\u05D3 :");
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_1.setBounds(1082, 29, 58, 14);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("\u05D0\u05D5 \u05D1\u05D7\u05E8 \u05DE\u05D5\u05E6\u05E8");
		btnNewButton.setBounds(851, 26, 108, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E4\u05E8\u05D8 \u05DE\u05E1' :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(1230, 228, 108, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("\u05E8\u05D5\u05D7\u05D1 \u05E4\u05EA\u05D7 (\u05DE\"\u05DE) :");
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_2.setBounds(1230, 265, 108, 26);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u05D2\u05D5\u05D1\u05D4 \u05E4\u05EA\u05D7 (\u05DE\"\u05DE) :");
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_3.setBounds(1230, 303, 108, 29);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u05DB\u05DE\u05D5\u05EA :");
		label_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_4.setBounds(1074, 227, 58, 29);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u05D4\u05E2\u05E8\u05D5\u05EA :");
		label_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_5.setBounds(1230, 359, 83, 37);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(1142, 232, 78, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(985, 232, 78, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(985, 269, 235, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(985, 308, 235, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(985, 376, 223, 151);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hosam\\workspace\\Final-Project\\Aluminum-Manufacturing-Business-Management\\src\\img\\background.jpg"));
		lblNewLabel_2.setBounds(35, 28, 196, 211);
		contentPane.add(lblNewLabel_2);
		
		JButton button = new JButton("\u05DE\u05D9\u05E7\u05DF\u05DD :");
		button.setBounds(1230, 135, 108, 51);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u05D6\u05D9\u05D2\u05D5\u05D2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(672, 91, 108, 51);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u05E6\u05D1\u05E2 :");
		button_2.setBounds(672, 29, 108, 51);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u05D6\u05D9\u05D2\u05D5\u05D2 \u05EA\u05D7\u05EA\u05D5\u05DF");
		button_3.setBounds(672, 158, 108, 51);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u05D6\u05D9\u05D2\u05D5\u05D2 \u05DC\u05E7\u05D1\u05D5\u05E2");
		button_4.setBounds(672, 230, 108, 51);
		contentPane.add(button_4);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_7.setColumns(10);
		textField_7.setBounds(985, 150, 235, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_8.setColumns(10);
		textField_8.setBounds(427, 44, 235, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_9.setColumns(10);
		textField_9.setBounds(426, 106, 235, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_10.setColumns(10);
		textField_10.setBounds(426, 173, 235, 20);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_11.setColumns(10);
		textField_11.setBounds(426, 245, 235, 20);
		contentPane.add(textField_11);
		
		JButton button_5 = new JButton("\u05EA\u05E8\u05D9\u05E1 \u05D2\u05DC\u05D9\u05DC\u05D4");
		button_5.setBounds(427, 307, 353, 51);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u05E4\u05D9\u05E8\u05D6\u05D5\u05DC");
		button_6.setBounds(427, 390, 353, 51);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("\u05E4\u05E8\u05D5\u05E4\u05D9\u05DC\u05D9\u05DD");
		button_7.setBounds(427, 474, 353, 51);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		button_8.setBounds(35, 308, 196, 51);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("\u05D1\u05D9\u05D8\u05D5\u05DC");
		button_9.setBounds(35, 390, 196, 51);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("\u05D4\u05D2\u05D3\u05E8\u05D5\u05EA");
		button_10.setBounds(35, 474, 196, 51);
		contentPane.add(button_10);
	}
}
