package vista;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaTratarFicheros extends JFrame {
	private JTextField txtRenameFich;
	private JTextField txtPropietario;

	public VentanaTratarFicheros() {
		getContentPane().setLayout(null);

		setSize(500, 350);
		setTitle("Ventana Administrador");
		setResizable(false);
		setLocationRelativeTo(null);
		JLabel lblNomFicheroEntrada = new JLabel("Nombre del fichero a tratar:");
		lblNomFicheroEntrada.setBounds(23, 48, 167, 14);
		getContentPane().add(lblNomFicheroEntrada);

		JLabel lblNewName = new JLabel("Renombra el fichero:");
		lblNewName.setBounds(23, 91, 133, 14);
		getContentPane().add(lblNewName);

		JLabel lblPropietario = new JLabel("Propietario:");
		lblPropietario.setBounds(23, 145, 101, 14);
		getContentPane().add(lblPropietario);

		JCheckBox cbSoloLectura = new JCheckBox("Solo lectura");
		cbSoloLectura.setBounds(23, 191, 97, 23);
		getContentPane().add(cbSoloLectura);

		JCheckBox cbLectEscrit = new JCheckBox("Lectura y escritura");
		cbLectEscrit.setBounds(152, 191, 152, 23);
		getContentPane().add(cbLectEscrit);

		JCheckBox cbTodos = new JCheckBox("Todos los permisos");
		cbTodos.setBounds(306, 191, 166, 23);
		getContentPane().add(cbTodos);

		txtRenameFich = new JTextField();
		txtRenameFich.setBounds(239, 88, 204, 20);
		getContentPane().add(txtRenameFich);
		txtRenameFich.setColumns(10);

		txtPropietario = new JTextField();
		txtPropietario.setBounds(239, 142, 204, 20);
		getContentPane().add(txtPropietario);
		txtPropietario.setColumns(10);

		JButton btnGuardarCambios = new JButton("GUARDAR");
		btnGuardarCambios.setBounds(175, 247, 118, 23);
		getContentPane().add(btnGuardarCambios);

		JComboBox cbFicheros = new JComboBox();
		cbFicheros.setBounds(239, 44, 204, 22);
		getContentPane().add(cbFicheros);
	}
}
