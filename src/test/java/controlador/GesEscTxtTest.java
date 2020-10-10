package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.AgregarAlTxt;
import modelo.LeerTxt;

public class GesEscTxtTest {

	String resultado;
	String resultadoesperado;
	AgregarAlTxt testEsctxt = new AgregarAlTxt();
	
	@Test
	public void test() {

		resultado = LeerTxt.leertxt();
		resultadoesperado =GesEscTxt.gesEscTxt();
		
		assertEquals(resultado, resultadoesperado); 
		
	}

}
