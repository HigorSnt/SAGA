package models;

/**
 * Classe que molda um combo de produtos.
 * 
 * @author Higor Santos - 118110808.
 * 
 */
public class Combo extends Produto {
	
	/** É o fator de desconto que o combo receberá. */
	private double fator;
	
	/**
	 * Contrói um combo. 
	 * 
	 * @param nome é o nome do combo.
	 * @param descricao é a descrição do combo.
	 * @param preco é o preço normal do combo, sem o desconto.
	 * @param fator é o fator de desconto do combo.
	 */
	public Combo(String nome, String descricao, double preco, double fator) {
		super(nome, descricao, preco);
		this.fator = 1 - fator;
	}
	
	/**
	 * Altera o valor do desconto que será dado.
	 * 
	 * @param fator é o novo valor do desconto.
	 */
	public void setFator(double fator) {
		this.fator = 1 - fator;
	}
	
	@Override
	public double getPreco() {
		return this.preco * this.fator;
	}
}
