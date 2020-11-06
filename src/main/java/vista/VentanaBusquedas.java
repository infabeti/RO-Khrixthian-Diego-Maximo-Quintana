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
	private String palabraBuscar;
	private String[] aux2;

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
		setResizable(false); // No resizable
		setLocationRelativeTo(null); // Ubica la ventana en el cento
		setTitle("Busquedas");

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaConsultas aux = new VentanaConsultas();
				String cogerTexto = aux.devTexto();
				palabraBuscar = tfinput.getText();
				marcarPalabra(cogerTexto, palabraBuscar);
			}

		});
	}

	public void marcarPalabra(String x, String y) {
		String palabra = null;
		aux2 = x.split(" ");
		char c = (char) 244;
		for (int i = 0; i < aux2.length; i++) {
			if (aux2[i].equals(y)) {
				palabra = aux2[i];
				palabra = c + palabra;
				aux2[i] = palabra;
			}
		}
		System.out.println(palabra);
	}

	public String[] devolArray() {
		return aux2;
	}

	public String devolPalabra() {
		return palabraBuscar;
	}
}
