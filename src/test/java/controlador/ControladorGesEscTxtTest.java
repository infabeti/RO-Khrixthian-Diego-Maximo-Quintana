package controlador;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import modelo.AgregarAlTxt;

public class ControladorGesEscTxtTest {

	private AgregarAlTxt agregarAlTxtMock = mock(AgregarAlTxt.class);
	private ControladorGesEscTxt controladorGesEscTxt = new ControladorGesEscTxt(agregarAlTxtMock);
	private String testString;

	@Test
	public void testgesEscTxt() {
		testString = "prueba";
		controladorGesEscTxt.gesEscTxt(testString);

		try {
			verify(agregarAlTxtMock, times(1)).agregar(testString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
