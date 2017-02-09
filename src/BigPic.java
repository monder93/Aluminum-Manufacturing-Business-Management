import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BigPic {

	private JFrame frame;
	String picUrl="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
//					BigPic window = new BigPic();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BigPic(String picUrl) {
		this.picUrl=picUrl;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 10, 688, 712);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 672, 673);
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(gallery.class.getResource(picUrl)).getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT)));
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}

}