package facade;

import controllers.GeralController;
import easyaccept.EasyAccept;

/**
 * Classe cujo objetivo é controlar a execução de maneira correta dos
 * método e classes adicionais.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class Facade {
	
	/** Variável que invoca a classe que faz a ligação entre os demais controllers. */
	private GeralController gc = new GeralController();
	
	///////////////////////////////////       MÉTODO QUE CHAMA O EASYACCEPT        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public static void main(String[] args) {
		args = new String[] {"facade.Facade", "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt",
				"acceptance_tests/use_case_3.txt", "acceptance_tests/use_case_4.txt", "acceptance_tests/use_case_5.txt",
				"acceptance_tests/use_case_6.txt", "acceptance_tests/use_case_7.txt"};
		EasyAccept.main(args);
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.gc.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.gc.exibeCliente(cpf);
	}
	
	public String exibeClientes() {
		return this.gc.exibeClientes();
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.gc.editaCliente(cpf, atributo, novoValor);
	}
	
	public void removeCliente(String cpf) {
		this.gc.removeCliente(cpf);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.gc.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return this.gc.exibeFornecedor(nome);
	}
	
	public String exibeFornecedores() {
		return this.gc.exibeFornecedores();
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.gc.editaFornecedor(nome,atributo, novoValor);
	}
	
	public void removeFornecedor(String nome) {
		this.gc.removeFornecedor(nome);
	}
	
	public String adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		return this.gc.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.gc.exibeProduto(nome, descricao, fornecedor);
	}
	
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.gc.exibeProdutosFornecedor(fornecedor);
	}
	
	public String exibeProdutos() {
		return this.gc.exibeProdutos();
	}
	
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		this.gc.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.gc.removeProduto(nome, descricao, fornecedor);
	}
	
	public String adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		return this.gc.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}
	
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		this.gc.editaCombo(nome, descricao, fornecedor, novoFator);
	}
	
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProd, String descProd) {
		this.gc.adicionaCompra(cpf, fornecedor, data, nomeProd, descProd);
	}
	
	public String getDebito(String cpf, String fornecedor) {
		return this.gc.getDebito(cpf, fornecedor);
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		return this.gc.exibeContas(cpf, fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		return this.gc.exibeContasClientes(cpf);
	}
	
	public void realizaPagamento(String cpf, String fornecedor) {
		this.gc.realizaPagamento(cpf, fornecedor);
	}
	
	public void ordenaPor(String criterio) {
		this.gc.ordenaPor(criterio);
	}
	
	public String listarCompras() {
		return this.gc.listarCompras();
	}
	
}