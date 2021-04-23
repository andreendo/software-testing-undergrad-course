package mutantes.ex11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutantsTest {

	@Test
	void testM1() {
		Original o = new Original();
		assertEquals(1, o.contarA("tempestAde"));
		
		Mutant1 logan = new Mutant1();
		assertEquals(1, logan.contarA("tempestAde"));
	}

	@Test
	void testM2() {
		Original o = new Original();
		assertEquals(1, o.contarA("tempestAde"));
		
		Mutant2 xavier = new Mutant2();
		assertEquals(1, xavier.contarA("tempestAde"));
		
		// mutante equivalente pq contador++ => contador = contador + 1 é 
		// semanticamente equivalente
	}
	
	@Test
	void testM3() {
		Original o = new Original();
		assertEquals(2, o.contarA("tempestAde Mistica"));
		
		Mutant3 fera = new Mutant3();
		assertEquals(2, fera.contarA("tempestAde Mistica"));
	}	
	
}
