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

import configuration.ConfigurationLoader;
import idao.ICoches;
import objetos.Accesory;
import objetos.Engine;
import objetos.Model;

public class LectorCochesConfig  implements ICoches{
	private static String m_id, m_name, m_descript, m_imageName, e_id,  e_name, e_descript, e_imageName,  a_id, a_name, a_descript, a_imageName ,m_aux, e_aux, a_aux , models_a;
	private static String m_price;
	String e_price;
	String a_price;
	private static String [] models_available;
	
	private static ArrayList<Model> models;
	private static ArrayList<Engine> engines;
	private static ArrayList<Accesory> accesories;
	public ConfigurationLoader confi;
	
	public LectorCochesConfig() {
		confi = ConfigurationLoader.getConfiguration();
		File f = new File(confi.getCar_configuration_path() + confi.getCar_configuration_file_name());
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		models = new ArrayList<Model>();
		engines = new ArrayList<Engine>();
		accesories = new ArrayList<Accesory>();
		
		
		try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(f);
		
		//Esto es para leer los modelos del XML: Models
		
		NodeList nList = ((Document) doc).getElementsByTagName("model");
		
		for (int i = 0; i < nList.getLength(); i++) {

			org.w3c.dom.Node nNode =nList.item(i);
					
			
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Node eElement = nNode;

				
				m_id = ((Element) eElement).getElementsByTagName("id").item(0).getTextContent();
				m_name=  ((Element) eElement).getElementsByTagName("name").item(0).getTextContent();
				m_descript = ((Element) eElement).getElementsByTagName("descript").item(0).getTextContent();
				m_imageName = ((Element) eElement).getElementsByTagName("image_name").item(0).getTextContent();
				m_price = ((Element) eElement).getElementsByTagName("price").item(0).getTextContent();
				
				//m_price = Integer.parseInt(m_aux);
				
				
				models.add(new Model(m_id, m_name, m_descript, m_imageName,m_price));
				
			}
		}
		
		//Esto es para leer los motores del XML: Engines
		
		NodeList nList2 = ((Document) doc).getElementsByTagName("engine");
		
		for (int j = 0; j < nList2.getLength(); j++) {

			org.w3c.dom.Node nNode2 =nList2.item(j);
					
			
					
			if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

				Node eElement2 = nNode2;

				
				e_id = ((Element) eElement2).getElementsByTagName("id").item(0).getTextContent();
				e_name=  ((Element) eElement2).getElementsByTagName("name").item(0).getTextContent();
				e_descript = ((Element) eElement2).getElementsByTagName("descript").item(0).getTextContent();
				e_imageName = ((Element) eElement2).getElementsByTagName("image_name").item(0).getTextContent();
				e_price = ((Element) eElement2).getElementsByTagName("price").item(0).getTextContent();
				
				//e_price = Integer.parseInt(e_aux);
				
				
				engines.add(new Engine(e_id, e_name, e_descript, e_imageName, e_price));
				
			}
		}
		
		//Esto es para leer los accesorios del XML: Accesories
		
				NodeList nList3 = ((Document) doc).getElementsByTagName("accesory");
				
				for (int k = 0; k < nList3.getLength(); k++) {

					org.w3c.dom.Node nNode3 =nList3.item(k);
							
					
							
					if (nNode3.getNodeType() == Node.ELEMENT_NODE) {

						Node eElement3 = nNode3;

						
						a_id = ((Element) eElement3).getElementsByTagName("id").item(0).getTextContent();
						a_name=  ((Element) eElement3).getElementsByTagName("name").item(0).getTextContent();
						a_descript = ((Element) eElement3).getElementsByTagName("descript").item(0).getTextContent();
						a_imageName = ((Element) eElement3).getElementsByTagName("image_name").item(0).getTextContent();
						a_price = ((Element) eElement3).getElementsByTagName("price").item(0).getTextContent();
						
						//a_price = Integer.parseInt(a_aux);
						
						models_a = ((Element) eElement3).getElementsByTagName("model_available").item(0).getTextContent();
						
						models_available = models_a.split(",");
						
						accesories.add(new Accesory(a_id, a_name, a_descript, a_imageName, a_price, models_available));
						
					}
				}
		
		
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Model> getModelAll() {
		// TODO Auto-generated method stub
		return models;
	}

	
	@Override
	public ArrayList<Engine> getEngineAll() {
		// TODO Auto-generated method stub
		return engines;
	}

	@Override
	public ArrayList<Accesory> getAccesoryAll() {
		// TODO Auto-generated method stub
		return accesories;
	}
	
	
	@Override
	public void addModel(Model Model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEngine(Engine Engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAccesory(Accesory Accesory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarModel(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarModel(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}

}
