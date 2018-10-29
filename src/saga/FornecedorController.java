package saga;

import java.util.HashMap;
import java.util.Map;

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
	public boolean cadastraFornecedor(String nome, String email, String telefone) {
		// Verificando se existe algum fornecedor com determinado nome.
		if (!contemFornecedor(nome)) {
			return false;
		}
		
		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return true;		
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
	public boolean editaEmail(String nome, String email) {
		// Verificando se existe algum fornecedor com determinado nome.
		if (!contemFornecedor(nome)) {
			return false;
		}
		
		this.fornecedores.get(nome).setEmail(email);
		return true;
	}
	
	/**
	 * Dado um certo nome esse método permitirá atualizar o telefone de 
	 * um fornecedor já cadastrado.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * @param telefone é o novo telefone do fornecedor.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public boolean editaTelefone(String nome, String telefone) {
		// Verificando se existe algum fornecedor com determinado nome.
		if (!contemFornecedor(nome)) {
			return false;
		}
		
		this.fornecedores.get(nome).setTelefone(telefone);
		return true;
	}
	
	/**
	 * Dado um nome, retorna o email do cliente. Caso o cliente não 
	 * exista é dado um aviso.
	 * 
	 * @param nome é o nome do fornecedor o qual se deseja recuperar o email.
	 * 
	 * @return O email do fornecedor, caso ele já tenha sido cadastrado.
	 */
	public String retornaEmail(String nome) {
		// Verificando se existe algum fornecedor com determinado nome.
		if (!contemFornecedor(nome)) {
			return "CLIENTE NÃO CADASTRADO";
		}
		
		return this.fornecedores.get(nome).getEmail();
	}
	
	/**
	 * Dado um nome, retorna o telefone do cliente. Caso o cliente não 
	 * exista é dado um aviso.
	 * 
	 * @param nome é o nome do fornecedor o qual se deseja recuperar o email.
	 * 
	 * @return O telefone do fornecedor, caso ele já tenha sido cadastrado.
	 */
	public String retornaTelefone(String nome) {
		// Verificando se existe algum fornecedor com determinado nome.
		if (!contemFornecedor(nome)) {
			return "CLIENTE NÃO CADASTRADO";
		}
		
		return this.fornecedores.get(nome).getTelefone();
	}
	
	/**
	 * Remove um fornecedor cadastrado, por meio do nome.
	 * 
	 * @param nome é o identificador do forncedor.
	 * 
	 * @return Um boolean informado se a operação foi bem sucedida ou não.
	 */
	public boolean removeFornecedor(String nome) {
		// Verificando se existe algum fornecedor com determinado nome.
		if (!contemFornecedor(nome)) {
			return false;
		}
		
		this.fornecedores.remove(nome);
		return true;
	}
	
	/**
	 * Método que serve pra recuperar um fornecedor já cadastrado por meio do nome
	 * informado no ato do cadastro. Caso não tenha sido cadastrado retorna um aviso.
	 * 
	 * @param nome é o identificador do cliente procurado.
	 * 
	 * @return Uma representação do fornecedor, ou um aviso caso não exista aquele fornecedor.
	 */
	public String recuperaFornecedor(String nome) {
		// Verificando se o fornecedor já foi cadastrado.
		if (!contemFornecedor(nome)) {
			return "FORNECEDOR NÃO CADASTRADO!";
		}
		
		return this.fornecedores.get(nome).toString();
	}
	
	/**
	 * Cadastra um produto em um fornecedor.
	 * 
	 * @param nome é o nome do fornecedor.
	 * @param nomeProd é o nome do produto que irá ser cadastrado.
	 * @param desc é uma descrição do produto.
	 * @param preco é o preco que irá ser comercializado.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedida a operação.
	 */
	public boolean cadastraProduto(String nome, String nomeProd, String desc, double preco) {
		return this.fornecedores.get(nome).cadastraProduto(nomeProd, desc, preco);
	}
	
	/**
	 * Método que retorna determinado produto de um fornecedor.
	 * 
	 * @param nome é o nome do fornecedor.
	 * @param key é o identificador do produto.
	 * 
	 * @return A representação de um produto comercializado por um determinado fornecedor.
	 */
	public String retornaProduto(String nome, String key) {
		return this.fornecedores.get(nome).retornaProduto(key);
	}
	
	public String retornaProdutoEFornecedor(String nome) {
		if (!contemFornecedor(nome)) {
			return "FORNECEDOR NÃO CADASTRADO!";
		}
		return this.fornecedores.get(nome).retornaProdutosEFornecedor();
	}
	
	public String fornecedoresEProdutos() {
		
	}
	
	/**
	 * Método que lista todos os fornecedores cadastrados.
	 * 
	 * @return A representação de cada cliente
	 */
	public String listaFornecedores() {
		String fornecedores = "Fornecedores: ";
		// Para evitar que saia um "|" no final da listagem será utilizado um contador
		int cont = 0;
		
		for (Fornecedor f : this.fornecedores.values()) {
			if (!(cont == 0) || !(cont == this.fornecedores.size() - 1)) {
				fornecedores += " | ";
			}
			fornecedores += f.toString();
			cont++;
		}
		
		return fornecedores;
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
