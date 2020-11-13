package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaTratarFicheros extends JFrame {
	private JTextField txtRenameFich;
	private JTextField txtPropietario;
	private JComboBox cbFicheros;
	private JButton btnGuardarCambios;
	private JLabel lblNomFicheroEntrada;
	private JLabel lblNewName;
	private JLabel lblPropietario;
	private JCheckBox cbSoloLectura;
	private JCheckBox cbLectEscrit;
	private JCheckBox cbTodos;
	private String[] listado;

	public VentanaTratarFicheros() {
		getContentPane().setLayout(null);

		setSize(500, 350);
		setTitle("Ventana Administrador");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblNomFicheroEntrada = new JLabel("Nombre del fichero a tratar:");
		lblNomFicheroEntrada.setBounds(23, 48, 167, 14);
		getContentPane().add(lblNomFicheroEntrada);

		lblNewName = new JLabel("Renombra el fichero:");
		lblNewName.setBounds(23, 91, 133, 14);
		getContentPane().add(lblNewName);

		lblPropietario = new JLabel("Propietario:");
		lblPropietario.setBounds(23, 145, 101, 14);
		getContentPane().add(lblPropietario);

		cbSoloLectura = new JCheckBox("Solo lectura");
		cbSoloLectura.setBounds(23, 191, 97, 23);
		getContentPane().add(cbSoloLectura);

		cbLectEscrit = new JCheckBox("Lectura y escritura");
		cbLectEscrit.setBounds(152, 191, 152, 23);
		getContentPane().add(cbLectEscrit);

		cbTodos = new JCheckBox("Todos los permisos");
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

		btnGuardarCambios = new JButton("GUARDAR");
		btnGuardarCambios.setBounds(175, 247, 118, 23);
		getContentPane().add(btnGuardarCambios);

		cbFicheros = new JComboBox();
		cbFicheros.setBounds(239, 44, 204, 22);
		getContentPane().add(cbFicheros);

		cargarComboBox();

		btnGuardarCambios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				renombrarFichero();
			}

		});
	}

	public void cargarComboBox() {
		// https://www.campusmvp.es/recursos/post/java-como-listar-filtrar-y-obtener-informacion-de-carpetas-y-archivos.aspx
		String ruta = ".//ficheros";
		File carpeta = new File(ruta);
		listado = carpeta.list();
		if (listado == null || listado.length == 0) {
			System.out.println("No hay elementos dentro de la carpeta actual");
			return;
		} else {
			for (int i = 0; i < listado.length; i++) {
				cbFicheros.addItem(listado[i].toString());
			}
		}
	}

	public void renombrarFichero() {
		String ruta = ".//ficheros";
		String fichSelec = cbFicheros.getSelectedItem().toString();
		// System.out.println(fichSelec);
		String newName = txtRenameFich.getText();
		// System.out.println(newName);
		try {
			File oldfile = new File(ruta + fichSelec);
			File newfile = new File(ruta + newName);
			boolean estatus = oldfile.renameTo(newfile);
			if (!estatus) {
				System.out.println("error");
			} else {
				System.out.println("archivo renombrado");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

//	public static void main(String[] args) {
//		cargarComboBox();
//	}
	}
}
