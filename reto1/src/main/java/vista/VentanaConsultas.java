package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import controlador.GesHtml;
import controlador.GesTxt;
import controlador.GesXml;
import modelo.LeerHtml;

import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.DefaultListModel;

public class VentanaConsultas extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnLibros;
	private JButton btnCDs;
	private JButton btnPelis;
	private JButton btnUsuarios;
	private JButton btnTrabajadores;
	private JButton btnPrestamos;
	private JScrollPane scrollPane;

	JTextPane textPane = new JTextPane();

	// Crea la ventana
	public VentanaConsultas() {
		setSize(1000, 950);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
		setResizable(false); // No resizable
		setLocationRelativeTo(null); // Ubica la ventana en el cento

		lblNewLabel = new JLabel("Libros");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(20, 48, 48, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(86, 45, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNewLabel_1 = new JLabel("CDs");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(20, 98, 48, 14);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(86, 95, 153, 20);
		contentPane.add(textField_1);

		lblNewLabel_2 = new JLabel("Peliculas");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(20, 148, 48, 14);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(86, 145, 153, 20);
		contentPane.add(textField_2);

		lblNewLabel_3 = new JLabel("Usuarios");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(20, 198, 48, 14);
		contentPane.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(86, 195, 153, 20);
		contentPane.add(textField_3);

		lblNewLabel_4 = new JLabel("Trabajadores");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(20, 248, 71, 14);
		contentPane.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(86, 245, 153, 20);
		contentPane.add(textField_4);

		lblNewLabel_5 = new JLabel("Prestamos");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(20, 298, 68, 14);
		contentPane.add(lblNewLabel_5);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(86, 295, 153, 20);
		contentPane.add(textField_5);

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
				GesTxt infoTxt = new GesTxt();

				String textoTxt = infoTxt.mostrarTxt();
				textPane.setText(textoTxt);
			}

		});

		// Botón Peliculas (.xml)
		btnPelis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GesXml infoXml = new GesXml();

				String textoXml = infoXml.mostrarXml();
				textPane.setText(textoXml);
			}

		});

		// Botón Usuarios (.html)
		btnUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GesHtml infoHtml = new GesHtml();

				String textoAMostrar = infoHtml.mostrarHtml();
				textPane.setText(textoAMostrar);
			}

		});
	}

}
