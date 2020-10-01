package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

@SuppressWarnings("serial")
public class VentanaUser extends JFrame {
	final VentanaConsultas consultas = new VentanaConsultas();// declaramos la ventana de consultas
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
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

		textField_1 = new JTextField();
		textField_1.setBounds(127, 124, 169, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnNewButton = new JButton("Acceder");
		btnNewButton.setBounds(165, 166, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setAction(action);
	}

	// Acción del botón Acceder
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Acceder");
			putValue(SHORT_DESCRIPTION, "Verificar y acceder a la ventana de consultas");
		}

		public void actionPerformed(ActionEvent e) {
			consultas.setVisible(true); // apertura de la ventana de consultas
			dispose();
		}
	}
}
