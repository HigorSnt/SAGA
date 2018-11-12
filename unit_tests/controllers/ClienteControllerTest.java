package controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.ClienteController;

class ClienteControllerTest {
	
	private ClienteController cc = new ClienteController();
	private FornecedorController fc = new FornecedorController();
	
	@BeforeEach
	public void Cadastra() {
		cc.cadastraCliente("58217738123", "Lucio Correia", "lucio_correia@ccc.ufcg.edu.br", "SPLab");
		cc.cadastraCliente("64269141198", "Ana Amari", "ana_amari@ccc.ufcg.edu.br", "SPG");
		fc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fc.adicionaFornecedor("Marcos","marcos@gmail.com", "83 99151-3570");
		fc.adicionaProduto("Seu Olavo", "Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50);
		fc.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50);
		fc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", 2.50);
	}
	
	@Test
	public void testeCadastraCliente() {
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("1111111111111111111", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("94412783134", "Wilson Andre", "     ", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("94412783134", "           ", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "       "));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", null));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("94412783134", "Wilson Andre", null, "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("94412783134", null, "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente(null, "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("       ", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("1250", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		
		assertThrows(IllegalArgumentException.class,()-> cc.exibeCliente("88888888888"));
		assertEquals("00023827490", cc.cadastraCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc"));
		assertThrows(IllegalArgumentException.class,()-> cc.cadastraCliente("00023827490", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertEquals("94412783134", cc.cadastraCliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertEquals("19418510068", cc.cadastraCliente("19418510068", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "LSD"));
	}
	
	@Test
	public void testeExibeClientes() {
		String s = "Ana Amari - SPG - ana_amari@ccc.ufcg.edu.br | "
				+ "Lucio Correia - SPLab - lucio_correia@ccc.ufcg.edu.br";
		assertEquals(s, cc.exibeClientes());
	}
	
	@Test
	public void testeEditaCliente() {
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("88888888888", "nome", "Wilson"));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "    ", "Wilson"));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", null, "sgvdfg"));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "nome", null));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "nome", "       "));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "email", null));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "email", "       "));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "localizacao", null));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "localizacao", "       "));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("58217738123", "sobrenome", "bdfgdfg"));
		
		assertEquals("Lucio Correia - SPLab - lucio_correia@ccc.ufcg.edu.br", cc.exibeCliente("58217738123"));
		cc.editaCliente("58217738123", "nome", "Lucio");
		cc.editaCliente("58217738123", "email", "lucio@ccc.ufcg.edu.br");
		cc.editaCliente("58217738123", "localizacao", "LSD");
		assertEquals("Lucio - LSD - lucio@ccc.ufcg.edu.br", cc.exibeCliente("58217738123"));
	}
	
	@Test
	public void testeRemoveCliente() {
		assertThrows(IllegalArgumentException.class, ()-> cc.removeCliente("11111111111"));
		assertThrows(IllegalArgumentException.class, ()-> cc.removeCliente(null));
		assertThrows(IllegalArgumentException.class, ()-> cc.removeCliente("      "));
		assertThrows(IllegalArgumentException.class, ()-> cc.removeCliente("11111111111111111111111"));
		assertThrows(IllegalArgumentException.class, ()-> cc.removeCliente("111"));
		
		assertEquals("Ana Amari - SPG - ana_amari@ccc.ufcg.edu.br", cc.exibeCliente("64269141198"));
		cc.removeCliente("64269141198");
		assertThrows(IllegalArgumentException.class, ()-> cc.removeCliente("64269141198"));
	}
	
	@Test
	public void testeAdicionaCompra() {
		assertEquals("Seu Olavo", cc.adicionaCompra("58217738123", "Seu Olavo", "02/04/2015", "X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50));
		assertEquals(4.50, cc.getDebito("58217738123", "Seu Olavo"));
		assertThrows(IllegalArgumentException.class, ()-> cc.getDebito("58217738123", "Marcos"));
	}
	
	@Test
	public void testeExibeContas() {
		cc.adicionaCompra("58217738123", "Seu Olavo", "02/04/2015", "X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50);
		cc.adicionaCompra("58217738123", "Seu Olavo", "07/04/1998", "Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50);
		assertEquals("Cliente: Lucio Correia | Seu Olavo | X-burguer - 02-04-2015"
				+ " | Coxao de Pizza - 07-04-1998", cc.exibeContas("58217738123", "Seu Olavo"));
		assertThrows(IllegalArgumentException.class, ()-> cc.exibeContas("58217738123", "Marcos"));
	}
	
	@Test
	public void testeExibeContasClientes() {
		assertThrows(IllegalArgumentException.class, ()-> cc.exibeContasClientes("58217738123"));
		cc.adicionaCompra("58217738123", "Seu Olavo", "02/04/2015", "X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50);
		cc.adicionaCompra("58217738123", "Seu Olavo", "07/04/1998", "Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50);
		cc.adicionaCompra("58217738123", "Marcos", "03/12/2013", "Coxao de Frango", "Coxao de frango com cheddar", 2.50);
		
		String s = "Cliente: Lucio Correia | Marcos | Coxao de Frango - 03-12-2013 | "
				+ "Seu Olavo | X-burguer - 02-04-2015 | Coxao de Pizza - 07-04-1998";
		assertEquals(s, cc.exibeContasClientes("58217738123"));
		
		cc.realizaPagamento("58217738123", "Marcos");
		assertEquals("Cliente: Lucio Correia | Seu Olavo | X-burguer - 02-04-2015 | "
				+ "Coxao de Pizza - 07-04-1998", cc.exibeContasClientes("58217735123"));
	}

}
