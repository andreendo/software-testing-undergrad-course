package exemplo.texto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathOpsTest {

	@Test
	void testSomaNormal() throws Exception {
		int res = MathOps.safe_add(10, 20);
		assertEquals(30, res);
	}

	@Test
	void testOverflow() {
		Exception exception = assertThrows(Exception.class, () -> {
			MathOps.safe_add(Integer.MAX_VALUE, 20);
		});
		
		assertEquals("Overflow", exception.getMessage());
	}	

	@Test
	void testUnderflow() {
		Exception exception = assertThrows(Exception.class, () -> {
			MathOps.safe_add(Integer.MIN_VALUE, -2);
		});
		
		assertEquals("Underflow", exception.getMessage());
	}
}

