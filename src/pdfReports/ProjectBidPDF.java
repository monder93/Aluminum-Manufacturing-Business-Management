package pdfReports;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import helpClasses.Fonts;
import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import main.ProjectProducts;

public class ProjectBidPDF implements Pdf
{

	@Override
	public void export() 
	{
		//-------------------------------------------variables to calculate debts,paid,still need to pay -----------------------
		double bidValue= 0;
		double allValue=0;
		double allValueAfterTax=0;
		final String RESOURCE = "src/img/logoAluminuim.jpg";
		JButton save = new JButton();
		JFileChooser fc = new JFileChooser();
		String clientName="";
		String contactName="";

		//----------------------------------------------------------------------------------------------------------------------

		fc.setCurrentDirectory(new java.io.File("C:\\"));
		fc.setDialogTitle("Save a File");
		//fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if(fc.showSaveDialog(save) == JFileChooser.APPROVE_OPTION)
		{
			String url = fc.getSelectedFile().getAbsolutePath();
			String url2= fc.getSelectedFile().getParent();
			String url3 = "C:\\";

			try
			{
				ResultSet rs1 = MysqlConnect.getDbCon().selectQuery("SELECT `שם מזמין` FROM `projects` WHERE `מספר פרויקט` = '"+ProjectProducts.id+"'  ");
				rs1.next();
				clientName=rs1.getString(1);
				
				rs1 = MysqlConnect.getDbCon().selectQuery("SELECT `איש קשר` FROM `projects` WHERE `מספר פרויקט` = '"+ProjectProducts.id+"'  ");
				rs1.next();
				contactName=rs1.getString(1);

				// Listing 1. Instantiation of document object
				Document document = new Document(PageSize.A4, 0, 0, 50, 50);

				File file = new File(".//reports//customersDebts.pdf");
				if (!file.exists())
				{
					if (file.mkdir()) 
					{
						System.out.println("Directory is created!");
					} 
					else 
					{
						System.out.println("Failed to create directory!");
					}
				}
				else
					System.out.println("mwgoood");

				// Listing 2. Creation of PdfWriter object
				if(url2.compareTo(url3)==0)
				{

					url=url2+"\\temp\\"+fc.getSelectedFile().getName();
				}

				PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(url + ".pdf"));

				writer.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
				//opening the document to write into it
				document.open();
				//----------------------------------------------------logo image ----------------------------------------------------
				// a cell with an image  
				PdfPTable imagetable = new PdfPTable(1);
				imagetable.setSpacingAfter(10);

				PdfPCell imageCell = new PdfPCell(Image.getInstance(String.format(RESOURCE, "0120903"), true));
				imageCell.setBorder(PdfPCell.NO_BORDER);
				imagetable.addCell(imageCell);

				document.add(imagetable);
				//----------------------------------------------------client information---------------------------------------------
				PdfPTable infotable = new PdfPTable(1);
				infotable.setSpacingAfter(10);
				infotable.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

				PdfPCell infoCell1 = new PdfPCell();
				infoCell1.addElement(new Phrase("אלום סוהר",Fonts.Arial14Bold));
				infoCell1.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				infotable.addCell(infoCell1);

				PdfPCell infoCell2 = new PdfPCell();
				infoCell2.addElement(new Phrase("תעשיות אלומיניום ותריסים לבניין",Fonts.Arial12));
				infoCell2.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				infotable.addCell(infoCell2);

				PdfPCell infoCell3 = new PdfPCell();
				infoCell3.addElement(new Phrase("דיר חנא 24973",Fonts.Arial12));
				infoCell3.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				infotable.addCell(infoCell3);

				PdfPCell infoCell4 = new PdfPCell();
				infoCell4.addElement(new Phrase("נייד : 050-5363833 , פקס : 04-6784519",Fonts.Arial12));
				infoCell4.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				infotable.addCell(infoCell4);

				document.add(infotable);

				//----------------------------------------------------report subject ---------------------------------------------
				PdfPTable subjecttable = new PdfPTable(1);
				subjecttable.setWidthPercentage(60);
				subjecttable.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

				PdfPCell subjectCell = new PdfPCell();
				//subjectCell.addElement(new Phrase("הצעת מחיר לכבוד :\n שם מזמין :"+clientName+"\n  איש קשר :"+contactName+"\n",Fonts.Arial14BoldItalic));
				subjectCell.addElement(new Phrase("הצעת מחיר לכבוד : איש קשר :"+contactName+"\n שם מזמין:"+clientName+"",Fonts.Arial14BoldItalic));
				subjectCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				subjecttable.addCell(subjectCell);

				PdfPCell subjectCel2 = new PdfPCell();
				subjectCel2.addElement(new Phrase(HelpFunctions.getCurrentTime(),Fonts.Arial14BoldItalic));
				subjectCel2.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				subjecttable.addCell(subjectCel2);

				document.add(subjecttable);			
				//----------------------------------------------------projectProducts Bid  table-------------------------------------------

				PdfPTable table = new PdfPTable(9);
				table.setSpacingBefore(15);
				table.setSpacingAfter(15);
				table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

				//first cell
				PdfPCell cell = new PdfPCell();
				Paragraph p2 = new Paragraph("מספר סידורי",Fonts.Arial);
				p2.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.setColspan(1);
				cell.addElement(p2);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//second cell
				Paragraph p3 = new Paragraph("תמונה",Fonts.Arial);
				p3.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.addElement(p3);
				cell.setColspan(1);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//second cell
				Paragraph p10 = new Paragraph("תיאור",Fonts.Arial);
				p10.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.addElement(p10);
				cell.setColspan(1);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//third cell
				Paragraph p4 = new Paragraph("סדרה",Fonts.Arial);
				p4.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.setColspan(1);
				cell.addElement(p4);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//4th cell
				Paragraph p5 = new Paragraph("רוחב",Fonts.Arial);
				p5.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.setColspan(1);
				cell.addElement(p5);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//5th cell
				Paragraph p6 = new Paragraph("גובה",Fonts.Arial);
				p6.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.setColspan(1);
				cell.addElement(p6);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//6th cell
				Paragraph p7 = new Paragraph("מחיר יחידה",Fonts.Arial);
				p7.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.setColspan(1);
				cell.addElement(p7);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//7th cell
				Paragraph p8 = new Paragraph("כמות",Fonts.Arial);
				p8.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.setColspan(1);
				cell.addElement(p8);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//8th cell
				Paragraph p9 = new Paragraph("מחיר",Fonts.Arial);
				p9.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.setColspan(1);
				cell.addElement(p9);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//getting the data from projectsproducts table in database

				ResultSet myRs = MysqlConnect.getDbCon().selectQuery("SELECT * FROM `projectsProducts` WHERE `מספר פרויקט` = '"+ProjectProducts.id+"'  ");

				while(myRs.next())
				{
					//product id 
					String cell2 = myRs.getString(1);

					//image 
					String cell3 = myRs.getString(3);
					String query="SELECT  `תמונה` FROM `products` WHERE `מזהה` ='"+cell3+"'";
					ResultSet rs;
					BufferedImage image;
					Image img = null;
					try 
					{
						rs = MysqlConnect.getDbCon().selectQuery(query);
						rs.next();
						java.sql.Blob blob = rs.getBlob(1);  
						java.io.InputStream in = blob.getBinaryStream();  
						image = ImageIO.read(in);
						img = Image.getInstance(image , null);
					}
					catch (SQLException | IOException e1) 
					{
						e1.printStackTrace();
					}

					//description
					String cell4 = myRs.getString(4);
					//series
					String cell5 = myRs.getString(5);
					//width
					String cell6 = myRs.getString(6);
					//height
					String cell7 = myRs.getString(7);
					//price
					String cell11 = myRs.getString(11);
					//quantity
					String cell8 = myRs.getString(8);

					// calculating the debt value and how much paid and still need to pay
					bidValue= Double.parseDouble(cell8)*Double.parseDouble(cell11);;
					allValue+=bidValue;
					//first cell
					cell = new PdfPCell();
					p2 = new Paragraph(cell2,Fonts.Arial);
					p2.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p2);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					cell=new PdfPCell();

					//second cell
					p3 = new Paragraph(cell3,Fonts.Arial);
					p3.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p3);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(new PdfPCell(img, true));
					cell=new PdfPCell();

					//third cell
					p4 = new Paragraph(cell4,Fonts.Arial);
					p4.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p4);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					cell=new PdfPCell();

