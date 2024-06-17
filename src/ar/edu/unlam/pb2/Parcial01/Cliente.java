package ar.edu.unlam.pb2.Parcial01;

public class Cliente {

	private String cuit;
	private String razonSocial;
	
	public Cliente(String cuit, String razonSocial) {
		// TODO: Completar el constructor para el correcto funcionamiento del software
		this.cuit = cuit;
		this.razonSocial = razonSocial;
	}

	// TODO: Completar con los getters y setters necesarios
	
	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	
	
}
