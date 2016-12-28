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
		DefaultListModel DLM = new DefaultListModel();
//		DLM.addElement("1");
		DLM.addElement("דלתות פתיחה");
		DLM.addElement("דלתות הזזה");
		DLM.addElement("דלתות כיס");
		DLM.addElement("חלונות פתיחה");
		DLM.addElement("חלונות הזזה");
		DLM.addElement("חלונות כיס");
		DLM.addElement("חלונות קבועים");
		DLM.addElement("תריסים");
		DLM.addElement("רשתות");
		DLM.addElement("מעקות");
		DLM.addElement("מקלחונים");
		DLM.addElement("קירות מסך");
		
		list.setModel(DLM);
		frame.getContentPane().add(list);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);

	}
}
