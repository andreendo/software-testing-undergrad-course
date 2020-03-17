package example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

class TimeoutExampleTest {
	private Operacoes op = new Operacoes();
	
	@Test
	void testSemTimeout() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			op.somatoria(10);
		});
	}

	@Test
	void testComTimeout() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			op.somatoria(-10);
		});
	}	
}