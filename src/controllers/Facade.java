package controllers;

import easyaccept.EasyAccept;

/**
 * Classe cujo objetivo é controlar a execução de maneira correta dos
 * método e classes adicionais.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class Facade {

	/** Variável que invoca o responsável por mexer com cada objeto do tipo Cliente. */
	private ClienteController cc = new ClienteController();
	/** Variável que invoca o responsável por mexer com cada objeto do tipo Fornecedor. */
	private FornecedorController fc = new FornecedorController();
	
	///////////////////////////////////       MÉTODO QUE CHAMA O EASYACCEPT        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public static void main(String[] args) {
		args = new String[] {"controllers.Facade", "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt",
				"acceptance_tests/use_case_3.txt"};
		EasyAccept.main(args);
	}
	
	///////////////////////////////////        MÉTODOS REFERENTES À CLIENTE        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Método que solicita o cadastro de um novo cliente.
	 * 
	 * @param cpf é o identificador de um cliente.
	 * @param nome é o nome do cliente.
	 * @param email é o email do cliente.
	 * @param localizacao é a localização do cliente.
	 * 
	 * @return Retorna o cpf .
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.cc.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	/**
	 * Dado um CPF será solicitado a representação do respectivo cliente. 
	 * 
	 * @param cpf é o identificador de um cliente.
	 * 
	 * @return A representação do cliente, caso ele esteja cadastrado.
	 */
	public String exibeCliente(String cpf) {
		return this.cc.exibeCliente(cpf);
	}
	
	/**
	 * Lista todos os clientes cadastrados.
	 * 
	 * @return Todos os clientes já cadastrados.
	 */
	public String exibeClientes() {
		return this.cc.exibeClientes();
	}
	
	/**
	 * Método que permite a edição do nome de um cliente.
	 * 
	 * @param cpf é o identificador de um cliente.
	 * @param atributo é o indicador de qual atributo que será modificado.
	 * @param novoValor é o valor que substituirá o antigo.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.cc.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * Método que exclui um cliente, caso ele tenha sido cadastrado.
	 * 
	 * @param cpf é o identificador único de um cliente.
	 */
	public void removeCliente(String cpf) {
		this.cc.removeCliente(cpf);
	}
	
	///////////////////////////////////        MÉTODOS REFERENTES AO FORNECEDOR        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Método que  solicita o cadastro de um novo fornecedor.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * @param email é o email do fornecedor.
	 * @param telefone é o telefone do fornecedor.
	 * 
	 * @return O nome do fornecedor.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.fc.adicionaFornecedor(nome, email, telefone);
	}
	
	/**
	 * Dado um nome será solicitado a representação de um certo cliente.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * 
	 * @return Uma string com a representação textual de um fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		return this.fc.exibeFornecedor(nome);
	}
	
	/**
	 * Lista todos os fornecedores cadastrados com seus dados.
	 * 
	 * @return A representação de todos os fornecedores.
	 */
	public String exibeFornecedores() {
		return this.fc.exibeFornecedores();
	}
	
	/**
	 * Método que permite editar um fornecedor.
	 * 
	 * @param nome é o fornecedor que terá alguma informação atualizada. 
	 * @param atributo é o indicador de qual atributo que será modificado.
	 * @param novoValor é o valor que irá substituir o antigo.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fc.editaFornecedor(nome,atributo, novoValor);
	}
	
	/**
	 * Método que exclui um fornecedor, caso ele tenha sido cadastrado.
	 * 
	 * @param nome é o identificador único de um fornecedor.
	 */
	public void removeFornecedor(String nome) {
		this.fc.removeFornecedor(nome);
	}
	
	///////////////////////////////////        MÉTODOS REFERENTES AO PRODUTO        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Cadastra um produto que irá ser comercializado.
	 * 
	 * @param fornecedor é o identificador do fornecedor.
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param preco é o preço do produto.
	 * 
	 * @return Retorna o nome e a descrição do produto.
	 */
	public String adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		return this.fc.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	
	/**
	 * Dado um nome de um fornecedor será solicitado a representação de 
	 * um produto com determinado nome e descrição.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param fornecedor é o nome do fornecedor.
	 * 
	 * @return Uma representação textual do produto.
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.fc.exibeProduto(nome, descricao, fornecedor);
	}
	
	/**
	 * Lista todos os produtos que determinado fornecedor comercializa.
	 * 
	 * @param fornecedor é o identificador do fornecedor.
	 * 
	 * @return Uma String com todos os produtos de um fornecedor.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.fc.exibeProdutosFornecedor(fornecedor);
	}
	
	/**
	 * Lista todos os fornecedores e seus produtos.
	 * 
	 * @return Uma string com todos os fornecedores e produtos comercializados.
	 */
	public String exibeProdutos() {
		return this.fc.exibeProdutos();
	}
	
	/**
	 * Permite a edição de um produto.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param fornecedor é o nome do fornecedor que comercializa o produto dado como parâmetro.
	 * @param novoPreco é o valor que irá substituir o antigo.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		this.fc.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	/**
	 * Remove o produto de um fornecedor.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param fornecedor é o identificador do fornecedor.
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.fc.removeProduto(nome, descricao, fornecedor);
	}

}
