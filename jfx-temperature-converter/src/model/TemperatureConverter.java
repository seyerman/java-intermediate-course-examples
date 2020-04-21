package model;

public class TemperatureConverter {
	public static double celsiusToFahrenheit(double cel) {
		double fah;
		
		fah = cel*9/5 + 32;
		
		return fah;
	}
}
