package controlador;

import modelo.LeerHtml;

public class ControladorGesHtml {
	private LeerHtml leerHtml;

	public String mostrarHtml() {

		leerHtml = new LeerHtml();

		return leerHtml.muestraContenido();
	}

}
