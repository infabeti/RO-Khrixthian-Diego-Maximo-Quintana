package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeerHtmlTest {
	
	private String resultado;
	private String resultadoesperado;
	private LeerHtml testhtml = new LeerHtml();
	

	@Test
	public void test() {
				
		resultado = testhtml.muestraContenido();
		
		if (resultado != null) {
			resultadoesperado = resultado;
		} ;
		
		assertEquals(resultado, resultadoesperado); 
		
	}

}
