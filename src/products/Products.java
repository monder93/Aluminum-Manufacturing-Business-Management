package products;

public abstract class Products 
{
	protected double width;
	protected double height;
	protected double colorPrice;
	protected String series;
	
	
	
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
	

	public Products(double width, double height, double colorPrice,String series)
	{
		super();
		this.width = width;
		this.height = height;
		this.colorPrice = colorPrice;
		this.series = series;
	}
	@Override
	public String toString() 
	{
		return "products [width is =" + width + ", height is =" + height + "]";
	}
	
	
	
	
}
