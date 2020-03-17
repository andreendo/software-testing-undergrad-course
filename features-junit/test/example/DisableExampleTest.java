package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DisableExampleTest {

	@Test
	void testDoisNumerosPositivos() {
		Operacoes op = new Operacoes();
		assertEquals(5, op.soma(2, 3));
	}
	
	@Disabled
	@Test
	void testDoisNumerosNegativos() {
		Operacoes op = new Operacoes();
		assertEquals(-5, op.soma(-2, -3));
	}
	
	@Test
	void testUmPositivoUmNegativo() {
		Operacoes op = new Operacoes();
		assertEquals(1, op.soma(-2, 3));
	}	
	
}