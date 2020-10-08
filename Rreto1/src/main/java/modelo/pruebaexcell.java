package modelo;
/*lee el fichero y va metiendo todo lo que tiene en la primera celda, y al final 
solo se ve la ultima fila del excell original en la 1 celda.
*/
import java.io.FileOutputStream;	 

	import org.apache.poi.hssf.usermodel.HSSFCell;

	import org.apache.poi.hssf.usermodel.HSSFRichTextString;

	import org.apache.poi.hssf.usermodel.HSSFRow;

	import org.apache.poi.hssf.usermodel.HSSFSheet;

	import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import controlador.GesOds;

 

	public class pruebaexcell {
	 

		public static void main(String[] args) {
			GesOds aux = new GesOds();
			
			String textoGuardado = aux.mostrarOds();
				        // Se crea el libro
			
				        HSSFWorkbook libro = new HSSFWorkbook();
			
				 
			
				        // Se crea una hoja dentro del libro
			
				        HSSFSheet hoja = libro.createSheet();
			
				 
			
				        // Se crea una fila dentro de la hoja
			
				        HSSFRow fila = hoja.createRow(0);
			
				 
			
				        // Se crea una celda dentro de la fila
			
				        HSSFCell celda = fila.createCell((short) 0);
			
				 
			
				        // Se crea el contenido de la celda y se mete en ella.
			
				        HSSFRichTextString texto = new HSSFRichTextString(textoGuardado + textoGuardado);
			
				        celda.setCellValue(texto);
			
				 
			
				        // Se salva el libro.
			
				        try {
			
				            FileOutputStream elFichero = new FileOutputStream(".//ficheros//prueba.ods");
			
				            libro.write(elFichero);
			
				            elFichero.close();
			
				        } catch (Exception e) {
			
				            e.printStackTrace();
			
				        }
			
				    }
			
				}
