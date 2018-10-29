package saga;

/**
 * Classe cujo objetivo é controlar a execução de maneira correta dos
 * método e classes adicionais.
 * 
 * @author higor
 *
 */
public class Facade {

	/** Variável que invoca o responsável por mexer com cada objeto do tipo Cliente. */
	private ClienteController cc;
	private FornecedorController fc;
	
	/**
	 * Método que faz a validação dos dados e, caso esteja tudo certo, solicita
	 * o cadastro de um novo cliente.
	 * 
	 * @param cpf é o identificador de um cliente.
	 * @param nome é o nome do cliente.
	 * @param email é o email do cliente.
	 * @param localizacao é a localização do cliente.
	 * 
	 * @return Um boolean informando se já o cadastro ocorreu com sucesso.
	 */
	public boolean cadastraCliente(String cpf, String nome, String email, String localizacao) {
		cpf = cpf.trim();
		nome = nome.trim();
		localizacao = localizacao.trim();
		
		verificaExcecao(cpf, nome, email, localizacao);
		
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
	public String retornaCliente(String cpf) {
		cpf = cpf.trim();
		verificaExcecao(cpf);
		
		return this.cc.recuperaCliente(cpf);
	}
	
	/**
	 * Lista todos os clientes cadastrados.
	 * 
	 * @return Todos os clientes já cadastrados.
	 */
	public String listarClientesCadastrados() {
		return this.cc.listaClientes();
	}
	
	/**
	 * Método que permite a edição do nome de um cliente.
	 * 
	 * @param cpf é o identificador de um cliente.
	 * @param nome é o valor que irá substituir o antigo.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public boolean editaNomeCliente(String cpf, String nome) {
		cpf = cpf.trim();
		nome = nome.trim();
		
		verificaExcecao(cpf, nome);
		return this.cc.editaNome(cpf, nome);
	}
	
	/**
	 * Método que permite a edição da localização onde um cliente trabalha.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param localizacao é o valor que irá substituir o antigo.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public boolean editaLocalizacaoCliente(String cpf, String localizacao) {
		cpf = cpf.trim();
		localizacao = localizacao.trim();
		
		verificaExcecao(cpf, localizacao);
		return this.cc.editaLocalizacao(cpf, localizacao);
	}
	
	/**
	 * Método que permite a edição do email de um cliente.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param email é o valor que irá substituir o antigo.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public boolean editaEmailCliente(String cpf, String email) {
		cpf = cpf.trim();
		email = email.trim();
		
		verificaExcecao(cpf, email);
		return this.cc.editaEmail(cpf, email);
	}
	
	/**
	 * Método que recupera o nome de um cliente.
	 * 
	 * @param cpf é o identificador de um cliente.
	 * 
	 * @return O nome do cliente que possui determinado CPF.
	 */
	public String retornaNomeCliente(String cpf) {
		cpf = cpf.trim();
		
		verificaExcecao(cpf);
		return this.cc.retornaNome(cpf);
	}
	
	/**
	 * Método que recupera a localização onde um cliente trabalha.
	 * 
	 * @param cpf é o identificador único de um cliente.
	 * 
	 * @return O local onde o cliente com determinado CPF trabalha.
	 */
	public String retornaLocalizacaoCliente(String cpf) {
		cpf = cpf.trim();
		
		verificaExcecao(cpf);
		return this.cc.retornaLocalizacao(cpf);
	}
	
	/**
	 * Método que recupera o email de um cliente.
	 * 
	 * @param cpf é o identificador único de um cliente.
	 * 
	 * @return O email do cliente com determinado CPF.
	 */
	public String retornaEmailCliente(String cpf) {
		cpf = cpf.trim();
		
		verificaExcecao(cpf);
		return this.cc.retornaEmail(cpf);
	}
	
	/**
	 * Método que exclui um cliente, caso ele tenha sido cadastrado.
	 * 
	 * @param cpf é o identificador único de um cliente.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public boolean removeCliente(String cpf) {
		cpf = cpf.trim();
		
		verificaExcecao(cpf);
		return this.cc.removeCliente(cpf);
	}
	
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
		nome = nome.trim();
		email = email.trim();
		telefone = telefone.trim();
		
		verificaExcecao(nome, email, telefone);
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
		verificaExcecao(nome);
		
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
		
		verificaExcecao(nome, email);
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
		
		verificaExcecao(nome, telefone);
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
		
		verificaExcecao(nome);
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
		
		verificaExcecao(nome);
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
		
		verificaExcecao(nome);
		return this.fc.removeFornecedor(nome);
	}
	
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
		
		verificaExcecao(nome, desc);
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
	public String retornaProdutoFornecedor(String nome, String nomeProd, String desc) {
		nome = nome.trim();
		nomeProd = nomeProd.trim();
		desc = desc.trim();
		String key = nomeProd + " " + desc;
		verificaExcecao(nome, nomeProd, desc);
		return this.fc.retornaProduto(nome, key);
	}
	
	public String retornaProdutoEFornecedor(String nome) {
		return this.fc.retornaProdutoEFornecedor(nome);
	}
	
	/**
	 * Método que verifica se os dados passados são válidos.
	 * 
	 * @param args são os dados a serem verificados.
	 */
	private void verificaExcecao(String... args) {
		for (String s : args) {
			if (s.equals(null)) {
				throw new NullPointerException("ENTRADA NULA PASSADA!");
			} else if (s.equals("")) {
				throw new IllegalArgumentException("ENTRADA VAZIA PASSADA!");
			}
		}
	}
}
