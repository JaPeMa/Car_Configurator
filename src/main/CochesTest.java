package main;

import java.util.Arrays;

import LectorXML.LectorCochesConfig;
import LectorXML.LectorXML;
import idao.ICoches;
import objetos.Accesory;

public class CochesTest {

	public static void main(String[] args) {

		ICoches gestorCars = new LectorCochesConfig();
		System.out.println("IMPRIMIMOS MODELOS");
		System.out.println(gestorCars.getModelAll().get(0).getImage_name());
		
		System.out.println("IMPRIMIMOS MOTORES");
		gestorCars.getEngineAll().forEach(System.out::println);
		
		
		System.out.println("IMPRIMIMOS ACCESORIOS");
		for(Accesory accesory: gestorCars.getAccesoryAll()) {
			System.out.println(Arrays.toString(accesory.getModel_available()));
		}
		
		
	}
}
