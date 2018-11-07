package LectorXML;

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

import configuration.Configuration;
import objetos.Accesory;
import objetos.Engine;
import objetos.Model;

public class LectorXML {
	private static String m_id, m_name, m_descript, m_imageName, e_id,  e_name, e_descript, e_imageName,  a_id, a_name, a_descript, a_imageName ,m_aux, e_aux, a_aux , models_a;
	private static String m_price;
	String e_price;
	String a_price;
	private static String [] models_available;
	
	private static ArrayList<Model> models;
	private static ArrayList<Engine> engines;
	private static ArrayList<Accesory> accesories;

	
	public Configuration getConfiguration() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Configuration conf = new Configuration();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("cv_config.xml"));

			doc.getDocumentElement().normalize();
			String car_conf_path = doc.getElementsByTagName("car_configuration_path").item(0).getTextContent(), 
					car_conf_file_name = doc.getElementsByTagName("car_configuration_file_name").item(0).getTextContent(),
					emp_list[] = doc.getElementsByTagName("employee_list").item(0).getTextContent().split(","),
					emp_password[] = doc.getElementsByTagName("employee_password").item(0).getTextContent().split(","),
					specifications_file_path = doc.getElementsByTagName("specifications_file_path").item(0).getTextContent(),
					version = doc.getElementsByTagName("version").item(0).getTextContent();

			boolean emp = doc.getElementsByTagName("employee_version").item(0).getTextContent().equalsIgnoreCase("true");
			
			
			conf = new Configuration(car_conf_path, car_conf_file_name, 
					specifications_file_path, emp_list, emp_password, version, emp);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return conf;

	}

}
