package main;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;

import javax.swing.JTextField;
import java.awt.ComponentOrientation;

public class PrdCostAnalysis {

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
	private JLabel label_8;
	private JTextField textField_9;
	private JLabel label_9;
	private JTextField textField_10;
	private JLabel label_10;
	private JTextField textField_11;
	private int prdID;
	private String name;
	private JLabel label_11;
	private JTextField textField_12;
	private String price;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrdCostAnalysis window = new PrdCostAnalysis();
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
	public PrdCostAnalysis() {
	}
	public PrdCostAnalysis(int prdID,String name,String price) {
		this.prdID=prdID;
		this.name=name;
		this.price=price;
		try {
			initialize();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @wbp.parser.entryPoint
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(450, 200, 550, 349);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(280, 170, 244, 123);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("אלומיניום :");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(125, 30, 145, 14);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField.setBounds(23, 24, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("פרזול :");
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(125, 58, 145, 14);
		frame.getContentPane().add(label);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(23, 52, 86, 20);
		frame.getContentPane().add(textField_1);

		JLabel label_1 = new JLabel("זכוכית :");
		label_1.setHorizontalTextPosition(SwingConstants.LEFT);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(125, 86, 145, 14);
		frame.getContentPane().add(label_1);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(23, 80, 86, 20);
		frame.getContentPane().add(textField_2);

		JLabel label_2 = new JLabel("עוור :");
		label_2.setHorizontalTextPosition(SwingConstants.LEFT);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(125, 114, 145, 14);
		frame.getContentPane().add(label_2);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_3.setColumns(10);
		textField_3.setBounds(23, 108, 86, 20);
		frame.getContentPane().add(textField_3);

		JLabel label_3 = new JLabel("סה\"כ עלות חומר :");
		label_3.setHorizontalTextPosition(SwingConstants.LEFT);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(125, 142, 145, 14);
		frame.getContentPane().add(label_3);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_4.setColumns(10);
		textField_4.setBounds(23, 136, 86, 20);
		frame.getContentPane().add(textField_4);

		JLabel label_4 = new JLabel("עלות יצור :");
		label_4.setHorizontalTextPosition(SwingConstants.LEFT);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(125, 170, 145, 14);
		frame.getContentPane().add(label_4);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_5.setColumns(10);
		textField_5.setBounds(23, 164, 86, 20);
		frame.getContentPane().add(textField_5);

		JLabel label_5 = new JLabel("עלות הרכבה :");
		label_5.setHorizontalTextPosition(SwingConstants.LEFT);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(125, 198, 145, 14);
		frame.getContentPane().add(label_5);

		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_6.setColumns(10);
		textField_6.setBounds(23, 192, 86, 20);
		frame.getContentPane().add(textField_6);

		JLabel label_6 = new JLabel("סה\"כ עלויות :");
		label_6.setHorizontalTextPosition(SwingConstants.LEFT);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(125, 226, 145, 14);
		frame.getContentPane().add(label_6);

		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setEditable(false);
		textField_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_7.setColumns(10);
		textField_7.setBounds(23, 220, 86, 20);
		frame.getContentPane().add(textField_7);

		JLabel label_7 = new JLabel("רווח :");
		label_7.setHorizontalTextPosition(SwingConstants.LEFT);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(125, 254, 145, 14);
		frame.getContentPane().add(label_7);

		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setEditable(false);
		textField_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_8.setColumns(10);
		textField_8.setBounds(23, 248, 86, 20);
		frame.getContentPane().add(textField_8);

		label_8 = new JLabel("סה\"כ מחיר מוצר :");
		label_8.setHorizontalTextPosition(SwingConstants.LEFT);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(125, 279, 145, 14);
		frame.getContentPane().add(label_8);

		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setEditable(false);
		textField_9.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_9.setColumns(10);
		textField_9.setBounds(23, 273, 86, 20);
		frame.getContentPane().add(textField_9);

		label_9 = new JLabel("מוצר :");
		label_9.setHorizontalTextPosition(SwingConstants.LEFT);
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(379, 30, 145, 14);
		frame.getContentPane().add(label_9);

		textField_10 = new JTextField(this.name);
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setEditable(false);
		textField_10.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_10.setColumns(10);
		textField_10.setBounds(292, 55, 232, 45);
		frame.getContentPane().add(textField_10);

		label_10 = new JLabel("סה\"כ משקל האלומיניום :");
		label_10.setHorizontalTextPosition(SwingConstants.LEFT);
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(360, 117, 164, 14);
		frame.getContentPane().add(label_10);

		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setEditable(false);
		textField_11.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_11.setColumns(10);
		textField_11.setBounds(292, 111, 80, 20);
		frame.getContentPane().add(textField_11);

		
		label_11 = new JLabel("סה\"כ מחיר מוצר כולל מע\"מ :");
		label_11.setHorizontalTextPosition(SwingConstants.LEFT);
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(358, 142, 169, 14);
		frame.getContentPane().add(label_11);
		
		textField_12 = new JTextField();
		textField_12.setText("0.0");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setEditable(false);
		textField_12.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_12.setColumns(10);
		textField_12.setBounds(292, 139, 80, 20);
		frame.getContentPane().add(textField_12);
		
		
		ResultSet rs = MysqlConnect.getDbCon().selectQuery("SELECT `משקל`, `אלומיניום`, `עוור`, `זכוכית`, `פרזול` FROM `costs` WHERE `מספר מוצר` ='"+prdID+"'");
		rs.next();
		double wight = Math.round(rs.getDouble(1)*100.0)/100.0 ;
		double almPrc =  Math.round(rs.getDouble(2)*100.0)/100.0 ;
		double glPrc =  Math.round(rs.getDouble(4)*100.0)/100.0 ;
		double everPrc =  Math.round(rs.getDouble(3)*100.0)/100.0 ;
		double przPrc =  Math.round(rs.getDouble(5)*100.0)/100.0 ;
		textField_11.setText(String.valueOf(wight));
		textField.setText(String.valueOf(almPrc));
		textField_3.setText(String.valueOf(everPrc));
		textField_2.setText(String.valueOf(glPrc));
		textField_1.setText(String.valueOf(przPrc));
		double stuffcosts=Math.round((przPrc+almPrc+everPrc+glPrc)*100.0)/100.0;
		textField_4.setText(String.valueOf(stuffcosts));
		
		
		ResultSet myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "רווח");
		myRs.next();
		double profit=(Double.parseDouble(myRs.getString(3))-1);
		myRs.next();
		myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "יצור");
		myRs.next();
		double productionsCost=(Double.parseDouble(myRs.getString(3))-1);
		myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "הרכבה");
		myRs.next();
		double workingCost=(Double.parseDouble(myRs.getString(3))-1);
		myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "מעמ");
		myRs.next();
		double tax=Double.parseDouble(myRs.getString(3));
		double prdCosts = Math.round((stuffcosts*productionsCost)*100.0)/100.0;
		textField_5.setText(String.valueOf(prdCosts));
		double wCost = Math.round((stuffcosts*workingCost)*100.0)/100.0;
		textField_6.setText(String.valueOf(wCost));
		double allCosts = Math.round((wCost+prdCosts+stuffcosts)*100.0)/100.0;
		textField_7.setText(String.valueOf(allCosts));
		double profitCost = Math.round((allCosts*profit)*100.0)/100.0;
		textField_8.setText(String.valueOf(profitCost));
		double price = Math.round((allCosts+profitCost)*100.0)/100.0;
		textField_9.setText(this.price);
		double fPrice = Math.round((price+(price*tax))*100.0)/100.0;
		textField_12.setText(String.valueOf(fPrice));
		
		HelpFunctions.setBackground(lblNewLabel_1,"analyse");





		
		

	}
}
