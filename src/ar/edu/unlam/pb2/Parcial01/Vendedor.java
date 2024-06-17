package ar.edu.unlam.pb2.Parcial01;

import java.util.Objects;

public class Vendedor {

	private String dni;
	private String nombre;
	private boolean deLicencia;
	
	public Vendedor (String dni, String nombre) {
		// TODO: Completar el constructor para el correcto funcionamiento del software
		// Por defecto, los vendedores no estan de licencia
		this.dni = dni;
		this.nombre = nombre;
	}
	
	// TODO: Completar con los getters y setters necesarios
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isDeLicencia() {
		return deLicencia;
	}

	public void setDeLicencia(boolean deLicencia) {
		this.deLicencia = deLicencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
	
}
