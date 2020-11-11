package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class VentanaBusquedas extends JFrame {
	private JPanel contentPane;
	private JTextField tfinput;
	private JButton btnNewButton;
	private String palabraBuscar;
	private String[] aux2;
	String coloreadoTxt = "";

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
				aux.textPane.setText("");
				pintarCambios();
			}

		});
	}

	public void marcarPalabra(String x, String y) {
		String palabra = null;
		aux2 = x.split(" ");
		char c = (char) 244;
		for (int i = 0; i < aux2.length - 1; i++) {
			// System.out.print(aux2[i]);
			if (aux2[i].equals(y)) {
				palabra = aux2[i];
				// palabra = c + palabra;
				// aux2[i] = palabra;
			}
		}
		for (int i = 0; i < aux2.length - 1; i++) {
			coloreadoTxt += aux2[i] + " ";
		}
	}

	public void pintarCambios() {
		Color c = Color.red;
		String msg = null;
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
		aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

		for (int i = 0; i < aux2.length - 1; i++) {
			if (aux2[i].equals(palabraBuscar)) {
				int len = VentanaConsultas.textPane.getDocument().getLength();
				VentanaConsultas.textPane.setCaretPosition(len);
				VentanaConsultas.textPane.setCharacterAttributes(aset, false);
				VentanaConsultas.textPane.replaceSelection(msg);
			} else {
				VentanaConsultas.textPane.replaceSelection(aux2[i]);
			}
		}
	}
}
