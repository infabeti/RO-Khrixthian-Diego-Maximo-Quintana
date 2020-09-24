package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class VentanaConsultas extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	// Crea la ventana 
	public VentanaConsultas() {
		setSize(700, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
		setResizable(false); // No resizable
		setLocationRelativeTo(null); // Ubica la ventana en el cento

		
		JLabel lblNewLabel = new JLabel("Archivo");
		lblNewLabel.setBounds(40, 48, 48, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(86, 45, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Leer");
		btnNewButton.setBounds(260, 44, 60, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(365, 45, 282, 381);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setContentType("text");
		
		JLabel lblNewLabel_1 = new JLabel("Archivo");
		lblNewLabel_1.setBounds(40, 98, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(86, 95, 153, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Leer");
		btnNewButton_1.setBounds(260, 94, 60, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Archivo");
		lblNewLabel_2.setBounds(40, 148, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(86, 145, 153, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton_2 = new JButton("Leer");
		btnNewButton_2.setBounds(260, 144, 60, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Archivo");
		lblNewLabel_3.setBounds(40, 198, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(86, 195, 153, 20);
		contentPane.add(textField_3);
		
		JButton btnNewButton_3 = new JButton("Leer");
		btnNewButton_3.setBounds(260, 194, 60, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Archivo");
		lblNewLabel_4.setBounds(40, 248, 48, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(86, 245, 153, 20);
		contentPane.add(textField_4);
		
		JButton btnNewButton_4 = new JButton("Leer");
		btnNewButton_4.setBounds(260, 244, 60, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("Archivo");
		lblNewLabel_5.setBounds(40, 298, 48, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(86, 295, 153, 20);
		contentPane.add(textField_5);
		
		JButton btnNewButton_5 = new JButton("Leer");
		btnNewButton_5.setBounds(260, 294, 60, 23);
		contentPane.add(btnNewButton_5);
	}
}
