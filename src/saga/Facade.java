package saga;

import easyaccept.EasyAccept;

/**
 * Classe cujo objetivo é controlar a execução de maneira correta dos
 * método e classes adicionais.
 * 
 * @author higor
 *
 */
public class Facade {

	/** Variável que invoca o responsável por mexer com cada objeto do tipo Cliente. */
	private ClienteController cc = new ClienteController();
	/** Variável que invoca o responsável por mexer com cada objeto do tipo Fornecedor. */
	private FornecedorController fc = new FornecedorController();
	
	///////////////////////////////////       MÉTODO QUE CHAMA O EASYACCEPT        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public static void main(String[] args) {
		args = new String[] {"saga.Facade", "acceptance_test/use_case_1.txt"};
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
	 * @return Um boolean informando se já o cadastro ocorreu com sucesso.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.cc.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	/**
	 * Dado um CPF será verificado se o dado passado é válido e
	 * em seguida pedirá para retornar a representação do respectivo cliente. 
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
	 * @param nome é o valor que irá substituir o antigo.
	 * 
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.cc.editaCliente(cpf, atributo, novoValor);
	}

	
	/**
	 * Método que exclui um cliente, caso ele tenha sido cadastrado.
	 * 
	 * @param cpf é o identificador único de um cliente.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public void removeCliente(String cpf) {
		this.cc.removeCliente(cpf);
	}
	
	///////////////////////////////////        MÉTODOS REFERENTES AO FORNECEDOR        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Método que faz a validação dos dados e, caso esteja tudo certo, solicita
	 * o cadastro de um novo fornecedor.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * @param email é o email do fornecedor.
	 * @param telefone é o telefone do fornecedor.
	 * 
	 * @return Um boolean informando se a operação foi ou não bem sucedida.
	 */
	public boolean cadastraFornecedor(String nome, String email, String telefone) {
		return this.fc.cadastraFornecedor(nome, email, telefone);
	}
	
	/**
	 * Dado um nome será verificado se o dado passado é válido e
	 * em seguida pedirá para retornar a representação do respectivo fornecedor. 
	 * 
	 * @param nome é o identificador de um fornecedor.
	 * 
	 * @return A representação do fornecedor, caso ele esteja cadastrado.
	 */
	public String retornaFornecedor(String nome) {
		nome = nome.trim();
		
		return this.fc.recuperaFornecedor(nome);
	}
	
	/**
	 * Lista todos os funcionários cadastrados com seus dados.
	 * 
	 * @return A representação de todos os fornecedores.
	 */
	public String listaFornecedoresCadastrados() {
		return this.fc.listaFornecedores();
	}
	
	/**
	 * Dado um certo nome esse método permitirá atualizar o email de 
	 * um fornecedor já cadastrado.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * @param email é o novo email do fornecedor.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public boolean editaEmailFornecedor(String nome, String email) {
		nome = nome.trim();
		email = email.trim();
		
		return this.fc.editaEmail(nome, email);
	}
	
	/**
	 * Método que permite a edição do telefone de um fornecedor.
	 * 
	 * @param nome é o identificador único de um fornecedor.
	 * @param telefone é o valor que irá substituir o antigo.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public boolean editaTelefoneFornecedor(String nome, String telefone) {
		nome = nome.trim();
		telefone = telefone.trim();
		
		return this.fc.editaTelefone(nome, telefone);
	}
	
	/**
	 * Método que recupera o email de um fornecedor.
	 * 
	 * @param nome é o identificador único de um fornecedor.
	 * 
	 * @return O email do fornecedor com determinado nome.
	 */
	public String retornaEmailFornecedor(String nome) {
		nome = nome.trim();
		
		return this.fc.retornaEmail(nome);
	}
	
	/**
	 * Método que recupera o telefone de um fornecedor.
	 * 
	 * @param nome é o identificador único de um fornecedor.
	 * 
	 * @return O telefone do fornecedor com determinado nome.
	 */
	public String retornaTelefoneFornecedor(String nome) {
		nome = nome.trim();
		
		return this.fc.retornaTelefone(nome);
	}
	
	/**
	 * Método que exclui um fornecedor, caso ele tenha sido cadastrado.
	 * 
	 * @param nome é o identificador único de um fornecedor.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public boolean removeFornecedor(String nome) {
		nome = nome.trim();
		
		return this.fc.removeFornecedor(nome);
	}
	
	///////////////////////////////////        MÉTODOS REFERENTES AO PRODUTO        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Cadastra um produto que irá ser comercializado.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * @param nomeProd é o nome do produto.
	 * @param desc é a descrição do produto.
	 * @param preco é o preço do produto.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação. 
	 */
	public boolean cadastraProdutoFornecedor(String nome, String nomeProd, String desc, double preco) {
		nome = nome.trim();
		desc = desc.trim();
		
		return this.fc.cadastraProduto(nome, nomeProd, desc, preco);
	}
	
	/**
	 * Dado um nome de um fornecedor será solicitado para retornar a representação de 
	 * um produto com determinado nome e descrição.
	 * 
	 * @param nome é o nome do fornecedor.
	 * @param nomeProd é o nome do produto.
	 * @param desc é a descrição do produto.
	 * 
	 * @return A representação de um produto caso ele tenha sido cadastrado.
	 */
	public String retornaProdutoDeFornecedor(String nome, String nomeProd, String desc) {
		nome = nome.trim();
		nomeProd = nomeProd.trim();
		desc = desc.trim();
		String key = nomeProd + " " + desc;
		
		return this.fc.retornaProduto(nome, key);
	}
	
	/**
	 * Lista todos os produtos que determinado fornecedor comercializa.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * 
	 * @return Uma String com todos os produtos de um fornecedor.
	 */
	public String listaProdutosDeFornecedor(String nome) {
		nome = nome.trim();
		return this.fc.retornaTodosProdutosDeFornecedor(nome);
	}
	
	/**
	 * Lista todos os fornecedores e seus produtos.
	 * 
	 * @return Uma string com todos os fornecedores e produtos comercializados.
	 */
	public String listaTodosFornecedoresEProdutos() {
		return this.fc.retornaTodosProdutosDeTodosFornecedores();
	}
	
	/**
	 * Altera o preço de um determinado produto comercializado por um certo 
	 * 
	 * @param nomeForn
	 * @param nomeProd
	 * @param desc
	 * @param preco
	 * @return
	 */
	public boolean editaPrecoProduto(String nomeForn, String nomeProd, String desc, double preco) {
		nomeForn = nomeForn.trim();
		nomeProd = nomeProd.trim();
		desc = desc.trim();
		String key = nomeProd + " " + desc;
		
		return this.fc.editaPrecoProduto(nomeForn, key, preco);
	}
	
	/**
	 * Remove o produto de um fornecedor.
	 * 
	 * @param nomeForn é o nome do fornecedor.
	 * @param nomeProd é o nome do produto.
	 * @param desc é a descrição do produto.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public boolean removeProdutoDeFornecedor(String nomeForn, String nomeProd, String desc) {
		nomeForn = nomeForn.trim();
		nomeProd = nomeProd.trim();
		desc = desc.trim();
		
		String key = nomeProd + " " + desc;
		return this.fc.removeProduto(nomeForn, key);
	}

}
