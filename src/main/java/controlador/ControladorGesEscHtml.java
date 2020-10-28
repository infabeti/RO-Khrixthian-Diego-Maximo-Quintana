package controlador;

import modelo.AgregarAlHtml;

public class ControladorGesEscHtml {

	private AgregarAlHtml agregarAlHtml;

	public ControladorGesEscHtml(AgregarAlHtml agregarAlHtml) {

		this.agregarAlHtml = agregarAlHtml;
	}

	public void gesEscHtml(String x) {

		agregarAlHtml.agregar(x);
	}
}
