package controlador;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import modelo.AgregarAlDocx;

public class ControladorGesEscDocxTest {

	private AgregarAlDocx agregaraldocxmock = mock(AgregarAlDocx.class);
	private ControladorGesEscDocx controladorGesEscDocx = new ControladorGesEscDocx(agregaraldocxmock);
	private String testString;

	@Test
	public void testgesEscDocx() {
		testString = "prueba";

		controladorGesEscDocx.gesEscDocx(testString);

		verify(agregaraldocxmock, times(1)).EscribirDocx("prueba");
	}
}