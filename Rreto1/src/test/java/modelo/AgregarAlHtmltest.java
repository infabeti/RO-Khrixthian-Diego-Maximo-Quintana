package modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AgregarAlHtmltest {

	String resultado;
	String resultadoesperado;
	AgregarAlHtml testEscHtml = new AgregarAlHtml();
	
	@Test
	public void test() {
		resultado = testEscHtml.agregar();
		
		resultadoesperado = LeerHtml.muestraContenido();
		
		assertEquals(resultado, resultadoesperado); 
	}

}
