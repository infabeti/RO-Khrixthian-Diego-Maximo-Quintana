package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControladorUserTest {
	private boolean resultadoEsperado;
	private boolean resultado;
	private ControladorUser controladorUser = new ControladorUser();

	@Test
	public void testControladorUserTrue() {
		resultadoEsperado = true;
		resultado = controladorUser.validarContrasena("letra1");
		
		assertEquals(resultado, resultadoEsperado);
	}
	
	@Test
	public void testControladorUserFalse() {
		resultadoEsperado = false;
		resultado = controladorUser.validarContrasena("αινσϊ");
		
		assertEquals(resultado, resultadoEsperado);
	}

}
