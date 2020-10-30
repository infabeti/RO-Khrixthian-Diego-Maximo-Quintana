package controlador;

import modelo.LeerHtml;

public class ControladorGesHtml {
	private LeerHtml leerHtml = new LeerHtml();
	
	public String mostrarHtml() {
		
		return leerHtml.muestraContenido(); 
	} 
}
