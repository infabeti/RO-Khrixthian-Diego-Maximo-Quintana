package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeerTxtTest {
	
	private String resultado;
	private String resultadoesperado;
	private LeerTxt testtxt = new LeerTxt();
	

	@Test
	public void test() {
				
		resultado = testtxt.leertxt();
		
		resultadoesperado ="  9999, El se�or de los anillos, J.R. Tolkien, novela fant�stica." + (char) 13 + (char) 10
				+ "8888, La columna de la muerte, Francisco Espinosa, ensayo hist�rico." + (char) 13 + (char) 10 
				+ "7777, El enemigo conoce el sistema, Marta Peirano, ensayo sobre la aplicaci�n capitalista de la inform�tica." + (char) 13 + (char) 10
				+ "6666, El segundo sexo, Simone de Beauvoir, ensayo sobre la opresi�n de la mujer." + (char) -1;
		
		assertEquals(resultado, resultadoesperado);
		
	}

}
