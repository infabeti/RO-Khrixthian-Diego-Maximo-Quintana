package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.AgregarAlTxt;
import modelo.LeerTxt;

public class GesEscTxtTest {

	private String resultado;
	private String resultadoesperado;
	private LeerTxt leerTxt = new LeerTxt();
	private AgregarAlTxt testEsctxt = new AgregarAlTxt();
	
	@Test
	public void test() {

		resultado = leerTxt.leertxt();
		resultadoesperado = testEsctxt.agregar();
		
		assertEquals(resultado, resultadoesperado); 
		
	}

}
