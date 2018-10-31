package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FornecedorTest {

	
	@Test
	void test() {
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor ("         ", "marcos@gmail.com", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor ("Marcos", "          ", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor ("Marcos", "marcos@gmail.com", "                   "));
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor (null, "marcos@gmail.com", "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor ("Marcos", null, "83 99151-3570"));
		assertThrows(IllegalArgumentException.class, ()-> new Fornecedor ("Marcos", "marcos@gmail.com", null));
	}

}
