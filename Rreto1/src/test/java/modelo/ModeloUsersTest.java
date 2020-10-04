package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModeloUsersTest {
	
	private ModeloUsers modeloUsers = new ModeloUsers();

	@Test
	public void testValidarSoloAlfanumericoTrue() {
		boolean resultadoEsperado = true;
		boolean resultado = modeloUsers.validarSoloAlfanumerico("numero1");
		
		assertEquals(resultado, resultadoEsperado);
	}
	
	@Test
	public void testValidarSoloAlfanumericoFalse() {
		boolean resultadoEsperado = false;
		boolean resultado = modeloUsers.validarSoloAlfanumerico("-");
		
		assertEquals(resultado, resultadoEsperado);
	}

}
