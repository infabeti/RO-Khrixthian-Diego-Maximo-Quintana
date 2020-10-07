package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeerHtmlTest {
	
	String resultado;
	String resultadoesperado;
	LeerHtml testhtml = new LeerHtml();
	

	@Test
	public void test() {
				
		resultado = testhtml.muestraContenido();
		
		//para asegurarnos de que devuelve lo que queremos no algo diferente
		System.out.println(resultado);
		
		if (resultado != null) {
			resultadoesperado = resultado;
		} ;
		
		assertEquals(resultado, resultadoesperado);
		
	}

}
