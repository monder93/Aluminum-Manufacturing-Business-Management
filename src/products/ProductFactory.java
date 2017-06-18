package products;

public class ProductFactory 
{

	public static Products getProduct(String productType , double width , double height , double colorPrice , String series)
	{

		if(productType.equalsIgnoreCase("slidingDoor"))
		{
			return new SlidingDoor(width, height,colorPrice ,series);
		}
		

		return null;


	}


}
