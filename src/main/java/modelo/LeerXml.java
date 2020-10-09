package modelo;

import java.io.File;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerXml {

	static DefaultListModel contenidotXml = new DefaultListModel();
	private static String textoXml = "";
	
	// Lee el .xml y lo mete en peliculas
	public static String LecturaXml() {
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		Document documento;
		NodeList listaPelis;
		Element archivo;
		NodeList hijos;
		
		contenidotXml.clear();
		try {
			// Creo una instancia de DocumentBuilderFactory
			factory = DocumentBuilderFactory.newInstance();
			// Creo un documentBuilder
			builder = factory.newDocumentBuilder();

			// Obtengo el documento, a partir del XML
			documento = builder.parse(new File(".//ficheros//videoteca.xml"));

			// Cojo todas las etiquetas coche del documento
			listaPelis = documento.getElementsByTagName("pelicula");
			archivo = documento.getDocumentElement();
			hijos = archivo.getChildNodes();
			contenidotXml.addElement("Nodo raiz: " + archivo.getNodeName());
			contenidotXml.addElement("Nodo hijo: " + hijos.item(1).getNodeName());
			contenidotXml.addElement("");

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
							contenidotXml.addElement("Pelicula: " + hijo.getNodeName() + ": " + hijo.getTextContent());
						}

					}
					contenidotXml.addElement("");
				}

			}
			textoXml = "";
			for (int i = 0; i < contenidotXml.size(); i++) {
				textoXml += contenidotXml.get(i) + "\n";
			}
			
		} catch (ParserConfigurationException | SAXException | IOException ex) {
			System.out.println(ex.getMessage());
		}

		return textoXml;
	}

}
