package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompraTest {

	private Compra c;
	
	@Test
	public void testCompra() {
		c = new Compra("Marcos", "Amigao Fernandes", "Coxao com batata", "Coxao de frango com batata frita", "03/12/2013", 4.00);
		assertEquals("Amigao Fernandes", c.getCliente());
		assertEquals("Marcos", c.getFornecedor());
		assertEquals(4.00, c.getPreco());
		assertEquals("03/12/2013", c.getData());
		assertEquals("Coxao com batata", c.getNomeProd());
		assertEquals("Coxao de frango com batata frita", c.getDescProd());
		
		assertEquals("Coxao com batata - 03-12-2013", c.toString());
	}
	
	@Test
	public void testEquals() {
		c = new Compra("Marcos", "Amigao Fernandes", "Coxao com batata", "Coxao de frango com batata frita", "03/12/2013", 4.00);
		
		assertTrue(c.equals(c));
		assertFalse(c.equals(null));
		assertFalse(c.equals(new Conta("Marcos")));
		
		assertFalse(c.equals(new Compra("Marcos", "Amigao Fernandes", "Coxao com batata", "Coxao de frango com batata frita", null, 4.00)));
		assertFalse(new Compra("Marcos", "Amigao Fernandes", "Coxao com batata", "Coxao de frango com batata frita", null, 4.00).equals(c));
		assertFalse(c.equals(new Compra("Marcos", "Amigao Fernandes", "Coxao com batata", "Coxao de frango com batata frita", "03/12/2015", 4.00)));
		assertFalse(c.equals(new Compra("Marcos", "Amigao Fernandes", "Coxao com batata", null, "03/12/2013", 4.00)));
		assertFalse(new Compra("Marcos", "Amigao Fernandes", "Coxao com batata", null, "03/12/2013", 4.00).equals(c));
		assertFalse(c.equals(new Compra("Marcos", "Amigao Fernandes", "Coxao com batata", "Coxao de frango com batata", "03/12/2013", 4.00)));
		assertFalse(c.equals(new Compra("Marcos", "Amigao Fernandes", null, "Coxao de frango com batata frita", "03/12/2013", 4.00)));
		assertFalse(new Compra("Marcos", "Amigao Fernandes", null, "Coxao de frango com batata frita", "03/12/2013", 4.00).equals(c));
		assertFalse(c.equals(new Compra("Marcos", "Amigao Fernandes", "Coxao", "Coxao de frango com batata frita", "03/12/2013", 4.00)));
		
	}

}
