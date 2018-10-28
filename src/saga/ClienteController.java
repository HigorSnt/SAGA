package saga;

import java.util.HashMap;
import java.util.Map;

/**
 * Controla todas as atividades realizadas referentes à um cliente.
 * 
 * @author higor
 *
 */
public class ClienteController {
	
	/** Armazena cada cliente com um identificador único. */
	private Map <String, Cliente> clientes;
	
	/**
	 * Inicializa o local onde os clientes serão cadastrados.
	 */
	public ClienteController() {
		this.clientes = new HashMap<>();
	}
	
	/**
	 * Cadastra um novo cliente.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param nome é o nome do cliente.
	 * @param email é o email do cliente.
	 * @param localizacao é o local onde o cliente trabalha.
	 * 
	 * @return Um boolean informando se foi possível ou não realizar o cadastro do usuário.
	 */
	public boolean cadastraCliente(String cpf, String nome, String email, String localizacao) {
		// verificando se o cliente já foi cadastrado.
		if (contemCliente(cpf)) {
			return false;
		}
		
		this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return true;
	}
	
	/**
	 * Dado um certo CPF esse método permitirá modificar o nome de 
	 * um cliente já cadastrado.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param nome é o novo nome do cliente.
	 * 
	 * @return Um boolean informando se a operação foi ou não bem sucedida.
	 */
	public boolean editaNome(String cpf, String nome) {
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			return false;
		}
		
		this.clientes.get(cpf).setNome(nome);
		return true;
	}
	
	/**
	 * Dado um certo CPF esse método permitirá atualizar o email de 
	 * um cliente já cadastrado.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param email é o novo email do cliente.
	 * 
	 * @return Um boolean informando se a operação foi ou não bem sucedida.
	 */
	public boolean editaEmail(String cpf, String email) {
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			return false;
		}
		
		this.clientes.get(cpf).setNome(email);
		return true;
	}
	
	/**
	 * Dado um certo CPF esse método permitirá atualizar a localização de 
	 * um cliente já cadastrado.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param localizacao é a nova localização do cliente
	 * 
	 * @return Um boolean informando se a operação foi ou não bem sucedida.
	 */
	public boolean editaLocalizacao(String cpf, String localizacao) {
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			return false;
		}
		
		this.clientes.get(cpf).setLocalizacao(localizacao);
		return true;
	}
	
	/**
	 * Dado um CPF, retorna a localização do cliente. Caso o cliente não 
	 * exista é dado um aviso.
	 * 
	 * @param cpf é o identificador do cliente.
	 * 
	 * @return O nome do cliente, caso ele já tenha sido cadastrado.
	 */
	public String retornaNome(String cpf) {
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			return "CLIENTE NÃO CADASTRADO";
		}
		
		return this.clientes.get(cpf).getNome();
	}
	
	/**
	 * Dado um CPF, retorna a localização do cliente. Caso o cliente não 
	 * exista é dado um aviso.
	 * 
	 * @param cpf é o identificador do cliente.
	 * 
	 * @return O email do cliente, caso ele já tenha sido cadastrado.
	 */
	public String retornaEmail(String cpf) {
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			return "CLIENTE NÃO CADASTRADO";
		}
		
		return this.clientes.get(cpf).getEmail();
	}
	
	/**
	 * Dado um CPF, retorna a localização do cliente. Caso o cliente não 
	 * exista é dado um aviso.
	 * 
	 * @param cpf é o identificador do cliente.
	 * 
	 * @return A localização do cliente, caso ele já tenha sido cadastrado.
	 */
	public String retornaLocalizacao(String cpf) {
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			return "CLIENTE NÃO CADASTRADO";
		}
		
		return this.clientes.get(cpf).getLocalizacao();
	}
	
	/**
	 * Remove um cliente cadastrado, por meio do CPF.
	 * 
	 * @param cpf é o identificador do cliente.
	 * 
	 * @return Um boolean informado se a operação foi bem sucedida ou não.
	 */
	public boolean removeCliente(String cpf) {
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			return false;
		}
		
		this.clientes.remove(cpf);
		return false;
	}
	
	/**
	 * Método que serve pra recuperar um cliente já cadastrado por meio do cpf
	 * informado no ato do cadastro. Caso não tenha sido cadastrado retorna um aviso.
	 * 
	 * @param cpf é o identificador do cliente procurado.
	 * 
	 * @return Uma representação do cliente, ou um aviso caso não exista aquele cliente.
	 */
	public String recuperaCliente(String cpf) {
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			return "CLIENTE NÃO CADASTRADO!";
		}
		
		return this.clientes.get(cpf).toString();
	}
	
	/**
	 * Método que lista todos os clientes cadastrados no sistema.
	 * 
	 * @return A representação de cada cliente.
	 */
	public String listaClientes() {
		String clientes = "Clientes: ";
		// Para evitar que saia um "|" no final da listagem será utilizado um contador
		int cont = 0;
		
		for (Cliente c : this.clientes.values()) {
			if (!(cont == 0) || !(cont == this.clientes.size() - 1)) {
				clientes += " | ";
			}
			clientes += c.toString();
			cont++;
		}
		
		return clientes;
	}
	
	/**
	 * Método que verifica se existe algum cliente com determinado CPF.
	 * 
	 * @param cpf é quem determina se aquele cliente existe.
	 * 
	 * @return Um boolean informando se o cliente existe. 
	 */
	private boolean contemCliente(String cpf) {
		return this.clientes.containsKey(cpf);
	}

}
