package controlador;

import modelo.AgregarAlOdt;

public class ControladorGesEscOdt {
	
	public void recogerDocx(String textoOdt) {
		AgregarAlOdt escritor = new AgregarAlOdt();

		 escritor.EscribirOdt(textoOdt);
	}
}
