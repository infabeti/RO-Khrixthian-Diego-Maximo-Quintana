package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControladorGesOdsTest {
	private String resultado;
	private String resultadoesperado;
	private ControladorGesOds testGesOds = new ControladorGesOds();
	
	@Test
	public void test() {
		resultado = testGesOds.mostrarOds();
		resultadoesperado ="N� de FILAS y COLUMNAS" + "\n" +
				"Filas : 4" + "\n" +
				"Columnas : 1024"+ "\n" + "\n" +
				"Usuario CodUser libro fecha entrega " + "\n" +  
				"Ibai 1234 el se�or de los anillos 5-10-2020 20-10-2020 " + "\n" +				
				"khrixthian 1235 el enemigo conoce el sistema 5-10-2020 20-10-2020 " + "\n" +
				"Maximo 1236 la columna de la muerte 5-10-2020 20-10-2020 ";
		assertEquals(resultado, resultadoesperado);
	}

}
