package controlador;

import modelo.LeerHtml;

public class ControladorGesHtml {
	
	public String mostrarHtml() {
		
		LeerHtml leerHtml = new LeerHtml();

		return leerHtml.muestraContenido();
	}

}
