package lab5_HigorSantos;

import java.util.HashMap;
import java.util.Map;

public class FornecedorController {
	
	private Map <String, Fornecedor> fornecedores;
	
	public FornecedorController() {
		this.fornecedores = new HashMap<>();
	}
	
	public boolean cadastraFornecedor(String nome, String email, String telefone) {
		if (!this.fornecedores.containsKey(nome)) {
			return false;
		}
		
		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return true;		
	}
	
	public boolean editaEmail(String nome, String email) {
		if (!fornecedores.containsKey(nome)) {
			return false;
		}
		
		this.fornecedores.get(nome).setEmail(email);
		return true;
	}
	
	public boolean editaTelefone(String nome, String telefone) {
		if (!fornecedores.containsKey(nome)) {
			return false;
		}
		
		this.fornecedores.get(nome).setTelefone(telefone);
		return true;
	}
	
	public String getEmail(String nome) {
		if (!fornecedores.containsKey(nome)) {
			return "CLIENTE NÃO CADASTRADO";
		}
		
		return this.fornecedores.get(nome).getEmail();
	}
	
	public String getTelefone(String nome) {
		if (!fornecedores.containsKey(nome)) {
			return "CLIENTE NÃO CADASTRADO";
		}
		
		return this.fornecedores.get(nome).getTelefone();
	}
	
	public String getFornecedor(String nome) {
		return this.fornecedores.get(nome).toString();
	}
	
	public boolean removeFornecedor(String nome) {
		if (!fornecedores.containsKey(nome)) {
			return false;
		}
		
		this.fornecedores.remove(nome);
		return true;
	}
	
	public String listaFornecedores() {
		String fornecedores = "Fornecedores:\n";
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
}
