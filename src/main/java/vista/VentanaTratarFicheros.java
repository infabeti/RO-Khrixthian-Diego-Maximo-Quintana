package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaTratarFicheros extends JFrame {
	private JTextField txtRenameFich;
	private JTextField txtPropietario;
	private JComboBox cbFicheros;
	private JButton btnGuardarCambios;
	private JLabel lblNomFicheroEntrada;
	private JLabel lblNewName;
	private JLabel lblPropietario;
	private String[] listado;
	private FileChannel origen = null;
	private FileChannel destino = null;
	private JButton btnMoverFichero;
	private JRadioButton rbLectura;
	private JRadioButton rbLectEscr;
	private JRadioButton rbTodos;
	private ButtonGroup bg;
	private JButton btnGuardarPermisos;

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

		txtRenameFich = new JTextField();
		txtRenameFich.setBounds(239, 88, 204, 20);
		getContentPane().add(txtRenameFich);
		txtRenameFich.setColumns(10);

		txtPropietario = new JTextField();
		txtPropietario.setBounds(239, 142, 204, 20);
		getContentPane().add(txtPropietario);
		txtPropietario.setColumns(10);

		btnGuardarCambios = new JButton("GUARDAR");
		btnGuardarCambios.setBounds(23, 248, 101, 23);
		getContentPane().add(btnGuardarCambios);

		cbFicheros = new JComboBox();
		cbFicheros.setBounds(239, 44, 204, 22);
		getContentPane().add(cbFicheros);

		btnMoverFichero = new JButton("MOVER");
		btnMoverFichero.setBounds(162, 248, 89, 23);
		getContentPane().add(btnMoverFichero);

		rbLectura = new JRadioButton("Solo Lectura");
		rbLectura.setBounds(47, 202, 109, 23);
		getContentPane().add(rbLectura);

		rbLectEscr = new JRadioButton("Lectura y escritura");
		rbLectEscr.setBounds(175, 202, 145, 23);
		getContentPane().add(rbLectEscr);

		rbTodos = new JRadioButton("Todos los permisos");
		rbTodos.setBounds(322, 202, 166, 23);
		getContentPane().add(rbTodos);

		bg = new ButtonGroup();
		bg.add(rbLectura);
		bg.add(rbLectEscr);
		bg.add(rbTodos);

		btnGuardarPermisos = new JButton("CAMBIAR PERMISOS");
		btnGuardarPermisos.setBounds(281, 248, 162, 23);
		getContentPane().add(btnGuardarPermisos);

		cargarComboBox();

		btnGuardarPermisos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPermisosLinux();
				// cambiarPermisosWindows();
			}
		});

		btnGuardarCambios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				renombrarFichero();
			}

		});

		btnMoverFichero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fichSelec = cbFicheros.getSelectedItem().toString();
				String ruta1 = ".//ficheros//" + fichSelec;
				String ruta2 = ".//ficheros2//" + fichSelec;
				try {
					moverFichero(ruta1, ruta2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});

	}

	public void cambiarPermisosWindows() {
		Process theProcess = null;
		String pathname = cbFicheros.getSelectedItem().toString();
		String ruta = ".//ficheros2//";
		File fichero = new File(ruta + pathname);
		if (rbTodos.isSelected()) {
			fichero.setExecutable(true);
			fichero.setReadable(true);
			fichero.setWritable(true);

		} else if (rbLectEscr.isSelected()) {
			fichero.setReadable(true);
			fichero.setWritable(true);

		} else if (rbLectura.isSelected()) {
			fichero.setReadable(true);
		}
	}

	// esto solo sirve para linux kreo
	public void cambiarPermisosLinux() {
		Process theProcess = null;
		String ruta = ".//ficheros2//";
		String pathname = cbFicheros.getSelectedItem().toString();
		pathname = ruta + pathname;
		if (rbTodos.isSelected()) {
			try {
				theProcess = Runtime.getRuntime().exec("chmod 777" + pathname);
			} catch (IOException e) {
				System.out.println("Error en el método exec()");
			}

		} else if (rbLectEscr.isSelected()) {
			try {
				theProcess = Runtime.getRuntime().exec("chmod 666" + pathname);
			} catch (IOException e) {
				System.out.println("Error en el método exec()");
			}
		} else if (rbLectura.isSelected()) {
			try {
				theProcess = Runtime.getRuntime().exec("chmod 444" + pathname);
			} catch (IOException e) {
				System.out.println("Error en el método exec()");
			}
		}
	}

	public void cargarComboBox() {
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
		String ruta = ".//ficheros//";
		String fichSelec = cbFicheros.getSelectedItem().toString();
		String newName = txtRenameFich.getText();
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
	}

	public void moverFichero(String origen, String destino) throws IOException {
		Path FROM = Paths.get(origen);
		Path TO = Paths.get(destino);
		// sobreescribir el fichero de destino, si existe, y copiar
		// los atributos, incluyendo los permisos rwx
		CopyOption[] options = new CopyOption[] { StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.COPY_ATTRIBUTES };
		Files.copy(FROM, TO, options);
	}
}
