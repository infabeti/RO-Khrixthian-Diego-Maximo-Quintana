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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;

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
	private JButton btnVolver;

	public VentanaTratarFicheros() {
		getContentPane().setLayout(null);

		setSize(500, 350);
		setTitle("Ventana Administrador");
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

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
		txtRenameFich.setToolTipText("");
		txtRenameFich.setBounds(239, 88, 204, 20);
		getContentPane().add(txtRenameFich);
		txtRenameFich.setColumns(10);

		txtPropietario = new JTextField();
		txtPropietario.setBounds(239, 142, 204, 20);
		getContentPane().add(txtPropietario);
		txtPropietario.setColumns(10);

		btnGuardarCambios = new JButton("GUARDAR");
		btnGuardarCambios.setBounds(150, 248, 101, 23);
		getContentPane().add(btnGuardarCambios);

		cbFicheros = new JComboBox();
		cbFicheros.setBounds(239, 44, 204, 22);
		getContentPane().add(cbFicheros);

		btnMoverFichero = new JButton("MOVER");
		btnMoverFichero.setBounds(35, 248, 89, 23);
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
		
		btnVolver = new JButton("VOLVER AL MENU PRINCIPAL");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(23, 300, 420, 20);
		getContentPane().add(btnVolver);

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
				cargarComboBox();
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
					JOptionPane.showMessageDialog(null, "Se ha movido el fichero '" + fichSelec + "' correctamente.", "MOVER FICHERO", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				VentanaUser.consultas.setVisible(true);
				dispose();
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

	// esto solo sirve para linux
	public void cambiarPermisosLinux() {
		Process theProcess = null;
		String pathname = cbFicheros.getSelectedItem().toString();
		String ruta = ".//ficheros2//";
		pathname = ruta + pathname;
		File auxFich = new File(pathname);

		if (rbTodos.isSelected()) {
			auxFich.setExecutable(true);
			auxFich.setReadable(true);
			auxFich.setWritable(true);

		} else if (rbLectEscr.isSelected()) {
			auxFich.setReadable(true);
			auxFich.setWritable(true);

		} else if (rbLectura.isSelected()) {
			auxFich.setReadable(true);
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
		boolean estatus = false;
		String ruta = ".//ficheros//";
		String fichSelec = cbFicheros.getSelectedItem().toString();
		String newName = txtRenameFich.getText();
		try {
			File oldfile = new File(ruta + fichSelec);
			File newfile = new File(ruta + newName);
			if(fichSelec.endsWith(".docx") && newName.endsWith(".docx")) {
				estatus = oldfile.renameTo(newfile);
			}else if(fichSelec.endsWith(".log") && newName.endsWith(".log")) {
				estatus = oldfile.renameTo(newfile);
			}else if(fichSelec.endsWith(".txt") && newName.endsWith(".txt")) {
				estatus = oldfile.renameTo(newfile);
			}else if(fichSelec.endsWith(".ods") && newName.endsWith(".ods")) {
				estatus = oldfile.renameTo(newfile);
			}else if(fichSelec.endsWith(".odt") && newName.endsWith(".odt")) {
				estatus = oldfile.renameTo(newfile);
			}else if(fichSelec.endsWith(".html") && newName.endsWith(".html")) {
				estatus = oldfile.renameTo(newfile);
			}else if(fichSelec.endsWith(".xml") && newName.endsWith(".xml")) {
				estatus = oldfile.renameTo(newfile);
			}
			
			if (!estatus) {
				JOptionPane.showMessageDialog(null, "No puedes renombrar el fichero '" + fichSelec + "' a una extension diferente", "RENOMBRAR FICHERO", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Se ha renombrado el fichero de '" + fichSelec + "' a '" + newName + "' correctamente.", "RENOMBRAR FICHERO", JOptionPane.INFORMATION_MESSAGE);
				cbFicheros.removeAllItems();
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
