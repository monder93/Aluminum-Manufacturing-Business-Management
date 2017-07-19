package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import helpClasses.BigPic;
import helpClasses.HelpFunctions;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 *  a class for gallery .. images for products
 */
public class gallery extends JFrame 
{
	//--------------------------------------------------global variables-----------------------------------------------
	ArrayList<BufferedImage> ArrayOfImages = new ArrayList<BufferedImage>();	
	private JPanel contentPane;
	private int i = 1;
	int index=0;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
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

	public void  LoadImagesFromFolder()
	{
		// File representing the folder that you select using a FileChooser
		final File dir = new File("src/galleryImages");
		// array of supported extensions (use a List if you prefer) and other formats you need};
		final String[] EXTENSIONS = new String[]{"gif", "png", "bmp" , "jpg" ,"jpeg"}; 
		//-------------------------------filter to identify images based on their extensions-------------------------------------
		final FilenameFilter IMAGE_FILTER = new FilenameFilter() 
		{
			@Override
			public boolean accept(final File dir, final String name) 
			{
				for (final String ext : EXTENSIONS)
				{
					//System.out.println(ext);
					if (name.endsWith("." + ext)) 
					{
						return	true;
					}
				}
				return false;
			}
		};


		//	System.out.println("before the if dir.isDirectory");
		if (dir.isDirectory()) 
		{
			// make sure it's a directory
			//System.out.println("before the for loop of the files");
			for (final File f : dir.listFiles(IMAGE_FILTER)) 
			{
				//System.out.println("before the try");
				BufferedImage img = null;
				try {
					img = ImageIO.read(f);
					ArrayOfImages.add(img);

					// you probably want something more involved here
					// to display in your UI
					//	System.out.println("------------------------------------------");
					//	System.out.println("image: " + f.getName());
					//	System.out.println(" width : " + img.getWidth());
					//	System.out.println(" height: " + img.getHeight());
					//	System.out.println(" size  : " + f.length());
				} 
				catch (final IOException e) 
				{
					System.out.println("error");
					// handle errors here
				}
			}
		}

		//test
		//for checking if array contain the pictures 
		for(BufferedImage b : ArrayOfImages)
		{
			// converting from bufferedImage to ImageIcon using the ImageIcon constructor(image) ,, BufferedImage implement Image
			ImageIcon i = new ImageIcon(b);
		}


		if(index+0<ArrayOfImages.size())
			HelpFunctions.setImageAsIcon(lblNewLabel, new ImageIcon(ArrayOfImages.get(index+0)));
		else
			HelpFunctions.setBackground(lblNewLabel, "nopic");
		if(index+1<ArrayOfImages.size())
			HelpFunctions.setImageAsIcon(label, new ImageIcon(ArrayOfImages.get(index+1)));
		else
			HelpFunctions.setBackground(label, "nopic");
		if(index+2<ArrayOfImages.size())
			HelpFunctions.setImageAsIcon(label_1, new ImageIcon(ArrayOfImages.get(index+2)));
		else
			HelpFunctions.setBackground(label_1, "nopic");
		if(index+3<ArrayOfImages.size())
			HelpFunctions.setImageAsIcon(label_2, new ImageIcon(ArrayOfImages.get(index+3)));
		else
			HelpFunctions.setBackground(label_2, "nopic");
		if(index+4<ArrayOfImages.size())
			HelpFunctions.setImageAsIcon(label_3, new ImageIcon(ArrayOfImages.get(index+4)));
		else
			HelpFunctions.setBackground(label_3, "nopic");
		if(index+5<ArrayOfImages.size())
			HelpFunctions.setImageAsIcon(label_4, new ImageIcon(ArrayOfImages.get(index+5)));
		else
			HelpFunctions.setBackground(label_4, "nopic");
		//new BigPic(new ImageIcon(ArrayOfImages.get(1)));


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

		label_4 = new JLabel("New label");
		label_4.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(index+5<ArrayOfImages.size())
				new BigPic(new ImageIcon(ArrayOfImages.get(index+5)));
			}
		});
		label_4.setBounds(187, 331, 234, 168);
		HelpFunctions.setBackground(label_4, "4");
		contentPane.add(label_4);

		label_2 = new JLabel("New label");
		label_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(index+3<ArrayOfImages.size())
				new BigPic(new ImageIcon(ArrayOfImages.get(index+3)));

			}
		});
		label_2.setBounds(933, 331, 234, 168);
		HelpFunctions.setBackground(label_2, "5");
		contentPane.add(label_2);

		label_3 = new JLabel("New label");
		label_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(index+4<ArrayOfImages.size())
				new BigPic(new ImageIcon(ArrayOfImages.get(index+4)));
			}
		});
		label_3.setBounds(561, 331, 234, 168);
		HelpFunctions.setBackground(label_3, "6");
		contentPane.add(label_3);

		String url="/img/"+ Integer.toString(i) +".jpg";

		lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(index+0<ArrayOfImages.size())
				new BigPic(new ImageIcon(ArrayOfImages.get(index+0)));
			}
		});
		lblNewLabel.setBounds(933, 82, 234, 168);
		//HelpFunctions.setBackground(lblNewLabel, "1");
		contentPane.add(lblNewLabel);

		label = new JLabel("New label");
		label.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				if(index+1<ArrayOfImages.size())
				new BigPic(new ImageIcon(ArrayOfImages.get(index+1)));
			}
		});
		label.setBounds(561, 82, 234, 168);
		contentPane.add(label);

		label_1 = new JLabel("New label");
		label_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(index+2<ArrayOfImages.size())
				new BigPic(new ImageIcon(ArrayOfImages.get(index+2)));
			}
		});
		label_1.setBounds(187, 82, 234, 168);
		contentPane.add(label_1);

		//next button
		JButton btnNewButton = new JButton("הבא");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(index<ArrayOfImages.size()-6)
				{
				index+=6;

				if(index+0<ArrayOfImages.size())
					HelpFunctions.setImageAsIcon(lblNewLabel, new ImageIcon(ArrayOfImages.get(index+0)));
				else
					HelpFunctions.setBackground(lblNewLabel, "nopic");
				if(index+1<ArrayOfImages.size())
					HelpFunctions.setImageAsIcon(label, new ImageIcon(ArrayOfImages.get(index+1)));
				else
					HelpFunctions.setBackground(label, "nopic");
				if(index+2<ArrayOfImages.size())
					HelpFunctions.setImageAsIcon(label_1, new ImageIcon(ArrayOfImages.get(index+2)));
				else
					HelpFunctions.setBackground(label_1, "nopic");
				if(index+3<ArrayOfImages.size())
					HelpFunctions.setImageAsIcon(label_2, new ImageIcon(ArrayOfImages.get(index+3)));
				else
					HelpFunctions.setBackground(label_2, "nopic");
				if(index+4<ArrayOfImages.size())
					HelpFunctions.setImageAsIcon(label_3, new ImageIcon(ArrayOfImages.get(index+4)));
				else
					HelpFunctions.setBackground(label_3, "nopic");
				if(index+5<ArrayOfImages.size())
					HelpFunctions.setImageAsIcon(label_4, new ImageIcon(ArrayOfImages.get(index+5)));
				else
					HelpFunctions.setBackground(label_4, "nopic");
			}

			}
		});
		btnNewButton.setBounds(734, 587, 137, 56);
		contentPane.add(btnNewButton);

		
		// back button 
		JButton button = new JButton("אחורה");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(index>0)
				{
					index-=6;

					if(index+0<ArrayOfImages.size())
						HelpFunctions.setImageAsIcon(lblNewLabel, new ImageIcon(ArrayOfImages.get(index+0)));
					else
						HelpFunctions.setBackground(lblNewLabel, "nopic");
					if(index+1<ArrayOfImages.size())
						HelpFunctions.setImageAsIcon(label, new ImageIcon(ArrayOfImages.get(index+1)));
					else
						HelpFunctions.setBackground(label, "nopic");
					if(index+2<ArrayOfImages.size())
						HelpFunctions.setImageAsIcon(label_1, new ImageIcon(ArrayOfImages.get(index+2)));
					else
						HelpFunctions.setBackground(label_1, "nopic");
					if(index+3<ArrayOfImages.size())
						HelpFunctions.setImageAsIcon(label_2, new ImageIcon(ArrayOfImages.get(index+3)));
					else
						HelpFunctions.setBackground(label_2, "nopic");
					if(index+4<ArrayOfImages.size())
						HelpFunctions.setImageAsIcon(label_3, new ImageIcon(ArrayOfImages.get(index+4)));
					else
						HelpFunctions.setBackground(label_3, "nopic");
					if(index+5<ArrayOfImages.size())
						HelpFunctions.setImageAsIcon(label_4, new ImageIcon(ArrayOfImages.get(index+5)));
					else
						HelpFunctions.setBackground(label_4, "nopic");
				}
			}
		});
		button.setBounds(513, 587, 137, 56);
		contentPane.add(button);

		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 0, 1362, 705);
		contentPane.add(background_label);
		HelpFunctions.setBackground(background_label);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);

		LoadImagesFromFolder();

	}
}
