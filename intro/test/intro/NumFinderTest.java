package intro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumFinderTest {

	@Test
	void testSimpleOrderedArray() {
		int[] numbers = { 1, 10 };
		NumFinder numFinder = new NumFinder();
		numFinder.find(numbers);

		assertEquals(1, numFinder.getSmallest());
		assertEquals(10, numFinder.getLargest());
	}
	
	@Test
	void testUnorderedArray() {
		int[] numbers = { 50, 1, 10, 5 };
		NumFinder numFinder = new NumFinder();
		numFinder.find(numbers);

		assertEquals(1, numFinder.getSmallest());
		assertEquals(50, numFinder.getLargest());
	}	
}