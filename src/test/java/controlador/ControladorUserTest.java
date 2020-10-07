package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControladorUserTest {
	
	ControladorUser controladorUser = new ControladorUser();

	@Test
	public void testControladorUserTrue() {
		boolean resultadoEsperado = true;
		boolean resultado = controladorUser.validarContrasena("letra1");
		
		assertEquals(resultado, resultadoEsperado);
	}
	
	@Test
	public void testControladorUserFalse() {
		boolean resultadoEsperado = false;
		boolean resultado = controladorUser.validarContrasena("αινσϊ");
		
		assertEquals(resultado, resultadoEsperado);
	}

}
