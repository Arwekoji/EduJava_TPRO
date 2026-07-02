package base;

/**
 * Temperature Conversion Class
 */
public class TemperatureConverter {

    final double ABSOLUTE_ZERO_CELSIUS = -273.15;
    final double BOILING_POINT_CELSIUS = 100.0;

    /**
     * function celsiusToFahrenheit
     * @param celsius - argument of temperature in C metric
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    /**
     * function fahrenheitToCelsius
     * @param fahrenheit - argument of temperature in F metric
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

}
