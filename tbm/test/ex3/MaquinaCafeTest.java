package ex3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaquinaCafeTest {

	@Test
	void testPedirCafeTodosEstados() throws Exception {
		//new,
		var maquina = new MaquinaCafe();
		// pedirCafe/false, 
		assertFalse(maquina.pedirCafe());
		//adicionarMoeda(1), 
		maquina.adicionarMoeda(1);
		//pedirCafe/false, 
		assertFalse(maquina.pedirCafe());
		//adicionarMoeda(1),
		maquina.adicionarMoeda(1);
		//pedirCafe/true, 
		assertTrue(maquina.pedirCafe());
		//pedirCafe/false
		assertFalse(maquina.pedirCafe());
	}
	

	@Test
	void testLancamentoExcecoes() throws Exception {
		// new,
		var maquina = new MaquinaCafe();
		// adicionarMoeda(!=1)/Exception,
		assertThrows(Exception.class, () -> maquina.adicionarMoeda(5));
		// adicionarMoeda(1), 
		maquina.adicionarMoeda(1);
		// adicionarMoeda(!=1)/Exception, 
		assertThrows(Exception.class, () -> maquina.adicionarMoeda(5));
		// adicionarMoeda(1), 
		maquina.adicionarMoeda(1);
		// adicionarMoeda(!=1)/Exception, 
		assertThrows(Exception.class, () -> maquina.adicionarMoeda(5));
		// adicionarMoeda(1)/Exception
		assertThrows(Exception.class, () -> maquina.adicionarMoeda(1));
	}

}
