package models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaTest {

	private Conta c = new Conta("Seu Olavo");
	
	@BeforeEach
	public void Compra() {
		c.adicionaCompra("Seu Olavo", "Amigao Fernandes", "Coxao com batata", "Coxao de frango com batata frita", "03/12/2013", 4.00);
		c.adicionaCompra("Seu Olavo", "Amigao Fernandes", "Coxao de Frango", "Coxao de frango com cheddar", "04/11/2018", 2.50);
	}
	
	@Test
	void testCompra() {
		assertEquals(6.50, c.getDebito());
		String s = "Seu Olavo | Coxao com batata - 03-12-2013 | Coxao de Frango - 04-11-2018";
		assertEquals(s, c.toString());
	}
	
	@Test
	public void testListarCompras() {
		List<Compra> l = new ArrayList<>();
		Compra c1 = new Compra("Seu Olavo", "Amigao Fernandes", "Coxao com batata", "Coxao de frango com batata frita", "03/12/2013", 4.00);
		Compra c2 = new Compra("Seu Olavo", "Amigao Fernandes", "Coxao de Frango", "Coxao de frango com cheddar", "04/11/2018", 2.50);
		l.add(c1);		l.add(c2);
		
		assertTrue(l.equals(c.listarCompras()));
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(6, c.compareTo(new Conta("Marcos")));
		assertEquals(0, c.compareTo(c));
		assertEquals(-7, c.compareTo(new Conta("Zana")));
	}
	
	@Test
	public void testEquals() {
		assertTrue(c.equals(c));
		assertFalse(c.equals(null));
		assertFalse(c.equals(new Cliente("11111111111", "a", "b", "c")));
		assertFalse(c.equals(new Conta(null)));
		assertFalse(new Conta(null).equals(c));
		assertFalse(c.equals(new Conta("Marcos")));
	}

}
