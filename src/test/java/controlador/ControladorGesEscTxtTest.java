package controlador;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import modelo.AgregarAlTxt;

public class ControladorGesEscTxtTest {

	@Test
	public void testControlEscTxt() {
		ControladorGesHtml aaa = new ControladorGesHtml();
		String aux = aaa.mostrarHtml();
		AgregarAlTxt agregarAlTxtMock = mock(AgregarAlTxt.class);

		ControladorGesEscTxt controladorGesEscTxt = new ControladorGesEscTxt(agregarAlTxtMock);
		controladorGesEscTxt.gesEscTxt(aux);

		try {
			verify(agregarAlTxtMock, times(1)).agregar(aux);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
