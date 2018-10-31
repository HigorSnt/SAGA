package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteControllerTest {
	
	private ClienteController cc = new ClienteController();
	
	@BeforeEach
	public void Cadastra() {
		cc.cadastraCliente("58217738123", "Lucio Correia", "lucio_correia@ccc.ufcg.edu.br", "SPLab");
	}
	
	@Test
	public void cadastraCliente() {
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("1111111111111111111", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("94412783134", "Wilson Andre", "     ", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("94412783134", "           ", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "       "));
		assertThrows(NullPointerException.class, ()-> cc.cadastraCliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", null));
		assertThrows(NullPointerException.class, ()-> cc.cadastraCliente("94412783134", "Wilson Andre", null, "Embedded"));
		assertThrows(NullPointerException.class, ()-> cc.cadastraCliente("94412783134", null, "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(NullPointerException.class, ()-> cc.cadastraCliente(null, "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertThrows(IllegalArgumentException.class, ()-> cc.cadastraCliente("", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		
		assertThrows(IllegalArgumentException.class,()-> cc.exibeCliente("88888888888"));
		assertEquals("00023827490", cc.cadastraCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc"));
		assertThrows(IllegalArgumentException.class,()-> cc.cadastraCliente("00023827490", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertEquals("94412783134", cc.cadastraCliente("94412783134", "Wilson Andre", "wilson_andre@ccc.ufcg.edu.br", "Embedded"));
		assertEquals("19418510068", cc.cadastraCliente("19418510068", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "LSD"));
	}
	
	@Test
	public void editaCliente() {
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("88888888888", "nome", "Wilson"));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "    ", "Wilson"));
		assertThrows(NullPointerException.class, ()-> cc.editaCliente("94412783134", null, "sgvdfg"));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "nome", null));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "nome", "       "));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "email", null));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "email", "       "));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "localizacao", null));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "localizacao", "       "));
		assertThrows(IllegalArgumentException.class, ()-> cc.editaCliente("94412783134", "sobrenome", "bdfgdfg"));
		
		assertEquals("Lucio Correia - SPLab - lucio_correia@ccc.ufcg.edu.br", cc.exibeCliente("58217738123"));
		cc.editaCliente("58217738123", "nome", "Lucio");
		cc.editaCliente("58217738123", "email", "lucio@ccc.ufcg.edu.br");
		cc.editaCliente("58217738123", "localizacao", "LSD");
		assertEquals("Lucio - LSD - lucio@ccc.ufcg.edu.br", cc.exibeCliente("58217738123"));
	}

}
