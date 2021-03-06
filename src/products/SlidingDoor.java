package products;

import java.sql.ResultSet;
import java.sql.SQLException;

import helpClasses.MysqlConnect;
import main.AddProjectProduct;
/*
 * a class for slidingDoor specific Product type
 */

public class SlidingDoor extends Door
{

	private double productionsCost;
	private double workingCost;
	private double alumLoss;
	private double profit;
	private double mashkofEverPrice;


	public SlidingDoor(double width, double height, double colorPrice,double glassPrice, String series ,int wingCount) throws SQLException
	{
		super(width, height, colorPrice,glassPrice, series , wingCount);

		ResultSet myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "רווח");
		myRs.next();
		profit=Double.parseDouble(myRs.getString(3));
		myRs.next();
		myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "יצור");
		myRs.next();
		productionsCost=Double.parseDouble(myRs.getString(3));
		myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "הרכבה");
		myRs.next();
		workingCost=Double.parseDouble(myRs.getString(3));
		myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "הפסד");
		myRs.next();
		alumLoss=Double.parseDouble(myRs.getString(3));
		myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "עוור");
		myRs.next();
		mashkofEverPrice=Double.parseDouble(myRs.getString(3));
		
		if(wingCount==0)
			wingCount=1;
	}

	//function to calculate the Price
	@Override
	public double calculatePrice() 
	{
		double price = calculateCosts();
		return (Math.round(price*profit*100.0)/100.0);

	}

	// function to calculate the Aluminum KG 
	@Override
	public double calculateAluminumKg() 
	{
		double sumKG = 0;
		String query = "SELECT i.כמות , i.תלות , i.מידה , p.משקל_גרם_למטר FROM ingredients i JOIN profiles p WHERE i.מספרפרופיל = p.מספרפרופיל AND i.סדרה = p.סדרה AND i.כנפיים = '"+wingCount+"' AND i.סדרה = '"+series+"' "; 
		try{
			ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
			while(myRs.next())
			{
				if((myRs.getString(2).equals("L"))==true)
				{
					if(	findChar(myRs.getString(2),'/')	==	true)
					sumKG+= myRs.getDouble(1)*((width/wingCount)+myRs.getDouble(3))*myRs.getDouble(4);
					else
					sumKG+= myRs.getDouble(1)*(width+myRs.getDouble(3))*myRs.getDouble(4);
				}
				else if((myRs.getString(2).equals("H"))==true)
				{
					sumKG+= myRs.getDouble(1)*(height+myRs.getDouble(3))*myRs.getDouble(4);
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		AddProjectProduct.wight=sumKG/1000000;
		return ((sumKG*colorPrice/1000000))*alumLoss;
	}

	//function to calculate the glass price
	@Override
	public double calculateGlassPrice() 
	{
		double glassP= (((width-180) * (height-227))/1000000)*glassPrice;
		AddProjectProduct.glPrc=glassP;
		return glassP;

	}

	// function to calculate the costs
	public double calculateCosts() {
		double price = 0;
		price	+= calculateAluminumKg();
		AddProjectProduct.almPrc=price;
//		System.out.println(price);
		price	+= calculateGlassPrice();
//		System.out.println(price);
		price += mashkofEverPrice*2*(height+width)/1000 ;
		AddProjectProduct.everPrc= mashkofEverPrice*2*(height+width)/1000 ;
//		System.out.println(price);
		price += 915.49;
		AddProjectProduct.przPrc=915.49;
//		System.out.println(price);
		return price*productionsCost*workingCost;
	}

	// checking function for char
	private boolean findChar(String text,char search)
	{
		for(int i=0;i<text.length();i++)
			if(text.charAt(i)==search)
				return true;
		return false;
	}
}
