package controlador;

import modelo.AgregarAlTxt;
import vista.VentanaConsultas;

public class ControladorGesEscTxt {
	private AgregarAlTxt agregarTxt = new AgregarAlTxt();
	private VentanaConsultas ventana = new VentanaConsultas();
	private String testoTxt;
	
	public void gesEscTxt() {

		testoTxt = ventana.textPane.getText(); 
		agregarTxt.agregar(testoTxt); 
	}
}
