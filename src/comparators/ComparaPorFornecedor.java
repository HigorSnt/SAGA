package comparators;

import java.util.Comparator;

import models.Compra;

public class ComparaPorFornecedor implements Comparator <Compra>{

	@Override
	public int compare(Compra o1, Compra o2) {
		return o1.getFornecedor().compareTo(o2.getFornecedor());
	}
}
