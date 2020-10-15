package controlador;

import modelo.AgregarAlOdt;

public class ControladorGesEscOdt {

	public void recogerOdt(String textoOdt) {
		AgregarAlOdt escritor = new AgregarAlOdt();

		escritor.EscribirOdt(textoOdt);
	}
}
