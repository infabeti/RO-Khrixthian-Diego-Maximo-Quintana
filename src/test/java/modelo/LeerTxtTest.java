package modelo;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

public class LeerTxtTest {

	private String resultado;
	private String resultadoesperado;
	private LeerTxt testtxt = new LeerTxt();

	@Test
	public void test() throws FileNotFoundException {
		String ruta = ".//ficheros//Libros.txt";
		FileReader x = new FileReader(ruta);

		resultado = testtxt.leertxt(x);

		resultadoesperado = " 9999, El se�or de los anillos, J.R. Tolkien, novela fant�stica." + (char) 13 + (char) 10
				+ " 8888, La columna de la muerte, Francisco Espinosa, ensayo hist�rico." + (char) 13 + (char) 10
				+ " 7777, El enemigo conoce el sistema, Marta Peirano, ensayo sobre la aplicaci�n capitalista de la inform�tica."
				+ (char) 13 + (char) 10
				+ " 6666, El segundo sexo, Simone de Beauvoir, ensayo sobre la opresi�n de la mujer." + (char) 13
				+ (char) 10 + " 5555, Patria, Fernando Aramburu." + (char) -1;

		assertEquals(resultado, resultadoesperado);

	}

}
