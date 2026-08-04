package base;

/**
 * Класс для конвертации температур из Цельсия в Фаренгейт или Кельвин
 *
 * @author Артур Федьвереш
 */
public class TempConverter {
    final double KELVIN_CONST = 273.15;


    /**
     * Метод, выдающий результат конвертации температуры по Цельсию в Фаренгейты, сразу в консоль
     *
     * @author Артур Федьвереш
     * @param celsius - Температура по Цельсию, тип double
     */
    public void convertC2F(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Температура " + celsius + "(С°) = " + fahrenheit + "(F)");
    }

    /**
     * Метод, выдающий результат конвертации температуры по Цельсию в Кельвины, сразу в консоль
     *
     * @author Артур Федьвереш
     * @param celsius - Температура по Цельсию, тип double
     */
    public void convertC2K(double celsius) {
        double kelvin = celsius + KELVIN_CONST;
        System.out.println("Температура " + celsius + "(С°) = " + kelvin + "(K)");
    }

}
