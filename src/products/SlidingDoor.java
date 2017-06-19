package products;

public class SlidingDoor extends Door implements info
{


	
	public SlidingDoor(double width, double height , double colorPrice ,double glassPrice, String series, int wingCount) 
	{
		super(width, height,colorPrice,glassPrice , series, wingCount);
	}

	@Override
	public double calculatePrice() 
	{
		String query = "SELECT i.כמות , i.תלות , i.מידה , p.משקל_גרם_למטר FROM ingredients i JOIN profiles p WHERE i.מספרפרופיל = p.מספרפרופיל AND i.סדרה = p.סדרה"; 
				
		return 0;
		
	}

	@Override
	public double calculateAluminumKg() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateGlassPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double calculateCosts() {
		// TODO Auto-generated method stub
		return 0;
	}

}
