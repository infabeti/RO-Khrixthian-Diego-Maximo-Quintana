package controlador;

import modelo.ExpresionRegularPassword;

public class ControladorExpresionRegularPassword {
    private ExpresionRegularPassword erPassword;
    private boolean control = false;

    public boolean validarContrasena(String contrasena) {
	erPassword = new ExpresionRegularPassword();

	control = erPassword.buscar(contrasena, "");

	return control;
    }
}
