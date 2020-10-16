package controlador;

import static org.mockito.Mockito.*;
import org.junit.Test;
import modelo.AgregarAlTxt;

public class ControladorGesEscTxtTest {
	
	@Test
	public void name() {
		
		AgregarAlTxt AgregarAlTxtMock = mock(AgregarAlTxt.class);

		ControladorGesEscTxt controladorGesEscTxt = new ControladorGesEscTxt(AgregarAlTxtMock);
		controladorGesEscTxt.gesEscTxt("Hola");
		
		verify(AgregarAlTxtMock, times(1)).agregar("hola");
}
}
