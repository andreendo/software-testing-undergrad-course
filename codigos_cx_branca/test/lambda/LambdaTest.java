package lambda;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LambdaTest {

	@Test
	void testOnlyWordsStartingWithA() {
		List<String> ss = Arrays.asList("andre", "ate mais");
		Lambda lambda = new Lambda();
		var res = lambda.countWordsStartingWithAandZ(ss);
		assertArrayEquals(new int[] { 2, 0 }, res);
	}

	@Test
	void testOnlyWordsStartingWithZ() {
		List<String> ss = Arrays.asList("zebra", "zezinho");
		Lambda lambda = new Lambda();
		var res = lambda.countWordsStartingWithAandZ(ss);
		assertArrayEquals(new int[] { 0, 2 }, res);
	}	
}
