package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class LeerDocx {
	
	public String LecturaDocx() {
		String textoDoc = "";
	
		final String path = ".//ficheros//CDs.docx";
		
		try {
			FileInputStream fps = new FileInputStream(path); 
			XWPFDocument docu = new XWPFDocument(fps);
			
			List<XWPFParagraph> data = docu.getParagraphs();
	
			for(XWPFParagraph p : data) {
				textoDoc += p.getText() + "\n";
			}
			docu.close();
			
		}
		catch(FileNotFoundException ex) {
			new ControlExcepciones("Excepci�n de archivo no encontrado" + ex.getMessage());
			System.out.print("Excepci�n de archivo no encontrado" + ex.getMessage());
		}
		
		catch(IOException ex1) {
			new ControlExcepciones("Excepci�n de Entrada/Salida" + ex1.getMessage());
			System.out.print("Excepci�n de Entrada/Salida" + ex1.getMessage());
		}
		
		return textoDoc;
	
	}

}
