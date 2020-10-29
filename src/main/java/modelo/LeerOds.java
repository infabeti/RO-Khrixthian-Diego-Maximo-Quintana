package modelo;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class LeerOds {
	private String contenidoOds = "";
	private Sheet sheet;
	private VariablesEstaticas ve = new VariablesEstaticas();
	// Obtengo el documento, a partir del ODS
	private final String Dir = ".//ficheros//Prestamos.ods";
	private final File archivo = new File(Dir);

	public String[][] LecturadOds() {
		int nColumnas;
		int nFilas;
		String[][] matriz = null;
		try {
			sheet = SpreadSheet.createFromFile(archivo).getSheet(0);
			nColumnas = sheet.getColumnCount();
			nFilas = sheet.getRowCount();
			matriz = new String[nFilas][nColumnas];
			MutableCell cell = null;
			for (int nRowIndex = 0; nRowIndex < nFilas; nRowIndex++) {
				for (int nColIndex = 0; nColIndex < nColumnas; nColIndex++) {
					cell = sheet.getCellAt(nColIndex, nRowIndex);
					if (nColIndex == nColumnas--) {
						cell = sheet.getCellAt(nColIndex++, nRowIndex);
					}
				}
			}
			cargarTabla(nFilas, nColumnas, cell, matriz);

		} catch (IOException e) {
			new ControlExcepciones("Excepción de Entrada/Salida" + e.getMessage());
			System.out.println("Excepción de Entrada/Salida" + e.getMessage());
		}

		return matriz;
	}

	public String[][] cargarTabla(int nFilas, int nColumnas, MutableCell cell, String[][] tabla) {

		/*
		 * CON EL SIGUIENTE BUCLE LLENAMOS LA TABLA CON LOS CONTENIDOS DE LA HOJA DE
		 * CALCULO, RELLENANDO EL ARRAY ESTATICO MatrizAuxiliarString
		 */
		for (int i = 0; i < nFilas; i++) {
			for (int j = 0; j < nColumnas; j++) {
				cell = sheet.getCellAt(j, i);
				tabla[i][j] = cell.getTextValue();
			}
		}
		
		return tabla;
	}
}
