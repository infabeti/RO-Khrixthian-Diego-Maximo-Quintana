package controlador;

import modelo.AgregarAlHtml;

public class ControladorGesEscHtml {
	
	private AgregarAlHtml agregarAlHtml;
	
	public void gesEscHtml(AgregarAlHtml agregarAlHtml) {

		this.agregarAlHtml = agregarAlHtml;
	}
	
	public void gesEscHtml(String x) {
		
		agregarAlHtml.agregar(x);
	}
}
