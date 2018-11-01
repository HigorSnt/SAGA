package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Cliente;
import models.Fornecedor;

class FornecedorTest {
	private Fornecedor f1;
	private Fornecedor f2;
	
	@BeforeEach
	public void Construtor() {
		f1 = new Fornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		f2 = new Fornecedor("Dona Alba", "alba@gmail.com", "83 99945-1294");
		
		f1.cadastraProduto("X-frango", "Hamburguer de frango com queijo e calabresa", 5.00);
		f1.cadastraProduto("X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50);
		f2.cadastraProduto("Rubacao", "Feijao com arroz e queijo coalho", 14.00);
	}
	
	@Test
	public void testConstrutor() {
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor ("         ", "marcos@gmail.com", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor ("Marcos", "          ", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor ("Marcos", "marcos@gmail.com", "                   "));
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor (null, "marcos@gmail.com", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor ("Marcos", null, "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor ("Marcos", "marcos@gmail.com", null));
		
		assertEquals("Dona Alba - alba@gmail.com - 83 99945-1294", f2.toString());
		assertEquals("Marcos", f1.getNome());
		assertEquals("marcos@gmail.com", f1.getEmail());
		assertEquals("83 99151-3570", f1.getTelefone());
	}
	
	@Test
	public void testSetEmail() {
		assertThrows(IllegalArgumentException.class, ()-> f1.setEmail("              "));
		assertThrows(IllegalArgumentException.class, ()-> f1.setEmail(null));
		
		f2.setEmail("dona_alba@gmail.com");
		assertEquals("dona_alba@gmail.com", f2.getEmail());
	}
	
	@Test
	public void testSetTelefone() {
		assertThrows(IllegalArgumentException.class, ()-> f1.setTelefone("              "));
		assertThrows(IllegalArgumentException.class, ()-> f1.setTelefone(null));
		
		f2.setTelefone("83 999451294");
		assertEquals("83 999451294", f2.getTelefone());
	}
	
	@Test
	public void testCadastraProduto() {
		assertThrows(IllegalArgumentException.class, ()-> f1.cadastraProduto("X-frango", "Hamburguer de frango com queijo e calabresa", -4.0));
		assertThrows(IllegalArgumentException.class, ()-> f1.cadastraProduto("", "Hamburguer de frango com queijo e calabresa", 5.00));
		assertThrows(IllegalArgumentException.class, ()-> f1.cadastraProduto("X-frango", "", 5.00));
		assertThrows(IllegalArgumentException.class, ()-> f1.cadastraProduto(null, "Hamburguer de frango com queijo e calabresa", 5.00));
		assertThrows(IllegalArgumentException.class, ()-> f1.cadastraProduto("X-frango", null, 5.00));
		assertThrows(IllegalArgumentException.class, ()-> f1.cadastraProduto("X-frango", "Hamburguer de frango com queijo e calabresa", 0.00));
		assertThrows(IllegalArgumentException.class, ()-> f1.cadastraProduto("X-frango", "Hamburguer de frango com queijo e calabresa", 7.00));
	}
	
	@Test
	public void testRetornaProduto() {
		assertEquals("X-frango - Hamburguer de frango com queijo e calabresa - R$5,00", f1.retornaProduto("X-frango Hamburguer de frango com queijo e calabresa"));
		assertEquals("X-burguer - Hamburguer de carne com queijo e calabresa - R$4,50", f1.retornaProduto("X-burguer Hamburguer de carne com queijo e calabresa"));
		assertEquals("Rubacao - Feijao com arroz e queijo coalho - R$14,00", f2.retornaProduto("Rubacao Feijao com arroz e queijo coalho"));
	}
	
	@Test
	public void testEditaPrecoProduto() {
		assertThrows(IllegalArgumentException.class, ()-> f1.editaPrecoProduto("X-frango Hamburguer de frango com queijo e calabresa", 0.0));
		assertThrows(IllegalArgumentException.class, ()-> f1.editaPrecoProduto("X-frango", 0.0));
		
		f1.editaPrecoProduto("X-frango Hamburguer de frango com queijo e calabresa", 4.00);
		assertEquals("R$4,00", f1.getPrecoProduto("X-frango", "Hamburguer de frango com queijo e calabresa"));
		assertThrows(IllegalArgumentException.class, ()-> f1.getPrecoProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo"));
		assertThrows(IllegalArgumentException.class, ()-> f1.getPrecoProduto("", "Hamburguer de frango com queijo e calabresa"));
		assertThrows(IllegalArgumentException.class, ()-> f1.getPrecoProduto("X-frango", ""));
		assertThrows(IllegalArgumentException.class, ()-> f1.getPrecoProduto(null, "Hamburguer de frango com queijo e calabresa"));
		assertThrows(IllegalArgumentException.class, ()-> f1.getPrecoProduto("X-frango", null));
	}
	
	@Test
	public void testExibeProdutosFornecedor() {
		String s = "Marcos - X-burguer - Hamburguer de carne com queijo e calabresa - R$4,50 | "
				+ "Marcos - X-frango - Hamburguer de frango com queijo e calabresa - R$5,00";
		
		assertEquals(s, f1.exibeProdutosFornecedor());
	}
	
	@Test
	public void testRemoveProduto() {
		assertThrows(IllegalArgumentException.class, ()-> f1.removeProduto("        ", "Hamburguer de carne com queijo e calabresa"));
		assertThrows(IllegalArgumentException.class, ()-> f1.removeProduto("X-frango", ""));
		assertThrows(IllegalArgumentException.class, ()-> f1.removeProduto(null, "Hamburguer de carne com queijo e calabresa"));
		assertThrows(IllegalArgumentException.class, ()-> f1.removeProduto("X-frango", null));
		assertThrows(IllegalArgumentException.class, ()-> f1.removeProduto("Coxao de Pizza", "Coxao de frango com presunto e queijo"));
		
		assertEquals("X-burguer - Hamburguer de carne com queijo e calabresa - R$4,50", f1.retornaProduto("X-burguer Hamburguer de carne com queijo e calabresa"));
		f1.removeProduto("X-burguer", "Hamburguer de carne com queijo e calabresa");
		assertThrows(IllegalArgumentException.class, ()-> f1.retornaProduto("X-burguer Hamburguer de carne com queijo e calabresa"));
	}
	
	@Test
	public void testEquals() {
		assertFalse(f1.equals(f2));
		assertFalse(f1.equals(null));
		assertFalse(f1.equals(new Cliente("00000000000", "e", "i", "o")));
		assertTrue(f1.equals(f1));
		assertTrue(f1.equals(new Fornecedor("Marcos", "a", "8888")));
		assertFalse(f1.equals(new Fornecedor("Dona Alba", "marcos@gmail.com", "83 99151-3570")));
	}
}
