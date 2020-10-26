package controlador;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import modelo.AgregarAlDocx;

public class ControladorGesEscDocxTest {

	@Test
	public void TestControlEscDocx() {
		ControladorGesDocx contenidoFichDocx = new ControladorGesDocx();
		String contFichDocx = "";
		AgregarAlDocx agregaraldocxmock = mock(AgregarAlDocx.class);

		ControladorGesEscDocx controladorGesEscDocx = new ControladorGesEscDocx(agregaraldocxmock);
		controladorGesEscDocx.gesEscDocx(contFichDocx);

		verify(agregaraldocxmock, times(1)).EscribirDocx(contFichDocx);
	}
}