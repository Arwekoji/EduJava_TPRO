package base;

/**
 * Точка входа
 *
 * @author Артур Федьвереш
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("C2F(0) = " + TemperatureConverter.celsiusToFahrenheit(0));
        System.out.println("F2C(40) = " + TemperatureConverter.fahrenheitToCelsius(40));
    }
}
