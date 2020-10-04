package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ControladorUser;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

@SuppressWarnings("serial")
public class VentanaUser extends JFrame {
	ControladorUser controladorUser = new ControladorUser();
	final VentanaConsultas consultas = new VentanaConsultas();// declaramos la ventana de consultas
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField password;
	private final Action action = new SwingAction();
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;

	// Crea la ventana
	public VentanaUser() {

		setSize(450, 275);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acci�n al cerrar la ventana
		setResizable(false); // No resizable
		setLocationRelativeTo(null); // Ubica la ventana en el cento

		lblNewLabel = new JLabel("Acceso Usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(127, 24, 169, 23);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(127, 65, 48, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(127, 81, 169, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setBounds(127, 108, 76, 14);
		contentPane.add(lblNewLabel_2);

		password = new JPasswordField();
		password.setBounds(127, 124, 169, 20);
		contentPane.add(password);
		password.setColumns(10);

		btnNewButton = new JButton("Acceder");
		btnNewButton.setBounds(165, 166, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setAction(action);
	}

	// Acci�n del bot�n Acceder
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Acceder");
			putValue(SHORT_DESCRIPTION, "Verificar y acceder a la ventana de consultas");
		}

		public void actionPerformed(ActionEvent e) {
			boolean control = controladorUser.validarContrasena(password.getText());
			
			if(control == false) {
				JOptionPane.showMessageDialog(
						null, "La contrase�a solo puede tener car�cteres alfanum�ricos, no s�mbolos.", 
						"ERROR AL INTRODUCIR LA CONTRASE�A", 
						JOptionPane.ERROR_MESSAGE);
			}
			
			if(control == true) {
				consultas.setVisible(true); //apertura de la ventana de consultas
				dispose();
			}
			
		}
	}
}
