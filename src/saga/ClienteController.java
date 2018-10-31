package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		// verificando se o cliente já foi cadastrado.
		if (contemCliente(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		
		this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return cpf;
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
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if (atributo.equals(null) || (atributo.trim().equals(""))) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		
		atributo = atributo.trim().toUpperCase();
		
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		
		if (atributo.equals("NOME")) {
			this.clientes.get(cpf).setNome(novoValor);
		}else if (atributo.equals("EMAIL")) {
			this.clientes.get(cpf).setEmail(novoValor);
		}else if (atributo.equals("LOCALIZACAO")) {
			this.clientes.get(cpf).setLocalizacao(novoValor);
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}
	
	/**
	 * Remove um cliente cadastrado, por meio do CPF.
	 * 
	 * @param cpf é o identificador do cliente.
	 * 
	 * @return Um boolean informado se a operação foi bem sucedida ou não.
	 */
	public void removeCliente(String cpf) {
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		
		this.clientes.remove(cpf);
	}
	
	/**
	 * Método que serve pra recuperar um cliente já cadastrado por meio do cpf
	 * informado no ato do cadastro. Caso não tenha sido cadastrado retorna um aviso.
	 * 
	 * @param cpf é o identificador do cliente procurado.
	 * 
	 * @return Uma representação do cliente, ou um aviso caso não exista aquele cliente.
	 */
	public String exibeCliente(String cpf) {
		// verificando se o cliente já foi cadastrado.
		if (!contemCliente(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		
		return this.clientes.get(cpf).toString();
	}
	
	/**
	 * Método que lista todos os clientes cadastrados no sistema.
	 * 
	 * @return A representação de cada cliente.
	 */
	public String exibeClientes() {
		List<Cliente> lista = new ArrayList<>(this.clientes.values());
		Collections.sort(lista);
		
		 return lista.stream().map(p -> p.toString()).collect(Collectors.joining(" | "));
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
