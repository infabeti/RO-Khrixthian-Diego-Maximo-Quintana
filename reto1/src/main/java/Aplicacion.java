import java.io.IOException;
import java.util.ArrayList;

import modelo.LeerHtml;
import modelo.para_txt;
import vista.VentanaBienvenida;
import vista.VentanaUser;

public class Aplicacion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new VentanaBienvenida();
		new VentanaUser().setVisible(true);
		
		//para ejecutar la lectura del txt  lo de abajo
		para_txt aaa = new para_txt();		
		try {
			ArrayList array = aaa.leertxt();
			for(int i = 0; i> array.size(); i++) {
				System.out.println(array);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
