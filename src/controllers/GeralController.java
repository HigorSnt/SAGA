package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GeralController {
	/** Variável que invoca o responsável por mexer com cada objeto do tipo Cliente. */
	private ClienteController cc = new ClienteController();
	/** Variável que invoca o responsável por mexer com cada objeto do tipo Fornecedor. */
	private FornecedorController fc = new FornecedorController();
	
	///////////////////////////////////        MÉTODOS REFERENTES À CLIENTE        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Método que solicita o cadastro de um novo cliente.
	 * 
	 * @param cpf é o identificador de um cliente.
	 * @param nome é o nome do cliente.
	 * @param email é o email do cliente.
	 * @param localizacao é a localização do cliente.
	 * 
	 * @return Retorna o cpf .
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.cc.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	/**
	 * Dado um CPF será solicitado a representação do respectivo cliente. 
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
	 * @param atributo é o indicador de qual atributo que será modificado.
	 * @param novoValor é o valor que substituirá o antigo.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.cc.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * Método que exclui um cliente, caso ele tenha sido cadastrado.
	 * 
	 * @param cpf é o identificador único de um cliente.
	 */
	public void removeCliente(String cpf) {
		this.cc.removeCliente(cpf);
	}
	
	///////////////////////////////////        MÉTODOS REFERENTES AO FORNECEDOR        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Método que  solicita o cadastro de um novo fornecedor.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * @param email é o email do fornecedor.
	 * @param telefone é o telefone do fornecedor.
	 * 
	 * @return O nome do fornecedor.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.fc.adicionaFornecedor(nome, email, telefone);
	}
	
	/**
	 * Dado um nome será solicitado a representação de um certo cliente.
	 * 
	 * @param nome é o identificador do fornecedor.
	 * 
	 * @return Uma string com a representação textual de um fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		return this.fc.exibeFornecedor(nome);
	}
	
	/**
	 * Lista todos os fornecedores cadastrados com seus dados.
	 * 
	 * @return A representação de todos os fornecedores.
	 */
	public String exibeFornecedores() {
		return this.fc.exibeFornecedores();
	}
	
	/**
	 * Método que permite editar um fornecedor.
	 * 
	 * @param nome é o fornecedor que terá alguma informação atualizada. 
	 * @param atributo é o indicador de qual atributo que será modificado.
	 * @param novoValor é o valor que irá substituir o antigo.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fc.editaFornecedor(nome,atributo, novoValor);
	}
	
	/**
	 * Método que exclui um fornecedor, caso ele tenha sido cadastrado.
	 * 
	 * @param nome é o identificador único de um fornecedor.
	 */
	public void removeFornecedor(String nome) {
		this.fc.removeFornecedor(nome);
	}
	
	///////////////////////////////////        MÉTODOS REFERENTES AO PRODUTO        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Cadastra um produto que irá ser comercializado.
	 * 
	 * @param fornecedor é o identificador do fornecedor.
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param preco é o preço do produto.
	 * 
	 * @return Retorna o nome e a descrição do produto.
	 */
	public String adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		return this.fc.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	
	/**
	 * Dado um nome de um fornecedor será solicitado a representação de 
	 * um produto com determinado nome e descrição.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param fornecedor é o nome do fornecedor.
	 * 
	 * @return Uma representação textual do produto.
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.fc.exibeProduto(nome, descricao, fornecedor);
	}
	
	/**
	 * Lista todos os produtos que determinado fornecedor comercializa.
	 * 
	 * @param fornecedor é o identificador do fornecedor.
	 * 
	 * @return Uma String com todos os produtos de um fornecedor.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.fc.exibeProdutosFornecedor(fornecedor);
	}
	
	/**
	 * Lista todos os fornecedores e seus produtos.
	 * 
	 * @return Uma string com todos os fornecedores e produtos comercializados.
	 */
	public String exibeProdutos() {
		return this.fc.exibeProdutos();
	}
	
	/**
	 * Permite a edição de um produto.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param fornecedor é o nome do fornecedor que comercializa o produto dado como parâmetro.
	 * @param novoPreco é o valor que irá substituir o antigo.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		this.fc.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	/**
	 * Remove o produto de um fornecedor.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param fornecedor é o identificador do fornecedor.
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.fc.removeProduto(nome, descricao, fornecedor);
	}
	
	///////////////////////////////////        MÉTODOS REFERENTES AO COMBO        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	public String adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		return this.fc.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}
	
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		this.fc.editaCombo(nome, descricao, fornecedor, novoFator);
	}
	
	///////////////////////////////////        MÉTODOS REFERENTES A COMPRA        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public String adicionaCompra(String cpf, String fornecedor, String data, String nomeProd, String descProd) {
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		}
		if (nomeProd == null || nomeProd.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}
		if (descProd == null || descProd.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		}
		if (data == null || data.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}
		
		data = data.trim();
		
		if (!ehDataValida(data)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		
		cpf = cpf.trim();
		fornecedor = fornecedor.trim();
		data = data.trim();
		nomeProd = nomeProd.trim();
		descProd = descProd.trim();
		
		if (!this.cc.contemCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
		if(!this.fc.contemFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		}
		if (!this.fc.contemProduto(fornecedor, nomeProd, descProd)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}
		
		double preco = this.fc.getPreco(fornecedor, nomeProd, descProd);
		return this.cc.adicionaCompra(cpf, fornecedor, data, nomeProd, descProd, preco);
	}
	
	public boolean ehDataValida(String data) {
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	sdf.setLenient(false);
        	sdf.parse(data);
        	return true;
        } catch (ParseException ex) {
        	return false;
        }
    }
	
	public String getDebito(String cpf, String fornecedor) {
		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		}
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		}
		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		}
		
		cpf = cpf.trim();
		fornecedor = fornecedor.trim();
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}
		if (!this.cc.contemCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}
		if(!this.fc.contemFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}
		
		return String.format("%.2f", this.cc.getDebito(cpf, fornecedor)).replace(",", ".");
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}
		if (!this.cc.contemCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
		if(!this.fc.contemFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}
		return this.cc.exibeContas(cpf, fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}
		if (!this.cc.contemCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		return this.cc.exibeContasClientes(cpf);
	}
	
	public void realizaPagamento(String cpf, String fornecedor) {
		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		}
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no pagamento de conta: cpf invalido.");
		}
		if (!this.cc.contemCliente(cpf)) {
			throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");
		}
		if (!this.fc.contemFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
		}
		this.cc.realizaPagamento(cpf, fornecedor);
	}
	
	public void ordenaPor(String criterio) {
		this.cc.setOrdenaPor(criterio);
	}
	
	public String listarCompras() {
		return this.cc.listarCompras();
	}
	
}