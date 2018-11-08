package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import models.Cliente;

/**
 * Controla todas as atividades realizadas referentes à um cliente.
 * 
 * @author Higor Santos - 118110808.
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
	 * @return Retorna o cpf.
	 */
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		if (cpf == null || contemCliente(cpf) || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		
		this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return cpf;
	}
	
	/**
	 * Dado um certo CPF esse método permitirá modificar o nome de um cliente já cadastrado.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param atributo é o indicador de qual atributo que será modificado.
	 * @param novoValor é o valor que substituirá o antigo.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if (atributo == null || (atributo.trim().equals(""))) {
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
	 * @param cpf é o identificador de um cliente.
	 */
	public void removeCliente(String cpf) {
		// verificando se o cliente já foi cadastrado.
		if (cpf == null || !contemCliente(cpf) || cpf.trim().equals("") || cpf.length() != 11) {
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
	 * @return Uma representação do cliente.
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
	
	public String  adicionaCompra(String cpf, String fornecedor, String data, String nomeProd, String descProd, double preco) {
		return this.clientes.get(cpf).adicionaCompra(fornecedor, data, nomeProd, preco);
	}
	
	public double getDebito(String cpf, String fornecedor) {
		return this.clientes.get(cpf).getDebito(fornecedor);
	}
	
	public String exibeContas(String cpf, String fornecedor){
		return this.clientes.get(cpf).exibeContas(fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		return this.clientes.get(cpf).exibeContasClientes();
	}
	
	/**
	 * Método que verifica se existe algum cliente com determinado CPF.
	 * 
	 * @param cpf é quem determina se aquele cliente existe.
	 * 
	 * @return Um boolean informando se o cliente existe. 
	 */
	public boolean contemCliente(String cpf) {
		return this.clientes.containsKey(cpf);
	}

}
