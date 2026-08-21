package base;

/**
 * Класс для отрисовки визуальных паттернов
 *
 * @author Артур Федьвереш
 */
public class Patterns {

    /**
     * Метод для отрисовки квадрата
     *
     * @param n Размер сторон квадрата
     * @author Артур Федьвереш
     */
    public static void square(byte n) {
        for (byte y = 1; y <= n; y++) {
            for (byte x = 1; x <= n; x++)
                System.out.print(" *");
            System.out.println();
        }

    }

    /**
     * Метод для отрисовки равностороннего треугольника с ориентированием вправо
     *
     * @param n Размер катетов треугольника
     * @author Артур Федьвереш
     */
    public static void rightTriangle(byte n) {
        for (byte y = 1; y <= n; y++) {
            for (byte x = 1; x <= y; x++)
                System.out.print(" *");
            System.out.println();
        }

    }

    /**
     * Метод для прорисовки пирамиды с нечетным количеством столбцов
     *
     * @param n Число столбцов
     * @author Артур Федьвереш
     */
    public static void pyramid(byte n) {
        if (n % 2 == 0)
            n++;

        for (byte y = 1; y <= 1 + n / 2; y++) {
            for (byte x = 1; x <= n; x++) {
                if (x >= (n / 2) - y + 2 && x <= (n / 2) + y)
                    System.out.print(" *");
                else
                    System.out.print("  ");
            }

            System.out.println();
        }
    }
}
