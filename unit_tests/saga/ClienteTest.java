package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Cliente;
import models.Produto;

class ClienteTest {

	private Cliente c1;
	private Cliente c2;
	
	@BeforeEach
	public void Contrutor() {
		c1 = new Cliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		c2 = new Cliente("64269141198", "Ana Amari", "ana_amari@ccc.ufcg.edu.br", "SPG");
	}
	
	@Test
	public void testConstrutor() {
		assertThrows(IllegalArgumentException.class, ()-> new Cliente("1111111111111111111", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> new Cliente("94412783134", "Wilson Andre", "     ", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> new Cliente("94412783134", "           ", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> new Cliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "       "));
		assertThrows(IllegalArgumentException.class, ()-> new Cliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", null));
		assertThrows(IllegalArgumentException.class, ()-> new Cliente("94412783134", "Wilson Andre", null, "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> new Cliente("94412783134", null, "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> new Cliente(null, "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> new Cliente("", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		
		assertEquals("00023827490", c1.getCpf());
		assertEquals("Victor Emanuel", c1.getNome());
		assertEquals("vitao@ccc.ufcg.edu.br", c1.getEmail());
		assertEquals("Labarc", c1.getLocalizacao());
		assertEquals("Ana Amari - SPG - ana_amari@ccc.ufcg.edu.br", c2.toString());
	}
	
	@Test
	public void testSetNome() {
		assertThrows(IllegalArgumentException.class, ()-> c1.setNome("       "));
		assertThrows(IllegalArgumentException.class, ()-> c1.setNome(null));
		
		assertEquals("vitao@ccc.ufcg.edu.br", c1.getEmail());
		c1.setEmail("vitao-cc@ccc.ufcg.edu.br");
		assertEquals("vitao-cc@ccc.ufcg.edu.br", c1.getEmail());
	}
	
	@Test
	public void testSetEmail() {
		assertThrows(IllegalArgumentException.class, ()-> c1.setEmail("       "));
		assertThrows(IllegalArgumentException.class, ()-> c1.setEmail(null));
		
		assertEquals("Victor Emanuel", c1.getNome());
		c1.setNome("Victor");
		assertEquals("Victor", c1.getNome());
	}
	
	@Test
	public void testSetLocalizacao() {
		assertThrows(IllegalArgumentException.class, ()-> c1.setLocalizacao("       "));
		assertThrows(IllegalArgumentException.class, ()-> c1.setLocalizacao(null));
		
		assertEquals("Labarc", c1.getLocalizacao());
		c1.setLocalizacao("Analytics");
		assertEquals("Analytics", c1.getLocalizacao());
	}
	@Test
	public void testEquals() {
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(null));
		assertFalse(c1.equals(new Produto("Comida", "Boa", 2.00)));
		assertTrue(c1.equals(c1));
		assertFalse(c1.equals(new Cliente("08274904781", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc")));
	}

}
