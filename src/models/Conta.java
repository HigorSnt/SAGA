package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que molda uma conta de um cliente.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class Conta implements Comparable <Conta>{
	
	/** É o nome do fornecedor que teve produto comprado pelo cliente. */
	private String fornecedor;
	/** Coleção que armazena todas as contas em aberto do cliente com um fornecedor. */
	private List<Compra> compras;
	
	/**
	 * Constrói uma conta.
	 * 
	 * @param fornecedor é o fornecdor que teve produto comprado pelo cliente.
	 */
	public Conta(String fornecedor) {
		this.fornecedor = fornecedor;
		this.compras = new ArrayList<>();
	}
	
	/**
	 * Adiciona uma compra pra um fornecedor.
	 * 
	 * @param fornecedor é o nome do fornecedor que teve um produto comprado.
	 * @param cliente é o nome do cliente que comprou um produto;
	 * @param nomeProd é o nome do produto comprado.
	 * @param descProd é a descrição do produto comprado.
	 * @param data é a data no qual a compra foi realizada.
	 * @param preco é o preço no qual a compra foi realizada.
	 */
	public void adicionaCompra(String fornecedor, String cliente, String nomeProd, 
			String descProd, String data, double preco) {
		this.compras.add(new Compra(fornecedor, cliente, nomeProd, descProd, data, preco));
	}
	
	/**
	 * Exibe o total de todas as compras não pagas do cliente com um fornecedor.
	 * 
	 * @return O total das compras.
	 */
	public double getDebito() {
		double soma = 0;
		for (Compra compra : this.compras) {
			soma += compra.getPreco();
		}
		return soma;
	}
	
	/**
	 * Retorna todas as compras do cliente com o fornecedor.
	 * 
	 * @return Uma lista com todas as compras.
	 */
	public List<Compra> listarCompras() {
		return this.compras;
	}
	
	@Override
	public String toString() {
		return this.fornecedor + " | " + this.compras.stream().map(p -> p.toString()).collect(Collectors.joining(" | "));
	}
	
	@Override
	public int compareTo(Conta o) {
		return this.fornecedor.compareTo(o.fornecedor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
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
		Conta other = (Conta) obj;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		return true;
	}
	
}