package controlador;

import static org.mockito.Mockito.*;
import org.junit.Test;
import modelo.AgregarAlTxt;

public class ControladorGesEscTxtTest {
	
	@Test
	public void name() {
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
