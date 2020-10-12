package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.AgregarAlTxt;
import modelo.LeerTxt;

public class GesEscTxtTest {

	private String resultado;
	private String resultadoesperado;
	private LeerTxt leerTxt = new LeerTxt();
	
	@Test
	public void test() {

		resultado = leerTxt.leertxt();
		resultadoesperado = "  9999, El señor de los anillos, J.R. Tolkien, novela fantástica." + (char) 13 + (char) 10
				+ "8888, La columna de la muerte, Francisco Espinosa, ensayo histórico." + (char) 13 + (char) 10
				+ "7777, El enemigo conoce el sistema, Marta Peirano, ensayo sobre la aplicación capitalista de la informática." + (char) 13 + (char) 10
				+ "6666, El segundo sexo, Simone de Beauvoir, ensayo sobre la opresión de la mujer." + (char) -1;
		
		assertEquals(resultado, resultadoesperado); 
		
	}

}
