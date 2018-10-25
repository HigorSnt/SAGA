package lab5_HigorSantos;

import java.util.HashMap;
import java.util.Map;

public class Fornecedor {
	
	private String nome;
	private String email;
	private String telefone;
	private Map <String, Produto> produtos;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

}
