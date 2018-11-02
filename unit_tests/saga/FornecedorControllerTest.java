package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.FornecedorController;

class FornecedorControllerTest {
	
	private FornecedorController fc = new FornecedorController();
	
	@BeforeEach
	public void cadastrando() {
		fc.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
	}
	@Test
	public void testAdicionaFornecedor() {
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("         ", "quiosque@gmail.com", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("Helhao", "          ", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("Helhao", "quiosque@gmail.com", "                   "));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor(null, "quiosque@gmail.com", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("Helhao", null, "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("Helhao", "quiosque@gmail.com", null));
		
		fc.adicionaFornecedor("Helhao", "quiosque@gmail.com", "83 98736-5050");
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("Marcos", "marcos@gmail.com", null));

		String s = "Helhao - quiosque@gmail.com - 83 98736-5050 | "
				+ "Marcos - marcos@gmail.com - 83 99151-3570";
		assertEquals(s, fc.exibeFornecedores());
	}
	
	@Test
	public void testEditaFornecedor() {
		assertThrows(IllegalArgumentException.class, ()-> fc.editaFornecedor("Marcos", "", "Marc"));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaFornecedor("Marcos", null, "Marc"));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaFornecedor("Marcos", "nome", "      "));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaFornecedor("Marcos", "email", "     "));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaFornecedor("Marcos", "email", null));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaFornecedor("Marcos", "telefone", "      "));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaFornecedor("Marcos", "telefone", null));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaFornecedor("Marcos", "empresa", "teste"));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaFornecedor("Helhao", "email", "helhao@gmail.com"));
		
		fc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fc.editaFornecedor("Seu Olavo", "email", "olavo@hotmail.com");
		fc.editaFornecedor("Seu Olavo", "telefone", "83 993481092");
		assertEquals("Seu Olavo - olavo@hotmail.com - 83 993481092", fc.exibeFornecedor("Seu Olavo"));
	}

	
	@Test
	public void testRemoveFornecedor() {
		assertThrows(IllegalArgumentException.class, ()-> fc.removeFornecedor(null));
		assertThrows(IllegalArgumentException.class, ()-> fc.removeFornecedor("     "));
		assertThrows(IllegalArgumentException.class, ()-> fc.removeFornecedor("Seu Olavo"));
		fc.removeFornecedor("Marcos");
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeFornecedor("Marcos"));
	}
	
	@Test
	public void testAdicionaProduto() {
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaProduto("      ","Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaProduto(null,"Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaProduto("Helhao", "Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaProduto("Marcos","           ", "Coxao de frango com presunto e queijo", 2.50));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaProduto("Marcos", null, "Coxao de frango com presunto e queijo", 2.50));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaProduto("Marcos","Coxao de Pizza", "       ", 2.50));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaProduto("Marcos","           ", null, 2.50));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaProduto("Marcos","           ", null, 0.0));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaProduto("Marcos","           ", null, -2.50));
	
		assertEquals("Coxao de Pizza Coxao de frango com presunto e queijo", fc.adicionaProduto("Marcos", "Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50));
	}
	
	@Test
	public void testExibeProduto() {
		fc.adicionaProduto("Marcos", "Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50);
		fc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", 2.50);
		
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProduto(null, "Coxao de frango com presunto e queijo", "Marcos"));
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProduto("    ", "Coxao de frango com presunto e queijo", "Marcos"));
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProduto("Coxao de Pizza", null, "Marcos"));
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProduto("Coxao de Pizza", "          ", "Marcos"));
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "          "));
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", null));
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "Helhao"));
		
		assertEquals("Coxao de Pizza - Coxao de frango com presunto e queijo - R$2,50", fc.exibeProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "Marcos"));
		
		String s = "Marcos - Coxao de Frango - Coxao de frango com cheddar - R$2,50 | "
				+ "Marcos - Coxao de Pizza - Coxao de frango com presunto e queijo - R$2,50";
		
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProdutosFornecedor(null));
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProdutosFornecedor("           "));
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProdutosFornecedor("Helhao"));
		assertEquals(s, fc.exibeProdutosFornecedor("Marcos"));
	}
	
	@Test
	public void testExibeProdutos() {
		fc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fc.adicionaFornecedor("Dona Alba", "alba@gmail.com", "83 99945-1294");
		fc.adicionaProduto("Marcos", "Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50);
		fc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", 2.50);
		fc.adicionaProduto("Seu Olavo", "X-frango", "Hamburguer de frango com queijo e calabresa", 5.00);
		fc.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50);
		fc.adicionaProduto("Dona Alba", "Rubacao", "Feijao com arroz e queijo coalho", 14.00);
		
		String s = "Dona Alba - Rubacao - Feijao com arroz e queijo coalho - R$14,00 | "
				+ "Marcos - Coxao de Frango - Coxao de frango com cheddar - R$2,50 | "
				+ "Marcos - Coxao de Pizza - Coxao de frango com presunto e queijo - R$2,50 | "
				+ "Seu Olavo - X-burguer - Hamburguer de carne com queijo e calabresa - R$4,50 | "
				+ "Seu Olavo - X-frango - Hamburguer de frango com queijo e calabresa - R$5,00";
		assertEquals(s, fc.exibeProdutos());
	}
	
	@Test
	public void testEditaPrecoProdutoERemoveProduto() {
		fc.adicionaProduto("Marcos", "Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50);
		fc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", 2.50);
	
		assertThrows(IllegalArgumentException.class, ()-> fc.editaProduto(null, "Coxao de frango com presunto e queijo", "Marcos", 3.00));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaProduto("        ", "Coxao de frango com presunto e queijo", "Marcos", 3.00));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaProduto("Coxao de Pizza", null, "Marcos", 3.00));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaProduto("Coxao de Pizza", "    ", "Marcos", 3.00));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", null, 3.00));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "    ", 3.00));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "Marcos", 0.00));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "Marcos", -3.00));
		assertThrows(IllegalArgumentException.class, ()-> fc.editaProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "Helhao", 3.00));
		
		fc.editaProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "Marcos", 3.00);
		assertEquals("Coxao de Pizza - Coxao de frango com presunto e queijo - R$3,00", fc.exibeProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "Marcos"));
		
		assertThrows(IllegalArgumentException.class, ()-> fc.removeProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", null));
		assertThrows(IllegalArgumentException.class, ()-> fc.removeProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "         "));
		assertThrows(IllegalArgumentException.class, ()-> fc.removeProduto("Coxao de Pizza", "          ", "Marcos"));
		assertThrows(IllegalArgumentException.class, ()-> fc.removeProduto("Coxao de Pizza", null, "Marcos"));
		assertThrows(IllegalArgumentException.class, ()-> fc.removeProduto("        ", "Coxao de frango com presunto e queijo", "Marcos"));
		assertThrows(IllegalArgumentException.class, ()-> fc.removeProduto(null, "Coxao de frango com presunto e queijo", "Marcos"));
		
		fc.removeProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "Marcos");
		assertThrows(IllegalArgumentException.class, ()-> fc.exibeProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo", "Marcos"));
	}

}
