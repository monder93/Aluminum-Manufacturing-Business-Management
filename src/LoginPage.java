import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() 
	{
		setResizable(false);
		setTitle("Login Page");
		initComponents();
		createEvents();
	}
	
	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9");
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(254, 142, 96, 30);
		contentPane.add(lblUsername);
		
		JButton btnNewButton = new JButton("\u05DB\u05E0\u05D9\u05E1\u05D4");
		btnNewButton.setBounds(147, 227, 187, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D4");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(254, 183, 80, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(147, 149, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 182, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPleaseEnterYour = new JLabel("\u05D1\u05D1\u05E7\u05E9\u05D4 \u05EA\u05DB\u05E0\u05D9\u05E1 \u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9 \u05D5\u05E1\u05D9\u05E1\u05DE\u05D4 \u05DB\u05D3\u05D9 \u05E9\u05EA\u05D5\u05DB\u05DC \u05DC\u05DB\u05E0\u05E1 \u05DC\u05DE\u05E2\u05E8\u05DB\u05EA");
		lblPleaseEnterYour.setForeground(Color.LIGHT_GRAY);
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPleaseEnterYour.setBounds(55, 68, 394, 43);
		contentPane.add(lblPleaseEnterYour);
		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 0, 491, 428);
		background_label.setIcon(new ImageIcon(new ImageIcon(LoginPage.class.getResource("/img/background.jpg")).getImage().getScaledInstance(background_label.getWidth(), background_label.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(background_label);
	}
	
	private void createEvents()
	{
		
	}

}
