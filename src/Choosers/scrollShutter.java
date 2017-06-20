package Choosers;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class scrollShutter 
{

	private JFrame frame;
	private JTextField textField;
	private JLabel label;
	private JTextField textField_1;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;
	private JRadioButton radioButton_7;
	private JRadioButton radioButton_8;
	private JRadioButton radioButton_9;
	private JRadioButton radioButton_10;
	private JLabel label_4;
	private JLabel label_5;
	private JRadioButton radioButton_11;
	private JRadioButton radioButton_12;
	private JRadioButton radioButton_13;
	private JRadioButton radioButton_14;
	private JRadioButton radioButton_15;
	private JRadioButton radioButton_16;
	private JRadioButton radioButton_17;
	private JRadioButton radioButton_18;
	private JRadioButton radioButton_19;
	private JRadioButton radioButton_20;
	private ButtonGroup bg1= new ButtonGroup();
	private ButtonGroup bg2= new ButtonGroup();
	private ButtonGroup bg3= new ButtonGroup();
	private ButtonGroup bg4= new ButtonGroup();
	private ButtonGroup bg5= new ButtonGroup();
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					scrollShutter window = new scrollShutter();
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
	public scrollShutter() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 658, 502);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JButton btnNewButton = new JButton("סוג שלב");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					new scrollShutterType();
				}
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(532, 22, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(340, 23, 161, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		label = new JLabel("גובה ארגז:");
		label.setBounds(210, 26, 64, 14);
		frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(92, 23, 108, 20);
		frame.getContentPane().add(textField_1);
		
		label_1 = new JLabel("כוח חשמל:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(93, 81, 107, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("הפעלה חשמלית:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(471, 80, 139, 14);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("יצרן מנוע:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(285, 81, 109, 14);
		frame.getContentPane().add(label_3);
		
		rdbtnNewRadioButton = new JRadioButton("40 וולט");
		rdbtnNewRadioButton.setHorizontalTextPosition(SwingConstants.LEFT);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnNewRadioButton.setBounds(91, 117, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		radioButton = new JRadioButton("60 וולט");
		radioButton.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton.setBounds(91, 143, 109, 23);
		frame.getContentPane().add(radioButton);
		
		radioButton_1 = new JRadioButton("70 וולט");
		radioButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_1.setBounds(91, 173, 109, 23);
		frame.getContentPane().add(radioButton_1);
		
		radioButton_2 = new JRadioButton("90 וולט");
		radioButton_2.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_2.setBounds(91, 199, 109, 23);
		frame.getContentPane().add(radioButton_2);
		
		radioButton_3 = new JRadioButton("110 וולט");
		radioButton_3.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_3.setBounds(91, 226, 109, 23);
		frame.getContentPane().add(radioButton_3);
		
		radioButton_4 = new JRadioButton("120 וולט");
		radioButton_4.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_4.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_4.setBounds(91, 252, 109, 23);
		frame.getContentPane().add(radioButton_4);
		
		radioButton_5 = new JRadioButton("מנוע");
		radioButton_5.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_5.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_5.setBounds(489, 116, 109, 23);
		frame.getContentPane().add(radioButton_5);
		
		radioButton_6 = new JRadioButton("מנוע + מנואלה");
		radioButton_6.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_6.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_6.setBounds(489, 142, 109, 23);
		frame.getContentPane().add(radioButton_6);
		
		radioButton_7 = new JRadioButton("בלי");
		radioButton_7.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_7.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_7.setBounds(489, 172, 109, 23);
		frame.getContentPane().add(radioButton_7);
		
		radioButton_8 = new JRadioButton("גולי");
		radioButton_8.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_8.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_8.setBounds(285, 117, 109, 23);
		frame.getContentPane().add(radioButton_8);
		
		radioButton_9 = new JRadioButton("סומפי");
		radioButton_9.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_9.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_9.setBounds(285, 143, 109, 23);
		frame.getContentPane().add(radioButton_9);
		
		radioButton_10 = new JRadioButton("אחר");
		radioButton_10.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_10.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_10.setBounds(285, 173, 109, 23);
		frame.getContentPane().add(radioButton_10);
		
		label_4 = new JLabel("סוג ארגז:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(503, 228, 107, 14);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("סגירה חיצונית לארגז:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(55, 336, 161, 14);
		frame.getContentPane().add(label_5);
		
		radioButton_11 = new JRadioButton("מונובלוק 30 + מכסה אלומיניום");
		radioButton_11.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_11.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_11.setBounds(419, 252, 179, 23);
		frame.getContentPane().add(radioButton_11);
		
		radioButton_12 = new JRadioButton("מונובלוק 30 + מכסה מזוניט");
		radioButton_12.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_12.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_12.setBounds(427, 276, 171, 23);
		frame.getContentPane().add(radioButton_12);
		
		radioButton_13 = new JRadioButton("מונובלוק 40");
		radioButton_13.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_13.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_13.setBounds(515, 302, 83, 23);
		frame.getContentPane().add(radioButton_13);
		
		radioButton_14 = new JRadioButton("ארגז רול");
		radioButton_14.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_14.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_14.setBounds(527, 328, 71, 23);
		frame.getContentPane().add(radioButton_14);
		
		radioButton_15 = new JRadioButton("ארגז תריס סמרי");
		radioButton_15.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_15.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_15.setBounds(487, 354, 111, 23);
		frame.getContentPane().add(radioButton_15);
		
		radioButton_16 = new JRadioButton("ארגז תריס סמרי -קליל - מכסה עץ");
		radioButton_16.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_16.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_16.setBounds(397, 380, 201, 23);
		frame.getContentPane().add(radioButton_16);
		
		radioButton_17 = new JRadioButton("ארגז תריס סמרי -קליל - מכסה גבס");
		radioButton_17.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_17.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_17.setBounds(387, 406, 211, 23);
		frame.getContentPane().add(radioButton_17);
		
		radioButton_18 = new JRadioButton("פח + רשת אקספנדר");
		radioButton_18.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_18.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_18.setBounds(65, 357, 136, 23);
		frame.getContentPane().add(radioButton_18);
		
		radioButton_19 = new JRadioButton("מכסה חיצוני לארגז");
		radioButton_19.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_19.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_19.setBounds(63, 384, 136, 23);
		frame.getContentPane().add(radioButton_19);
		
		radioButton_20 = new JRadioButton("בלי");
		radioButton_20.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_20.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_20.setBounds(156, 406, 43, 23);
		frame.getContentPane().add(radioButton_20);
		
		bg1.add(rdbtnNewRadioButton);
		bg1.add(radioButton);
		bg1.add(radioButton_1);
		bg1.add(radioButton_2);
		bg1.add(radioButton_3);
		bg1.add(radioButton_4);
		bg2.add(radioButton_5);
		bg2.add(radioButton_6);
		bg2.add(radioButton_7);
		bg3.add(radioButton_8);
		bg3.add(radioButton_9);
		bg3.add(radioButton_10);
		bg4.add(radioButton_11);
		bg4.add(radioButton_12);
		bg4.add(radioButton_13);
		bg4.add(radioButton_14);
		bg4.add(radioButton_15);
		bg4.add(radioButton_16);
		bg4.add(radioButton_17);
		bg5.add(radioButton_18);
		bg5.add(radioButton_19);
		bg5.add(radioButton_20);
		
		button = new JButton("אישור");
		button.setBounds(254, 429, 89, 23);
		frame.getContentPane().add(button);
		
		
		
		
	}
}
