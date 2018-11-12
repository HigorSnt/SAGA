package comparators;

import java.util.Comparator;

import models.Compra;

/**
 * Define a ordenação de cada compra por meio do nome do cliente.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class ComparaPorCliente implements Comparator <Compra> {

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getCliente().equals(o2.getCliente())) {
			String s1 = o1.getFornecedor() + " " + o1.getDescProd() + " " + o1.getData();
			String s2 = o2.getFornecedor() + " " + o2.getDescProd() + " " + o2.getData();
			return s1.compareTo(s2);
		}
		
		return o1.getCliente().compareTo(o2.getCliente());
	}
	
}
