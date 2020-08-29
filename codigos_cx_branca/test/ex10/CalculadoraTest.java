package ex10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	// Caminho: 1, 2, 4, 5, 6, 4, 7, 9
	@Test
	void testCasoSucesso() throws Exception {
		Calculadora c = new Calculadora();
		assertEquals(0, c.somatoriaLimitada(0, 10));
	}
	
	// Caminho: 1, 2, 3, 4, 5, 6, 4, 5, 6, 4, 7, 9
	@Test
	void testCasoSucessoComValorNegativo() throws Exception {
		Calculadora c = new Calculadora();
		assertEquals(1, c.somatoriaLimitada(-1, 10));
	}	
	
	// Caminho: 1, 2, 4, 5, 6, 4, 5, 6, 4, 7, 8
	@Test
	void testExceptionValorLimite() {
		Calculadora c = new Calculadora();
		assertThrows(Exception.class, () -> {
			c.somatoriaLimitada(1, 0);
		});
	}		
	
	// Caminho: 
	@Test
	void testExceptionValorLimite2() throws Exception {
		Calculadora c = new Calculadora();
		assertThrows(Exception.class, () -> {
			c.somatoriaLimitada(0, -1);
		});
	}	
}
