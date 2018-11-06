package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import models.Fornecedor;

/**
 * Controla todas as atividades realizadas referentes à um fornecedor.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class FornecedorController {
	
	/** Armazena todos os fornecedores, utilizando um identificador único. */
	private Map <String, Fornecedor> fornecedores;
	
	/**
	 * Inicializa onde os fornecedores serão armazenado.
	 */
	public FornecedorController() {
		this.fornecedores = new HashMap<>();
	}
	
	/**
	 * Cadastra um fornecedor.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * @param email é o email do fornecedor.
	 * @param telefone é o telefone do fornecedor.
	 * 
	 * @return Retorna o nome cadastrado.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		// Verificando se existe algum fornecedor com determinado nome.
		if (contemFornecedor(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		
		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return nome;		
	}
	
	/**
	 * Permite editar o email e telefone de um fornecedor.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * @param atributo é o indicador de qual atributo que será modificado.
	 * @param novoValor é o valor que irá substituir o antigo.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		if (atributo == null || atributo.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		if (!contemFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
		
		atributo = atributo.trim().toUpperCase();
		
		if (atributo.equals("NOME")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		} else if (atributo.equals("EMAIL")) {
			this.fornecedores.get(nome).setEmail(novoValor);
		} else if (atributo.equals("TELEFONE")) {
			this.fornecedores.get(nome).setTelefone(novoValor);
		} else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}
	
	/**
	 * Remove um fornecedor pelo nome.
	 * 
	 * @param nome é o identificador do fornecedor.
	 */
	public void removeFornecedor(String nome) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		} else if (!contemFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		
		this.fornecedores.remove(nome);
	}
	
	/**
	 * Exibe a representação textual de um fornecedor.
	 * 
	 * @param nome é o nome do fornecedor.
	 * 
	 * @return Uma string com a representação textual de um fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		// Verificando se o fornecedor já foi cadastrado.
		if (!contemFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		
		return this.fornecedores.get(nome).toString();
	}

	/**
	 * Método que permite o cadastro de um produto.
	 * 
	 * @param fornecedor é o nome do fornecedor que comercializa o produto.
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param preco é o preço do produto.
	 * 
	 * @return Retorna o nome e a descrição do produto.
	 */
	public String adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!contemFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		
		this.fornecedores.get(fornecedor).cadastraProduto(nome, descricao, preco);
		return nome + " - " + descricao;
	}
	
	/**
	 * Método que exibe um produto comercializado por um fornecedor.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param fornecedor é o nome do fornecedor.
	 * 
	 * @return Uma representação textual do produto.
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		} else if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		} else if (!contemFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		
		fornecedor = fornecedor.trim();
		String key = nome.trim() + " - " + descricao.trim();
		
		return this.fornecedores.get(fornecedor).retornaProduto(key);
	}
	
	/**
	 * Exibe todos os produtos de um determinado fornecedor.
	 * 
	 * @param fornecedor é o nome do fornecedor que se deseja saber os produtos.
	 * 
	 * @return Retorna a representação textual de todos os produtos de um fornecedor. 
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!contemFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		
		return this.fornecedores.get(fornecedor).exibeProdutosFornecedor();
	}
	
	/**
	 * Exibe todos os produtos cadastrados em todos os fornecedores.
	 * 
	 * @return Uma string com todos os fornecedores e produtos em ordem alfabética.
	 */
	public String exibeProdutos() {
		List<Fornecedor> lista = new ArrayList<>(this.fornecedores.values());
		Collections.sort(lista);
		
		return lista.stream().map(p -> p.exibeProdutosFornecedor()).collect(Collectors.joining(" | "));
	}
	
	/**
	 * Permite editar o preço de um produto.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param fornecedor é o identificador do fornecedor que comercializa o produto.
	 * @param novoPreco é o novo preço do produto.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		} else if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}else if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (novoPreco <= 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		} else if (!contemFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		
		this.fornecedores.get(fornecedor).editaProduto(nome.trim() + " - " + descricao.trim(), novoPreco);
	}
	
	/**
	 * Permite remover um produto
	 * 
	 * @param nome é o nome do produto a ser removido.
	 * @param descricao é a descrição do produto que será removido.
	 * @param fornecedor é o identificador de quem vende o produto.
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		if (fornecedor == null ||fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!contemFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		
		this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
	}
	
	/**
	 * Método que lista todos os fornecedores cadastrados.
	 * 
	 * @return A representação de cada cliente
	 */
	public String exibeFornecedores() {
		List <Fornecedor> lista = new ArrayList<>(this.fornecedores.values());
		Collections.sort(lista);
		return lista.stream().map(f -> f.toString()).collect(Collectors.joining(" | "));
	}
	
	public String adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}
		if (produtos == null || produtos.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
		}
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		}
		if (fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		if (produtos == null || produtos.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
		}
		if (!contemFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
		
		fornecedor = fornecedor.trim();
		
		return this.fornecedores.get(fornecedor).adicionaCombo(nome, descricao, fator, produtos);
	}
	
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
		
		this.fornecedores.get(fornecedor).editaCombo(nome, descricao, novoFator);
	}
	
	/**
	 * Verifica se um determinado nome já foi cadastrado.
	 * 
	 * @param nome é o nome que deseja ser verificado.
	 * 
	 * @return Um boolean informando se existe ou não determinado nome cadatrado.
	 */
	private boolean contemFornecedor(String nome) {
		return this.fornecedores.containsKey(nome);
	}
}
