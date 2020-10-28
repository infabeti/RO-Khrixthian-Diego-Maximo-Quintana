package controlador;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import modelo.AgregarAlOdt;

public class ControladorGesEscOdtTest {

	private AgregarAlOdt agregarAlOdtMock = mock(AgregarAlOdt.class);
	private ControladorGesEscOdt controladorGesEscOdt = new ControladorGesEscOdt(agregarAlOdtMock);
	private String testString;

	@Test
	public void testgesEscOdt() {
		testString = "prueba";
		controladorGesEscOdt.gesEscOdt(testString);

		verify(agregarAlOdtMock, times(1)).EscribirOdt(testString);
	}

}
