import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class gallery extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gallery frame = new gallery();
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
	public gallery() 
	{
		initComponents();

	}

	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setIcon(new ImageIcon(gallery.class.getResource("/img/door.jpg")));
		label_4.setBounds(187, 331, 234, 168);
		contentPane.add(label_4);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon(gallery.class.getResource("/img/door.jpg")));
		label_2.setBackground(Color.BLUE);
		label_2.setBounds(933, 331, 234, 168);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setIcon(new ImageIcon(gallery.class.getResource("/img/door.jpg")));
		label_3.setBounds(561, 331, 234, 168);
		contentPane.add(label_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(gallery.class.getResource("/img/door.jpg")));
		lblNewLabel.setBounds(187, 82, 234, 168);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(gallery.class.getResource("/img/door.jpg")));
		label.setBounds(561, 82, 234, 168);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(gallery.class.getResource("/img/door.jpg")));
		label_1.setBackground(Color.BLUE);
		label_1.setBounds(933, 82, 234, 168);
		contentPane.add(label_1);
		
		JLabel background_label = new JLabel("New label");
		background_label.setBounds(0, 0, 1362, 705);
		contentPane.add(background_label);
		HelpFunctions.setBackground(background_label);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		
	}
}
