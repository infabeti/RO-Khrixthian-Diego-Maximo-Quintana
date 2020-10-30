package Aplicacion;

import vista.VentanaBienvenida;
import vista.VentanaUser;

public class Aplicacion {
	public static void main(String[] args) {
		new VentanaBienvenida();
		new VentanaUser().setVisible(true);
	} 
}
