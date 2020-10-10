package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import controlador.ControladorGesDocx;
import controlador.ControladorGesHtml;
import controlador.ControladorGesOds;
import controlador.ControladorGesOdt;
import controlador.ControladorGesTxt;
import controlador.ControladorGesXml;
import controlador.GesEscHtml;
import controlador.GesEscTxt;
import modelo.LeerHtml;

import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.DefaultListModel;


public class VentanaConsultas extends JFrame {

	private JPanel contentPane;

	private JLabel lblLibros;
	private JLabel lblCDs;
	private JLabel lblPeliculas;
	private JLabel lblUsuarios;
	private JLabel lblTrabajadores;
	private JLabel lblPrestamos;

	private JButton btnLibrosLEER;
	private JButton btnCDsLEER;
	private JButton btnPelisLEER;
	private JButton btnUsuariosLEER;
	private JButton btnTrabajadoresLEER;
	private JButton btnPrestamosLEER;

	private JButton btnLibrosESCRIBIR;
	private JButton btnCDsESCRIBIR;
	private JButton btnPelisESCRIBIR;
	private JButton btnUsuariosESCRIBIR;
	private JButton btnTrabajadoresESCRIBIR;
	private JButton btnPrestamosESCRIBIR;

	private JScrollPane scrollPane;

	public static JTextPane textPane = new JTextPane();

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

		lblCDs = new JLabel("CDs");
		lblCDs.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCDs.setBounds(20, 98, 48, 14);
		contentPane.add(lblCDs);

		lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPeliculas.setBounds(20, 148, 48, 14);
		contentPane.add(lblPeliculas);

		lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUsuarios.setBounds(20, 198, 48, 14);
		contentPane.add(lblUsuarios);

		lblTrabajadores = new JLabel("Trabajadores");
		lblTrabajadores.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrabajadores.setBounds(20, 248, 71, 14);
		contentPane.add(lblTrabajadores);

		lblPrestamos = new JLabel("Prestamos");
		lblPrestamos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPrestamos.setBounds(20, 298, 68, 14);
		contentPane.add(lblPrestamos);

		// Botones LEER
		btnLibrosLEER = new JButton("Leer");
		btnLibrosLEER.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLibrosLEER.setBounds(90, 44, 71, 25);
		contentPane.add(btnLibrosLEER);

		btnCDsLEER = new JButton("Leer");
		btnCDsLEER.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCDsLEER.setBounds(90, 94, 71, 25);
		contentPane.add(btnCDsLEER);

		btnPelisLEER = new JButton("Leer");
		btnPelisLEER.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPelisLEER.setBounds(90, 144, 71, 25);
		contentPane.add(btnPelisLEER);

		btnUsuariosLEER = new JButton("Leer");
		btnUsuariosLEER.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUsuariosLEER.setBounds(90, 194, 71, 25);
		contentPane.add(btnUsuariosLEER);

		btnTrabajadoresLEER = new JButton("Leer");
		btnTrabajadoresLEER.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTrabajadoresLEER.setBounds(90, 244, 71, 25);
		contentPane.add(btnTrabajadoresLEER);

		btnPrestamosLEER = new JButton("Leer");
		btnPrestamosLEER.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPrestamosLEER.setBounds(90, 294, 71, 25);
		contentPane.add(btnPrestamosLEER);

		// ----------------------------------------
		// Botones ESCRIBIR
		btnLibrosESCRIBIR = new JButton("Escribir");
		btnLibrosESCRIBIR.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLibrosESCRIBIR.setBounds(171, 44, 71, 25);
		contentPane.add(btnLibrosESCRIBIR);

		btnCDsESCRIBIR = new JButton("Escribir");
		btnCDsESCRIBIR.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCDsESCRIBIR.setBounds(171, 94, 71, 25);
		contentPane.add(btnCDsESCRIBIR);

		btnPelisESCRIBIR = new JButton("Escribir");
		btnPelisESCRIBIR.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPelisESCRIBIR.setBounds(171, 144, 71, 25);
		contentPane.add(btnPelisESCRIBIR);

		btnUsuariosESCRIBIR = new JButton("Escribir");
		btnUsuariosESCRIBIR.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUsuariosESCRIBIR.setBounds(171, 194, 71, 25);
		contentPane.add(btnUsuariosESCRIBIR);

		btnTrabajadoresESCRIBIR = new JButton("Escribir");
		btnTrabajadoresESCRIBIR.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTrabajadoresESCRIBIR.setBounds(171, 244, 71, 25);
		contentPane.add(btnTrabajadoresESCRIBIR);

		btnPrestamosESCRIBIR = new JButton("Escribir");
		btnPrestamosESCRIBIR.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPrestamosESCRIBIR.setBounds(171, 294, 71, 25);
		contentPane.add(btnPrestamosESCRIBIR);

		// Area de texto
		scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 45, 650, 810);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(textPane);
		textPane.setContentType("text");
		textPane.setEditable(true);

		// Acciones de los botones LEER

		// Botón Libros (.txt)
		btnLibrosLEER.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesTxt infoTxt = new ControladorGesTxt();

				String textoTxt = infoTxt.mostrarTxt();
				textPane.setText(textoTxt);
			}

		});		
		
		// Escribir Nuevos Libros
		btnLibrosESCRIBIR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GesEscTxt aux = new GesEscTxt();
				String aux2 = aux.gesEscTxt();

				try {
					FileWriter fstream = new FileWriter(".\\ficheros\\Libros.txt");
					BufferedWriter out = new BufferedWriter(fstream);

					out.write(aux2);
					out.close();
				} catch (IOException ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

		});

		// Botón CDs (.docx)
		btnCDsLEER.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesDocx infoDocx = new ControladorGesDocx();

				String textoDocx = infoDocx.mostrarDocx();
				textPane.setText(textoDocx);
			}

		});

		// Botón Peliculas (.xml)
		btnPelisLEER.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesXml infoXml = new ControladorGesXml();

				String textoXml = infoXml.mostrarXml();
				textPane.setText(textoXml);
			}

		});

		// Botón Usuarios (.html)
		btnUsuariosLEER.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesHtml infoHtml = new ControladorGesHtml();
				
				String textoAMostrar = infoHtml.mostrarHtml();
				textPane.setText(textoAMostrar);
			}

		});

		//Escribir nuevos usuarios
		btnUsuariosESCRIBIR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GesEscHtml aux = new GesEscHtml();
				String aux2 = aux.gesEscHtml();				
				
			    try {
			        FileWriter fstream = new FileWriter(".\\ficheros\\Usuarios.html");
			        BufferedWriter out = new BufferedWriter(fstream);
			        
			        out.write( aux2);
			        out.close();
			    } catch (IOException ex) {
			        System.out.println("Error: "+ex.getMessage());   
			    }
			} 

		});

		// Botón Trabajadores (.odt)
		btnTrabajadoresLEER.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesOdt infoOdt = new ControladorGesOdt();

				String contenidoOdt = infoOdt.mostrarOdt();
				textPane.setText(contenidoOdt);
			}

		});		

		// Botón Prestamos (.ods)
		btnPrestamosLEER.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorGesOds infoOds = new ControladorGesOds();

				String contenidoOds = infoOds.mostrarOds();
				textPane.setText(contenidoOds);
			}

		});
	}

}
