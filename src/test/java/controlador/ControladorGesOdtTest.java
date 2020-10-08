package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControladorGesOdtTest {
	private String resultado;
	private String resultadoesperado;
	private ControladorGesOdt testGesOdt = new ControladorGesOdt();
	
	@Test
	public void test() {
		resultado = testGesOdt.mostrarOdt();
		resultadoesperado ="Evaristo el rey de la baraja, director, antig�edad: 25-02-1996." + "\n" + 
				"La mujer pantera, compras, antig�edad: 13-05-1997." + "\n" + 
				"Maria Juana, actividades ludicas, antig�edad: a�o 0."; 
		assertEquals(resultado, resultadoesperado);
	}
}
