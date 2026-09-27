package base;

import utils.ConsolePatterns;

import java.util.Arrays;
import java.util.Objects;

/**
 * Утилита для вычисления и вывода данных по одномерному массиву
 */
public class ArrayStats {

    /**
     * Запись со статистикой указанного массива
     *
     * @param array            Анализируемый одномерный массив с int элементами
     * @param sum              Сумма элементов
     * @param arithmeticMean   Среднее арифметическое
     * @param maxIndex         Индекс элемента с наибольшим значением
     * @param minIndex         Индекс элемента с наименьшим значением
     * @param quantityEven     Количество чётных элементов
     * @param quantityOdd      Количество нечётных элементов
     * @param quantityPositive Количество положительных элементов
     * @param quantityNegative Количество отрицательных элементов
     */
    public record Stats(int[] array,
                        int sum, float arithmeticMean,
                        int maxIndex, int minIndex,
                        int quantityEven, int quantityOdd,
                        int quantityPositive, int quantityNegative) {

        @Override
        public String toString() {
            return String.format("""
                            Массив: %s
                            Сумма: %d
                            Среднее: %.2f
                            Максимум: %d (индекс %d)
                            Минимум: %d (индекс %d)
                            Чётных: %d, нечётных: %d
                            Положительных: %d, отрицательных: %d
                            """, Arrays.toString(array),
                    sum, arithmeticMean,
                    array[maxIndex], maxIndex,
                    array[minIndex], minIndex,
                    quantityEven, quantityOdd,
                    quantityPositive, quantityNegative);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Stats stats = (Stats) o;
            return sum == stats.sum && minIndex == stats.minIndex && maxIndex == stats.maxIndex &&
                    quantityOdd == stats.quantityOdd && quantityEven == stats.quantityEven &&
                    Float.compare(arithmeticMean, stats.arithmeticMean) == 0 &&
                    quantityNegative == stats.quantityNegative && quantityPositive == stats.quantityPositive && Objects.deepEquals(array, stats.array);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Arrays.hashCode(array), sum, arithmeticMean, minIndex, maxIndex, quantityEven, quantityOdd, quantityNegative, quantityPositive);
        }
    }

    /**
     * Анализирует одномерный массив за один проход
     *
     * @param array Одномерный массив int типа
     * @return Статистика по данному массиву
     */
    private static Stats getStats(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Ошибка! В массиве отсутствуют элементы для анализа!");

        int sum = 0;
        float arithmeticMean;

        int minIndex = 0;
        int maxIndex = 0;

        int even = 0;
        int odd = 0;

        int negative = 0;
        int positive = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (array[i] < array[minIndex])
                minIndex = i;

            if (array[i] > array[maxIndex])
                maxIndex = i;

            if (array[i] % 2 == 0)
                even++;
            else
                odd++;

            if (array[i] >= 0)
                positive++;
            else
                negative++;
        }

        arithmeticMean = (float) sum / array.length;

        return new Stats(array, sum, arithmeticMean, maxIndex, minIndex, even, odd, positive, negative);
    }

    /**
     * Запрашивает анализ массива и пытается вывести результат анализа в консоль
     *
     * @param array Одномерный массив int типа
     * @return Успешность анализа массива
     */
    public static Stats analyzeArray(int[] array) {
        Stats arrayStats = getStats(array);
        System.out.print(arrayStats);
        return arrayStats;
    }

    /**
     * Кастомные тесты класса с тестовыми данными по умолчанию
     *
     * @return Успешность тестов
     */
    public static boolean runTests() {
        return runTests(
                new int[]{5, -3, 8, 1, -9, 2, 7, 4},
                new Stats(new int[]{5, -3, 8, 1, -9, 2, 7, 4}, 15, 1.875f, 2, 4, 3, 5, 6, 2)
        );
    }

    /**
     * Кастомные тесты класса с указанием тестовых данных
     *
     * @param testArray  Тестовый одномерный массив с элементами int типа
     * @param testRecord Запись с необходимыми результатами для сравнения тестов
     * @return Успешность тестов
     */
    public static boolean runTests(int[] testArray, Stats testRecord) {
        try {
            if (!analyzeArray(testArray).equals(testRecord)) {
                ConsolePatterns.printTaskError();
                return false;
            }
            return true;
        } catch (Throwable throwable) {
            ConsolePatterns.printRuntimeError(throwable);
            return false;
        }
    }
}

/* Задание 3.2 — Одномерные массивы

Критерии оценки:
- статистика вычисляется корректно для любого массива
- переворот реализован через цикл с двумя указателями, не через вспомогательный массив
- бинарный поиск реализован вручную с выводом шагов сужения
- алгоритм слияния работает корректно для массивов разной длины

------------------------------------------------------------------------------------------------------------------------

Задача 1. Класс ArrayStats. Статистика массива.
Объявите массив из 8 целых чисел произвольно.
Вычислите и выведите:
    сумму всех элементов,
    среднее арифметическое с точностью до двух знаков,
    максимальный элемент и его индекс,
    минимальный элемент и его индекс,
    количество чётных и нечётных чисел,
    количество отрицательных и положительных чисел.

Пример вывода (Тестовый массив [5, -3, 8, 1, -9, 2, 7, 4]):
    Массив: [5, -3, 8, 1, -9, 2, 7, 4]
    Сумма: 15
    Среднее: 1.88
    Максимум: 8 (индекс 2)
    Минимум: -9 (индекс 4)
    Чётных: 3, нечётных: 5
    Положительных: 5, отрицательных: 2
 */