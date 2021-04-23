package mutantes.ex14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutantesTest {

	@Test
	void testM1() {
		int[] anos = {2001, 1999, 2004, 1476};
		
		Original o = new Original();
		assertEquals(2, o.calcularAnosBissexto(anos));
		
		Mutante1 noturno = new Mutante1();
		assertEquals(2, noturno.calcularAnosBissexto(anos));
	}

	@Test
	void testM2() {
		int[] anos = {2001, 1999, 2004, 1476};
		
		Original o = new Original();
		assertEquals(2, o.calcularAnosBissexto(anos));
		
		Mutante2 cable = new Mutante2();
		assertEquals(2, cable.calcularAnosBissexto(anos));		
	}	
	
	
	@Test
	void testM3() {
		int[] anos = {2001, 1999, 2004, 1476, 600};
		
		Original o = new Original();
		assertEquals(2, o.calcularAnosBissexto(anos));
		
		Mutante3 cable = new Mutante3();
		assertEquals(2, cable.calcularAnosBissexto(anos));		
	}		
}