					//4th cell
					p5 = new Paragraph(cell5,Fonts.Arial);
					p5.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p5);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					cell=new PdfPCell();

					//5th cell
					p6 = new Paragraph(cell6,Fonts.Arial);
					p6.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p6);
					table.addCell(cell);
					cell=new PdfPCell();

					//6th cell
					p7 = new Paragraph(cell7,Fonts.Arial);
					p7.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p7);
					table.addCell(cell);
					cell=new PdfPCell();

					//11th cell
					p8 = new Paragraph(cell11,Fonts.Arial);
					p8.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p8);
					table.addCell(cell);
					cell=new PdfPCell();

					//8th cell
					p9 = new Paragraph(cell8,Fonts.Arial);
					p9.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p9);
					table.addCell(cell);
					cell=new PdfPCell();

					//9th cell
					p10 = new Paragraph(String.valueOf(bidValue),Fonts.Arial);
					p10.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p10);
					table.addCell(cell);
					cell=new PdfPCell();					
				}
				document.add(table);

				//----------------------------------------------Value table---------------------------------------------------------------
				allValueAfterTax=allValue*117/100;
				PdfPTable beforelastTable = new PdfPTable(2);
				beforelastTable.setSpacingBefore(5);
				beforelastTable.setSpacingAfter(5);
				beforelastTable.setWidthPercentage(40);
				beforelastTable.setRunDirection(PdfWriter.RUN_DIRECTION_RTL); 

				PdfPCell beforelastCell = new PdfPCell();
				beforelastCell.addElement(new Phrase("סך הכל לפני מעם : ",Fonts.Arial14Bold));
				beforelastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				beforelastTable.addCell(beforelastCell);
				
				beforelastCell = new PdfPCell();
				beforelastCell.addElement(new Phrase(String.valueOf(allValue),Fonts.Arial14Bold));
				beforelastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				beforelastTable.addCell(beforelastCell);
				
				beforelastCell = new PdfPCell();
				beforelastCell.addElement(new Phrase("סך הכל אחרי מעם : ",Fonts.Arial14Bold));
				beforelastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				beforelastTable.addCell(beforelastCell);
				
				beforelastCell = new PdfPCell();
				beforelastCell.addElement(new Phrase(String.valueOf(allValueAfterTax),Fonts.Arial14Bold));
				beforelastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				beforelastTable.addCell(beforelastCell);
				document.add(beforelastTable);

				
				
				//----------------------------------------------last table , signature ---------------------------------------------------
				PdfPTable lastTable = new PdfPTable(1);
				lastTable.setSpacingBefore(10);
				lastTable.setSpacingAfter(20);
				lastTable.setRunDirection(PdfWriter.RUN_DIRECTION_LTR); 

				PdfPCell lastCell = new PdfPCell();
				lastCell.addElement(new Phrase("  בברכה \nאלום סוהר",Fonts.Arial14Bold));
				lastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				lastTable.addCell(lastCell);
				document.add(lastTable);

				//---------------------------------------------closing the document-------------------------------------------------
				document.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		
	}


}
