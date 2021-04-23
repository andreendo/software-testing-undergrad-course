package mutantes.ex7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutantesEx7Test {

	@Test
	void testMutante1() {
		int[] arr = {3, 4, 5, 1};
		
		Original o = new Original();
		assertEquals(5, o.getMaior(arr));
		
		Mutante1 highlander = new Mutante1();
		assertEquals(5, highlander.getMaior(arr));
	}

	@Test
	void testMutante2() {
		int[] arr = {3, 5, 4, 1};
		
		Original o = new Original();
		assertEquals(5, o.getMaior(arr));
		
		Mutante2 sean = new Mutante2();
		assertEquals(5, sean.getMaior(arr));
	}
	
	@Test
	void testMutante3() {
		int[] arr = {3, 5, 4, 1};
		
		Original o = new Original();
		assertEquals(5, o.getMaior(arr));
		
		Mutante3 lambert = new Mutante3();
		assertEquals(5, lambert.getMaior(arr));
		
//		Mutante equivalente -> pq o maior é comparado com ele mesmo na posicao 0
	}	
}
