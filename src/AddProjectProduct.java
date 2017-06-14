import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProjectProduct 
{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					AddProjectProduct window = new AddProjectProduct();
					window.frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddProjectProduct()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(350, 120, 660, 547);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("הוספת מוצר לפרויקט");
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton chooseProduct = new JButton("בחירת מוצר");
		chooseProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new product();
			}
		});
		chooseProduct.setBounds(363, 58, 214, 54);
		frame.getContentPane().add(chooseProduct);
		
		JLabel lblNewLabel = new JLabel("סדרה");
		lblNewLabel.setBounds(531, 148, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("תיאור");
		lblNewLabel_1.setBounds(531, 194, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("רוחב");
		lblNewLabel_2.setBounds(531, 240, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("גובה");
		lblNewLabel_3.setBounds(531, 280, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("כמות");
		lblNewLabel_4.setBounds(531, 320, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("מידת הקבוע");
		lblNewLabel_5.setBounds(497, 360, 80, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("תמונה");
		lblNewLabel_6.setBounds(76, 58, 188, 168);
		frame.getContentPane().add(lblNewLabel_6);
		HelpFunctions.setBackground(lblNewLabel_6,"nopic");
		
		JButton btnNewButton = new JButton("צבע");
		btnNewButton.setBounds(270, 240, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(76, 240, 184, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("זיגוג");
		button.setBounds(270, 280, 89, 23);
		frame.getContentPane().add(button);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(76, 280, 184, 20);
		frame.getContentPane().add(textField_1);
		
		JButton button_1 = new JButton("זיגוג לקבוע");
		button_1.setBounds(270, 320, 92, 23);
		frame.getContentPane().add(button_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(76, 320, 184, 20);
		frame.getContentPane().add(textField_2);
		
		JButton button_2 = new JButton("מיקום");
		button_2.setBounds(270, 360, 89, 23);
		frame.getContentPane().add(button_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(76, 360, 184, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton_1 = new JButton("אישור");
		btnNewButton_1.setBounds(363, 419, 214, 47);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button_3 = new JButton("ביטול");
		button_3.setBounds(76, 419, 214, 47);
		frame.getContentPane().add(button_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(401, 145, 120, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(286, 191, 235, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(401, 237, 120, 20);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(401, 277, 120, 20);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(401, 317, 120, 20);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(401, 357, 86, 20);
		frame.getContentPane().add(textField_9);
		
		JLabel background_label = new JLabel("רקע");
		background_label.setBounds(0, 0, 644, 561);
		frame.getContentPane().add(background_label);
		HelpFunctions.setBackground(background_label);
		
	}

}
