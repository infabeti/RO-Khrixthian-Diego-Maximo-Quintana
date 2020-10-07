package controlador;

import javax.swing.JOptionPane;

import modelo.ModeloUsers;

public class ControladorUser {
	
	ModeloUsers modeloUsers;
	
	public boolean validarContrasena(String contrasena) {
		modeloUsers = new ModeloUsers();
		
		boolean control;
		control = modeloUsers.validarSoloAlfanumerico(contrasena);
		
		return control;
		
	}

}
