import java.awt.BorderLayout;
import java.io.FileInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.adobe.acrobat.Viewer;

public class PdfViewer extends JPanel{
    private Viewer viewer;
 
    public PdfViewer() throws Exception{
//        String fileName = PdfViewer.class.getResource("files/test.pdf").getPath();
//        System.out.println(PdfViewer.class.getResource("files/test.pdf").getPath());
        this.setLayout(new BorderLayout());
 
        viewer = new Viewer();
        FileInputStream fis = new FileInputStream(PdfViewer.class.getResource("files/test.pdf").getPath());
        viewer.setDocumentInputStream(fis);
        this.add(viewer, BorderLayout.CENTER);
        viewer . zoomTo ( 2 );
        viewer.activate();
    }
 
    public static void main() throws Exception {
 
//        String fileName = PdfViewer.class.getResource("files/test.pdf").getPath();
//        System.out.println(fileName);
        PdfViewer lecteur = new PdfViewer();
        JFrame f = new JFrame("Lecteur PDF");
        f.setSize(1024,768);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        f.getContentPane().add(lecteur);
    }
}