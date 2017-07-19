package products;

/* 
 * abstract class for the product 
 */
public abstract class Products implements info
{
	protected double width;
	protected double height;
	protected double colorPrice;
	protected String series;
	protected double glassPrice;
	protected int wingCount;
	
	public int getWingCount() {
		return wingCount;
	}
	public void setWingCount(int wingCount) {
		this.wingCount = wingCount;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public double getGlassPrice() {
		return glassPrice;
	}
	public void setGlassPrice(double glassPrice) {
		this.glassPrice = glassPrice;
	}
	public double getColorPrice() {
		return colorPrice;
	}
	public void setColorPrice(double colorPrice) {
		this.colorPrice = colorPrice;
	}
	public double getWidth() 
	{
		return width;
	}
	public void setWidth(double width) 
	{
		this.width = width;
	}
	public double getHeight()
	{
		return height;
	}
	public void setHeight(double height) 
	{
		this.height = height;
	}
	

	public Products(double width, double height, double colorPrice,double glassPrice ,String series ,int wingCount)
	{
		super();
		this.width = width;
		this.height = height;
		this.colorPrice = colorPrice;
		this.series = series;
		this.glassPrice=glassPrice;
		this.wingCount=wingCount;
	}
	@Override
	public String toString() 
	{
		return "products [width is =" + width + ", height is =" + height + "]";
	}
	
	
	
	
}
