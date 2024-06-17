package ar.edu.unlam.pb2.Parcial01;

public class Producto extends Item {
	
	private Integer puntoDeReposicion;
	
	public Producto(Integer codigo, String nombre, Double precio, Integer puntoDeReposicion) {
		// TODO: Completar el constructor para el correcto funcionamiento del software
		super(codigo, nombre, precio);
		this.puntoDeReposicion = puntoDeReposicion;
	}

	// TODO: Completar con los getters y setters necesarios
	

	public Integer getPuntoDeReposicion() {
		return puntoDeReposicion;
	}

	public void setPuntoDeReposicion(Integer puntoDeReposicion) {
		this.puntoDeReposicion = puntoDeReposicion;
	}
	
	
	
}
