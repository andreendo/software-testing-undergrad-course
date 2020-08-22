package responses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.TemperatureUtil;

class TemperatureUtilTest {

	@Test
	void testCelsiusToFahrenheit() {
		TemperatureUtil util = new TemperatureUtil();
		assertEquals(86.0, util.celsiusToFahrenheit(30.0), 0.001);
	}

	@Test
	void testFahrenheitToCelsius() {
		TemperatureUtil util = new TemperatureUtil();
		assertEquals(30.0, util.FahrenheitToCelsius(86.0), 0.001);
	}

	@Test
	void testCrossChecking() {
		TemperatureUtil util = new TemperatureUtil();
		double[] values = {0.0, -6.5, 56.7};
		for(double temp : values) {
			double inC = util.FahrenheitToCelsius(temp);
			assertEquals(temp, util.celsiusToFahrenheit(inC), 0.001);
			
			double inF = util.celsiusToFahrenheit(temp);			
			assertEquals(temp, util.FahrenheitToCelsius(inF), 0.001);
		}
	}

	@Test
	void testException() {
		TemperatureUtil util = new TemperatureUtil();
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			util.celsiusToFahrenheit(-1900);
		});
		assertEquals("Invalid range of temperature", exception.getMessage());
	}
	
	@Test
	void testFormat() {
		TemperatureUtil util = new TemperatureUtil();
		assertEquals("3,6 C", util.format(3.56, true));
		assertEquals("-25,5 F", util.format(-25.54, false));
	}	
}
