package base;

/**
 * Точка входа
 *
 * @author Артур Федьвереш
 */
public class Main {
    public static void main(String[] args) {
        boolean isAboveBoiling = false;
        double temperature = TemperatureConverter.celsiusToFahrenheit(0);
        isAboveBoiling = (TemperatureConverter.fahrenheitToCelsius(temperature) >= TemperatureConverter.BOILING_POINT_CELSIUS);
        System.out.println("C2F(0) = " + temperature + " (Это выше точки кипения воды? " + isAboveBoiling + ")");
        temperature = TemperatureConverter.fahrenheitToCelsius(40);
        isAboveBoiling = (temperature >= TemperatureConverter.BOILING_POINT_CELSIUS);
        System.out.println("F2C(40) = " + temperature + " (Это выше точки кипения воды? " + isAboveBoiling + ")");
    }
}
