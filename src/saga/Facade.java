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
	public boolean editaNome(String cpf, String nome) {
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
	public boolean editaLocalizacao(String cpf, String localizacao) {
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
	public boolean editaEmail(String cpf, String email) {
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
	public String retornaNome(String cpf) {
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
	public String retornaLocalizacao(String cpf) {
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
	public String retornaEmail(String cpf) {
		cpf = cpf.trim();
		
		verificaExcecao(cpf);
		return this.cc.retornaEmail(cpf);
	}
	
	public boolean removeCliente(String cpf) {
		cpf = cpf.trim();
		
		verificaExcecao(cpf);
		return this.cc.removeCliente(cpf);
	}
	
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
