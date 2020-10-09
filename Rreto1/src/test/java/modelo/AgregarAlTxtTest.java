package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AgregarAlTxtTest {

	String resultado;
	String resultadoesperado;
	AgregarAlTxt testEsctxt = new AgregarAlTxt();
	
	@Test
	public void test() {
		resultado = testEsctxt.agregar();
		
		resultadoesperado = LeerTxt.leertxt();
		
		assertEquals(resultado, resultadoesperado); 
	}

}
