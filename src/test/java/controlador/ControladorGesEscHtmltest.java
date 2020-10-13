package controlador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.AgregarAlHtml;
import modelo.AgregarAlTxt;
import modelo.LeerHtml;
import modelo.LeerTxt;

public class ControladorGesEscHtmltest {

	private String resultado;
	private String resultadoesperado;
	private AgregarAlHtml testEschtml = new AgregarAlHtml();
	
	@Test
	public void test() {

		resultado = LeerHtml.muestraContenido();
		resultadoesperado = ControladorGesEscHtml.gesEscHtml();
		
		assertEquals(resultado, resultadoesperado); 
		
	} 
}
