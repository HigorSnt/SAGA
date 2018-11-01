package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controla todas as atividades realizadas referentes à um fornecedor.
 * 
 * @author higor
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
	 * @param nome é o nome do fornecedor.
	 * @param email é o email do fornecedor.
	 * @param telefone é o telefone do fornecedor.
	 * 
	 * @return Um booleano informando se foi cadastrado ou não.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		// Verificando se existe algum fornecedor com determinado nome.
		if (contemFornecedor(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		
		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return nome;		
	}
	
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
	 * Remove um fornecedor cadastrado, por meio do nome.
	 * 
	 * @param nome é o identificador do forncedor.
	 * 
	 * @return Um boolean informado se a operação foi bem sucedida ou não.
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
	 * Método que serve pra recuperar um fornecedor já cadastrado por meio do nome
	 * informado no ato do cadastro. Caso não tenha sido cadastrado retorna um aviso.
	 * 
	 * @param nome é o identificador do cliente procurado.
	 * 
	 * @return Uma representação do fornecedor, ou um aviso caso não exista aquele fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		// Verificando se o fornecedor já foi cadastrado.
		if (!contemFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		
		return this.fornecedores.get(nome).toString();
	}
	
	/**
	 * Cadastra um produto em um fornecedor.
	 * 
	 * @param fornecedor é o nome do fornecedor.
	 * @param nome é o nome do produto que irá ser cadastrado.
	 * @param descricao é uma descrição do produto.
	 * @param preco é o preco que irá ser comercializado.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public String adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!contemFornecedor(fornecedor)) {
			throw new IllegalAccessError("Erro no cadastro de produto: fornecedor nao existe.");
		}
		
		this.fornecedores.get(fornecedor).cadastraProduto(nome, descricao, preco);
		return nome + " " + descricao;
	}
	
	/**
	 * Método que retorna determinado produto de um fornecedor.
	 * 
	 * @param nome é o nome do fornecedor.
	 * @param key é o identificador do produto.
	 * 
	 * @return A representação de um produto comercializado por um determinado fornecedor.
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
		String key = nome.trim() + " " + descricao.trim();
		
		return this.fornecedores.get(fornecedor).retornaProduto(key);
	}
	
	public String exibeProdutosFornecedor(String fornecedor) {
		if (!contemFornecedor(fornecedor)) {
			throw new IllegalAccessError("Erro na exibicao de produto: fornecedor nao existe.");
		} else if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalAccessError("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		
		return this.fornecedores.get(fornecedor).exibeProdutosFornecedor();
	}

	public String exibeProdutos() {
		List<Fornecedor> lista = new ArrayList<>(this.fornecedores.values());
		Collections.sort(lista);
		
		return lista.stream().map(p -> p.exibeProdutosFornecedor()).collect(Collectors.joining(" | "));
	}
	
	public void editaPrecoProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		} else if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}else if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (novoPreco <= 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		} else if (!contemFornecedor(fornecedor)) {
			throw new IllegalAccessError("Erro na edicao de produto: fornecedor nao existe.");
		}
		
		this.fornecedores.get(fornecedor).editaPrecoProduto(nome.trim() + " " + descricao.trim(), novoPreco);
	}
	
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
