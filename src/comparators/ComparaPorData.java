package comparators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import models.Compra;

/**
 * Define a ordenação de cada compra por meio da data da compra.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class ComparaPorData implements Comparator<Compra>{
	
	private Date data1;
	private Date data2;
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public int compare(Compra o1, Compra o2) {
		try {
			this.data1 = this.sdf1.parse(o1.getData());
			this.data2 = this.sdf2.parse(o2.getData());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (this.data1.equals(this.data2)) {
			String s1 = o1.getCliente() + " " + o1.getFornecedor() + " " + o1.getDescProd();
			String s2 = o2.getCliente() + " " + o2.getFornecedor() + " " + o2.getDescProd();
			return s1.compareTo(s2);
		}
		
		return this.data1.compareTo(this.data2);
	}	
}