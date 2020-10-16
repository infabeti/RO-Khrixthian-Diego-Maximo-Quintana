package controlador;

import org.junit.Test;
import static org.mockito.Mockito.*;
import modelo.AgregarAlHtml;

public class ControladorGesEscHtmltest {	
	
	@Test
	public void testHtml() {
		ControladorGesHtml aaa = new ControladorGesHtml();
		String aux = aaa.mostrarHtml();
		AgregarAlHtml agregarAlHtmlmock = mock(AgregarAlHtml.class);
		
		ControladorGesEscHtml controladorGesEscHtml = new ControladorGesEscHtml(agregarAlHtmlmock);
		controladorGesEscHtml.gesEscHtml(aux);
		
		verify(agregarAlHtmlmock, times(1)).agregar(aux);
	} 
}
