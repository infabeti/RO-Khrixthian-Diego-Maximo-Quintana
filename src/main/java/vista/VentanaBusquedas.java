package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaBusquedas extends JFrame {
	private JPanel contentPane;
	private JTextField tfinput;
	private JButton btnNewButton;
	private String cogerTexto;

	public VentanaBusquedas() {
		setSize(300, 150);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("Busqueda:");
		lbl1.setBounds(21, 11, 72, 14);
		contentPane.add(lbl1);

		tfinput = new JTextField();
		tfinput.setBounds(85, 8, 168, 20);
		contentPane.add(tfinput);
		tfinput.setColumns(10);

		btnNewButton = new JButton("BUSCAR");
		btnNewButton.setBounds(158, 56, 89, 23);
		contentPane.add(btnNewButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
		setResizable(false); // No resizable
		setLocationRelativeTo(null); // Ubica la ventana en el cento
		setTitle("Busquedas");

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaConsultas.textPane.getText();

			}

		});
	}
}
