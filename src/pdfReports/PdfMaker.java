package pdfReports;

// PdfMaker Classes ,, to export specific report from our reports in a good way
// using facade design pattern 
public class PdfMaker 
{	
	private Pdf customerDebtsPDF;
	private Pdf debtsForSuppliersPDF;
	private Pdf glassOrdersPDF;
	private Pdf glassPricesPDF;
	private Pdf mshkofemOrdersPDF;
	private Pdf mshkofemPricesPDF;
	private Pdf perzolOrdersPDF;
	private Pdf perzolPricesPDF;
	private Pdf profilesOrdersPDF;
	private Pdf profilesPricesPDF;
	private Pdf shutterOrdersPDF;
	private Pdf shutterPricesPDF;
	private Pdf projectsListPDF;
	
	public PdfMaker()
	{
		customerDebtsPDF = new CustomerDebtsPDF();
		debtsForSuppliersPDF = new DebtsForSuppliersPDF();
		glassOrdersPDF = new GlassOrdersPDF();
		glassPricesPDF = new GlassPricesPDF();
		mshkofemOrdersPDF = new MshkofemOrdersPDF();
		mshkofemPricesPDF = new MshkofemPricesPDF();
		perzolOrdersPDF = new PerzolOrdersPDF();
		perzolPricesPDF = new PerzolPricesPDF();
		profilesOrdersPDF = new ProfilesOrdersPDF();
		profilesPricesPDF = new ProfilesPricesPDF();
		shutterOrdersPDF = new ShutterOrdersPDF();
		shutterPricesPDF = new ShutterPricesPDF();
		projectsListPDF = new ProjectsListPDF();
	}
	
	public void exportCustomerDebtsPDF()
	{
		customerDebtsPDF.export();
	}
	public void exportDebtsForSuppliersPDF()
	{
		debtsForSuppliersPDF.export();
	}

	public void exportGlassOrdersPDF()
	{
		glassOrdersPDF.export();
	}
	
	public void exportGlassPricesPDF()
	{
		glassPricesPDF.export();
	}
	
	public void exportMshkofemOrdersPDF()
	{
		mshkofemOrdersPDF.export();
	}
	
	public void exportMshkofemPricesPDF()
	{
		mshkofemPricesPDF.export();
	}
	
	public void exportPerzolOrdersPDF()
	{
		perzolOrdersPDF.export();
	}
	
	public void exportPerzolPricesPDF()
	{
		perzolPricesPDF.export();
	}
	
	public void exportProfilesOrdersPDF()
	{
		profilesOrdersPDF.export();
	}
	
	public void exportProfilesPricesPDF()
	{
		profilesPricesPDF.export();
	}
	
	public void exportShutterOrdersPDF()
	{
		shutterOrdersPDF.export();
	}
	
	public void exportShutterPricesPDF()
	{
		shutterPricesPDF.export();
	}
	
	public void exportProjectsListPDF()
	{
		projectsListPDF.export();
	}
	
}
