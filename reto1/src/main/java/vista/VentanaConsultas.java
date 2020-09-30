package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import controlador.GesXml;

import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
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
	JTextPane textPane = new JTextPane();
	String texto ="";
	private final Action action = new Acceder();

	// Crea la ventana
	public VentanaConsultas() {
		setSize(700, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
		setResizable(false); // No resizable
		setLocationRelativeTo(null); // Ubica la ventana en el cento

		JLabel lblNewLabel = new JLabel("Libros");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(20, 48, 48, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(86, 45, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CDs");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(20, 98, 48, 14);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(86, 95, 153, 20);
		contentPane.add(textField_1);

		JLabel lblNewLabel_2 = new JLabel("Peliculas");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(20, 148, 48, 14);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(86, 145, 153, 20);
		contentPane.add(textField_2);

		JLabel lblNewLabel_3 = new JLabel("Usuarios");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(20, 198, 48, 14);
		contentPane.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(86, 195, 153, 20);
		contentPane.add(textField_3);

		JLabel lblNewLabel_4 = new JLabel("Trabajadores");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(20, 248, 71, 14);
		contentPane.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(86, 245, 153, 20);
		contentPane.add(textField_4);

		JLabel lblNewLabel_5 = new JLabel("Prestamos");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(20, 298, 68, 14);
		contentPane.add(lblNewLabel_5);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(86, 295, 153, 20);
		contentPane.add(textField_5);

		JButton btnLibros = new JButton("Acceder");
		btnLibros.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLibros.setBounds(260, 44, 71, 23);
		contentPane.add(btnLibros);

		JButton btnCDs = new JButton("Acceder");
		btnCDs.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCDs.setBounds(260, 94, 71, 23);
		contentPane.add(btnCDs);

		JButton btnPelis = new JButton("Acceder");
		btnPelis.setAction(action);
		btnPelis.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPelis.setBounds(260, 144, 71, 23);
		contentPane.add(btnPelis);

		JButton btnUsuarios = new JButton("Acceder");
//		btnUsuarios.setAction(action);
		btnUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUsuarios.setBounds(260, 194, 71, 23);
		contentPane.add(btnUsuarios);

		JButton btnTrabajadores = new JButton("Acceder");
		btnTrabajadores.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTrabajadores.setBounds(260, 244, 71, 23);
		contentPane.add(btnTrabajadores);

		JButton btnPrestamos = new JButton("Acceder");
		btnPrestamos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPrestamos.setBounds(260, 294, 71, 23);
		contentPane.add(btnPrestamos);

		// Area de texto
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(365, 45, 282, 381);
		contentPane.add(scrollPane);

//		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setContentType("text");
		textPane.setText(texto);
	}
	
	private class Acceder extends AbstractAction {
		
	
		public Acceder() {
			putValue(NAME, "Acceder");
			putValue(SHORT_DESCRIPTION, "Accede a las peliculas");
		}
		public void actionPerformed(ActionEvent e) {
			textPane.setText("");
			controlador.GesXml pelis = new GesXml();
			
			DefaultListModel peliculas = pelis.mostrarPeliculas();
			

			for (int i=0;i<peliculas.size();i++) {
			texto += peliculas.get(i) + "\n";
				
			}
			textPane.setText(texto);
		}
	}
}
