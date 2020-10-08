package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import controlador.ControladorGesHtml;
import controlador.ControladorGesOds;
import controlador.ControladorGesOdt;
import controlador.ControladorGesTxt;
import controlador.ControladorGesXml;

import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsultas extends JFrame {
	
	private JPanel contentPane;
	private JTextField campoLibros;
	private JTextField campoCDs;
	private JTextField campoPeliculas;
	private JTextField campoUsuarios;
	private JTextField campoTrabajadores;
	private JTextField campoPrestamos;
	private JLabel lblLibros;
	private JLabel lblCDs;
	private JLabel lblPeliculas;
	private JLabel lblUsuarios;
	private JLabel lblTrabajadores;
	private JLabel lblPrestamos;
	private JButton btnLibros;
	private JButton btnCDs;
	private JButton btnPelis;
	private JButton btnUsuarios;
	private JButton btnTrabajadores;
	private JButton btnPrestamos;
	private JScrollPane scrollPane;

	private JTextPane textPane = new JTextPane();

	// Crea la ventana
	public VentanaConsultas() {
		setSize(1000, 950);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
		setResizable(false); // No resizable
		setLocationRelativeTo(null); // Ubica la ventana en el cento

		lblLibros = new JLabel("Libros");
		lblLibros.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblLibros.setBounds(20, 48, 48, 14);
		contentPane.add(lblLibros);

		campoLibros = new JTextField();
		campoLibros.setBounds(86, 45, 153, 20);
		contentPane.add(campoLibros);
		campoLibros.setColumns(10);

		lblCDs = new JLabel("CDs");
		lblCDs.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCDs.setBounds(20, 98, 48, 14);
		contentPane.add(lblCDs);

		campoCDs = new JTextField();
		campoCDs.setColumns(10);
		campoCDs.setBounds(86, 95, 153, 20);
		contentPane.add(campoCDs);

		lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPeliculas.setBounds(20, 148, 48, 14);
		contentPane.add(lblPeliculas);

		campoPeliculas = new JTextField();
		campoPeliculas.setColumns(10);
		campoPeliculas.setBounds(86, 145, 153, 20);
		contentPane.add(campoPeliculas);

		lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUsuarios.setBounds(20, 198, 48, 14);
		contentPane.add(lblUsuarios);

		campoUsuarios = new JTextField();
		campoUsuarios.setColumns(10);
		campoUsuarios.setBounds(86, 195, 153, 20);
		contentPane.add(campoUsuarios);

		lblTrabajadores = new JLabel("Trabajadores");
		lblTrabajadores.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrabajadores.setBounds(20, 248, 71, 14);
		contentPane.add(lblTrabajadores);

		campoTrabajadores = new JTextField();
		campoTrabajadores.setColumns(10);
		campoTrabajadores.setBounds(86, 245, 153, 20);
		contentPane.add(campoTrabajadores);

		lblPrestamos = new JLabel("Prestamos");
		lblPrestamos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPrestamos.setBounds(20, 298, 68, 14);
		contentPane.add(lblPrestamos);

		campoPrestamos = new JTextField();
		campoPrestamos.setColumns(10);
		campoPrestamos.setBounds(86, 295, 153, 20);
		contentPane.add(campoPrestamos);

		// Botones
		btnLibros = new JButton("Acceder");
		btnLibros.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLibros.setBounds(260, 44, 71, 23);
		contentPane.add(btnLibros);

		btnCDs = new JButton("Acceder");
		btnCDs.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCDs.setBounds(260, 94, 71, 23);
		contentPane.add(btnCDs);

		btnPelis = new JButton("Acceder");
		btnPelis.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPelis.setBounds(260, 144, 71, 23);
		contentPane.add(btnPelis);

		btnUsuarios = new JButton("Acceder");
		btnUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUsuarios.setBounds(260, 194, 71, 23);
		contentPane.add(btnUsuarios);

		btnTrabajadores = new JButton("Acceder");
		btnTrabajadores.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTrabajadores.setBounds(260, 244, 71, 23);
		contentPane.add(btnTrabajadores);

		btnPrestamos = new JButton("Acceder");
		btnPrestamos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPrestamos.setBounds(260, 294, 71, 23);
		contentPane.add(btnPrestamos);

		// Area de texto
		scrollPane = new JScrollPane();
		scrollPane.setBounds(365, 45, 600, 810);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(textPane);
		textPane.setContentType("text");

		// Acciones de los botones

		// Botón Libros (.txt)
		btnLibros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesTxt infoTxt = new ControladorGesTxt();

				String textoTxt = infoTxt.mostrarTxt();
				textPane.setText(textoTxt);
			}

		});

		// Botón Peliculas (.xml)
		btnPelis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesXml infoXml = new ControladorGesXml();

				String textoXml = infoXml.mostrarXml();
				textPane.setText(textoXml);
			}

		});

		// Botón Usuarios (.html)
		btnUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesHtml infoHtml = new ControladorGesHtml();

				String textoAMostrar = infoHtml.mostrarHtml();
				textPane.setText(textoAMostrar);
			}

		});

		// Botón Trabajadores (.odt)
		btnTrabajadores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesOdt infoOdt = new ControladorGesOdt();

				String contenidoOdt = infoOdt.mostrarOdt();
				textPane.setText(contenidoOdt);
			}

		});

		// Botón Prestamos (.ods)
		btnPrestamos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesOds infoOds = new ControladorGesOds();

				String contenidoOds = infoOds.mostrarOds();
				textPane.setText(contenidoOds);
			}

		});
	}

}
