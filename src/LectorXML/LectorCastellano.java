package LectorXML;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import interfaces.Login;

public class LectorCastellano {
	

	 public static String[] leer() {
		 Scanner sc;
		 String[] lineaseparadas = null;
	      try {
	    	  File  castellano= new File("src/LectorXML/castellano_cv.txt");
	    	  sc= new Scanner(castellano);
	    	 
	    	  
	         
	          String linea=sc.nextLine();
	          lineaseparadas=linea.split(",");
	        
	          
	       }
	      	
	       catch(Exception e){
	          e.printStackTrace();
	       }
	      return lineaseparadas;
     }
	

}
