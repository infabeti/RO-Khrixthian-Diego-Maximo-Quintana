package controlador;

import static org.mockito.Mockito.*;
import org.junit.Test;
import modelo.AgregarAlDocx;

public class ControladorGesEscDocxTest {

	@Test
	public void Testdocx() {
		
		AgregarAlDocx agregaraldocxmock = mock(AgregarAlDocx.class);
		
		ControladorGesEscDocx controladorGesEscDocx = new ControladorGesEscDocx(agregaraldocxmock);
		controladorGesEscDocx.gesEscDocx("hola");
		
		verify(agregaraldocxmock, times(1)).EscribirDocx("hola");
	}
}
