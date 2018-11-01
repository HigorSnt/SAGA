package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.ClienteController;

class ClienteControllerTest {
	
	private ClienteController cc = new ClienteController();
	
	@BeforeEach
	public void Cadastra() {
		cc.cadastraCliente("58217738123", "Lucio Correia", "lucio_correia@ccc.ufcg.edu.br", "SPLab");
		cc.cadastraCliente("64269141198", "Ana Amari", "ana_amari@ccc.ufcg.edu.br", "SPG");
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

}
