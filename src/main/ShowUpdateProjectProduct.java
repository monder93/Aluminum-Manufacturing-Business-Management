package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.itextpdf.text.log.SysoCounter;

import Choosers.colorList;
import Choosers.glassList;
import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import net.proteanit.sql.DbUtils;
import products.ProductFactory;
import products.Products;

import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowUpdateProjectProduct extends JFrame {

	private JPanel contentPane;
	private JTextField widthTextField;
	private JTextField heightTextField;
	private JTextField seriesTextField;
	public static JTextField colorTextField;
	public static JTextField glassTextField;
	private JTextField quantityTextField;
	private JTextField idTextField;
	private JTextField proIdTextField;
	private JTextField proCodeTextField;
	private JTextField descriptionTextField;
	private JLabel image_label;
	//variables to save data from projectProducts ,, for specefic product 
	private String id;
	private String proId;
	private String productCode;
	private String width;
	private String height;
	private String series;
	private String color;
	public static double colorPrice;
	private String glass;
	public static double glassPrice;
	private String description;
	private String quantity;
	private String type;
	private String pricee;
	
	private JButton btnNewButton_1;
	private JButton button;
	private JLabel lblNewLabel_1;
	private JTextField priceTextField;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowUpdateProjectProduct frame = new ShowUpdateProjectProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowUpdateProjectProduct(String id, String proId ,String productCode,String width,String height,String series,String color,String glass,String description,String quantity,String price)
	{
		this();
		this.id=id;
		this.proId=proId;
		this.productCode=productCode;
		this.width=width;
		this.height=height;
		this.series=series;
		this.color=color;
		this.glass=glass;
		this.description=description;
		this.quantity=quantity;
		this.pricee=price;
		idTextField.setText(this.id);
		proIdTextField.setText(this.proId);
		proCodeTextField.setText(this.productCode);
		widthTextField.setText(this.width);
		heightTextField.setText(this.height);
		seriesTextField.setText(this.series);
		colorTextField.setText(this.color);
		glassTextField.setText(this.glass);
		quantityTextField.setText(this.quantity);
		descriptionTextField.setText(this.description);
		priceTextField.setText(this.pricee);

		//getting the picture 
		String query="SELECT  `תמונה` FROM `products` WHERE `מזהה` ='"+this.productCode+"'";
		String query1="SELECT  `מחיר לקג` FROM `colors` WHERE `קוד מזהה` ='"+this.color+"'";
		String query2="SELECT  `מחיר למר` FROM `glass` WHERE `תאור` ='"+this.glass+"'";
		String query3="SELECT  `סוג פתיחה` FROM `products` WHERE `סדרה` ='"+this.series+"'";

		ResultSet rs;
		try 
		{
			System.out.println("----------------from constructor--------------");
			rs = MysqlConnect.getDbCon().selectQuery(query);
			rs.next();
			java.sql.Blob blob = rs.getBlob(1);  
			java.io.InputStream in = blob.getBinaryStream();  
			BufferedImage image = ImageIO.read(in);
			HelpFunctions.setImageAsIcon(image_label,new ImageIcon(image));
		
			rs = MysqlConnect.getDbCon().selectQuery(query1);
			rs.next();
			ShowUpdateProjectProduct.colorPrice=rs.getDouble(1);
			System.out.println(ShowUpdateProjectProduct.colorPrice);
			
			rs = MysqlConnect.getDbCon().selectQuery(query2);
			rs.next();
			ShowUpdateProjectProduct.glassPrice=rs.getDouble(1);
			System.out.println(ShowUpdateProjectProduct.glassPrice);
			
			rs = MysqlConnect.getDbCon().selectQuery(query3);
			rs.next();
			this.type=rs.getString(1);
			System.out.println(this.type);
			System.out.println("---------------------------------------");

		}
		catch (SQLException | IOException e1) 
		{
			e1.printStackTrace();
		}

		
		
		
	}
	/**
	 * Create the frame.
	 */
	public ShowUpdateProjectProduct() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 150, 615, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		image_label = new JLabel("תמונה");
		image_label.setBounds(10, 267, 212, 155);
		contentPane.add(image_label);
		
		JLabel lblNewLabel = new JLabel("מספר סידורי");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(481, 11, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("מספר פרויקט");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(288, 11, 79, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("קוד מוצר");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(74, 11, 61, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("רוחב");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(515, 216, 43, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("גובה");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(295, 216, 61, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("סדרה");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(103, 111, 32, 14);
		contentPane.add(label_4);
		
		JLabel label_7 = new JLabel("כמות");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(74, 222, 61, 14);
		contentPane.add(label_7);
		
		widthTextField = new JTextField();
		widthTextField.setBounds(407, 213, 86, 20);
		contentPane.add(widthTextField);
		widthTextField.setColumns(10);
		
		heightTextField = new JTextField();
		heightTextField.setColumns(10);
		heightTextField.setBounds(206, 216, 86, 20);
		contentPane.add(heightTextField);
		
		seriesTextField = new JTextField();
		seriesTextField.setEditable(false);
		seriesTextField.setColumns(10);
		seriesTextField.setBounds(10, 108, 86, 20);
		contentPane.add(seriesTextField);
		
		colorTextField = new JTextField();
		colorTextField.setEditable(false);
		colorTextField.setColumns(10);
		colorTextField.setBounds(407, 105, 86, 20);
		contentPane.add(colorTextField);
		
		glassTextField = new JTextField();
		glassTextField.setEditable(false);
		glassTextField.setColumns(10);
		glassTextField.setBounds(206, 108, 86, 20);
		contentPane.add(glassTextField);
		
		quantityTextField = new JTextField();
		quantityTextField.setColumns(10);
		quantityTextField.setBounds(10, 219, 86, 20);
		contentPane.add(quantityTextField);
		
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setColumns(10);
		idTextField.setBounds(407, 8, 86, 20);
		contentPane.add(idTextField);
		
		proIdTextField = new JTextField();
		proIdTextField.setEditable(false);
		proIdTextField.setColumns(10);
		proIdTextField.setBounds(206, 8, 86, 20);
		contentPane.add(proIdTextField);
		
		proCodeTextField = new JTextField();
		proCodeTextField.setEditable(false);
		proCodeTextField.setColumns(10);
		proCodeTextField.setBounds(10, 8, 61, 20);
		contentPane.add(proCodeTextField);
		
		JLabel label_8 = new JLabel("תיאור");
		label_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_8.setBounds(512, 307, 46, 14);
		contentPane.add(label_8);
		
		JButton btnNewButton = new JButton("עדכון");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				double price=0;
				if(!widthTextField.getText().toString().equals("")	&& !heightTextField.getText().toString().equals("")	&& !quantityTextField.getText().toString().equals(""))
					{
					color=colorTextField.getText().toString();
					glass=glassTextField.getText().toString();
					width=widthTextField.getText().toString();
					height=heightTextField.getText().toString();
					quantity=quantityTextField.getText().toString();
					try
					{
						ProductFactory pr = new ProductFactory();
						Products p = pr.getProduct(type, Double.parseDouble(width), Double.parseDouble(height),ShowUpdateProjectProduct.colorPrice, ShowUpdateProjectProduct.glassPrice,series, 2);
						price = p.calculatePrice();
						
						System.out.println("id is : " +id);
						System.out.println("pro id is : "+proId);
						System.out.println("product code is : "+productCode);
						System.out.println("width is : "+width);
						System.out.println("height is : "+height);
						System.out.println("series is : "+series);
						System.out.println("color is : "+color);
						System.out.println("glass is : "+glass);
						System.out.println("description is : "+description);
						System.out.println("quantity is : "+quantity);
						System.out.println("pricee is : "+pricee);
						System.out.println("price is : "+price);
						System.out.println("glass price is : "+glassPrice);
						System.out.println("color price is : "+colorPrice);
						System.out.println("type is  : "+type);


						
						String updateProductQuery="UPDATE `projectsproducts` SET`צבע`='"+color+"',`זיגוג`='"+glass+"',`רוחב`='"+width+"',`גובה`='"+height+"',`כמות`='"+quantity+"',`מחיר`='"+price+"' WHERE `מספר סידורי`='"+id+"'";
						MysqlConnect.getDbCon().updateQuery(updateProductQuery);
						System.out.println("price is : "+ price);

					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
					
					try 
					{
						ResultSet myRs;
						myRs = MysqlConnect.getDbCon().selectQuery("SELECT * FROM `projectsProducts` WHERE `מספר פרויקט` = '"+ProjectProducts.id +"'  ");
						ProjectProducts.table.setModel(DbUtils.resultSetToTableModel(myRs));
						HelpFunctions.renderingTable(ProjectProducts.table);
						
						double allPrice=ProjectProducts.calcAllProductPrice();
						double pieceAvarage = ProjectProducts.calcProductAvaragePrice();
						ProjectProducts.lblNewLabel_3.setText(String.valueOf(allPrice));
						ProjectProducts.label_1.setText(String.valueOf(allPrice*1.17));
						ProjectProducts.lblNewLabel_4.setText(String.valueOf(Math.floor(pieceAvarage*100/100)));
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
					
					dispose();
					
					}
			}
		});
		btnNewButton.setBounds(270, 399, 89, 23);
		contentPane.add(btnNewButton);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setEditable(false);
		descriptionTextField.setBounds(228, 304, 265, 20);
		contentPane.add(descriptionTextField);
		descriptionTextField.setColumns(10);
		
		btnNewButton_1 = new JButton("זיגוג");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					new glassList("UpdateProjectProduct");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(307, 104, 67, 23);
		contentPane.add(btnNewButton_1);
		
		button = new JButton("צבע");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					new colorList("UpdateProjectProduct");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		button.setBounds(515, 104, 67, 23);
		contentPane.add(button);
		
		lblNewLabel_1 = new JLabel("מחיר");
		lblNewLabel_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_1.setBounds(515, 403, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		priceTextField = new JTextField();
		priceTextField.setEditable(false);
		priceTextField.setBounds(419, 400, 86, 20);
		contentPane.add(priceTextField);
		priceTextField.setColumns(10);
	}
}
