package datos;

import java.util.Date;

public class Cliente {
	private String nombre, primer_apellido, segundo_apellido, direccion, email, genero;
	private Date fecha;

	public Cliente(String nombre, String primer_apellido, String segundo_apellido, String direccion, String email,
			String genero, Date fecha) {
		this.nombre = nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.direccion = direccion;
		this.email = email;
		this.genero = genero;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getEmail() {
		return email;
	}

	public String getGenero() {
		return genero;
	}

	public Date getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "[DATOS CLIENTE] " + nombre + "," + primer_apellido + "," + segundo_apellido + "," + direccion + ","
				+ email + "," + genero + "," + fecha;
	}
}