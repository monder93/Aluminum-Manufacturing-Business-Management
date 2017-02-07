import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.Box;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private static JLabel timeLabel;
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
		setTitle("מסך ראשי");
		initComponents();
		HelpFunctions.clock(timeLabel);

	}

	/**
	 * 
	 */
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
		
		JButton btnNewButton = new JButton("מחשבון");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Calc("מחשבון");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton.setBounds(756, 111,183, 114);
		contentPane.add(btnNewButton);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		menuBar.setBounds(0, 0, 1376, 30);
		contentPane.add(menuBar);
		//-------------------------------------------------------------
		// this line to align the menuBar to the right side
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);

		JMenu menu_4 = new JMenu("יציאה");
		menu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		menu_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu_4);


		JMenu menu_2 = new JMenu("הגדרות");
		menu_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu_2);
		
				JMenu menu_6 = new JMenu("עזרה");
				menu_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
				menuBar.add(menu_6);
				
				JMenuItem mntmNewMenuItem_4 = new JMenuItem("הוראות שימוש");
				mntmNewMenuItem_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							PdfViewer pdfview =new PdfViewer();
							pdfview.main();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				mntmNewMenuItem_4.setHorizontalTextPosition(SwingConstants.RIGHT);
				mntmNewMenuItem_4.setHorizontalAlignment(SwingConstants.RIGHT);
				menu_6.add(mntmNewMenuItem_4);
				
				JMenuItem mntmNewMenuItem_5 = new JMenuItem("חישוב שיפועים ,זווית וקשתות");
				mntmNewMenuItem_5.setHorizontalAlignment(SwingConstants.RIGHT);
				mntmNewMenuItem_5.setHorizontalTextPosition(SwingConstants.RIGHT);
				menu_6.add(mntmNewMenuItem_5);

		JMenu menu_3 = new JMenu("שרטוטים");
		menu_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu_3);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("שרטוטי חלונות");
		mntmNewMenuItem_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.RIGHT);
		menu_3.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("שרטוטי דלתות");
		mntmNewMenuItem_3.setHorizontalTextPosition(SwingConstants.RIGHT);
		mntmNewMenuItem_3.setHorizontalAlignment(SwingConstants.RIGHT);
		menu_3.add(mntmNewMenuItem_3);

		JMenu menu_1 = new JMenu("דוחות");
		menu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu_1);

		JMenu mnNewMenu = new JMenu("\u05EA\u05DE\u05D7\u05D9\u05E8");
		mnNewMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mnNewMenu.setActionCommand("");
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnNewMenu.setHorizontalTextPosition(SwingConstants.RIGHT);
		mnNewMenu.setHorizontalAlignment(SwingConstants.RIGHT);
		menu_1.add(mnNewMenu);

		JMenuItem menuItem_19 = new JMenuItem("תמחיר זכוכית");
		menuItem_19.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_19.setHorizontalAlignment(SwingConstants.RIGHT);
		mnNewMenu.add(menuItem_19);

		JMenuItem menuItem_20 = new JMenuItem("תמחיר פירזול");
		menuItem_20.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_20.setHorizontalAlignment(SwingConstants.RIGHT);
		mnNewMenu.add(menuItem_20);

		JMenuItem menuItem_22 = new JMenuItem("תמחיר פרופילים");
		menuItem_22.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_22.setHorizontalAlignment(SwingConstants.RIGHT);
		mnNewMenu.add(menuItem_22);

		JMenuItem menuItem_21 = new JMenuItem("תמחיר משקופים עיוורים");
		menuItem_21.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_21.setHorizontalAlignment(SwingConstants.RIGHT);
		mnNewMenu.add(menuItem_21);

		JMenuItem menuItem_23 = new JMenuItem("תמחיר תריס גלילה");
		menuItem_23.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_23.setHorizontalAlignment(SwingConstants.RIGHT);
		mnNewMenu.add(menuItem_23);

		JMenu menu_5 = new JMenu("דוחי הזמנות");
		menu_5.setHorizontalTextPosition(SwingConstants.RIGHT);
		menu_5.setHorizontalAlignment(SwingConstants.RIGHT);
		menu_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		menu_5.setActionCommand("");
		menu_1.add(menu_5);

		JMenuItem menuItem_14 = new JMenuItem("דוח הזמנת זכוכית");
		menuItem_14.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_14.setHorizontalAlignment(SwingConstants.RIGHT);
		menu_5.add(menuItem_14);

		JMenuItem menuItem_15 = new JMenuItem("דוח הזמנת פירזול");
		menuItem_15.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_15.setHorizontalAlignment(SwingConstants.RIGHT);
		menu_5.add(menuItem_15);

		JMenuItem menuItem_16 = new JMenuItem("דוח הזמנת פרופילים");
		menuItem_16.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_16.setHorizontalTextPosition(SwingConstants.RIGHT);
		menu_5.add(menuItem_16);

		JMenuItem menuItem_17 = new JMenuItem("דוח הזמנת משקופים עיוורים");
		menuItem_17.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_17.setHorizontalAlignment(SwingConstants.RIGHT);
		menu_5.add(menuItem_17);

		JMenuItem menuItem_18 = new JMenuItem("דוח הזמנת תריס גלילה");
		menuItem_18.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_18.setHorizontalTextPosition(SwingConstants.RIGHT);
		menu_5.add(menuItem_18);

		JMenuItem menuItem_7 = new JMenuItem("דוח רשימת הפרויקטים");
		menuItem_7.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_7.setHorizontalAlignment(SwingConstants.RIGHT);
		menu_1.add(menuItem_7);

		JMenuItem menuItem_8 = new JMenuItem("דוח חובות לספקים");
		menuItem_8.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_8.setHorizontalTextPosition(SwingConstants.RIGHT);
		menu_1.add(menuItem_8);

		JMenuItem menuItem_9 = new JMenuItem("דוח לקוחות חייבים");
		menuItem_9.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_9.setHorizontalAlignment(SwingConstants.RIGHT);
		menu_1.add(menuItem_9);

		JMenuItem menuItem_10 = new JMenuItem("");
		menu_1.add(menuItem_10);

		JMenu menu = new JMenu("טבלאות");
		menu.setHorizontalTextPosition(SwingConstants.RIGHT);
		menu.setHorizontalAlignment(SwingConstants.RIGHT);
		menu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menu);

		JMenuItem menuItem_1 = new JMenuItem("טבלת לקוחות");
		menuItem_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_1.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tables("contacts");
			}
		});
		menu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("טבלת ספקים");
		menuItem_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_2.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tables("suppliers");

			}
		});
		menu.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("טבלת פרופילים");
		menuItem_3.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_3.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tables("profiles");

			}
		});
		menu.add(menuItem_3);

		JMenuItem menuItem_4 = new JMenuItem("טבלת זיגוג");
		menuItem_4.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_4.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tables("glasses");

			}
		});
		menu.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("טבלת צבעים");
		menuItem_5.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_5.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tables("colors");

			}
		});
		menu.add(menuItem_5);

		JMenuItem mntmNewMenuItem = new JMenuItem("טבלת סוגי פתיחה");
		mntmNewMenuItem.setHorizontalTextPosition(SwingConstants.RIGHT);
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new OpenType();
			}
		});
		menu.add(mntmNewMenuItem);
		JMenu mnOrders = new JMenu("הזמנות");
		mnOrders.setHorizontalTextPosition(SwingConstants.RIGHT);
		mnOrders.setHorizontalAlignment(SwingConstants.RIGHT);
		mnOrders.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnOrders);

		JMenuItem menuItem = new JMenuItem("הזמנת זכוכית");
		menuItem.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Orders("glassOrders");
			}
		});
		mnOrders.add(menuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("הזמנת פירזול");
		mntmNewMenuItem_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Orders("perfectionsorders");
			}
		});
		mnOrders.add(mntmNewMenuItem_1);

		JMenuItem menuItem_11 = new JMenuItem("הזמנת פרופילים");
		menuItem_11.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_11.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Orders("profilesOrders");
			}
		});
		mnOrders.add(menuItem_11);

		JMenuItem menuItem_12 = new JMenuItem("הזמנת משקופים עיוורים");
		menuItem_12.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_12.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Orders("lintelsOrders");
			}
		});
		mnOrders.add(menuItem_12);

		JMenuItem menuItem_13 = new JMenuItem("הזמנת תריס גלילה");
		menuItem_13.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuItem_13.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Orders("shuttersOrders");
			}
		});
		mnOrders.add(menuItem_13);

		JButton button = new JButton("גלריה");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(1062, 443,183, 114);
		contentPane.add(button);

		JButton button_1 = new JButton("קטלוגים");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBounds(756, 443, 183, 114);
		contentPane.add(button_1);

		JButton button_3 = new JButton("פרויקטים");
		button_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new ProjectsPage();

			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_3.setBounds(1062, 111, 183, 114);
		contentPane.add(button_3);

		JButton button_7 = new JButton("חובות לספקים");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Orders("debtsForSuppliers");
			}
		});
		button_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_7.setBounds(756, 278,183, 114);
		contentPane.add(button_7);

		JButton button_8 = new JButton("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA \u05D7\u05D9\u05D9\u05D1\u05D9\u05DD");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DebtsPage("customersDebts");
			}
		});
		button_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_8.setBounds(1062, 278, 183, 114);
		contentPane.add(button_8);

		timeLabel = new JLabel("Time+Date");
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		timeLabel.setBounds(10, 639, 336, 55);
		contentPane.add(timeLabel);
		


		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 25, 1376, 693);
		HelpFunctions.setBackground(background_label);
		contentPane.add(background_label);	
		
		HelpFunctions.setIcon(btnNewButton, "calculator");
	}
}
