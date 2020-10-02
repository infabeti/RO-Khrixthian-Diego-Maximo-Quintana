package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeerXmlTest {
	
	String resultado;
	String resultadoesperado;
	LeerXml testxml = new LeerXml();

	@Test
	public void test() {

		resultado = testxml.LecturaXml();
		
		//para asegurarnos de que devuelve lo que queremos no algo diferente
		System.out.println(resultado);
		
		if (resultado != null) {
			resultadoesperado = resultado;
		} ;
		
		assertEquals(resultado, resultadoesperado);
	}

}
