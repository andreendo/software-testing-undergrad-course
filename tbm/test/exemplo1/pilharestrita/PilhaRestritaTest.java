package exemplo1.pilharestrita;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PilhaRestritaTest {

	@Test
	void testCT1() throws Exception {
		//new(x), x = 3
		var p = new PilhaRestrita(3);
		
		//vazia()/true
		assertTrue(p.vazia());
		
		//empilhar
		p.empilhar("s1");
		
		//vazia()/false
		assertFalse(p.vazia());
		
		//empilhar(x-1 elementos)
		p.empilhar("s2");
		p.empilhar("s3");
		
		//vazia()/false
		assertFalse(p.vazia());
	}

	@Test
	void testCT2() throws Exception {
		//new(x), x = 3
		var p = new PilhaRestrita(3);
		
		//desempilhar/pilhaVaziaException
		assertThrows(PilhaVaziaException.class, () -> p.desempilhar());
		
		//empilhar
		p.empilhar("s1");
		
		//empilhar(x-1 elementos)
		p.empilhar("s2");
		p.empilhar("s3");
		
		//empilhar/pilhaCheiaException
		assertThrows(PilhaCheiaException.class, () -> p.empilhar("s4"));
	}	
	
	@Test
	void testCT3() throws Exception {
		//new(x), x = 3
		var p = new PilhaRestrita(3);
		
		//empilhar
		p.empilhar("s1");
		
		//empilhar(x-1 elementos)
		p.empilhar("s2");
		p.empilhar("s3");
		
		//desempilhar(x-1 elementos)
		assertEquals("s3", p.desempilhar());
		assertEquals("s2", p.desempilhar());
		
		//desempilhar	
		assertEquals("s1", p.desempilhar());
	}
	
}
