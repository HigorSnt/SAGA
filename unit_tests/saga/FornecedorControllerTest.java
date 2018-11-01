package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FornecedorControllerTest {
	
	private FornecedorController fc = new FornecedorController();

	@Test
	public void testAdicionaFornecedor() {
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("         ", "marcos@gmail.com", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("Marcos", "          ", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("Marcos", "marcos@gmail.com", "                   "));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor(null, "marcos@gmail.com", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("Marcos", null, "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> fc.adicionaFornecedor("Marcos", "marcos@gmail.com", null));
		
		fc.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
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
		
		fc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fc.editaFornecedor("Seu Olavo", "email", "olavo@hotmail.com");
		fc.editaFornecedor("Seu Olavo", "telefone", "83 993481092");
		assertEquals("Seu Olavo - olavo@hotmail.com - 83 993481092", fc.exibeFornecedor("Seu Olavo"));
	}

}
