package main;

import LectorXML.LectorCochesConfig;
import LectorXML.LectorXML;
import idao.ICoches;

public class CochesTest {

	public static void main(String[] args) {

		ICoches gestorCars = new LectorCochesConfig();
		System.out.println("IMPRIMIMOS MODELOS");
		System.out.println(gestorCars.getModelAll().get(0).getImage_name());
		
		System.out.println("IMPRIMIMOS MOTORES");
		gestorCars.getEngineAll().forEach(System.out::println);
		
		
		System.out.println("IMPRIMIMOS ACCESORIOS");
		gestorCars.getAccesoryAll().forEach(System.out::println);
		
		
	}
}
