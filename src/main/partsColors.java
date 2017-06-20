package main;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;

import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class partsColors {

	private JFrame frame;
	private JTextField textField;
	private ButtonGroup BG1= new ButtonGroup();
	private ButtonGroup BG2= new ButtonGroup();
	private ButtonGroup BG3= new ButtonGroup();
	private ButtonGroup BG4= new ButtonGroup();
	//-------------------variables to save values
	String plastic;
	String gomya;
	String mvreshet;
	String ydet;
	boolean flag=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					partsColors window = new partsColors();
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
	public partsColors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 432, 374);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblNewLabel = new JLabel("פלסטיק:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(277, 33, 99, 32);
		frame.getContentPane().add(lblNewLabel);

		JRadioButton radioButton = new JRadioButton("לבן");
		radioButton.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				if(arg0.getStateChange()==1)
					plastic ="לבן";
			}
		});
		radioButton.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton.setBounds(323, 72, 53, 23);
		frame.getContentPane().add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("שחור");
		radioButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange()==1)
					plastic ="שחור";
			}
		});
		radioButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_1.setBounds(323, 98, 53, 23);
		frame.getContentPane().add(radioButton_1);

		JLabel label = new JLabel("גומיות:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(277, 126, 99, 32);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("מברשות:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(277, 218, 99, 32);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("ידיות וצירים:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(77, 33, 99, 32);
		frame.getContentPane().add(label_2);

		JRadioButton radioButton_6 = new JRadioButton("לבן");
		radioButton_6.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange()==1){
					ydet ="לבן";
					flag=false;
				}
			}
		});
		radioButton_6.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_6.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_6.setBounds(123, 72, 53, 23);
		frame.getContentPane().add(radioButton_6);

		JRadioButton radioButton_7 = new JRadioButton("שחור");
		radioButton_7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange()==1){
					ydet ="שחור";
					flag=false;
				}
			}
		});
		radioButton_7.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_7.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_7.setBounds(123, 98, 53, 23);
		frame.getContentPane().add(radioButton_7);

		JRadioButton radioButton_8 = new JRadioButton("ברונזה");
		radioButton_8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				if(e.getStateChange()==1){
					ydet ="ברונזה";
					flag=false;
				}
			}
		});
		radioButton_8.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_8.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_8.setBounds(111, 126, 65, 23);
		frame.getContentPane().add(radioButton_8);

		JRadioButton radioButton_9 = new JRadioButton("כסף עתיק");
		radioButton_9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange()==1)
				{
					flag=false;
					ydet ="כסף עתיק";
				}
			}
		});
		radioButton_9.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_9.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_9.setBounds(99, 152, 77, 23);
		frame.getContentPane().add(radioButton_9);

		JRadioButton radioButton_10 = new JRadioButton("טבעי");
		radioButton_10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange()==1)
				{
					flag=false;
					ydet ="טבעי";
				}
			}
		});
		radioButton_10.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_10.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_10.setBounds(123, 178, 53, 23);
		frame.getContentPane().add(radioButton_10);

		JRadioButton radioButton_11 = new JRadioButton("קרם");
		radioButton_11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange()==1)
				{
					ydet ="קרם";
					flag=false;
				}
			}
		});
		radioButton_11.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_11.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_11.setBounds(123, 204, 53, 23);
		frame.getContentPane().add(radioButton_11);

		JRadioButton radioButton_2 = new JRadioButton("לבן");
		radioButton_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange()==1)
					gomya ="לבן";
			}
		});
		radioButton_2.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_2.setBounds(323, 157, 53, 23);
		frame.getContentPane().add(radioButton_2);

		JRadioButton radioButton_3 = new JRadioButton("שחור");
		radioButton_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				if(e.getStateChange()==1)
					gomya ="שחור";
			}
		});
		radioButton_3.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_3.setBounds(323, 183, 53, 23);
		frame.getContentPane().add(radioButton_3);

		JRadioButton radioButton_4 = new JRadioButton("לבן");
		radioButton_4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				if(e.getStateChange()==1)
					mvreshet ="לבן";
			}
		});
		radioButton_4.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_4.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_4.setBounds(323, 257, 53, 23);
		frame.getContentPane().add(radioButton_4);

		JRadioButton radioButton_5 = new JRadioButton("שחור");
		radioButton_5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange()==1)
					mvreshet ="שחור";
			}
		});
		radioButton_5.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_5.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_5.setBounds(323, 283, 53, 23);
		frame.getContentPane().add(radioButton_5);

		JRadioButton radioButton_12 = new JRadioButton("אחר");
		radioButton_12.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				flag = true;
			}
		});
		radioButton_12.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) 
			{
				if(radioButton_12.isSelected())
					textField.show();
				else
					textField.hide();
			}
		});
		radioButton_12.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_12.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_12.setBounds(123, 230, 53, 23);
		frame.getContentPane().add(radioButton_12);

		BG1.add(radioButton);
		BG1.add(radioButton_1);

		BG2.add(radioButton_2);
		BG2.add(radioButton_3);

		BG3.add(radioButton_4);
		BG3.add(radioButton_5);

		BG4.add(radioButton_6);
		BG4.add(radioButton_7);
		BG4.add(radioButton_8);
		BG4.add(radioButton_9);
		BG4.add(radioButton_10);
		BG4.add(radioButton_11);
		BG4.add(radioButton_12);




		textField = new JTextField();
		textField.setBounds(90, 260, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		radioButton.setSelected(true);
		radioButton_2.setSelected(true);
		radioButton_4.setSelected(true);
		radioButton_6.setSelected(true);

		JButton button = new JButton("אישור");

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(flag)
					ydet=textField.getText();

				try {
					ResultSet myRs = MysqlConnect.getDbCon().selectWhereQuery("hardwareColor", "מזהה פרויקט", ProjectProducts.id);
					int counter=0;
					if(myRs.next())
					{
						counter++;
					}
					if(counter>0)
					{
						String q="UPDATE `hardwareColor` SET `פלסטיק`= '"+plastic+"',`גומיות`='"+gomya+"',`מברישת`='"+mvreshet+"',`ידיות וצירים`='"+ydet+"' WHERE `מזהה פרויקט`";
						MysqlConnect.getDbCon().updateQuery(q);
					}
					else
					{
						String q="INSERT INTO `hardwareColor`(`מזהה פרויקט`, `פלסטיק`, `גומיות`, `מברישת`, `ידיות וצירים`) VALUES ('"+ProjectProducts.id+"','"+plastic+"','"+gomya+"','"+mvreshet+"','"+ydet+"')";
						MysqlConnect.getDbCon().insertQuery(q);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		button.setBounds(188, 301, 89, 23);
		frame.getContentPane().add(button);

		JLabel background_label = new JLabel("New label");
		background_label.setBounds(0, -4, 416, 339);
		frame.getContentPane().add(background_label);
		HelpFunctions.setBackground(background_label);
		textField.hide();

	}
}
