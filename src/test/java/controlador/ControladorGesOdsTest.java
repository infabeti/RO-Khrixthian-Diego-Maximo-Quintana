package controlador;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class ControladorGesOdsTest {
	/*
	 * private String resultado; private String resultadoesperado; private
	 * ControladorGesOds testGesOds = new ControladorGesOds();
	 */
	// prueba para mockito
	private ControladorGesOds controladorGesOdsMock = mock(ControladorGesOds.class);
	private ControladorGesOds controladorGesOds = new ControladorGesOds(controladorGesOdsMock);
	private String testString;

	@Test
	public void test() {
		/*
		 * resultado = testGesOds.mostrarOds();
		 * 
		 * resultadoesperado ="Nº de FILAS y COLUMNAS" + "\n" + "Filas : 4" + "\n" +
		 * "Columnas : 1024"+ "\n" + "\n" + "Usuario CodUser libro fecha entrega " +
		 * "\n" + "Ibai 1234 el señor de los anillos 5-10-2020 20-10-2020 " + "\n" +
		 * "khrixthian 1235 el enemigo conoce el sistema 5-10-2020 20-10-2020 " + "\n" +
		 * "Maximo 1236 la columna de la muerte 5-10-2020 20-10-2020 ";
		 * assertEquals(resultado, resultadoesperado);
		 */
		testString = "prueba";
		controladorGesOds.mostrarOds(testString);

		try {
			verify(leerOdsMock, times(1)).mostrarOds(testString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
