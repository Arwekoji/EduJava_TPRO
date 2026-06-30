package base;

/**
 * Точка входа в программу
 *
 * @author Артур Федьвереш
 */
public class Main {

    /**
     * Метод точки входа
     *
     * @param args Аргументы точки входа
     * @author Артур Федьвереш
     */
    public static void main(String[] args) {

        // 1 ЗАДАЧА
        System.out.println("Из чисел 0 и 1, минимумом является число " + MathUtils.min(0, 1));
        System.out.println("Из чисел 0 и 1, максимумом является число " + MathUtils.max(0, 1));
        System.out.print("Clamp(х, 3, 7) для чисел 1, 4 и 10 равен " + MathUtils.clamp(1, 3, 7) + " | ");
        System.out.print(MathUtils.clamp(4, 3, 7) + " | ");
        System.out.println(MathUtils.clamp(10, 3, 7));

        System.out.println("- - - - - -");

        // 2 ЗАДАЧА
        System.out.println("Год 2000 является високосным? " + MathUtils.isLeapYear(2000));
        System.out.println("Год 2026 является високосным? " + MathUtils.isLeapYear(2026));
        System.out.println("Год 2100 является високосным? " + MathUtils.isLeapYear(2100));
        System.out.println("Год 2024 является високосным? " + MathUtils.isLeapYear(2024));

        System.out.printf("Температура 0°C после конвертации станет равна %.1fF, а после конвертации обратно снова станет равна %.1f°C\n",
                MathUtils.celsiusToFahrenheit(0), MathUtils.fahrenheitToCelsius(MathUtils.celsiusToFahrenheit(0)));

        System.out.println("- - - - - -");

        // 3 ЗАДАЧА
        System.out.println("5! = " + MathUtils.factorial(5));
        System.out.println("5^3 = " + MathUtils.power(5, 3));
    }

}