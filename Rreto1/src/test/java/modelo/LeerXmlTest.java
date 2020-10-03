package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeerXmlTest {
	
	String resultado;
	String resultadoesperado;
	LeerXml testxml = new LeerXml();

	@Test
	public void test() {

		resultado = testxml.LecturaXml();
		
		resultadoesperado = "Nodo raiz: videoteca" + (char) 13 + (char) 10
				+ "Nodo hijo: peliculas" + (char) 13 + (char) 10
				+ "\r\n" + (char) 13 + (char) 10
				+ "Pelicula: titulo: El se�or de los anillos - La comunidad del anillo" + (char) 13 + (char) 10
				+ "Pelicula: director: Peter Jackson" + (char) 13 + (char) 10
				+ "Pelicula: a�o: 2001" + (char) 13 + (char) 10
				+ "\r\n" + (char) 13 + (char) 10
				+ "Pelicula: titulo: Titanic" + (char) 13 + (char) 10
				+ "Pelicula: director: James Cameron" + (char) 13 + (char) 10
				+ "Pelicula: a�o: 1997" + (char) 13 + (char) 10
				+ "\r\n" + (char) 13 + (char) 10
				+ "Pelicula: titulo: Seven" + (char) 13 + (char) 10
				+ "Pelicula: director: David Fincher" + (char) 13 + (char) 10
				+ "Pelicula: a�o: 1995" + (char) -1;
		
		assertEquals(resultado, resultadoesperado);
	}

}
