package lab5_HigorSantos;

import java.util.HashMap;
import java.util.Map;

public class ClienteController {
	private Map <String, Cliente> clientes;
	
	public ClienteController() {
		this.clientes = new HashMap<>();
	}
	
	public boolean cadastraCliente(String cpf, String nome, String localizacao, String email) {
		if (clientes.containsKey(cpf)) {
			return false;
		}
		
		clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return true;
	}
	
	public boolean editaNome(String cpf, String nome) {
		if (!clientes.containsKey(cpf)) {
			return false;
		}
		
		this.clientes.get(cpf).setNome(nome);
		return true;
	}
	
	public boolean editaEmail(String cpf, String email) {
		if (!clientes.containsKey(cpf)) {
			return false;
		}
		
		this.clientes.get(cpf).setNome(email);
		return true;
	}
	
	public boolean editaLocalizacao(String cpf, String localizacao) {
		if (!clientes.containsKey(cpf)) {
			return false;
		}
		
		this.clientes.get(cpf).setLocalizacao(localizacao);
		return true;
	}
	
	public String getNome(String cpf) {
		if (!clientes.containsKey(cpf)) {
			return "CLIENTE NÃO CADASTRADO";
		}
		
		return this.clientes.get(cpf).getNome();
	}
	
	public String getEmail(String cpf) {
		if (!clientes.containsKey(cpf)) {
			return "CLIENTE NÃO CADASTRADO";
		}
		
		return this.clientes.get(cpf).getEmail();
	}
	
	public String getLocalizacao(String cpf) {
		if (!clientes.containsKey(cpf)) {
			return "CLIENTE NÃO CADASTRADO";
		}
		
		return this.clientes.get(cpf).getLocalizacao();
	}
	
	public String getCliente(String cpf) {
		return this.clientes.get(cpf).toString();
	}
	
	public String listaClientes() {
		String clientes = "Clientes:\n";
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

}
