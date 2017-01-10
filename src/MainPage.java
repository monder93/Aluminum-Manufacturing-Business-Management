import java.awt.EventQueue;
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.*;
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
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Component;

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
		HelpFunctions.clock(timeLabel);
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
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);

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
		
		JMenu mnNewMenu = new JMenu("\u05EA\u05DE\u05D7\u05D9\u05E8");
		mnNewMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mnNewMenu.setActionCommand("");
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnNewMenu.setHorizontalTextPosition(SwingConstants.LEFT);
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		menu_1.add(mnNewMenu);
		
		JMenuItem menuItem_6 = new JMenuItem("");
		mnNewMenu.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("");
		menu_1.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("");
		menu_1.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("");
		menu_1.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("");
		menu_1.add(menuItem_10);

		JMenu menu = new JMenu("\u05D8\u05D1\u05DC\u05D0\u05D5\u05EA");
		menu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu);

		JMenuItem menuItem_1 = new JMenuItem("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tables customers = new Tables("customers");
			}
		});
		menu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("\u05E1\u05E4\u05E7\u05D9\u05DD");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tables suppliers = new Tables("suppliers");

			}
		});
		menu.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("\u05E4\u05E8\u05D5\u05E4\u05D9\u05DC\u05D9\u05DD");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tables profiles = new Tables();

			}
		});
		menu.add(menuItem_3);

		JMenuItem menuItem_4 = new JMenuItem("\u05D6\u05D9\u05D2\u05D5\u05D2");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tables glasses = new Tables();

			}
		});
		menu.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("\u05E6\u05D1\u05E2\u05D9\u05DD");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tables colors = new Tables();

			}
		});
		menu.add(menuItem_5);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u05E1\u05D5\u05D2\u05D9 \u05E4\u05EA\u05D9\u05D7\u05D4");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Tables openType = new Tables();
				OpenType ot = new OpenType();
			}
		});
		menu.add(mntmNewMenuItem);
		JMenu mnProjects = new JMenu("\u05E4\u05E8\u05D5\u05D9\u05E7\u05D8\u05D9\u05DD");
		mnProjects.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnProjects);

		JMenuItem menuItem = new JMenuItem("\u05D4\u05E6\u05D2 \u05E4\u05E8\u05D5\u05D9\u05E7\u05D8\u05D9\u05DD");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProjectsPage projects=new ProjectsPage();
			}
		});
		mnProjects.add(menuItem);

		JButton button = new JButton("\u05D2\u05DC\u05E8\u05D9\u05D4");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(681, 338, 564, 48);
		contentPane.add(button);

		JButton button_1 = new JButton("\u05E7\u05D8\u05DC\u05D5\u05D2\u05D9\u05DD");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBounds(109, 338, 565, 48);
		contentPane.add(button_1);

		JButton button_2 = new JButton("\u05D4\u05D6\u05DE\u05E0\u05EA \u05E4\u05E8\u05D5\u05E4\u05D9\u05DC\u05D9\u05DD");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders profileOrder = new Orders("profilesOrders");
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_2.setBounds(591, 57, 183, 114);
		contentPane.add(button_2);

		JButton button_3 = new JButton("\u05D4\u05D6\u05DE\u05E0\u05EA \u05D6\u05DB\u05D5\u05DB\u05D9\u05EA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders glassOrder = new Orders("glassOrders");

			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_3.setBounds(1061, 57, 183, 114);
		contentPane.add(button_3);

		JButton btnNewButton = new JButton("\u05D4\u05D6\u05DE\u05E0\u05EA \u05E4\u05D9\u05E8\u05D6\u05D5\u05DC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders perfectionOrder = new Orders("perfectionsorders");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(833, 57, 168, 114);
		contentPane.add(btnNewButton);

		JButton button_4 = new JButton("\u05D4\u05D6\u05DE\u05E0\u05EA \u05EA\u05E8\u05D9\u05E1 \u05D2\u05DC\u05D9\u05DC\u05D4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders shutterOrder = new Orders("shuttersOrders");
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_4.setBounds(109, 57, 168, 114);
		contentPane.add(button_4);

		JButton button_5 = new JButton("\u05D4\u05D6\u05DE\u05E0\u05EA \u05DE\u05E9\u05E7\u05D5\u05E4\u05D9\u05DD \u05E2\u05D9\u05D5\u05D5\u05E8\u05D9\u05DD");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders lintelOrder = new Orders("lintelsOrders");
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_5.setBounds(342, 58, 191, 113);
		contentPane.add(button_5);

		JButton button_6 = new JButton("\u05D7\u05D9\u05E9\u05D5\u05D1 \u05E9\u05D9\u05E4\u05D5\u05E2\u05D9\u05DD ,\u05D6\u05D5\u05D5\u05D9\u05EA \u05D5\u05E7\u05E9\u05EA\u05D5\u05EA");
		button_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_6.setBounds(109, 197, 1137, 41);
		contentPane.add(button_6);

		JButton button_7 = new JButton("\u05D7\u05D5\u05D1\u05D5\u05EA \u05DC\u05E1\u05E4\u05E7\u05D9\u05DD");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders debtsForSupp = new Orders("debtsForSuppliers");
			}
		});
		button_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_7.setBounds(108, 267, 564, 48);
		contentPane.add(button_7);

		JButton button_8 = new JButton("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA \u05D7\u05D9\u05D9\u05D1\u05D9\u05DD");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DebtsPage customerDebt = new DebtsPage("customersDebts");
			}
		});
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
		HelpFunctions.setBackground(background_label);
		contentPane.add(background_label);		
	}
	//----------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------


	private void createEvents()
	{

	}
}
