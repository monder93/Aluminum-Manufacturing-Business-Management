	package products;

import java.sql.SQLException;

import javax.swing.JOptionPane;

/* 
 * a class factory for all types of products 
 */
public class ProductFactory 
{

	public Products getProduct(String productType , double width , double height , double colorPrice ,double glassPrice, String series, int wingCount) throws SQLException
	{

		if(productType.equalsIgnoreCase("דלתות הזזה"))
		{
			return new SlidingDoor(width, height , colorPrice , glassPrice ,series, wingCount);
		}
		else if(productType.equalsIgnoreCase("דלתות פתיחה"))
		{
			return new OpeningDoor(width, height , colorPrice , glassPrice ,series,wingCount );
		}
		else if(productType.equalsIgnoreCase("חלונות הזזה"))
		{
			return new SlidingWindow(width, height , colorPrice , glassPrice ,series,wingCount );
		}
		else if(productType.equalsIgnoreCase("חלונות פתיחה"))
		{
			return new OpeningWindow(width, height , colorPrice , glassPrice ,series,wingCount );
		}
		else
		{
			JOptionPane.showMessageDialog(null, "wrong type");
			return null;
		}

	}


}
