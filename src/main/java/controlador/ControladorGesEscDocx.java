package controlador;

import modelo.AgregarAlDocx;

public class ControladorGesEscDocx {
	
	private AgregarAlDocx agregarAlDocx;
	
	public ControladorGesEscDocx(AgregarAlDocx agregarAlDocx) {
		this.agregarAlDocx = agregarAlDocx;	
	}
	
	public void gesEscDocx(String x) { 

		agregarAlDocx.EscribirDocx(x);
	} 
}
