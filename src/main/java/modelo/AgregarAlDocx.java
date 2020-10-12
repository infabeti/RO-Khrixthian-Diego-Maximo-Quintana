package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class AgregarAlDocx {
	public void EscribirDocx(String textoNuevo) {
	
		String path = ".//ficheros//CDs.docx";
		
		try {
			FileInputStream fps = new FileInputStream(path);
			XWPFDocument docu = new XWPFDocument(fps);
			
			
			XWPFParagraph paragraph = docu.createParagraph();
			XWPFRun run = paragraph.createRun();

			run.setText(textoNuevo);
			run.setSubscript(VerticalAlign.SUBSCRIPT);

			try {
			FileOutputStream fos = new FileOutputStream(".//ficheros//CDs.docx");
			docu.write(fos);
			fos.close();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}
			
//			List<XWPFParagraph> data = docu.getParagraphs();
//	
//			for(XWPFParagraph p : data) {
//				textoDoc += p.getText() + "\n";
//			}
			docu.close();
			
		}
		catch(FileNotFoundException ex) {
			new ControlExcepciones("Excepción de archivo no encontrado" + ex.getMessage());
			System.out.print("Excepción de archivo no encontrado" + ex.getMessage());
		}
		
		catch(IOException ex1) {
			new ControlExcepciones("Excepción de Entrada/Salida" + ex1.getMessage());
			System.out.print("Excepción de Entrada/Salida" + ex1.getMessage());
		}
	
	}
}
