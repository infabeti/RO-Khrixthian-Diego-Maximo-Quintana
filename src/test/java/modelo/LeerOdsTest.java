package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeerOdsTest {

	private String[][] resultado;
	private String[][] resultadoesperado;
	private LeerOds testods = new LeerOds();

	@Test
	public void test() {

		resultado = testods.LecturadOds();

		String[][] resEsp = {{"Usuario", "CodUser", "libro", "fecha", "entrega"}, 
						{"Ibai", "1234", "el señor de los anillos", "5-10-2020", "20-10-2020"},
						{"khrixthian", "1235", "el enemigo conoce el sistema", "5-10-2020", "20-10-2020"},
						{"Maximo", "1236", "la columna de la muerte", "5-10-2020", "20-10-2020"},
						{"Diego", "1237", "watchmen", "5-10-2021", "20-10-2021"}};

		assertArrayEquals(resultado, resEsp);

	}

}
