package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComboTest {
	
	private Combo c;
	
	@Test
	public void testCombo() {
		c = new Combo("X-burguer + suco", "X-burguer com suco de maracuja", 4.00, 0.20);
		assertEquals("X-burguer + suco", c.getNome());
		assertEquals("X-burguer com suco de maracuja", c.getDescricao());
		assertEquals(3.20, c.getPreco());
		c.setFator(0.5);
		assertEquals(2.00, c.getPreco());
	}

}
