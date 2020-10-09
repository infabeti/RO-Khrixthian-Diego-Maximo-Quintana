package modelo;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import controlador.ControladorGesHtml;

public class LeerOds {
	private static String contenidoOds = "";
	private static Sheet sheet;
	// Obtengo el documento, a partir del ODS
	private static String Dir = ".//ficheros//Prestamos.ods";
	private static File archivo = new File(Dir);
	
	public String LecturadOds() {
		int nColumnas;
		int nFilas;
		try {
			// Empiezo por la hoja 0 para la manipulación | paso el nombre de la hoja como
			// string
			sheet = SpreadSheet.createFromFile(archivo).getSheet(0);

			// El nº de cada fila y columna
			nColumnas = sheet.getColumnCount();
			nFilas = sheet.getRowCount();
			contenidoOds += "Nº de FILAS y COLUMNAS" + "\n";
			contenidoOds += "Filas : " + nFilas + "\n";
			contenidoOds += "Columnas : " + nColumnas + "\n";
			contenidoOds += "\n";
			// Repitiendo por cada fila de la hoja seleccionada
			MutableCell cell = null;
			for (int nRowIndex = 0; nRowIndex < nFilas; nRowIndex++) {

				// Repitiendo por cada columna
				for (int nColIndex = 0; nColIndex < nColumnas; nColIndex++) {
					cell = sheet.getCellAt(nColIndex, nRowIndex);
					contenidoOds += cell.getValue() + " ";

					if (nColIndex == nColumnas--) {
						cell = sheet.getCellAt(nColIndex++, nRowIndex);
					}
				}
				contenidoOds += "\n";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Elimino espacios repetidos (ascii 32)
		String contenidoOdsFinal = "";

		for (int i = 0; i < contenidoOds.length() - 1; i++) {

			if ((int) contenidoOds.charAt(i) == (int) contenidoOds.charAt(i + 1) && contenidoOds.charAt(i) == 32) {

			} else {
				contenidoOdsFinal += contenidoOds.charAt(i);
			}
		}

		return contenidoOdsFinal;
	}

}
