package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LecturaXml {
	
	ArrayList peliculas;
	
	public static void main(String[] args) {
		
		ArrayList peliculas = new ArrayList();
		try {
			// Creo una instancia de DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// Creo un documentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Obtengo el documento, a partir del XML
			Document documento = builder.parse(new File(".//ficheros//videoteca.xml"));

			// Cojo todas las etiquetas coche del documento
			NodeList listaPelis = documento.getElementsByTagName("pelicula");
			Element archivo = documento.getDocumentElement();
			NodeList hijos = archivo.getChildNodes();
			peliculas.add("Nodo raiz: " + archivo.getNodeName());
//			System.out.println("Nodo raiz: " + archivo.getNodeName());
//			System.out.println("Nodo hijo: " + hijos.item(1).getNodeName());
			peliculas.add("Nodo hijo: " + hijos.item(1).getNodeName());
//			System.out.println();
			peliculas.add("");

			// Recorro las etiquetas
			for (int i = 0; i < hijos.getLength(); i++) {
				// Cojo el nodo actual
				Node nodo = listaPelis.item(i);
				// Compruebo si el nodo es un elemento
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					// Lo transformo a Element
					Element e = (Element) nodo;
					// Obtengo sus hijos
					NodeList hijos2 = e.getChildNodes();
					// Recorro sus hijos
					for (int j = 0; j < hijos2.getLength(); j++) {
						// Obtengo al hijo actual
						Node hijo = hijos2.item(j);
						// Compruebo si es un nodo
						if (hijo.getNodeType() == Node.ELEMENT_NODE) {
							// Muestro el contenido
//							System.out.println("Pelicula: " + hijo.getNodeName() + ": " + hijo.getTextContent());
							peliculas.add("Pelicula: " + hijo.getNodeName() + ": " + hijo.getTextContent());
						}

					}
					peliculas.add("");
//					System.out.println("");
				}

			}

		} catch (ParserConfigurationException | SAXException | IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}	
	//FUNCIÓN QUE DEVUELVE LAS PELICULAS
	public ArrayList getPeliculas() {
		return peliculas;
	}
	
}
