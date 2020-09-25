package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class modeloLectura {
	
	public void leerDocx() {
	
		String path = "C:\\Users\\IN2DAM\\Desktop\\wordprueba.docx";
		
		try {
			FileInputStream fps = new FileInputStream(path);
			XWPFDocument docu = new XWPFDocument(fps);
			
			List<XWPFParagraph> data = docu.getParagraphs();
	
			for(XWPFParagraph p : data) {
				System.out.print(p.getText() + "\n");
			}
			
			
		}
		catch(FileNotFoundException ex) {
			System.out.print(ex.getMessage());
		}
		
		catch(IOException ex1) {
			System.out.print(ex1.getMessage());
		}
	
	}

}
