import java.awt.BorderLayout;
import java.io.FileInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.adobe.acrobat.Viewer;

public class PdfViewer extends JPanel{
	private Viewer viewer;
	String name="";
	public PdfViewer(String name) throws Exception{
		this.name=name;
		this.setLayout(new BorderLayout());
		viewer = new Viewer();
		//String temp = PdfViewer.class.getResource("files/"+name+".pdf").getPath();
		//System.out.println(new String(temp.getBytes("ISO-8859-1"), "UTF-8"));

		FileInputStream fis = new FileInputStream(PdfViewer.class.getResource("files/"+name+".pdf").getPath());
		viewer.setDocumentInputStream(fis);
		this.add(viewer, BorderLayout.CENTER);
		viewer . zoomTo ( 2 );
		viewer.activate();
	}
	
//	public PdfViewer(String name){
//		
//	}
	
	

	public void main() throws Exception {

		PdfViewer lecteur = new PdfViewer(name);
		JFrame f = new JFrame("Lecteur PDF");
		f.setSize(1024,768);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
		f.getContentPane().add(lecteur);
	}
}