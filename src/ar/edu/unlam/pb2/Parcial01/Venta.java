package ar.edu.unlam.pb2.Parcial01;

import java.util.HashMap;
import java.util.Map;

public class Venta {

	private String codigo;
	private Cliente cliente;
	private Vendedor vendedor;
	private Map<Vendible, Integer> renglones;

	public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
		// TODO: Completar el constructor para el correcto funcionamiento del software
		this.codigo = codigo;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.renglones = new HashMap<>();
	}
	
	// TODO: Completar con los getters y setters necesarios
	
		public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Map<Vendible, Integer> getRenglones() {
		return renglones;
	}


	public void agregarRenglon(Vendible vendible, Integer cantidad) {
		// TODO: Agregar el vendible a la venta 
		
		renglones.put(vendible, cantidad);
		
	}
	

	@Override
	public String toString() {

		return "Venta: " + codigo + "\n" + "Cliente" + cliente + "\n" + "Vendedor" + vendedor + "\n";
	}

}
