package comparators;

import java.util.Comparator;

import models.Compra;

public class ComparaPorFornecedor implements Comparator <Compra>{

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getFornecedor().equals(o2.getFornecedor())) {
			String s1 = o1.getCliente() + " " + o1.getDescProd() + " " + o1.getData();
			String s2 = o2.getCliente() + " " + o2.getDescProd() + " " + o2.getData();
			return s1.compareTo(s2);
		}
		
		return o1.getFornecedor().compareTo(o2.getFornecedor());
	}
}
