package main;

import configuration.Configuration;
import configuration.ConfigurationLoader;
import interfaces.Login;

public class Main {

	public static void main(String[] args) {
		ConfigurationLoader confi=ConfigurationLoader.getConfiguration();
		Login.main(null);
		
	}

}
