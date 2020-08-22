package pce.avl.ex12;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	//	(“sul”, 200; 10 * 200)
	@Test
	void testSucesso() throws Exception {
		CustoDAO custoDaoMock = mock(CustoDAO.class);
		when(custoDaoMock.getCustoPorGrama("sul"))
			.thenReturn(10);
		
		Calculadora c = new Calculadora(custoDaoMock);
		int custoDoFrete = c.calcularFrete("sul", 200);
		assertEquals(10 * 200, custoDoFrete);
	}

	
	//	(“leste”, 200; “exceção para região”)
	@Test
	void testExececaoParaRegiao() throws Exception {
		CustoDAO custoDaoMock = mock(CustoDAO.class);
		when(custoDaoMock.getCustoPorGrama("leste"))
			.thenReturn(-10);
		
		Calculadora c = new Calculadora(custoDaoMock);
		
		Exception exc = assertThrows(Exception.class, () -> {
			c.calcularFrete("leste", 200);	
		});
		
		assertEquals("regiao invalida", exc.getMessage());
	}	
	
	//(“sul”, -20; “exceção para peso”)
	@Test
	void testExececaoParaPesoNegativo() throws Exception {
		CustoDAO custoDaoMock = mock(CustoDAO.class);
		when(custoDaoMock.getCustoPorGrama("sul"))
			.thenReturn(10);
		
		Calculadora c = new Calculadora(custoDaoMock);
		
		Exception exc = assertThrows(Exception.class, () -> {
			c.calcularFrete("sul", -20);	
		});
		assertEquals("peso invalido", exc.getMessage());
	}	
	
	//	(“sul”, 2300000; “exceção para peso”)
	@Test
	void testExececaoParaPesoMuitoElevado() throws Exception {
		CustoDAO custoDaoMock = mock(CustoDAO.class);
		when(custoDaoMock.getCustoPorGrama("sul"))
			.thenReturn(10);
		
		Calculadora c = new Calculadora(custoDaoMock);
		
		Exception exc = assertThrows(Exception.class, () -> {
			c.calcularFrete("sul", 2300000);	
		});
		assertEquals("peso invalido", exc.getMessage());
	}	
	
	//ANALISE DE VALOR LIMITE
	
	//	(“sul”, 0; “exceção para peso”)
	@Test
	void testExececaoParaPesoZero() throws Exception {
		CustoDAO custoDaoMock = mock(CustoDAO.class);
		when(custoDaoMock.getCustoPorGrama("sul"))
			.thenReturn(10);
		
		Calculadora c = new Calculadora(custoDaoMock);
		
		Exception exc = assertThrows(Exception.class, () -> {
			c.calcularFrete("sul", 0);	
		});
		assertEquals("peso invalido", exc.getMessage());
	}		
	
	//	(“sul”, 1; 10 * 1)
	@Test
	void testSucessoCom1Grama() throws Exception {
		CustoDAO custoDaoMock = mock(CustoDAO.class);
		when(custoDaoMock.getCustoPorGrama("sul"))
			.thenReturn(10);
		
		Calculadora c = new Calculadora(custoDaoMock);
		int custoDoFrete = c.calcularFrete("sul", 1);
		assertEquals(10, custoDoFrete);
	}
	
	//	(“sul”, 2000000; 10 * 2000000)
	@Test
	void testSucessoCom2000000Gramas() throws Exception {
		CustoDAO custoDaoMock = mock(CustoDAO.class);
		when(custoDaoMock.getCustoPorGrama("sul"))
			.thenReturn(10);
		
		Calculadora c = new Calculadora(custoDaoMock);
		int custoDoFrete = c.calcularFrete("sul", 2000000);
		assertEquals(10 * 2000000, custoDoFrete);
	}	
	
	//	(“sul”, 2000001; “exceção para peso”)
	@Test
	void testExececaoParaPesoUmPoucoAcimaDoLimite() throws Exception {
		CustoDAO custoDaoMock = mock(CustoDAO.class);
		when(custoDaoMock.getCustoPorGrama("sul"))
			.thenReturn(10);
		
		Calculadora c = new Calculadora(custoDaoMock);
		
		Exception exc = assertThrows(Exception.class, () -> {
			c.calcularFrete("sul", 2000001);	
		});
		assertEquals("peso invalido", exc.getMessage());
	}	
}
