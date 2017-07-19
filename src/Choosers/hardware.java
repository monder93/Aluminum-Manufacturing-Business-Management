package Choosers;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import main.AddOrderItems;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/*
 * this class for choosing hardware list
 * */
public class hardware {

	private JFrame frame;
	private JTable table;
	private String type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hardware window = new hardware();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public hardware(String type) throws SQLException
	{
		this();
		this.type=type;

	}

	public hardware() throws SQLException
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException 
	{
		frame = new JFrame();
		frame.setBounds(450, 150, 428, 509);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle("פירזולים");
		JLabel lblPic = new JLabel("pic");
		lblPic.setBounds(73, 343, 248, 116);
		frame.getContentPane().add(lblPic);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 392, 332);
		frame.getContentPane().add(scrollPane);
		frame.setName("פרזול");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				if(!table.getSelectionModel().isSelectionEmpty())
				{
					int row = table.getSelectedRow();
					String query="SELECT  `תמונה` FROM `hardware` WHERE `מזהה` ='"+(table.getModel().getValueAt(row, 0))+"'";
					ResultSet rs;
					try 
					{
						rs = MysqlConnect.getDbCon().selectQuery(query);
						rs.next();
						java.sql.Blob blob = rs.getBlob(1);  
						java.io.InputStream in = blob.getBinaryStream();  
						BufferedImage image = ImageIO.read(in);
						HelpFunctions.setImageAsIcon(lblPic,new ImageIcon(image));
					}
					catch (SQLException | IOException e1) 
					{
						e1.printStackTrace();
					}
				}
				else
				{
					System.out.println("no picture selected");
				}
				JTable table =(JTable) arg0.getSource();
				Point p = arg0.getPoint();
				int row = table.rowAtPoint(p);
				if (arg0.getClickCount() == 2) 
				{
					if(type.equals("AddOrderItems"))
					{
						String hardwareID=(table.getModel().getValueAt(row, 2)).toString();
						AddOrderItems.idTextField.setText(hardwareID);
						String hardwareName=(table.getModel().getValueAt(row, 3)).toString();
						AddOrderItems.descriptionTextField_1.setText(hardwareName);
						frame.dispose();
					}
				}
			}
		});
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);

		String query = "SELECT * FROM hardware";
		ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(myRs));
		HelpFunctions.renderingTable(table);
		HelpFunctions.setBackground(lblPic, "noPic");
	}
}
