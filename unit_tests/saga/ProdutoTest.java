package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTest {
	
	private Produto p1;
	private Produto p2;
	
	@BeforeEach
	public void Construtor() {
		p1 = new Produto ("X-frango", "Hamburguer de frango com queijo e calabresa", 5.00);
		p2 = new Produto ("Coxao de Pizza", "Coxao de frango com presunto e queijo", 2.50);
	}
	
	@Test
	public void testConstrutor() {
		assertThrows(IllegalArgumentException.class, ()-> new Produto("", "Hamburguer de frango com queijo e calabresa", 5.00));
		assertThrows(IllegalArgumentException.class, ()-> new Produto("X-frango", "", 5.00));
		assertThrows(IllegalArgumentException.class, ()-> new Produto("X-frango", "Hamburguer de frango com queijo e calabresa", 0.0));
		assertThrows(NullPointerException.class, ()-> new Produto(null, "Hamburguer de frango com queijo e calabresa", 5.00));
		assertThrows(NullPointerException.class, ()-> new Produto("X-frango", null, 5.00));
		
		assertEquals("Coxao de Pizza - Coxao de frango com presunto e queijo - R$2,50", p2.toString());
		assertEquals("X-frango Hamburguer de frango com queijo e calabresa", p1.getNomeDescricao());
		assertEquals("R$5,00", p1.getPreco());
	}
	
	@Test
	public void testSetPreco() {
		assertThrows(IllegalArgumentException.class, ()-> p1.setPreco(0.0));
		assertEquals("R$5,00", p1.getPreco());
		p1.setPreco(4.00);
		assertEquals("R$4,00", p1.getPreco());
	}
	
	@Test
	public void testEquals() {
		assertFalse(p1.equals(p2));
		assertFalse(p1.equals(null));
		assertFalse(p1.equals(new Cliente("00000000000", "e", "i", "o")));
		assertTrue(p1.equals(p1));
		assertTrue(p1.equals(new Produto("X-frango", "Hamburguer de frango com queijo e calabresa", 8.00)));
		assertTrue(p1.equals(new Produto("X-frango", "Hamburguer de frango com queijo e calabresa", 4.00)));
	}

}
