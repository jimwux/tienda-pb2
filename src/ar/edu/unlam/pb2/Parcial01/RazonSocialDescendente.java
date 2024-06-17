package ar.edu.unlam.pb2.Parcial01;

import java.util.Comparator;

public class RazonSocialDescendente implements Comparator<Cliente> {

	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o2.getRazonSocial().compareTo(o1.getRazonSocial());
	}

}
