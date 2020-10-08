package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeerXmlTest {
	
	private String resultado;
	private String resultadoesperado;
	private LeerXml testxml = new LeerXml();

	@Test
	public void test() {

		resultado = testxml.LecturaXml();
		
		resultadoesperado = "Nodo raiz: videoteca" + (char) 10
				+ "Nodo hijo: peliculas" + (char) 10 + (char) 10
				+ "Pelicula: titulo: El señor de los anillos - La comunidad del anillo"	+ (char) 10	
				+ "Pelicula: director: Peter Jackson" +  (char) 10		
				+ "Pelicula: año: 2001"	+ (char) 10	+ (char) 10		
				+ "Pelicula: titulo: Titanic"	+ (char) 10	
				+ "Pelicula: director: James Cameron" + (char) 10		
				+ "Pelicula: año: 1997"	+ (char) 10	+ (char) 10			
				+ "Pelicula: titulo: Seven"	+ (char) 10	
				+ "Pelicula: director: David Fincher" + (char) 10		
				+ "Pelicula: año: 1995" + (char) 10 + (char) 10;
		
		assertEquals(resultado, resultadoesperado);
	}

}
