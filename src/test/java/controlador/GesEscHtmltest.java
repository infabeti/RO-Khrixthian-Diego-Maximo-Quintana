package controlador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.AgregarAlHtml;
import modelo.AgregarAlTxt;
import modelo.LeerHtml;
import modelo.LeerTxt;

public class GesEscHtmltest {

	String resultado;
	String resultadoesperado;
	AgregarAlHtml testEschtml = new AgregarAlHtml();
	
	@Test
	public void test() {

		resultado = LeerHtml.muestraContenido();
		resultadoesperado =GesEscHtml.gesEscHtml();
		
		assertEquals(resultado, resultadoesperado); 
		
	} 
}
