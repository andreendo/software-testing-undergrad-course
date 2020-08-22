package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemperatureUtilTest {

	@Test
	void testCelsiusToFahrenheit() {
		var util = new TemperatureUtil();
		double res = util.celsiusToFahrenheit(30.0);
		assertEquals(86.0, res, 0.001);
	}

	@Test
	void testException() {
		var util = new TemperatureUtil();
		
		var ex = assertThrows(IllegalArgumentException.class, () -> {
			util.celsiusToFahrenheit(30590.0);	
		});
		
		//assertiva		
	}	
	
}
