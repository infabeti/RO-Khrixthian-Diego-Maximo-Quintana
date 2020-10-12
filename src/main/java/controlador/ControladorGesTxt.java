package controlador;

import modelo.LeerTxt;

public class ControladorGesTxt {
	private LeerTxt leerTxt;
	
	public String mostrarTxt() {

		leerTxt = new LeerTxt();
		
		return leerTxt.leertxt(); 
	}
}
