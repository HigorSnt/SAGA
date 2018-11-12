package models;

/**
 * Classe que cria uma compra para um cliente com um fornecedor.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class Compra {
	
	/** O nome do fornecedor que teve o produto comprado. */
	private String fornecedor;
	/** O nome do cliente que possui a compra */
	private String cliente;
	/** O nome do produto que foi comprado. */
	private String nomeProd;
	/** A descrição do produto que foi comprado. */
	private String descProd;
	/** O preço da compra. */
	private double preco;
	/** A data que a compra foi realizada. */
	private String data;
	
	/**
	 * Contrói uma compra.
	 * 
	 * @param fornecedor é o nome do fornecedor que teve o produto comprado.
	 * @param cliente é o nome do cliente que realizou a compra.
	 * @param nomeProd é o nome do produto que foi comprado.
	 * @param descProd é a descrição do produto que foi comprado.
	 * @param data é a data que a compra foi realizada.
	 * @param preco é o preço da compra.
	 */
	public Compra(String fornecedor, String cliente, String nomeProd, String descProd, String data, double preco) {
		this.fornecedor = fornecedor;
		this.cliente = cliente;
		this.nomeProd = nomeProd;
		this.descProd = descProd;
		this.data = data;
		this.preco = preco;
	}
	
	/**
	 * Exibe o nome do cliente.
	 * 
	 * @return Retorna o nome do cliente.
	 */
	public String getCliente() {
		return cliente;
	}
	
	/**
	 * Exibe o nome do fornecedor.
	 * 
	 * @return Retorna o nome do fornecedor.
	 */
	public String getFornecedor() {
		return fornecedor;
	}
	
	/**
	 * Exibe o preço da compra.
	 * 
	 * @return Retorna o preço da compra.
	 */
	public double getPreco() {
		return preco;
	}
	
	/**
	 * Exibe a data da compra.
	 * 
	 * @return Retorna a data da compra.
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * Exibe o nome do produto.
	 * 
	 * @return Retorna o nome do produto que foi comprado.
	 */
	public String getNomeProd() {
		return this.nomeProd;
	}
	
	/**
	 * Exibe a descrição do produto
	 * 
	 * @return Retorna a descrição do produto que foi comprado.
	 */
	public String getDescProd() {
		return descProd;
	}
	
	@Override
	public String toString() {
		return this.nomeProd + " - " + this.data.replace("/", "-");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descProd == null) ? 0 : descProd.hashCode());
		result = prime * result + ((nomeProd == null) ? 0 : nomeProd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descProd == null) {
			if (other.descProd != null)
				return false;
		} else if (!descProd.equals(other.descProd))
			return false;
		if (nomeProd == null) {
			if (other.nomeProd != null)
				return false;
		} else if (!nomeProd.equals(other.nomeProd))
			return false;
		return true;
	}

	
}