package base;

/**
 * Temperature Conversion Class
 *
 * @author Arthur Fedveresh
 */


public class TemperatureConverter {

    double ABSOLUTE_ZERO_CELSIUS = -273.15;
    double BOILING_POINT_CELSIUS = 100.0;
    boolean isAboveBoiling = false;

    /**
     * function celsiusToFahrenheit
     *
     * @param celsius - argument of temperature in C metric
     * @author Arthur Fedveresh
     */
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    /**
     * function fahrenheitToCelsius
     *
     * @param fahrenheit - argument of temperature in F metric
     * @author Arthur Fedveresh
     */
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

}