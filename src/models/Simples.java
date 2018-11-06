package models;

/**
 * Classe que molda um objeto do tipo Produto.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class Simples extends Produto {
	
	/**
	 * Constrói um produto.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param preco é o preço do produto.
	 */
	public Simples(String nome, String descricao, double preco){
		super(nome, descricao, preco);
	}
	
	/**
	 * Atualiza o preço do produto.
	 * 
	 * @param preco é o preço de um determinado produto.
	 */
	public void setPreco(double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		
		this.preco = preco;
	}

}
