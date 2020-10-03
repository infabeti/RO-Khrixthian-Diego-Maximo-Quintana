package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

public class GesXmlTest {
	String resultado;
	String resultadoesperado;
	GesXml testGesXml = new GesXml();
	
	@Test
	public void test() {
		resultado = testGesXml.mostrarXml();
		resultadoesperado = "Nodo raiz: videoteca" + (char) 10
		+ "Nodo hijo: peliculas" + (char) 10 + (char) 10
		+ "Pelicula: titulo: El se�or de los anillos - La comunidad del anillo"	+ (char) 10	
		+ "Pelicula: director: Peter Jackson" +  (char) 10		
		+ "Pelicula: a�o: 2001"	+ (char) 10	+ (char) 10		
		+ "Pelicula: titulo: Titanic"	+ (char) 10	
		+ "Pelicula: director: James Cameron" + (char) 10		
		+ "Pelicula: a�o: 1997"	+ (char) 10	+ (char) 10			
		+ "Pelicula: titulo: Seven"	+ (char) 10	
		+ "Pelicula: director: David Fincher" + (char) 10		
		+ "Pelicula: a�o: 1995" + (char) 10 + (char) 10;
		assertEquals(resultado, resultadoesperado);
	}

}
