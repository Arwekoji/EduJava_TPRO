package base;

/**
 * Класс для отрисовки визуальных паттернов в консоли
 */
public class Patterns {

    /**
     * Процедура для отрисовки квадрата
     *
     * @param n Размер сторон квадрата
     */
    public static void square(byte n) {
        for (byte y = 1; y <= n; y++) {
            for (byte x = 1; x <= n; x++)
                System.out.print(" *");
            System.out.println();
        }
    }

    /**
     * Процедура для отрисовки равностороннего треугольника с ориентированием вправо
     *
     * @param n Размер катетов треугольника
     */
    public static void rightTriangle(byte n) {
        for (byte y = 1; y <= n; y++) {
            for (byte x = 1; x <= y; x++)
                System.out.print(" *");
            System.out.println();
        }
    }

    /**
     * Процедура для прорисовки пирамиды с нечетным количеством столбцов
     *
     * @param n Число столбцов
     */
    public static void pyramid(byte n) {
        for (byte i = 1; i <= n; i++)
            System.out.printf("""
                              %s%s
                              """,
                              " ".repeat(n - i),
                              "* ".repeat(i)
            );
    }
}
