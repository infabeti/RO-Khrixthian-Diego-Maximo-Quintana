package modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AgregarAlDocxtest {

	private String resultado;
	private String resultadoesperado;
	private LeerDocx leerDocx = new LeerDocx();
	
	@Test
	public void test() {
		resultado = leerDocx.LecturaDocx();
		
		resultadoesperado ="Deltoya, Extremoduro, Rock Transgresivo." + (char) 13 + (char) 10
				+ "One, Metallica, Rock." + (char) 13 + (char) 10
				+ "Fear of the dark, Iron Maiden, Rock." + (char) 13 + (char) 10
				+ "Don't Give Me Names, Guano Apes, Grunge." + (char) -1
				+ "Devil come to me, Dover, Grunge." + (char) 13 + (char) 10
				+ "A night al the opera, Queen, Rock" + (char) 13 + (char) 10
				+ "A pelo, Platero y tu, rock" + (char) -1;;
		
		assertEquals(resultado, resultadoesperado);
	}
}
