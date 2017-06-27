package products;

import java.sql.ResultSet;
import java.sql.SQLException;

import helpClasses.MysqlConnect;
import main.AddProjectProduct;

public class OpeningDoor extends Door
{

	private double productionsCost;
	private double workingCost;
	private double alumLoss;
	private double profit;
	private double mashkofEverPrice;


	public OpeningDoor(double width, double height, double colorPrice,double glassPrice, String series ,int wingCount) throws SQLException
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
		//		System.out.println("profit : " + profit);
		//		System.out.println("productions : " + productionsCost);
		//		System.out.println("working : " + workingCost);
		//		System.out.println("loss : " + alumLoss);

	}

	@Override
	public double calculatePrice() 
	{
		double price = calculateCosts();
		return (Math.floor(price*profit*100)/100);

	}

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

	@Override
	public double calculateGlassPrice() 
	{
		double glassP= (((width-180) * (height-227))/1000000)*glassPrice;
		AddProjectProduct.glPrc=glassP;
		return glassP;

	}

	public double calculateCosts() {
		double price = 0;
		price	+= calculateAluminumKg();
		AddProjectProduct.almPrc=price;
		System.out.println(price);
		price	+= calculateGlassPrice();
		System.out.println(price);
		price += mashkofEverPrice*2*(height+width)/1000 ;
		AddProjectProduct.everPrc= mashkofEverPrice*2*(height+width)/1000 ;
		System.out.println(price);
		price += 709.49;
		AddProjectProduct.przPrc=709.49;
		System.out.println(price);
		return price*productionsCost*workingCost;
	}

	private boolean findChar(String text,char search)
	{
		for(int i=0;i<text.length();i++)
			if(text.charAt(i)==search)
				return true;
		return false;
	}
}
