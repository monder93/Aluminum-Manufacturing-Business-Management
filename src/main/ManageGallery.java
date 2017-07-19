package main;

/*
 * a class for managing the gallery 
 * adding , deleting images 
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.FileFilter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import helpClasses.HelpFunctions;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageGallery extends JFrame 
{
	private JList list;
	private DefaultListModel dlmA;
	private JLabel lblNewLabel;
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
					if (name.endsWith("." + ext)) 
					{
						return	true;
					}
				}
				return false;
			}
		};

		dlmA = new DefaultListModel();
		if (dir.isDirectory()) 
		{
			// make sure it's a directory
			for (final File f : dir.listFiles(IMAGE_FILTER)) 
			{

				try 
				{
					dlmA.addElement(f);
				}
				catch (Exception e)
				{
					// TODO: handle exception
				}
			}
			list.setModel(dlmA);

		}


	}






	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel backgroundlabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageGallery frame = new ManageGallery();
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
	public ManageGallery() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 501, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("ניהול גלריה");
		scrollPane = new JScrollPane();
		scrollPane.setBounds(259, 11, 204, 239);
		contentPane.add(scrollPane);
		setVisible(true);
		list = new JList();
		scrollPane.setViewportView(list);
		list.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent arg0)
			{
				HelpFunctions.setImageAsIcon(lblNewLabel, new ImageIcon(list.getSelectedValue().toString()));
			}
		});

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 225, 181);
		contentPane.add(lblNewLabel);

		//deleting image button 
		JButton button = new JButton("מחיקת תמונה");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{

					// create new file
					File f = new File(list.getSelectedValue().toString());
					f.delete();
					LoadImagesFromFolder();
					HelpFunctions.setBackground(lblNewLabel, "nopic");

				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		button.setBounds(136, 214, 109, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("הוספת תמונה");
		button_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//choosing picture to add 

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif");
				fileChooser.setFileFilter(filter);
				int result = fileChooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					String imageName = selectedFile.getName();
					File file = new File(path);
					BufferedImage image = null;
					try 
					{
						image = ImageIO.read(file);
						ImageIO.write(image, "jpg",new File("src/galleryImages/"+imageName));
						HelpFunctions.setBackground(lblNewLabel, "nopic");
					}
					catch (IOException e1) 
					{
						e1.printStackTrace();
					}
					LoadImagesFromFolder();
				}
				else if(result == JFileChooser.CANCEL_OPTION)
				{

				}
			}
		});
		button_1.setBounds(10, 214, 116, 23);
		contentPane.add(button_1);

		LoadImagesFromFolder();
		HelpFunctions.setBackground(lblNewLabel, "nopic");

		backgroundlabel = new JLabel("New label");
		backgroundlabel.setBounds(0, 0, 485, 261);
		contentPane.add(backgroundlabel);
		HelpFunctions.setBackground(backgroundlabel);
	}
}
