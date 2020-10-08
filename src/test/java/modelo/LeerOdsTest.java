package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeerOdsTest {

	private String resultado;
	private String resultadoesperado;
	private LeerOds testods = new LeerOds();
	

	@Test
	public void test() {
				
		resultado = testods.LecturadOds();
		
		if (resultado != null) {
			resultadoesperado = resultado;
		} ;
		
		assertEquals(resultado, resultadoesperado);
		
	}

}
