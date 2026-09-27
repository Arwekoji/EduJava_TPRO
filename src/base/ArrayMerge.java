package base;

import utils.ConsolePatterns;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Набор ручных реализаций слияния массивов и отсеивания чётных элементов из них
 */
public final class ArrayMerge {

    /**
     * Сливает два отсортированных массива в один по возрастанию
     *
     * @param array1 Заранее отсортированный массив #1 для сложения
     * @param array2 Заранее отсортированный массив #2 для сложения
     */
    public static int[] merge(int[] array1, int[] array2) {
        if (array1 == null || array1.length == 0 || array2 == null || array2.length == 0)
            throw new IllegalArgumentException("Один из массивов является пустым");

        int[] arrayMerged = new int[array1.length + array2.length];

        int arrayCounter1 = 0;
        int arrayCounter2 = 0;
        for (int resultSize = 0; resultSize < arrayMerged.length; resultSize++)
            if (arrayCounter1 < array1.length && (arrayCounter2 == array2.length || array1[arrayCounter1] <= array2[arrayCounter2]))
                arrayMerged[resultSize] = array1[arrayCounter1++];
            else
                arrayMerged[resultSize] = array2[arrayCounter2++];

        return arrayMerged;
    }

    /**
     * Отсеивает чётные числа в новый массив
     *
     * @param array Изначальный массив до отсеивания
     * @return Новый массив только с чётными числами из array
     */
    public static int[] filterEven(int[] array) {
        // Динамический массив тяжелее статичного, но необходим в связи с невозможностью предугадать количество четных чисел
        ArrayList<Integer> resultArray = new ArrayList<>();

        for (int element : array)
            if (element % 2 == 0)
                resultArray.add(element);

        int[] primitiveArray = new int[resultArray.size()];
        for (int i = 0; i < resultArray.size(); i++)
            primitiveArray[i] = resultArray.get(i);

        return primitiveArray;
    }

    /**
     * Кастомные тесты класса с тестовыми данными по умолчанию
     *
     * @return Успешность тестов
     */
    public static boolean runTests() {
        return runTests(
                new int[]{1, 2, 7, 4, 5, 6, 3},
                new int[]{7, 3, 5, 4, 6},
                new int[]{1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7},
                new int[]{2, 4, 4, 6, 6}
        );
    }

    /**
     * Кастомные тесты класса с указанием тестовых данных
     *
     * @param testArray1       Тестовый массив #1 до сортировки
     * @param testArray2       Тестовый массив #2 до сортировки
     * @param mergedArrayCheck Ожидаемый результат слияния отсортированных массивов #1 и #2
     * @param evenArrayCheck   Ожидаемый результат отсеивания чётных чисел из evenArrayCheck
     * @return Успешность тестов
     */
    public static boolean runTests(int[] testArray1, int[] testArray2, int[] mergedArrayCheck, int[] evenArrayCheck) {
        try {
            System.out.printf("""
                            Ниже будет произведено слияние двух отсортированных массивов и отсеивание чётных элементов в другой массив.
                            Массив #1: %s
                            Массив #2: %s
                            
                            """,
                    Arrays.toString(testArray1),
                    Arrays.toString(testArray2)
            );

            Arrays.sort(testArray1);
            Arrays.sort(testArray2);

            System.out.printf("""
                            __Отсортированные__
                            Массив #1: %s
                            Массив #2: %s
                            
                            """,
                    Arrays.toString(testArray1),
                    Arrays.toString(testArray2)
            );

            int[] mergedArray = merge(testArray1, testArray2);
            int[] evenArray = filterEven(mergedArray);

            System.out.printf("""
                    Слияние массивов #1 и #2 после сортировки:
                    %s
                    
                    Чётные числа из общего массива:
                    %s
                    """, Arrays.toString(mergedArray), Arrays.toString(evenArray));

            if (!Arrays.equals(mergedArray, mergedArrayCheck) || !Arrays.equals(evenArray, evenArrayCheck)) {
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

Задача 4. Класс ArrayMerge. Слияние и фильтрация.
    Объявите два отсортированных массива разной длины.
    Объедините их в один отсортированный массив без использования Arrays.sort для итогового массива — используйте алгоритм слияния (merge):
        сравнивайте элементы обоих массивов по очереди и выбирайте меньший.
    Дополнительно: создайте новый массив содержащий только чётные элементы из исходного массива.

Пример вывода:
    Не указан
 */