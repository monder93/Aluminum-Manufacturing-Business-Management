import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gallery extends JFrame {

	private JPanel contentPane;
	private int i = 1;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("גלריה");
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(187, 331, 234, 168);
		HelpFunctions.setBackground(label_4, "4");
		contentPane.add(label_4);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(933, 331, 234, 168);
		HelpFunctions.setBackground(label_2, "5");
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(561, 331, 234, 168);
		HelpFunctions.setBackground(label_3, "6");
		contentPane.add(label_3);
		
		String url="/img/"+ Integer.toString(i) +".jpg";

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new BigPic(url);
			}
		});
		lblNewLabel.setBounds(187, 82, 234, 168);
		HelpFunctions.setBackground(lblNewLabel, "1");
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(561, 82, 234, 168);
		HelpFunctions.setBackground(label, "2");
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(933, 82, 234, 168);
		HelpFunctions.setBackground(label_1, "3");
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("הבא");
		btnNewButton.setBounds(734, 587, 137, 56);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("אחורה");
		button.setBounds(513, 587, 137, 56);
		contentPane.add(button);
		
		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 0, 1362, 705);
		contentPane.add(background_label);
		HelpFunctions.setBackground(background_label);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		
	}
}
