package base;

import utils.ConsolePatterns;

import java.util.ArrayList;

/**
 * Представление треугольника Паскаля
 */
public class PascalTriangle {
    public static final ArrayList<int[]> triangle = new ArrayList<>();
    public static int[] sumOfElements;

    /**
     * Функция факториала
     *
     * @param n Число, необходимое возвести в факториал
     * @return Число после возведения в факториал
     */
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Расчет треугольника паскаля до указанной ширины
     *
     * @param size Ширина, a.k.a. число элементов в нижней строке
     */
    public static void generate(int size) {
        triangle.clear();
        sumOfElements = new int[size];

        for (int i = 0; i < size; i++) {
            int[] row = new int[i + 1];
            for (int j = 0; j < row.length; j++) {
                row[j] = factorial(i) / (factorial(j) * factorial(i - j));
                sumOfElements[i] += row[j];
            }
            triangle.add(row);
        }
    }

    /**
     * Вывод треугольника паскаля и информации о нем в консоль
     */
    public static void printInfo() {
        for (int i = 0; i < sumOfElements.length; i++) {
            System.out.printf("Sum(%d_row)=%d (2^%d=%d) | ", i, sumOfElements[i], i, (int) Math.pow(2, i));
        }
        System.out.println();

        for (int y = 0; y < triangle.size(); y++) {
            System.out.print(" ".repeat(triangle.size() - y));
            for (int x = 0; x < triangle.get(y).length; x++)
                System.out.print(triangle.get(y)[x] + " ");
            System.out.println();
        }
    }

    /**
     * Кастомные тесты класса с тестовыми данными по умолчанию
     *
     * @return Успешность тестов
     */
    public static boolean runTests() {
        return runTests(8);
    }

    /**
     * Кастомные тесты класса с указанием тестовых данных
     *
     * @param triangleSize Ширина треугольника Паскаля, a.k.a. число элементов в нижней строке
     * @return Успешность тестов
     */
    public static boolean runTests(int triangleSize) {
        try {
            generate(triangleSize);
            printInfo();

            return true;
        } catch (Throwable throwable) {
            ConsolePatterns.printRuntimeError(throwable);
            return false;
        }
    }
}

/*
Критерии оценки:
- треугольник Паскаля построен через зубчатый массив и выровнен по центру

------------------------------------------------------------------------------------------------------------------------

Задача 4. Класс PascalTriangle. Треугольник Паскаля.
Постройте треугольник Паскаля для n = 8 строк используя зубчатый массив.
Выведите треугольник выровненным по центру консоли.
Дополнительно: подсчитайте сумму элементов каждой строки и убедитесь что она равна 2 в степени номера строки.

Пример вывода:
             1
           1   1
         1   2   1
       1   3   3   1
     1   4   6   4   1

------------------------------------------------------------------------------------------------------------------------

Замечание #1:
    В задаче 4 лучше разделить методы заполнения матрицы, отрисовки ее и вывода сумм строк.
    Метод наименование которого начинается с get не может быть void.
 */