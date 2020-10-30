package controlador;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import org.jopendocument.dom.spreadsheet.MutableCell;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.LeerOds;

public class ControladorGesOdsTest {
	
	private MutableCell cell = null;
	private String[][] matriz = {{"Hola", "Mundo"},{"Hola","Mundo"}};
	private String[][] matrizTRUE = {{"Hola", "Mundo"},{"Hola","Mundo"}};
		
	@Test
	public void ControladorGesOdsTest() {
		
		String[][] resultadoEsperado = matrizTRUE;
	
		LeerOds leerOds = mock(LeerOds.class);
		Mockito.when(leerOds.cargarTabla(2, 2, cell, matriz)).thenReturn(matrizTRUE);
		assertArrayEquals(leerOds.cargarTabla(2, 2, cell, matriz), resultadoEsperado);
			
	}
}


