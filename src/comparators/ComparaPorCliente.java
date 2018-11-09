package comparators;

import java.util.Comparator;

import models.Compra;

public class ComparaPorCliente implements Comparator <Compra> {

	@Override
	public int compare(Compra o1, Compra o2) {
		return o1.getCliente().compareTo(o2.getCliente());
	}
	
}
