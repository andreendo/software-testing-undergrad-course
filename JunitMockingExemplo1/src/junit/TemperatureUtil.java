// Example inspired by http://ccsl.ime.usp.br/files/publications/files/2008/intro-java-cc.pdf

package junit;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TemperatureUtil {
	private DecimalFormat df = new DecimalFormat("#.#");
	
	public TemperatureUtil() {
		df.setRoundingMode(RoundingMode.HALF_UP);
	}
	
	public double celsiusToFahrenheit(double c) {
		validateRange(c);
		return 9.0 * c / 5.0 + 32.0;
	}
	
	public double FahrenheitToCelsius(double f) {
		validateRange(f);
		return 5.0 * (f - 32.0) / 9.0;
	}
	
	private void validateRange(double t) {
		if (t < -1000 || t > 1000)
			throw new IllegalArgumentException("Invalid range of temperature");
	}
	
	public String format(double t, boolean isCelsius) {
		String res = df.format(t);		
		return isCelsius ? res + " C" : res + " F";
	}
}