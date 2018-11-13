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
		
		assertTrue(cc.contemCliente("58217738123"));
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
		assertThrows(IllegalArgumentException.class, ()-> cc.removeCliente(null));
		assertThrows(IllegalArgumentException.class, ()-> cc.removeCliente("     "));
		assertThrows(IllegalArgumentException.class, ()-> cc.removeCliente("123"));
		assertThrows(IllegalArgumentException.class, ()-> cc.removeCliente("12345678900000000"));
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
				+ "Coxao de Pizza - 07-04-1998", cc.exibeContasClientes("58217738123"));
	}
	
	@Test
	public void testeListarCompras() {
		ClienteController clientec = new ClienteController();
		FornecedorController fornecedorc = new FornecedorController();
		
		fornecedorc.adicionaFornecedor("Joabe", "joabecompena@gmail.com", "83 90036-5012");
		fornecedorc.adicionaFornecedor("Severo", "seusevero@hotmail.com", "83 7898-4565");
		fornecedorc.adicionaFornecedor("Dona Alba", "alba@gmail.com", "83 99945-1294");
		fornecedorc.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		
		clientec.cadastraCliente("12312312312", "Joao Neto", "joao.neto@ccc.ufcg.edu.br", "LIA");
		clientec.cadastraCliente("45645645645", "Dalto", "dalto@gmail.com", "SPLAB");
		clientec.cadastraCliente("78978978978", "Zana", "zanazaninha@bol.com", "LSI");
		clientec.cadastraCliente("58217738123", "Lucio Correia", "lucio_correia@ccc.ufcg.edu.br", "SPLab");
		clientec.cadastraCliente("19418510068", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "LSD");
		
		fornecedorc.adicionaProduto("Marcos", "Batata frita", "Porcao de batata frita", 4.00);
		fornecedorc.adicionaProduto("Marcos", "Refrigerante", "Refrigerante (lata)", 2.50);
		fornecedorc.adicionaProduto("Joabe", "Bolo de Chocolate", "Bolo de trigo com cobertura de chocolate", 2.00);
		fornecedorc.adicionaProduto("Joabe", "Trufa de Beijinho", "Doce sabor beijinho", 1.50);
		fornecedorc.adicionaProduto("Severo", "Cocada de Amendoin", "Cocada de doce de leite com pedacos de amendoin", 1.50);
		fornecedorc.adicionaProduto("Severo", "Agua", "Garrafa de agua 500ml", 1.00);
		fornecedorc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", 2.50);
		fornecedorc.adicionaProduto("Dona Alba", "Rubacao", "Feijao com arroz e queijo coalho", 14.00);
		fornecedorc.adicionaCombo("Marcos", "Coxao com batata", "Coxao de frango com batata frita", 0.30, "Coxao de Frango - Coxao de frango com cheddar, Refrigerante - Refrigerante (lata)");
		fornecedorc.adicionaCombo("Joabe", "Bolo de Chocolate + Trufa de Beijinho", "Um Bolo e uma Trufa", 0.10, "Bolo de Chocolate - Bolo de trigo com cobertura de chocolate, Trufa de Beijinho - Doce sabor beijinho");
		fornecedorc.adicionaCombo("Severo", "Cocada com Agua", "Cocada de doce de leite com amendoin e agua gelada", 0.25, "Cocada de Amendoin - Cocada de doce de leite com pedacos de amendoin, Agua - Garrafa de agua 500ml");
		
		clientec.adicionaCompra("12312312312", "Joabe", "08/11/2018", "Bolo de Chocolate", "Bolo de trigo com cobertura de chocolate", 2.00);
		clientec.adicionaCompra("12312312312", "Joabe", "07/11/2018", "Trufa de Beijinho", "Doce sabor beijinho", 1.50);
		clientec.adicionaCompra("12312312312", "Severo", "08/11/2018", "Agua", "Garrafa de agua 500ml", 1.00);
		clientec.adicionaCompra("45645645645", "Joabe", "06/11/2018", "Bolo de Chocolate + Trufa de Beijinho", "Um Bolo e uma Trufa", 3.15);
		clientec.adicionaCompra("78978978978", "Severo", "05/11/2018", "Cocada de Amendoin", "Cocada de doce de leite com pedacos de amendoin", 1.50);
		clientec.adicionaCompra("45645645645", "Severo", "04/11/2018", "Cocada com Agua", "Cocada de doce de leite com amendoin e agua gelada", 1.88);
		clientec.adicionaCompra("58217738123", "Dona Alba", "11/11/2011", "Rubacao", "Feijao com arroz e queijo coalho", 0);
		clientec.adicionaCompra("19418510068", "Marcos", "08/11/2018", "Coxao com batata", "Coxao de frango com batata frita", 4.55);
		
		assertThrows(IllegalArgumentException.class, ()-> clientec.setOrdenaPor(null));
		assertThrows(IllegalArgumentException.class, ()-> clientec.setOrdenaPor("            "));
		assertThrows(IllegalArgumentException.class, ()-> clientec.setOrdenaPor("produto"));
		assertThrows(IllegalArgumentException.class, ()-> clientec.listarCompras());
		
		String s1 = "Amigao Fernandes, Marcos, Coxao de frango com batata frita, 08/11/2018 | "
				+ "Dalto, Joabe, Um Bolo e uma Trufa, 06/11/2018 | Dalto, Severo, Cocada de doce de leite com amendoin e agua gelada, 04/11/2018"
				+ " | Joao Neto, Joabe, Bolo de trigo com cobertura de chocolate, 08/11/2018 | "
				+ "Joao Neto, Joabe, Doce sabor beijinho, 07/11/2018 | Joao Neto, Severo, Garrafa de agua 500ml, 08/11/2018 | "
				+ "Lucio Correia, Dona Alba, Feijao com arroz e queijo coalho, 11/11/2011 | "
				+ "Zana, Severo, Cocada de doce de leite com pedacos de amendoin, 05/11/2018";
		
		String s2 = "Dona Alba, Lucio Correia, Feijao com arroz e queijo coalho, 11/11/2011 | Joabe, Dalto, Um Bolo e uma Trufa, 06/11/2018 | "
				+ "Joabe, Joao Neto, Bolo de trigo com cobertura de chocolate, 08/11/2018 | Joabe, Joao Neto, Doce sabor beijinho, 07/11/2018 | "
				+ "Marcos, Amigao Fernandes, Coxao de frango com batata frita, 08/11/2018 | "
				+ "Severo, Dalto, Cocada de doce de leite com amendoin e agua gelada, 04/11/2018 | "
				+ "Severo, Joao Neto, Garrafa de agua 500ml, 08/11/2018 | "
				+ "Severo, Zana, Cocada de doce de leite com pedacos de amendoin, 05/11/2018";
		
		String s3 = "11/11/2011, Lucio Correia, Dona Alba, Feijao com arroz e queijo coalho | "
				+ "04/11/2018, Dalto, Severo, Cocada de doce de leite com amendoin e agua gelada | "
				+ "05/11/2018, Zana, Severo, Cocada de doce de leite com pedacos de amendoin | 06/11/2018, Dalto, Joabe, Um Bolo e uma Trufa | "
				+ "07/11/2018, Joao Neto, Joabe, Doce sabor beijinho | 08/11/2018, Amigao Fernandes, Marcos, Coxao de frango com batata frita | "
				+ "08/11/2018, Joao Neto, Joabe, Bolo de trigo com cobertura de chocolate | 08/11/2018, Joao Neto, Severo, Garrafa de agua 500ml";
		
		clientec.setOrdenaPor("cliente");
		assertEquals(s1, clientec.listarCompras());
		clientec.setOrdenaPor("fornecedor");
		assertEquals(s2, clientec.listarCompras());
		clientec.setOrdenaPor("data");
		assertEquals(s3, clientec.listarCompras());
		
	}

}
