package controlador;

import modelo.LeerOds;

public class ControladorGesOds {
	
	LeerOds leerOds = new LeerOds();
	
	public String mostrarOds() {
		
		return leerOds.LecturadOds();
	}
}
