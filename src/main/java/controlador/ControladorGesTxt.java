package controlador;

import java.io.FileReader;

import modelo.LeerTxt;

public class ControladorGesTxt {
	private LeerTxt leerTxt;
	private FileReader x = null;

	public String mostrarTxt() {

		leerTxt = new LeerTxt();

		return leerTxt.leertxt(x);
	}
}
