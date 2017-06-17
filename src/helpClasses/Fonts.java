package helpClasses;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;

public class Fonts 
{
	public static final com.itextpdf.text.Font Tahoma = FontFactory.getFont("c:/windows/fonts/tahoma.ttf",BaseFont.IDENTITY_H,10);
	public static final com.itextpdf.text.Font Arial = FontFactory.getFont("c:/windows/fonts/arial.ttf",BaseFont.IDENTITY_H,10);
	public static final com.itextpdf.text.Font Arial12 = FontFactory.getFont("c:/windows/fonts/arial.ttf",BaseFont.IDENTITY_H,12);
	public static final com.itextpdf.text.Font Arial14Bold = FontFactory.getFont("c:/windows/fonts/arial.ttf",BaseFont.IDENTITY_H,14|Font.BOLD);
	public static final com.itextpdf.text.Font Arial14BoldItalic = FontFactory.getFont("c:/windows/fonts/arial.ttf",BaseFont.IDENTITY_H,14|Font.BOLD|Font.ITALIC);

}
