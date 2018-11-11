package comparators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import models.Compra;

public class ComparaPorData implements Comparator<Compra>{
	
	private Date data1;
	private Date data2;
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	public int compare(Compra o1, Compra o2) {
		try {
			data1 = sdf1.parse(o1.getData());
			data2 = sdf2.parse(o2.getData());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (data1.equals(data2)) {
			String s1 = o1.getCliente() + " " + o1.getFornecedor() + " " + o1.getDescProd();
			String s2 = o2.getCliente() + " " + o2.getFornecedor() + " " + o2.getDescProd();
			return s1.compareTo(s2);
		}
		
		return data1.compareTo(data2);
	}	
}