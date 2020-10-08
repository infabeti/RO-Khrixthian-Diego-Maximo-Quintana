package modelo;

import java.io.*;
import java.util.List;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;


public class modeloLectura {
	
	public static void main(String[] args) throws IOException {
	
		String path = ".//ficheros//CDs.docx";
		//
		File archivodoc = new File(path);
		
		
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
		
		catch(IOException ex1) {
			System.out.print(ex1.getMessage());
		}
	
	}

}
