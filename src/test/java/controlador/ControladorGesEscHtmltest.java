package controlador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.AgregarAlHtml;
import modelo.LeerHtml;

public class ControladorGesEscHtmltest {

	private String resultado;
	private String resultadoesperado;
	private LeerHtml leerHtml = new LeerHtml();
	
	@Test
	public void test() {

		resultado = leerHtml.muestraContenido();
		resultadoesperado = "<html>" + (char) 10 +
				"	<head>" + (char) 10 +
				"		<p>USUARIOS</p>" + (char) 10 +
				"	</head>" + (char) 10 + (char) 10 +
				"<body>" + (char) 10 +
				"	<numsocio> 1234 </numsocio> <br>" + (char) 10 +
				"		<nombre> Ibai </nombre>" + (char) 10 +
				"		<apellidos> Maria Juana </apellidos><br>" + (char) 10 +
				"		<direccion> C/ Buenaventura Durruti S/N </direccion><br>" + (char) 10 + 
				"		<telefono> 666 999 777 </telefono><br>" + (char) 10 + (char) 10 +
				"	<numsocio> 1235 </numsocio> <br>" + (char) 10 +
				"		<nombre> khrixthian </nombre>" + (char) 10 +
				"		<apellidos> Tururu Tiriri </apellidos><br>" + (char) 10 +
				"		<direccion> C/ Revolucion S/N </direccion><br>" + (char) 10 + 
				"		<telefono> 666 999 666 </telefono><br>" + (char) 10 + (char) 10 +
				"	<numsocio> 1236 </numsocio> <br>" + (char) 10 +
				"		<nombre> Maximo </nombre>" + (char) 10 +
				"		<apellidos> Meridio Romano </apellidos><br>" + (char) 10 +
				"		<direccion> C/ Jaque al rey S/N </direccion><br>" + (char) 10 +
				"		<telefono> 666 555 777 </telefono><br>" + (char) 10 + (char) 10 +
				"</body>" + (char) 10 + (char) 10 +
				"</html>" + (char) 10;
		
		assertEquals(resultado, resultadoesperado); 
		
	} 
}
