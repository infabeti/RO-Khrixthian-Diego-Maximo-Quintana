package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import controlador.ControladorGesDocx;
import controlador.ControladorGesEscDocx;
import controlador.ControladorGesEscHtml;
import controlador.ControladorGesEscOdt;
import controlador.ControladorGesEscTxt;
import controlador.ControladorGesHtml;
import controlador.ControladorGesOds;
import controlador.ControladorGesOdt;
import controlador.ControladorGesTxt;
import controlador.ControladorGesXml;
import modelo.AgregarAlDocx;
import modelo.AgregarAlHtml;
import modelo.AgregarAlOdt;
import modelo.AgregarAlTxt;
import modelo.ExpresionRegularAsterisco;
import modelo.VariablesEstaticas;

public class VentanaConsultas extends JFrame {

    public static JPanel contentPane;

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

    private JButton btnBuscar;
	private String[] aux2;

    private JScrollPane scrollPane;

    public JTextPane textPane = new JTextPane();

    private JTable tabla;
    private JTextField tfBuscar;
    private JButton btnAdministrar;
    private JLabel lblUserActivo;
    private JLabel lblUserActual;

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

	btnBuscar = new JButton("BUSCAR");
	btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 10));
	btnBuscar.setBounds(153, 423, 89, 23);
	contentPane.add(btnBuscar);

	// Area de texto
	scrollPane = new JScrollPane();
	scrollPane.setBounds(300, 45, 650, 810);
	contentPane.add(scrollPane);

	JLabel lblbusqueda = new JLabel("Busqueda:");
	lblbusqueda.setBounds(20, 372, 83, 25);
	contentPane.add(lblbusqueda);

	tfBuscar = new JTextField();
	tfBuscar.setBounds(118, 374, 124, 25);
	contentPane.add(tfBuscar);
	tfBuscar.setColumns(10);

	lblUserActivo = new JLabel("Usuario Activo:");
	lblUserActivo.setBounds(372, 11, 130, 14);
	contentPane.add(lblUserActivo);

	lblUserActual = new JLabel("");
	lblUserActual.setBounds(512, 11, 99, 14);
	contentPane.add(lblUserActual);
	lblUserActual.setText(VentanaUser.nomUsu);

	btnAdministrar = new JButton("ADMINISTRAR");
	btnAdministrar.setBounds(118, 524, 143, 23);
	contentPane.add(btnAdministrar);

	// Acciones de los botones LEER y ESCRIBIR

	// Botón Libros (.txt)
	btnLibrosLEER.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		ControladorGesTxt infoTxt = new ControladorGesTxt();
		String textoTxt = infoTxt.mostrarTxt();

		aux2 = textoTxt.split(" ");

		scrollPane.setViewportView(textPane);
		textPane.setContentType("text");
		textPane.setEditable(true);
		textPane.setText(textoTxt);

	    }

	});

	// Escribir Nuevos Libros
	btnLibrosESCRIBIR.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		AgregarAlTxt agregarTxt = new AgregarAlTxt();
		String testoTxt;
		ControladorGesEscTxt auxTxt = new ControladorGesEscTxt(agregarTxt);
		testoTxt = textPane.getText();
		auxTxt.gesEscTxt(testoTxt);
		scrollPane.setViewportView(textPane);
	    }

	});

	// Botón CDs (.docx)
	btnCDsLEER.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		ControladorGesDocx infoDocx = new ControladorGesDocx();
		String textoDocx = infoDocx.mostrarDocx();
		scrollPane.setViewportView(textPane);
		textPane.setContentType("text");
		textPane.setEditable(true);
		textPane.setText(textoDocx);
	    }

	});

	// Botón CDs (.docx)
	btnCDsESCRIBIR.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		AgregarAlDocx agregarAlDocx = new AgregarAlDocx();// kreamos una instancia del modelo para pasarsela al
								  // controlador
		ControladorGesEscDocx escritor = new ControladorGesEscDocx(agregarAlDocx);
		String textoDocx = textPane.getText();
		escritor.gesEscDocx(textoDocx);
	    }

	});

	// Botón Peliculas (.xml)
	btnPelisLEER.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		ControladorGesXml infoXml = new ControladorGesXml();
		String textoXml = infoXml.mostrarXml();
		scrollPane.setViewportView(textPane);
		textPane.setContentType("text");
		textPane.setEditable(true);
		textPane.setText(textoXml);
	    }

	});

	// Botón Usuarios (.html)
	btnUsuariosLEER.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		ControladorGesHtml infoHtml = new ControladorGesHtml();
		String textoAMostrar = infoHtml.mostrarHtml();
		scrollPane.setViewportView(textPane);
		textPane.setContentType("text");
		textPane.setEditable(true);
		textPane.setText(textoAMostrar);
	    }

	});

	// Escribir nuevos usuarios (.html)
	btnUsuariosESCRIBIR.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		AgregarAlHtml agregarAlHtml = new AgregarAlHtml();
		ControladorGesEscHtml escritor = new ControladorGesEscHtml(agregarAlHtml);
		String textoHtml = textPane.getText();
		escritor.gesEscHtml(textoHtml);
	    }

	});

	// Botón Trabajadores (.odt)
	btnTrabajadoresLEER.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		ControladorGesOdt infoOdt = new ControladorGesOdt();
		String textoOdt = infoOdt.mostrarOdt();
		scrollPane.setViewportView(textPane);
		textPane.setContentType("text");
		textPane.setEditable(true);
		textPane.setText(textoOdt);
	    }

	});

	// Escribir nuevos usuarios (.odt)
	btnTrabajadoresESCRIBIR.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		AgregarAlOdt agregarAlOdt = new AgregarAlOdt();
		ControladorGesEscOdt escritor = new ControladorGesEscOdt(agregarAlOdt);
		String textoOdt = textPane.getText();
		escritor.gesEscOdt(textoOdt);
	    }

	});

	// Botón Prestamos (.ods)
	btnPrestamosLEER.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		ControladorGesOds infoOds = new ControladorGesOds();
		String contenidoOds = infoOds.mostrarOds();
		tabla = new JTable(VariablesEstaticas.MatrizAuxiliarString, VariablesEstaticas.cabezeraMatrizAuxiliar);
		scrollPane.setViewportView(tabla);
	    }

	});

	// Botón Buscar
	btnBuscar.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		// Para pintar las palabras del texto que coincidan con la expresión regular
		ExpresionRegularAsterisco asterisco;
		int numPalabras, x, y = 0;
		String contenido, contenidoColoreado;
		StringTokenizer token;
		String[] palabras;

		asterisco = new ExpresionRegularAsterisco();
		contenido = textPane.getText();
		contenidoColoreado = "";
		token = new StringTokenizer(contenido);
		numPalabras = token.countTokens();
		palabras = new String[numPalabras];
		String palabra = "";

		// Recorrido para llenar la matriz auxiliar de palabras
		for (x = 0; x < contenido.length(); x++) {
		    if (contenido.charAt(x) == 32 && x != 0) {
			if (contenido.charAt(x - 1) == 46) { // Si acaba la frase con un punto, salto de linea
			    palabra += "\n ";
			    x += 1;
			} else { // Guardo las palabras con un espacio al final
			    palabra += (char) 32;
			}
			palabras[y] = palabra;
			palabra = "";
			y += 1;
		    } else {
			palabra += contenido.charAt(x);
		    }
		}

		textPane.setText("");

		// Recorrido para completar leer el valor true o false,
		// en función que responda a la expresión regular, y colorearlo

		for (x = 0; x < palabras.length; x++) {
		    if (asterisco.buscar(tfBuscar.getText().toString(), palabras[x].toString())) {
		    	pintarPalabra(textPane, palabras[x], Color.RED);
		    }
		    if (!asterisco.buscar(tfBuscar.getText().toString(), palabras[x].toString())) {
		    	pintarPalabra(textPane, palabras[x], Color.DARK_GRAY);
		    }
		}

	    }

	});

    }

    public void pintarPalabra(JTextPane tp, String msg, Color c) {
	StyleContext sc = StyleContext.getDefaultStyleContext();
	AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

	aset = sc.addAttribute(aset, StyleConstants.FontFamily, "arial");
	aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

	int len = tp.getDocument().getLength();
	tp.setCaretPosition(len);
	tp.setCharacterAttributes(aset, false);
	tp.replaceSelection(msg);
    }
}
