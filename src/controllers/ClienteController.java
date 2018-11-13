package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import comparators.ComparaPorCliente;
import comparators.ComparaPorData;
import comparators.ComparaPorFornecedor;
import models.Cliente;
import models.Compra;

/**
 * Controla todas as atividades realizadas referentes à um cliente.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class ClienteController {
	
	/** Armazena cada cliente com um identificador único. */
	private Map <String, Cliente> clientes;
	/** Variável que define a forma de ordenação das compras. */
	private String ordenaPor;
	
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
	
	/**
	 * Adiciona uma compra pra um cliente.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param fornecedor é o identificador do fornecedor.
	 * @param data é a data onde a compra foi realizada.
	 * @param nomeProd é o nome do produto.
	 * @param descProd é a descrição do produto.
	 * @param preco é o preço da compra.
	 * 
	 * @return O fornecedor da compra.
	 */
	public String  adicionaCompra(String cpf, String fornecedor, String data, String nomeProd, String descProd, double preco) {
		return this.clientes.get(cpf).adicionaCompra(fornecedor, data, nomeProd, descProd, preco);
	}
	
	/**
	 * Totaliza da conta de um fornecedor para um dado cliente.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param fornecedor é o identificador do fornecedor.
	 * 
	 * @return O total da conta de um fornecedor para um dado cliente.
	 */
	public double getDebito(String cpf, String fornecedor) {
		return this.clientes.get(cpf).getDebito(fornecedor);
	}
	
	/**
	 * Exibe as contas de um cliente com um fornecedor.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param fornecedor é o identificador do fornecedor.
	 * 
	 * @return Retorna a representação textual da conta de um cliente com um fornecedor.
	 */
	public String exibeContas(String cpf, String fornecedor){
		return this.clientes.get(cpf).exibeContas(fornecedor);
	}
	
	/**
	 * Exibe a representação textual de todas as contas de um cliente.
	 * 
	 * @param cpf é o identificador de um cliente.
	 * 
	 * @return Retorna a representação textual de todas as contas de um cliente.
	 */
	public String exibeContasClientes(String cpf) {
		return this.clientes.get(cpf).exibeContasClientes();
	}
	
	/**
	 * Realiza a quitação do débito de um cliente com um fornecedor.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param fornecedor é o identificador do fornecedor.
	 */
	public void realizaPagamento(String cpf, String fornecedor) {
		this.clientes.get(cpf).realizaPagamento(fornecedor);
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
	
	/**
	 * Define critério de ordenação.
	 * 
	 * @param criterio é a forma que as compras serão ordenadas.
	 */
	public void setOrdenaPor(String criterio) {
		if (criterio == null || criterio.trim().equals("")) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		}
		criterio = criterio.trim().toUpperCase();
		if (!criterio.equals("CLIENTE") && !criterio.equals("FORNECEDOR") && !criterio.equals("DATA")) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}
		this.ordenaPor = criterio;
	}
	
	/**
	 * Lista as compras de acordo com o critério de ordenação.
	 * 
	 * @return Retorna a listagem das compras de acordo com o critério de ordenação que deverá ser definido anteriormente.
	 */
	public String listarCompras() {
		if (this.ordenaPor == null) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		}
		
		List<Compra> lista = new ArrayList<>();
		for (Cliente c : this.clientes.values()) {
			lista.addAll(c.listarCompras());
		}
		
		if (this.ordenaPor.equals("CLIENTE")) {
			Collections.sort(lista, new ComparaPorCliente());
			return lista.stream().map(p -> p.getCliente() + ", " + p.getFornecedor() + ", "
					+ p.getDescProd() + ", " + p.getData()).collect(Collectors.joining(" | "));
		} else if (this.ordenaPor.equals("FORNECEDOR")) {
			Collections.sort(lista, new ComparaPorFornecedor());
			return lista.stream().map(p -> p.getFornecedor() + ", " + p.getCliente() + ", "
					+ p.getDescProd() + ", " + p.getData()).collect(Collectors.joining(" | "));
		} else {
			Collections.sort(lista, new ComparaPorData());
			return lista.stream().map(p -> p.getData() + ", " + p.getCliente() + ", "
					+ p.getFornecedor() + ", " + p.getDescProd()).collect(Collectors.joining(" | "));
		}
	}

}
