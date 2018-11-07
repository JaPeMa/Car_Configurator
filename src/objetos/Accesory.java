package objetos;

import java.util.Arrays;

public class Accesory {

	private String id;
	private String name;
	private String descript;
	private String image_name;
	private String price;
	private String[] model_available;

	
	
	// Constructor de objeto Modelo
	public Accesory(String id, String name, String descript, String image_name, String a_price,
			String[] model_available) {
		super();
		this.id = id;
		this.name = name;
		this.descript = descript;
		this.image_name = image_name;
		this.price = a_price;
		this.model_available = model_available;
	}

	// Setters y getters de los atributos
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String[] getModel_available() {
		return model_available;
	}

	public void setModel_available(String[] model_available) {
		this.model_available = model_available;
	}

	@Override
	public String toString() {
		return "Accesory [id=" + id + ", name=" + name + ", descript=" + descript + ", image_name=" + image_name
				+ ", price=" + price + ", model_available=" + Arrays.toString(model_available) + "]";
	}

}
