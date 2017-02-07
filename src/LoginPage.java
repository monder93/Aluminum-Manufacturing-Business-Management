import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userText;
	private JTextField passText;
	static LoginPage frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginPage();
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
	}
	
	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 496, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(254, 142, 96, 30);
		contentPane.add(lblUsername);
		
		JButton btnNewButton = new JButton("\u05DB\u05E0\u05D9\u05E1\u05D4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if((userText.getText().compareTo("admin")==0)&&(passText.getText().compareTo("admin")==0))
				{
					new MainPage();
					frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "שם משתמש או סיסמה שגויים .. נא לנסות מחדש");
			
				}
		});
		btnNewButton.setBounds(147, 227, 187, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D4");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(254, 183, 80, 14);
		contentPane.add(lblNewLabel);
		
		userText = new JTextField();
		userText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton.doClick();
			}
		});
		userText.setBounds(147, 149, 86, 20);
		contentPane.add(userText);
		userText.setColumns(10);
		
		passText = new JPasswordField();
		passText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton.doClick();
			}
		});
		passText.setBounds(147, 182, 86, 20);
		contentPane.add(passText);
		passText.setColumns(10);
		
		JLabel lblPleaseEnterYour = new JLabel("\u05DC\u05DB\u05E0\u05D9\u05E1\u05D4 \u05DC\u05DE\u05E2\u05E8\u05DB\u05EA , \u05E0\u05D0 \u05DC\u05D4\u05DB\u05E0\u05D9\u05E1 \u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9 \u05D5\u05E1\u05D9\u05E1\u05DE\u05D4");
		lblPleaseEnterYour.setForeground(Color.BLACK);
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPleaseEnterYour.setBounds(86, 67, 356, 43);
		contentPane.add(lblPleaseEnterYour);
		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 0, 491, 428);
		HelpFunctions.setBackground(background_label);
		contentPane.add(background_label);
	}
	
}
