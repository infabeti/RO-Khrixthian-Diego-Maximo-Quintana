package controlador;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import modelo.AgregarAlHtml;

public class ControladorGesEscHtmltest {

	@Test
	public void testControlEscHtml() {
		ControladorGesHtml aaa = new ControladorGesHtml();
		String aux = aaa.mostrarHtml();
		AgregarAlHtml agregarAlHtmlmock = mock(AgregarAlHtml.class);

		ControladorGesEscHtml controladorGesEscHtml = new ControladorGesEscHtml(agregarAlHtmlmock);
		controladorGesEscHtml.gesEscHtml(aux);

		verify(agregarAlHtmlmock, times(1)).agregar(aux);
	}
}
