package controlador;

import modelo.LeerXml;

public class ControladorGesXml {
	private LeerXml leerXml;
	
	public String mostrarXml() {
		
		leerXml = new LeerXml();
		
		return leerXml.LecturaXml();
	}

}
