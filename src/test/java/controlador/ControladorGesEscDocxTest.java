package controlador;

import static org.mockito.Mockito.*;
import org.junit.Test;
import modelo.AgregarAlDocx;

public class ControladorGesEscDocxTest {

	@Test
	public void Testdocx() {
		ControladorGesDocx aaa = new ControladorGesDocx();
		String aux = aaa.mostrarDocx();
		AgregarAlDocx agregaraldocxmock = mock(AgregarAlDocx.class);
		
		ControladorGesEscDocx controladorGesEscDocx = new ControladorGesEscDocx(agregaraldocxmock);
		controladorGesEscDocx.gesEscDocx(aux);
		
		verify(agregaraldocxmock, times(1)).EscribirDocx(aux);
	}
}
