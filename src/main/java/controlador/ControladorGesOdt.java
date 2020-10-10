package controlador;

import modelo.LeerOdt;

public class ControladorGesOdt {
	private LeerOdt leerOdt;
	
	public String mostrarOdt() {
		
		leerOdt = new LeerOdt();

		return leerOdt.LecturadOdt();
	}
}
