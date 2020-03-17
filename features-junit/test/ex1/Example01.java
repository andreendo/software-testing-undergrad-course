package ex1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Example01 {

	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("BeforeEach");
	}

	@AfterEach
	void afterEach() {
		System.out.println("AfterEach");
	}	

	@Test
	void testPontoFlutuante() {
		float var = 1.0f / 2.0f;
		
		assertEquals(0.5, var);
		
		float var2 = 1.0f / 3.0f;
		
		assertEquals(0.33, var2, 0.01);
		System.out.println(0.33 - var2);
	}

	@Test
	void testPontoFlutuante2() {
		assertThrows(Exception.class, () -> {
//			throw new Exception();
		});
	}	
	
	@Test
	void testTimeout() {
		assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
			while(true);
		});
	}
	
}
