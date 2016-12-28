import java.awt.EventQueue;
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JLabel timeLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() 
	{
		setTitle("MainPage");

		initComponents();
		clock();
	}

	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this 3 lines to set bounds for 100% of screen and set resizable to false 
		setBounds(100, 100, 578, 374);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		menuBar.setBounds(0, 0, 1352, 30);
		contentPane.add(menuBar);
		//-------------------------------------------------------------
		// this line to align the menuBar to the right side
		menuBar.add(Box.createHorizontalGlue());

		JMenu menu_4 = new JMenu("\u05D9\u05E6\u05D9\u05D0\u05D4");
		menu_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu_4);

		JMenu menu_3 = new JMenu("\u05E9\u05E8\u05D8\u05D5\u05D8\u05D9\u05DD");
		menu_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu_3);

		JMenu menu_2 = new JMenu("\u05D4\u05D2\u05D3\u05E8\u05D5\u05EA");
		menu_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu_2);

		JMenu menu_1 = new JMenu("\u05D3\u05D5\u05D7\u05D5\u05EA");
		menu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu_1);

		JMenu menu = new JMenu("\u05D8\u05D1\u05DC\u05D0\u05D5\u05EA");
		menu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu);
		JMenu mnProjects = new JMenu("\u05E4\u05E8\u05D5\u05D9\u05E7\u05D8\u05D9\u05DD");
		mnProjects.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnProjects);

		JButton button = new JButton("\u05D2\u05DC\u05E8\u05D9\u05D4");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(681, 338, 564, 48);
		contentPane.add(button);

		JButton button_1 = new JButton("\u05E7\u05D8\u05DC\u05D5\u05D2\u05D9\u05DD");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBounds(109, 338, 565, 48);
		contentPane.add(button_1);

		JButton button_2 = new JButton("\u05D4\u05D6\u05DE\u05E0\u05EA \u05E4\u05E8\u05D5\u05E4\u05D9\u05DC\u05D9\u05DD");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_2.setBounds(598, 57, 158, 114);
		contentPane.add(button_2);

		JButton button_3 = new JButton("\u05D4\u05D6\u05DE\u05E0\u05EA \u05D6\u05DB\u05D5\u05DB\u05D9\u05EA");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_3.setBounds(1086, 57, 158, 114);
		contentPane.add(button_3);

		JButton btnNewButton = new JButton("\u05D4\u05D6\u05DE\u05E0\u05EA \u05E4\u05D9\u05E8\u05D6\u05D5\u05DC");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(843, 57, 158, 114);
		contentPane.add(btnNewButton);

		JButton button_4 = new JButton("\u05D4\u05D6\u05DE\u05E0\u05EA \u05EA\u05E8\u05D9\u05E1 \u05D2\u05DC\u05D9\u05DC\u05D4");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_4.setBounds(109, 57, 158, 114);
		contentPane.add(button_4);

		JButton button_5 = new JButton("\u05D4\u05D6\u05DE\u05E0\u05EA \u05DE\u05E9\u05E7\u05D5\u05E4\u05D9\u05DD \u05E2\u05D9\u05D5\u05D5\u05E8\u05D9\u05DD");
		button_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_5.setBounds(344, 57, 175, 113);
		contentPane.add(button_5);

		JButton button_6 = new JButton("\u05D7\u05D9\u05E9\u05D5\u05D1 \u05E9\u05D9\u05E4\u05D5\u05E2\u05D9\u05DD ,\u05D6\u05D5\u05D5\u05D9\u05EA \u05D5\u05E7\u05E9\u05EA\u05D5\u05EA");
		button_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_6.setBounds(109, 197, 1137, 41);
		contentPane.add(button_6);

		JButton button_7 = new JButton("\u05D7\u05D5\u05D1\u05D5\u05EA \u05DC\u05E1\u05E4\u05E7\u05D9\u05DD");
		button_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_7.setBounds(108, 267, 564, 48);
		contentPane.add(button_7);

		JButton button_8 = new JButton("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA \u05D7\u05D9\u05D9\u05D1\u05D9\u05DD");
		button_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_8.setBounds(681, 267, 565, 48);
		contentPane.add(button_8);

		timeLabel = new JLabel("Time+Date");
		timeLabel.setForeground(Color.LIGHT_GRAY);
		timeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		timeLabel.setBounds(10, 639, 336, 55);
		contentPane.add(timeLabel);

		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 22, 1352, 672);
		background_label.setIcon(new ImageIcon(new ImageIcon(LoginPage.class.getResource("/img/background.jpg")).getImage().getScaledInstance(background_label.getWidth(), background_label.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(background_label);		
	}
	//----------------------------------------------------------------------------------------
	public void clock()
	{
		Thread clock=new Thread()
		{
			public void run()
			{
				try 
				{
					while(true)
					{
						Calendar cal = new GregorianCalendar();
						int day=cal.get(Calendar.DAY_OF_MONTH);
						int month=cal.get(Calendar.MONTH);
						int year=cal.get(Calendar.YEAR);

						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour=cal.get(Calendar.HOUR);

						timeLabel.setText("Time :  "+hour + ":"+minute+":"+second+"   Date :  "+day+"/"+month+"/"+year);
						sleep(1000);

					}	
				} catch (Exception e) 
				{
					// TODO: handle exception
				}
			}
		};
		clock.start();
	}
	//----------------------------------------------------------------------------------------


	private void createEvents()
	{

	}
}
