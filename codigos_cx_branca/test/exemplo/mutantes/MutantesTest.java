package exemplo.mutantes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

class MutantesTest {

	@Test
	void testMutante1() {
		Original o = new Original();
		assertEquals(1.0, o.pow(2, 0), 0.001);

		Mutante1 logan = new Mutante1();
		assertEquals(1.0, logan.pow(2, 0), 0.001);

		// mutante equivalente, pq zero não faz diferença
	}

	@Test
	void testMutante2() {
		Original o = new Original();
		assertEquals(2.0, o.pow(2, 1), 0.001);

		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			Mutante2 mercurio = new Mutante2();
			assertEquals(2.0, mercurio.pow(2, 1), 0.001);
		});
	}

	@Test
	void testMutante3() {
		Original o = new Original();
		assertEquals(2.0, o.pow(2, 1), 0.001);

		Mutante3 storm = new Mutante3();
		assertEquals(2.0, storm.pow(2, 1), 0.001);
		
		// mutante equivalente, pq decrementa e para no zero		
	}
	
	@Test
	void testMutante4() {
		Original o = new Original();
		assertEquals(2.0, o.pow(2, 1), 0.001);

		Mutante4 noturno = new Mutante4();
		assertEquals(2.0, noturno.pow(2, 1), 0.001);
	}	
}
