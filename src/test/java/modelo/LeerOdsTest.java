package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeerOdsTest {

	String resultado;
	String resultadoesperado;
	LeerOds testods = new LeerOds();
	

	@Test
	public void test() {
				
		resultado = testods.LecturadOds();
		
		//para asegurarnos de que devuelve lo que queremos no algo diferente
		System.out.println(resultado);
		
		if (resultado != null) {
			resultadoesperado = resultado;
		} ;
		
		assertEquals(resultado, resultadoesperado);
		
	}

}
