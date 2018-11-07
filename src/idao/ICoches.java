package idao;

import java.util.ArrayList;

import objetos.Accesory;
import objetos.Engine;
import objetos.Model;

public interface ICoches {

	ArrayList<Model> getModelAll();
	ArrayList<Engine> getEngineAll();
	ArrayList<Accesory> getAccesoryAll();
	void addModel(Model model);
	void addEngine(Engine engine);
	void addAccesory(Accesory accesory);
	
	void actualizarModel(Model model);
	void actualizarEngine(Engine engine);
	void actualizarAccesory(Accesory accesory);
	
	void eliminarModel(Model model);
	void eliminarEngine(Engine engine);
	void eliminarAccesory(Accesory accesory);
}
