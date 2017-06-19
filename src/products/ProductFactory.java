package products;

import java.sql.SQLException;

public class ProductFactory 
{

	public static Products getProduct(String productType , double width , double height , double colorPrice ,double glassPrice, String series, int wingCount) throws SQLException
	{

		if(productType.equalsIgnoreCase("slidingDoor"))
		{
			return new SlidingDoor(width, height , colorPrice , glassPrice ,series, wingCount);
		}
		else if(productType.equalsIgnoreCase("openingDoor"))
		{
			return new OpeningDoor(width, height , colorPrice , glassPrice ,series,wingCount );
		}

		return null;


	}


}
