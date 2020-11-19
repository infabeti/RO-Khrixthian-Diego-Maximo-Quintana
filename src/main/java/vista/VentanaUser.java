package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.ControladorExpresionRegularPassword;
//import controlador.ControladorUser;

@SuppressWarnings("serial")
public class VentanaUser extends JFrame {
    public ControladorExpresionRegularPassword controladorExpresionRegularPassword = new ControladorExpresionRegularPassword();
//	public ControladorUser controladorUser = new ControladorUser();
    private VentanaConsultas consultas;// declaramos la ventana de consultas
    private JPanel contentPane;
    static boolean ES_ADMINISTRADOR;
    static String nomUsu;
    private JTextField fieldUser;
    private JPasswordField fieldPassword;
    private JLabel lblCabecera;
    private JLabel lblUsuario;
    private JLabel lblContrasena;
    private JButton botonAcceder;

    // Crea la ventana
    public VentanaUser() {

	setSize(450, 275);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
	setResizable(false); // No resizable
	setLocationRelativeTo(null); // Ubica la ventana en el cento

	lblCabecera = new JLabel("Acceso Usuarios");
	lblCabecera.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblCabecera.setBounds(127, 24, 169, 23);
	contentPane.add(lblCabecera);

	lblUsuario = new JLabel("Usuario");
	lblUsuario.setBounds(127, 65, 48, 14);
	contentPane.add(lblUsuario);

	fieldUser = new JTextField();
	fieldUser.setBounds(127, 81, 169, 20);
	contentPane.add(fieldUser);
	fieldUser.setColumns(10);

	lblContrasena = new JLabel("Contrase\u00F1a");
	lblContrasena.setBounds(127, 108, 76, 14);
	contentPane.add(lblContrasena);

	fieldPassword = new JPasswordField();
	fieldPassword.setBounds(127, 124, 169, 20);
	contentPane.add(fieldPassword);
	fieldPassword.setColumns(10);

	botonAcceder = new JButton("Acceder");
	botonAcceder.setBounds(165, 166, 89, 23);
	contentPane.add(botonAcceder);

	// ActionListeners
	botonAcceder.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		boolean control = controladorExpresionRegularPassword.validarContrasena(fieldPassword.getText());
//				boolean control = controladorUser.validarContrasena(fieldPassword.getText());

		if (control == false) {
		    JOptionPane.showMessageDialog(null,
			    "La contraseña solo puede tener carácteres alfanuméricos, no símbolos.",
			    "ERROR AL INTRODUCIR LA CONTRASEÑA", JOptionPane.ERROR_MESSAGE);
		}

		if (control == true) {
		    nomUsu = fieldUser.getText();
		    if (fieldUser.getText().equals("admin") && !fieldPassword.getText().equals("admin1")) {
			JOptionPane.showMessageDialog(null,
				"La contraseña de admin no es correcta. Se accedera como usuario normal.",
				"ADMINISTRADOR NO VALIDO", JOptionPane.OK_OPTION);
		    } else if (fieldUser.getText().equals("admin") && fieldPassword.getText().equals("admin1")) {
			ES_ADMINISTRADOR = true;
			JOptionPane.showMessageDialog(null, "Iniciando Ventana de Administrador",
				"ADMINISTRADOR VALIDADO", JOptionPane.ERROR_MESSAGE);
		    }
		    System.out.println(ES_ADMINISTRADOR);
		    consultas = new VentanaConsultas();
		    consultas.setVisible(true); // apertura de la ventana de consultas
		    dispose();
		}
	    }
	});
    }
}
