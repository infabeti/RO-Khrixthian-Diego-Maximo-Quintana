package modelo;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class LeerOds {
	public static String LecturadOds() {
		String contenidoOds = "";
		Sheet sheet;

		// Obtengo el documento, a partir del ODS
		String Dir = ".//ficheros//Prestamos.ods";
		File archivo = new File(Dir);

		try {
			// Empiezo por la hoja 0 para la manipulación | paso el nombre de la hoja como
			// string
			sheet = SpreadSheet.createFromFile(archivo).getSheet(0);

			// El nº de cada fila y columna
			int nColumnas = sheet.getColumnCount();
			int nFilas = sheet.getRowCount();
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
				}
				contenidoOds += "\n";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return contenidoOds;
	}

}
