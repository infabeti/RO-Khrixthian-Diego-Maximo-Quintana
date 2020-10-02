package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeerTxtTest {
	
	String resultado;
	String resultadoesperado;
	LeerTxt testtxt = new LeerTxt();
	

	@Test
	public void test() {
				
		resultado = testtxt.leertxt();
		
		//para asegurarnos de que devuelve lo que queremos no algo diferente
		System.out.println(resultado);
		
		if (resultado != null) {
			resultadoesperado = resultado;
		} ;
		
		assertEquals(resultado, resultadoesperado);
		
	}

}
