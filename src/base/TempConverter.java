package base;

/**
 * Класс для конвертации температур из Цельсия в Фаренгейт или Кельвин
 *
 * @author Артур Федьвереш
 */
public class TempConverter {
    final double KELVIN_CONST = 273.15;
    double lastTemperatureCelsius;
    double lastTemperatureKelvin;
    double lastTemperatureFahrenheit;


    /**
     * Метод, выдающий результат конвертации температуры по Цельсию в Фаренгейты, сразу в консоль
     *
     * @author Артур Федьвереш
     * @param celsius - Температура по Цельсию, тип double
     */
    public void convertCelsiusToFahrenheit(double celsius) {
        lastTemperatureFahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Температура " + celsius + "(С°) = " + lastTemperatureFahrenheit + "(F)");
        lastTemperatureCelsius = celsius;
    }

    /**
     * Метод, выдающий результат конвертации температуры по Цельсию в Кельвины, сразу в консоль
     *
     * @author Артур Федьвереш
     * @param celsius - Температура по Цельсию, тип double
     */
    public void convertCelsiusToKelvin(double celsius) {
        lastTemperatureKelvin = celsius + KELVIN_CONST;
        System.out.println("Температура " + celsius + "(С°) = " + lastTemperatureKelvin + "(K)");
        lastTemperatureCelsius = celsius;
    }

}
