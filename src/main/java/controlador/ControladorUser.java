package controlador;

import modelo.ModeloUsers;

public class ControladorUser {

	private ModeloUsers modeloUsers;
	private boolean control = false;

	public boolean validarContrasena(String contrasena) {
		modeloUsers = new ModeloUsers();

		control = modeloUsers.validarSoloAlfanumerico(contrasena);

		return control; 

	}

}
