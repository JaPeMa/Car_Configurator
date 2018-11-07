package objetos;

public class Model {

	private String id;
	private String name;
	private String descript;
	private String image_name;
	private String price;
	
	//Constructor de objeto Modelo
	public Model(String id, String name, String descript, String image_name, String m_price) {
		super();
		this.id = id;
		this.name = name;
		this.descript = descript;
		this.image_name = image_name;
		this.price = m_price;
	}

	
	//Setters y getters de los atributos
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


	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", descript=" + descript + ", image_name=" + image_name
				+ ", price=" + price + "]";
	}
	
	
	
	
	
	
	
	
	
}
