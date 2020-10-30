package controlador;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;

import modelo.ModeloUsers;

public class ControladorUserTest {
	private boolean resultadoEsperado;

	@Test
	public void testgesEscTxt() {
		ModeloUsers modeloUsersMock = mock(ModeloUsers.class);
		resultadoEsperado = true;
		Mockito.when(modeloUsersMock.validarSoloAlfanumerico("prueba")).thenReturn(true);
		assertEquals(modeloUsersMock.validarSoloAlfanumerico("prueba"), resultadoEsperado);
	}
}
