package controlador;

import modelo.LeerOds;

public class ControladorGesOds {

	public String[][] mostrarOds(LeerOds leerOds) {
		
		return leerOds.LecturadOds();
		
	}
}
