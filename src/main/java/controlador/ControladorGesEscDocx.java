package controlador;

import modelo.AgregarAlDocx;

public class ControladorGesEscDocx {
	
	public void recogerDocx(String textoDocx) {
		AgregarAlDocx escritor = new AgregarAlDocx();

		 escritor.EscribirDocx(textoDocx);
	}
}
