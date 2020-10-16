package controlador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static org.mockito.Mockito.*;
import modelo.AgregarAlHtml;

public class ControladorGesEscHtmltest {	
	
	@Test
	public void testHtml() {
		
		AgregarAlHtml agregarAlHtmlmock = mock(AgregarAlHtml.class);
		
		ControladorGesEscHtml controladorGesEscHtml = new ControladorGesEscHtml(agregarAlHtmlmock);
		
	} 
}
