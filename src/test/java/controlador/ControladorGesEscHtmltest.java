package controlador;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import modelo.AgregarAlHtml;

public class ControladorGesEscHtmltest {

	private AgregarAlHtml agregarAlHtmlmock = mock(AgregarAlHtml.class);
	private ControladorGesEscHtml controladorGesEscHtml = new ControladorGesEscHtml(agregarAlHtmlmock);
	private String testString;

	@Test
	public void testgesEscHtml() {
		testString = "prueba";
		controladorGesEscHtml.gesEscHtml(testString);

		verify(agregarAlHtmlmock, times(1)).agregar(testString);
	}
}
