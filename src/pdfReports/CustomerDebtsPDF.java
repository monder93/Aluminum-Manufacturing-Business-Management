package pdfReports;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import com.itextpdf.text.BaseColor;
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

public class CustomerDebtsPDF implements Pdf
{
	
	public void export() 
	{

		//-------------------------------------------variables to calculate debts,paid,still need to pay -----------------------
		double debtValue= 0;
		double paidValue=0;
		double needToPayValue=0;
		final String RESOURCE = "src/img/logoAluminuim.jpg";
		JButton save = new JButton();
		JFileChooser fc = new JFileChooser();

		//----------------------------------------------------------------------------------------------------------------------

		fc.setCurrentDirectory(new java.io.File("C:\\"));
		fc.setDialogTitle("Save a File");
		//fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if(fc.showSaveDialog(save) == JFileChooser.APPROVE_OPTION)
		{
			//
		}
		String url = fc.getSelectedFile().getAbsolutePath();
		String url2= fc.getSelectedFile().getParent();
		String url3 = "C:\\";
		
			
			
		
		
		//---------------
		
		try
		{
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
			subjecttable.setWidthPercentage(40);
			subjecttable.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
			
			PdfPCell subjectCell = new PdfPCell();
			subjectCell.addElement(new Phrase("דוח פירוט לקוחות חייבים",Fonts.Arial14BoldItalic));
			subjectCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
			subjecttable.addCell(subjectCell);
			
			PdfPCell subjectCel2 = new PdfPCell();
			subjectCel2.addElement(new Phrase(HelpFunctions.getCurrentTime(),Fonts.Arial14BoldItalic));
			subjectCel2.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
			subjecttable.addCell(subjectCel2);
			
			document.add(subjecttable);			
			//----------------------------------------------------customersDebts table-------------------------------------------

			PdfPTable table = new PdfPTable(5);
			table.setSpacingBefore(15);
			table.setSpacingAfter(15);
			table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
			
			//first cell
			PdfPCell cell = new PdfPCell();
			Paragraph p2 = new Paragraph("שם לקוח",Fonts.Arial);
			p2.setAlignment(PdfPCell.ALIGN_CENTER);
			cell.setColspan(1);
			cell.addElement(p2);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			cell=new PdfPCell();

			//second cell
			Paragraph p3 = new Paragraph("תאריך",Fonts.Arial);
			p3.setAlignment(PdfPCell.ALIGN_CENTER);
			cell.addElement(p3);
			cell.setColspan(1);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			cell=new PdfPCell();

			//third cell
			Paragraph p4 = new Paragraph("חוב",Fonts.Arial);
			p4.setAlignment(PdfPCell.ALIGN_CENTER);
			cell.setColspan(1);
			cell.addElement(p4);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			cell=new PdfPCell();

			//4th cell
			Paragraph p5 = new Paragraph("שולם",Fonts.Arial);
			p5.setAlignment(PdfPCell.ALIGN_CENTER);
			cell.setColspan(1);
			cell.addElement(p5);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			cell=new PdfPCell();

			//5th cell
			Paragraph p6 = new Paragraph("לתשלום",Fonts.Arial);
			p6.setAlignment(PdfPCell.ALIGN_CENTER);
			cell.setColspan(1);
			cell.addElement(p6);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			cell=new PdfPCell();

			//getting the data from customers debts table in database
//			Connection myConn = HelpFunctions.DbConnection();
			String pdf_query = "SELECT * FROM `customersdebts`";
//			Statement st = myConn.createStatement();
			ResultSet rs = MysqlConnect.getDbCon().selectQuery(pdf_query);
			while(rs.next())
			{
				String cell2 = rs.getString(2);
				String cell3 = rs.getString(3);
				String cell4 = rs.getString(4);
				String cell5 = rs.getString(5);
				String cell6 = rs.getString(6);

				// calculating the debt value and how much paid and still need to pay
				debtValue+= Double.parseDouble(cell4);
				paidValue+=Double.parseDouble(cell5);
				needToPayValue+=Double.parseDouble(cell6);
				
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
				table.addCell(cell);
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
			}
			document.add(table);

//----------------------------------------------------debts table and values---------------------------------------------------
			
			Paragraph debtParagraph = new Paragraph(String.valueOf(debtValue),Fonts.Arial);
			Paragraph paidParagraph = new Paragraph(String.valueOf(paidValue),Fonts.Arial);
			Paragraph needToPayParagraph = new Paragraph(String.valueOf(needToPayValue),Fonts.Arial);

			debtParagraph.setAlignment(PdfPCell.ALIGN_RIGHT);
			paidParagraph.setAlignment(PdfPCell.ALIGN_RIGHT);
			needToPayParagraph.setAlignment(PdfPCell.ALIGN_RIGHT);

			
			//table of the debts info
			PdfPTable debtsTable = new PdfPTable(2);
			debtsTable.setWidthPercentage(30);
			debtsTable.setSpacingBefore(10);
			debtsTable.setSpacingAfter(20);
			debtsTable.setRunDirection(PdfWriter.RUN_DIRECTION_RTL); 
			
			PdfPCell paragraphCell = new PdfPCell();
			paragraphCell.addElement(new Phrase("סך הכל חוב",Fonts.Arial));
			paragraphCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
			paragraphCell.setBackgroundColor(BaseColor.RED);
			debtsTable.addCell(paragraphCell);

			paragraphCell = new PdfPCell();
			paragraphCell.addElement(debtParagraph);
			paragraphCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
			paragraphCell.setBackgroundColor(BaseColor.RED);
			debtsTable.addCell(paragraphCell);
			
			paragraphCell = new PdfPCell();
			paragraphCell.addElement(new Phrase("סך הכל שולם",Fonts.Arial));
			paragraphCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
			paragraphCell.setBackgroundColor(BaseColor.GREEN);
			debtsTable.addCell(paragraphCell);
			
			paragraphCell = new PdfPCell();
			paragraphCell.addElement(paidParagraph);
			paragraphCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
			paragraphCell.setBackgroundColor(BaseColor.GREEN);
			debtsTable.addCell(paragraphCell);

			paragraphCell = new PdfPCell();
			paragraphCell.addElement(new Phrase("סך הכל לתשלום",Fonts.Arial));
			paragraphCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
			paragraphCell.setBackgroundColor(BaseColor.RED);
			debtsTable.addCell(paragraphCell);
			
			paragraphCell = new PdfPCell();
			paragraphCell.addElement(needToPayParagraph);
			paragraphCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);	
			paragraphCell.setBackgroundColor(BaseColor.RED);
			debtsTable.addCell(paragraphCell);
			
			document.add(debtsTable);
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