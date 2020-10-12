package modelo;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class LeerOds {
	private String contenidoOds = "";
	private Sheet sheet;
	// Obtengo el documento, a partir del ODS
	private final String Dir = ".//ficheros//Prestamos.ods";
	private final File archivo = new File(Dir);

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
			contenidoOds += String.format("%s%s%s%d%s%s%d%s%s", "Nº de FILAS y COLUMNAS", "\n", "Filas : ", nFilas,
					"\n", "Columnas : ", nColumnas, "\n", "\n");

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
			new ControlExcepciones("Excepción de Entrada/Salida" + e.getMessage());
			System.out.println("Excepción de Entrada/Salida" + e.getMessage());
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
