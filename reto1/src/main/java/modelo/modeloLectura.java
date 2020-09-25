package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class modeloLectura {
	
	public void leerDocx() throws IOException {
	
		String path = "C:\\Users\\IN2DAM\\Desktop\\wordklase.docx";
		
		try {
			FileInputStream fps = new FileInputStream(path);
			XWPFDocument docu = new XWPFDocument(fps);
			
			List<XWPFParagraph> data = docu.getParagraphs();
	
			for(XWPFParagraph p : data) {
				System.out.print(p.getText() + "\n");
			}
			docu.close();
			
		}
		catch(FileNotFoundException ex) {
			System.out.print(ex.getMessage());
		}
	
	}

}
