package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import comparators.ComparaPorCliente;
import comparators.ComparaPorData;
import comparators.ComparaPorFornecedor;

public class Conta {
	
	private List<Compra> compras = new ArrayList<>();
	
	public void adicionaCompra(String fornecedor, String cliente, String nomeProd, String data, double preco) {
		this.compras.add(new Compra(fornecedor, cliente, nomeProd, data, preco));
	}
	
	public double getDebito(String fornecedor) {
		double soma = 0;
		for (Compra compra : this.compras) {
			if (compra.getFornecedor().equals(fornecedor))
				soma += compra.getPreco();
		}
		return soma;
	}
	
	public String listarCompras(String ordenaPor) {
		if (ordenaPor.equals("CLIENTE")) {
			Collections.sort(this.compras, new ComparaPorCliente());
			return this.compras.stream().map(p -> p.getCliente() + ", " + p.getFornecedor() + ", "
					+ p.getNomeProd() + ", " + p.getData()).collect(Collectors.joining(" | "));
		} else if (ordenaPor.equals("FORNECEDOR")) {
			Collections.sort(this.compras, new ComparaPorFornecedor());
			return this.compras.stream().map(p -> p.getFornecedor() + ", " + p.getCliente() + ", "
					+ p.getNomeProd() + ", " + p.getData()).collect(Collectors.joining(" | "));
		} else {
			Collections.sort(this.compras, new ComparaPorData());
			return this.compras.stream().map(p -> p.getData() + ", " + p.getCliente() + ", "
					+ p.getFornecedor() + ", " + p.getNomeProd()).collect(Collectors.joining(" | "));
		}
	}
	
	@Override
	public String toString() {
		return this.compras.stream().map(p -> p.toString()).collect(Collectors.joining(" | "));
	}
	
	/*@Override
	public int compareTo(Conta o) {
		return this.fornecedor.compareTo(o.fornecedor);
	}*/
}

/**


 Expected <Amigao Fernandes, Marcos, Coxao de frango com cheddar, 08/11/2018 | 
 Ana Amari, Marcos, Coxao de frango com cheddar, 01/11/2016 | 
 Ana Amari, Marcos, Refrigerante (lata), 01/11/2016 | 
 Dalto, Joabe, Um Bolo e uma Trufa, 06/11/2018 | Dalto, Severo, Cocada de doce de leite com amendoin e agua gelada, 04/11/2018 | 
 Joao Neto, Joabe, Bolo de trigo com cobertura de chocolate, 08/11/2018 | Joao Neto, Joabe, Doce sabor beijinho, 07/11/2018 | 
 Joao Neto, Severo, Garrafa de agua 500ml, 08/11/2018 | Lucio Correia, Dona Alba, Feijao com arroz e queijo coalho, 11/11/2011 | 
 Lucio Correia, Marcos, Coxao de frango com presunto e queijo, 07/04/1998 | Lucio Correia, Marcos, Refrigerante (lata), 11/12/1998 | 
 Zana, Severo, Cocada de doce de leite com pedacos de amendoin, 05/11/2018>, 
 but was <Lucio Correia, Marcos, Coxao de Pizza, 07/04/1998 | Lucio Correia, Marcos, Refrigerante, 11/12/1998 | 
 Lucio Correia, Dona Alba, Rubacao, 11/11/2011Joao Neto, Severo, Agua, 08/11/2018 | Joao Neto, Joabe, Bolo de Chocolate, 08/11/2018 | 
 Joao Neto, Joabe, Trufa de Beijinho, 07/11/2018 Ana Amari, Marcos, Refrigerante, 01/11/2016 | Ana Amari, Marcos, Coxao de Frango, 01/11/2016
 Amigao Fernandes, Marcos, Coxao de Frango, 08/11/2018Zana, Severo, Cocada de Amendoin, 05/11/2018Dalto, Severo, Cocada com Agua, 04/11/2018 | 
 Dalto, Joabe, Bolo de Chocolate + Trufa de Beijinho, 06/11/2018>









*/