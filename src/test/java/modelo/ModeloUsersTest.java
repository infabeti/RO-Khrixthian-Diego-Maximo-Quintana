package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModeloUsersTest {
	private boolean resultadoEsperado;
	private boolean resultado;
	private ModeloUsers modeloUsers = new ModeloUsers();

	@Test
	public void testValidarSoloAlfanumericoTrue() {
		resultadoEsperado = true;
		resultado = modeloUsers.validarSoloAlfanumerico("numero1");
		
		assertEquals(resultado, resultadoEsperado);
	}
	
	@Test
	public void testValidarSoloAlfanumericoFalse() {
		resultadoEsperado = false;
		resultado = modeloUsers.validarSoloAlfanumerico("-");
		
		assertEquals(resultado, resultadoEsperado);
	}

}
