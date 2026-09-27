package base;

import utils.ConsolePatterns;
import utils.Randomizer;

import java.util.Arrays;

/**
 * Набор ручных реализаций поиска элемента в числовых массивах
 */
public final class ArraySearch {
    /**
     * Ищет элемент в числовом массиве бинарным методом без проверок на равенство
     *
     * @param array        Массив для анализа
     * @param targetNumber Значение элемента для поиска
     * @return Индекс найденного элемента или -1 если не найден
     */
    public static int searchIndexBinary(int[] array, int targetNumber) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Массив не содержит подходящих элементов для поиска");

        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (rightIndex - leftIndex > 1) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (targetNumber < array[middleIndex])
                rightIndex = middleIndex;
            else
                leftIndex = middleIndex;
        }

        if (targetNumber == array[leftIndex])
            return leftIndex;

        if (targetNumber == array[rightIndex])
            return rightIndex;

        return -1;
    }

    /**
     * Ищет элемент в массиве линейным методом
     *
     * @param array        Массив для анализа вида int[]
     * @param targetNumber Искомое число
     * @return Индекс найденного элемента или -1 при его отсутствии
     */
    public static int searchIndexLinear(int[] array, int targetNumber) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Массив не содержит подходящих элементов для поиска");

        for (int i = 0; i < array.length; i++)
            if (array[i] == targetNumber)
                return i;

        return -1;
    }

    /**
     * Кастомные тесты класса с тестовыми данными по умолчанию
     *
     * @return Успешность тестов
     */
    public static boolean runTests() {
        return runTests(new int[]{6, 1, 7, 3, 10, 5, 2, 8, 9, 4}, new int[]{0, 5}, 6);
    }

    /**
     * Кастомные тесты класса с указанием тестовых данных
     *
     * @param testArray    Тестовый одномерный массив с элементами int типа
     * @param searchNumber Искомое число в тестовых массивах
     * @param targetIndex  Ожидаемый индекс в детерменированной тестовом массиве testArray
     * @return Успешность тестов
     */
    public static boolean runTests(int[] testArray, int[] targetIndex, int searchNumber) {
        try {
            int[] randomArray = Randomizer.createArray(10, 10, 1);
            System.out.printf("""
                    Данный тест выполнит поочередно два вида поиска в двух массивах. Ищется число {%d} вида int
                    Виды проверок: Линейный поиск, ручной бинарный поиск
                    Виды массивов: Детерминированный и случайный, оба имеют тип int[] (10 элементов в рамках теста с числами от 1 до 10)
                    
                    Массив #1, случайный: %s
                    ___Производится линейный поиск:
                    """, searchNumber, Arrays.toString(randomArray)
            );
            int foundIndex = searchIndexLinear(randomArray, searchNumber);
            if (foundIndex != -1)
                System.out.printf("Число \"%d\" было найдено под индексом [%d]%n", searchNumber, foundIndex);
            else
                System.out.println("Элемент с числом {%d} в массиве не найден".formatted(searchNumber));

            // СЛУЧАЙНЫЙ МАССИВ, БИНАРНЫЙ ПОИСК

            Arrays.sort(randomArray);
            System.out.printf("""
                    Отсортированный массив: %s
                    ___Производится бинарный поиск:
                    """, Arrays.toString(randomArray));

            foundIndex = searchIndexBinary(randomArray, searchNumber);
            if (foundIndex != -1)
                System.out.printf("Число \"%d\" было найдено под индексом [%d]%n", searchNumber, foundIndex);
            else
                System.out.println("Элемент с числом {%d} в массиве не найден".formatted(searchNumber));

            // ДЕТЕРМИНИРОВАННЫЙ МАССИВ, ЛИНЕЙНЫЙ ПОИСК

            System.out.printf("""
                    
                    Массив #2, детерминированный: %s
                    ___Производится линейный поиск:
                    """, Arrays.toString(testArray));

            foundIndex = searchIndexLinear(testArray, searchNumber);
            if (foundIndex != -1)
                System.out.printf("Число \"%d\" было найдено под индексом [%d]%n", searchNumber, foundIndex);
            else
                System.out.println("Элемент с числом {%d} в массиве не найден".formatted(searchNumber));

            if (foundIndex != targetIndex[0]) {
                ConsolePatterns.printTaskError();
                return false;
            }

            // ДЕТЕРМИНИРОВАННЫЙ МАССИВ, БИНАРНЫЙ ПОИСК

            Arrays.sort(testArray);
            System.out.printf("""
                    Отсортированный массив: %s
                    ___Производится бинарный поиск:
                    """, Arrays.toString(testArray));

            foundIndex = searchIndexBinary(testArray, searchNumber);
            if (foundIndex != -1)
                System.out.printf("Число \"%d\" было найдено под индексом [%d]%n", searchNumber, foundIndex);
            else
                System.out.println("Элемент с числом {%d} в массиве не найден".formatted(searchNumber));

            if (foundIndex != targetIndex[1]) {
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

Задача 3. Класс ArraySearch. Поиск в массиве.
    Заполните массив из 10 элементов числами от 1 до 10 в случайном порядке (используйте Math.random() или просто задайте вручную так, чтобы был не по порядку).
    Реализуйте линейный поиск: найдите заданное число и выведите его индекс или сообщение что не найдено.
    Затем отсортируйте массив через Arrays.sort и реализуйте бинарный поиск вручную (без Arrays.binarySearch) — делите массив пополам и сужайте область поиска.

Пример вывода:
    Не указан

 */