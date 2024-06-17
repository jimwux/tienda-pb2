package ar.edu.unlam.pb2.Parcial01;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TiendaTest {

	/**
	 * Resolver los siguientes tests
	 */
	
	private Tienda tienda;
	
	@Before
	public void init() {
		this.tienda = new Tienda ("35416546416", "Tienda");
	}
		

	@Test (expected = VendedorDeLicenciaException.class)
	public void queAlIntentarAgregarUnaVentaParaUnVendedorDeLicenciaSeLanceUnaVendedorDeLicenciaException() throws Exception {
		
		String codigo = "v1111";
		Cliente cliente = new Cliente ("12335163", "BAPRO");
		Vendedor vendedor = new Vendedor ("45070730", "Jimena");
		vendedor.setDeLicencia(true);
		
		Venta venta = new Venta (codigo, cliente, vendedor);
		
		this.tienda.agregarVenta(venta);	
		
	}

	@Test (expected = VendibleInexistenteException.class)
	public void queAlIntentarAgregarUnVendibleInexistenteAUnaVentaSeLanceUnaVendibleInexistenteException() throws Exception {
		
		String codigo = "v1111";
		Cliente cliente = new Cliente ("12335163", "BAPRO");
		Vendedor vendedor = new Vendedor ("45070730", "Jimena");		
		Venta venta = new Venta (codigo, cliente, vendedor);
		
		this.tienda.agregarVenta(venta);	
		
		Producto producto = new Producto (1, "Peluche", 500.0, 5);
		this.tienda.agregarProductoAVenta(codigo, producto);
		
	}

	@Test
	public void queSePuedaObtenerUnaListaDeProductosCuyoStockEsMenorOIgualAlPuntoDeReposicion() {
		
		Producto producto1 = new Producto (1, "Peluche", 500.0, 5);
		Producto producto2 = new Producto (3, "Peluche", 500.0, 8);
		Producto producto3 = new Producto (2, "Peluche", 500.0, 2);
		Producto producto4 = new Producto (4, "Peluche", 500.0, 6);
		
		this.tienda.agregarProducto(producto1, 10);
		this.tienda.agregarProducto(producto2, 8);
		this.tienda.agregarProducto(producto3, 5);
		this.tienda.agregarProducto(producto4, 3);
		
		List<Producto> productosObtenidos = this.tienda.obtenerProductosCuyoStockEsMenorOIgualAlPuntoDeReposicion();
		
		Integer iterador = 0;
		for (Producto producto : productosObtenidos) {
			switch (iterador) {
			case 0:
				assertEquals(producto, producto2);
				break;
			case 1:
				assertEquals(producto, producto4);
				break;	
			} iterador++;
		}

		
	}

	@Test
	public void queSePuedaObtenerUnaListaDeClientesOrdenadosPorRazonSocialDescendente() {
		
		Cliente cliente1 = new Cliente ("12335163", "BAPRO");
		Cliente cliente2 = new Cliente ("12231653", "ARBA");
		Cliente cliente3 = new Cliente ("12368913", "UNLAM");
		Cliente cliente4 = new Cliente ("12489499", "PFA");

		this.tienda.agregarCliente(cliente1);
		this.tienda.agregarCliente(cliente2);
		this.tienda.agregarCliente(cliente3);
		this.tienda.agregarCliente(cliente4);
		
		List<Cliente> clientesObtenidos = this.tienda.obtenerClientesOrdenadosPorRazonSocialDescendente();
		
		Integer iterador = 0;
		for (Cliente cliente : clientesObtenidos) {
			switch (iterador) {
			case 0:
				assertEquals(cliente, cliente3);
				break;
			case 1:
				assertEquals(cliente, cliente4);
				break;	
			case 3:
				assertEquals(cliente, cliente2);
				break;
			case 4:
				assertEquals(cliente, cliente1);
				break;	
			} iterador++;
		}	
		
	}

	@Test
	public void queSePuedaObtenerUnMapaDeVentasRealizadasPorCadaVendedor() throws Exception {
		// TODO: usar como key el vendedor y Set<Venta> para las ventas
		
		Vendedor vendedor1 = new Vendedor ("27263694", "Micaela");		
		Vendedor vendedor2 = new Vendedor ("45070730", "Jimena");		

		Cliente cliente1 = new Cliente ("12335163", "BAPRO");
		Venta venta1 = new Venta ("v111", cliente1, vendedor1);		
		this.tienda.agregarVenta(venta1);	

		Cliente cliente2 = new Cliente ("12335163", "BAPRO");	
		Venta venta2 = new Venta ("v112", cliente2, vendedor1);	
		this.tienda.agregarVenta(venta2);	

		Cliente cliente3 = new Cliente ("12335163", "BAPRO");
		Venta venta3 = new Venta ("v113", cliente3, vendedor2);		
		this.tienda.agregarVenta(venta3);	
		
		Integer iterador = 0;
		
		for (Map.Entry<Vendedor, Set<Venta>> entry : this.tienda.obtenerVentasPorVendedor().entrySet()) {
			
			Vendedor vendedorActual = entry.getKey();
			Set<Venta> ventasDelVendedor = entry.getValue();
			
			switch (iterador) {		
			case 0:
				assertEquals(vendedorActual, vendedor1);
				assertEquals(2, ventasDelVendedor.size());
				break;
			case 1:
				assertEquals(vendedorActual, vendedor2);
				assertEquals(1, ventasDelVendedor.size());
				break;	
			} iterador++;
		}
		
	}

	@Test
	public void queSePuedaObtenerElTotalDeVentasDeServicios() throws Exception {
		
		Vendedor vendedor = new Vendedor ("27263694", "Micaela");			
		Cliente cliente = new Cliente ("12335163", "BAPRO");

		Venta venta1 = new Venta ("v111", cliente, vendedor);		
		this.tienda.agregarVenta(venta1);	

		Venta venta2 = new Venta ("v112", cliente, vendedor);	
		this.tienda.agregarVenta(venta2);			

		Servicio servicio1 = new Servicio (1, "Limpieza", 750.0, "19/02/2024", "28/02/2024");
		this.tienda.agregarServicio(servicio1);
		
		Servicio servicio2 = new Servicio (2, "Cocina", 890.0, "16/02/2024", "16/03/2024");
		this.tienda.agregarServicio(servicio2);
		
		Producto producto1 = new Producto (1, "Peluche", 500.0, 5);
		this.tienda.agregarProducto(producto1, 10);
		
		this.tienda.agregarServicioAVenta("v111", servicio1);
		this.tienda.agregarProductoAVenta("v111", producto1);
		this.tienda.agregarServicioAVenta("v112", servicio2);

		Double totalDeVentasDeServicios = this.tienda.obtenerTotalDeVentasDeServicios();
		Double totalEsperado = 750.0 + 890.0;
		
		assertEquals(totalEsperado, totalDeVentasDeServicios);
		
	}

	@Test
	public void queAlRealizarLaVentaDeUnProductoElStockSeActualiceCorrectamente() throws Exception {
		
		Vendedor vendedor = new Vendedor ("27263694", "Micaela");			
		Cliente cliente = new Cliente ("12335163", "BAPRO");

		Venta venta1 = new Venta ("v111", cliente, vendedor);		
		this.tienda.agregarVenta(venta1);	

		Producto producto1 = new Producto (1, "Peluche", 500.0, 5);
		this.tienda.agregarProducto(producto1, 10);
		
		this.tienda.agregarProductoAVenta("v111", producto1);
		
		Integer stockNuevo = this.tienda.getStock(producto1);
		Integer stockEsperado = 9;
		
		assertEquals(stockEsperado, stockNuevo);
		
		
	}
}
