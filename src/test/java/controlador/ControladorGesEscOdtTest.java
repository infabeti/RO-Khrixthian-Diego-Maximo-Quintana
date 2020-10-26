package controlador;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import modelo.AgregarAlOdt;

public class ControladorGesEscOdtTest {

	@Test
	public void testControlEscOdt() {
		ControladorGesOdt aaa = new ControladorGesOdt();
		String aux = aaa.mostrarOdt();
		AgregarAlOdt agregarAlOdtMock = mock(AgregarAlOdt.class);

		ControladorGesEscOdt controladorGesEscOdt = new ControladorGesEscOdt(agregarAlOdtMock);
		controladorGesEscOdt.gesEscOdt(aux);

		verify(agregarAlOdtMock, times(1)).EscribirOdt(aux);
	}

}
