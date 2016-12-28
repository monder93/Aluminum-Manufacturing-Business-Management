import java.awt.EventQueue;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;

public class OpenType {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenType window = new OpenType();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OpenType() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD, 11));
		list.setBounds(20, 11, 198, 239);
		DefaultListModel<String> DLM = new DefaultListModel();
//		DLM.addElement("1");
		DLM.addElement("\u05D3\u05DC\u05EA\u05D5\u05EA \u05E4\u05EA\u05D9\u05D7\u05D4\n");
		DLM.addElement("\u05D3\u05DC\u05EA\u05D5\u05EA \u05D4\u05D6\u05D6\u05D4\n");
		DLM.addElement("\u05D3\u05DC\u05EA\u05D5\u05EA \u05DB\u05D9\u05E1\n");
		DLM.addElement("\u05D7\u05DC\u05D5\u05E0\u05D5\u05EA \u05E4\u05EA\u05D9\u05D7\u05D4\n");
		DLM.addElement("\u05D7\u05DC\u05D5\u05E0\u05D5\u05EA \u05D4\u05D6\u05D6\u05D4\n");
		DLM.addElement("\u05D7\u05DC\u05D5\u05E0\u05D5\u05EA \u05DB\u05D9\u05E1\n");
		DLM.addElement("\u05D7\u05DC\u05D5\u05E0\u05D5\u05EA \u05E7\u05D1\u05D5\u05E2\u05D9\u05DD\n");
		DLM.addElement("\u05EA\u05E8\u05D9\u05E1\u05D9\u05DD");
		DLM.addElement("\u05E8\u05E9\u05EA\u05D5\u05EA\n");
		DLM.addElement("\u05DE\u05E2\u05E7\u05D5\u05EA");
		DLM.addElement("\u05DE\u05E7\u05DC\u05D7\u05D5\u05E0\u05D9\u05DD");
		DLM.addElement("\u05E7\u05D9\u05E8\u05D5\u05EA \u05DE\u05E1\u05DA");
		
		list.setModel(DLM);
		frame.getContentPane().add(list);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);

	}
}
