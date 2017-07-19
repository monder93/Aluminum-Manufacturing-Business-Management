package helpClasses;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 *  this class for biggering pictures from the gallery 
 * */

public class BigPic 
{
	private JFrame frame;
	ImageIcon ImageIcon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BigPic(ImageIcon ImageIcon) 
	{
		this.ImageIcon=ImageIcon;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 10, 688, 712);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("תמונה גדולה");
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 672, 673);
		HelpFunctions.setImageAsIcon(lblNewLabel, ImageIcon);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}

}
