import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Catalogue extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ButtonGroup companyBG= new ButtonGroup();
	private String companyName="";
	private String pdfFileName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Catalogue frame = new Catalogue();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Catalogue() 
	{
		initComponents();
	}
	
	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 349, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setBounds(69, 83, 186, 217);
		contentPane.add(scrollPane);
		
		table = new JTable()
		{
		    @Override
		    public boolean isCellEditable(int row, int column) 
		    {
		        return column==1 ;                
		    };
		};
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);
		
		JRadioButton radioButton = new JRadioButton("קליל");
		radioButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				companyName=radioButton.getText();
				String query="SELECT `שם` FROM `catalogue` WHERE `חברה`='"+companyName+"' ";
				System.out.println(query);
				pdfFileName="kalil/";
				try 
				{
					Connection myConn = HelpFunctions.DbConnection();
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(myRs));
					
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
				}
			}
		});
		
	
		table.addMouseListener(new MouseAdapter() 
		{
		    public void mousePressed(MouseEvent me)
		    {
				
		        		
		        if (me.getClickCount() == 2) 
		        {
			    	int row = table.getSelectedRow();
			    	if(row<0)
						JOptionPane.showMessageDialog(null, "בחר אופציה בבקשה");
					else
					{

				    String choosedName=(table.getModel().getValueAt(row, 0)).toString();

					try{
						//get link from database
						String query="SELECT `קישור` FROM `catalogue` WHERE `חברה`='"+companyName+"' AND `שם`='"+choosedName+"' ";
						Connection myConn = HelpFunctions.DbConnection();
						Statement myStmt = myConn.createStatement();
						ResultSet myRs = myStmt.executeQuery(query);
						String StringTemp=pdfFileName;
						 while (myRs.next())
						 {
							 pdfFileName=pdfFileName+myRs.getString(1);
						 }
						System.out.println(pdfFileName);
						
					System.out.println(pdfFileName);	
					PdfViewer pdfview =new PdfViewer(pdfFileName);
					pdfview.main();
					pdfFileName=StringTemp;
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					}
				}
			}
		});	
		
		radioButton.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton.setBounds(181, 36, 74, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("אקסטל");
		radioButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				companyName=radioButton_1.getText();
				String query="SELECT `שם` FROM `catalogue` WHERE `חברה`='"+companyName+"' ";
				System.out.println(query);
				pdfFileName="akstel/";
				try 
				{
					Connection myConn = HelpFunctions.DbConnection();
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(myRs));
					
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
				
			}
		});
		radioButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_1.setBounds(69, 36, 74, 23);
		contentPane.add(radioButton_1);
		
		JLabel background_label = new JLabel("New label");
		background_label.setBounds(0, 0, 337, 311);
		contentPane.add(background_label);
		companyBG.add(radioButton);
		companyBG.add(radioButton_1);
		//setting background
		HelpFunctions.setBackground(background_label);

	}
}
