import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;

public class ProjectsPage extends JFrame{

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectsPage frame = new ProjectsPage();
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
	public ProjectsPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 374);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 68, 980, 390);
		getContentPane().add(table);
		
		JButton btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
		btnNewButton.setBounds(1098, 68, 203, 46);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF \u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
		btnNewButton_1.setBounds(1098, 136, 203, 46);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
		btnNewButton_2.setBounds(1098, 206, 203, 46);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u05DE\u05D9\u05D5\u05DF");
		btnNewButton_3.setBounds(1098, 269, 203, 46);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9");
		btnNewButton_4.setBounds(1098, 337, 203, 46);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u05D7\u05D6\u05E8\u05D4");
		btnNewButton_5.setBounds(1098, 406, 203, 46);
		getContentPane().add(btnNewButton_5);
	}
}