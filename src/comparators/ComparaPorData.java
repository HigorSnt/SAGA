package comparators;

import java.util.Comparator;

import models.Compra;

public class ComparaPorData implements Comparator<Compra>{
	
	public int compare(Compra o1, Compra o2) {
		return o1.getData().compareTo(o2.getData());
	}	
}