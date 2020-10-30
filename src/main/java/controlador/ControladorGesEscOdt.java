package controlador;

import modelo.AgregarAlOdt;

public class ControladorGesEscOdt {

	private AgregarAlOdt agregarAlOdt;

	public ControladorGesEscOdt(AgregarAlOdt agregarAlOdt) {

		this.agregarAlOdt = agregarAlOdt;
	}

	public void gesEscOdt(String x) {

		this.agregarAlOdt.EscribirOdt(x);
	}
}
