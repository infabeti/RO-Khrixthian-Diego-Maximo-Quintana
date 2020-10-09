package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;


public class LeerDocx {
	
	public String LecturaDocx() {
	String textoHtml = "";
	
		String path = ".//ficheros//CDs.docx";
		
		try {
			FileInputStream fps = new FileInputStream(path);
			XWPFDocument docu = new XWPFDocument(fps);
			
			List<XWPFParagraph> data = docu.getParagraphs();
	
			for(XWPFParagraph p : data) {
				textoHtml += p.getText() + "\n";
			}
			docu.close();
			
		}
		catch(FileNotFoundException ex) {
			System.out.print("Excepción de archivo no encontrado" + ex.getMessage());
		}
		
		catch(IOException ex1) {
			System.out.print("Excepción de archivo no encontrado" + ex1.getMessage());
		}
		
		return textoHtml;
	
	}

}
