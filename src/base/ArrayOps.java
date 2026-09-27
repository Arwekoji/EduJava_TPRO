package base;

import utils.ConsolePatterns;
import utils.Randomizer;

import java.util.Arrays;

/**
 * Набор реализация для сдвига и переворота массивов
 */
public final class ArrayOps {
    /**
     * Отзеркаливает заданный одномерный массив
     *
     * @param array Одномерный массив типа Integer[]
     * @return Тот же массив с перестроенным порядком
     */
    public static int[] mirrorOf(int[] array) {
        if (array == null || array.length == 0)
            return array;

        for (int i = 0; i < array.length / 2; i++) { // Форма записи компактнее и контролируемее, чем через цикл While
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

        return array;
    }

    /**
     * Сдвигает элементы в массиве на N позиций через алгоритм трёх разворотов
     *
     * @param array Массив для форматирования
     * @param step  Величина сдвига вправо (N позиций)
     * @return Тот же массив, но со сдвинутым списком элементов
     */
    public static int[] shiftOf(int[] array, int step) {
        if(array == null || array.length == 0) // null-safety для всех реализаций
            return array;

        // РЕАЛИЗАЦИЯ #3 - Алгоритм трёх разворотов
        //  Алгоритм сдвига на любое количество шагов без второго массива, но со вторым массивом
        //  (Экономия ЦП и памяти)
        //  Прошлые реализации в конце файла закомментированы для демонстрации понимания

        step = step % array.length; // Убираем число шагов, которые фактически не повлияют на структуру массива, но при этом тратят ресурсы
        if (step < 0)
            step += array.length;

        if (step == 0) // Дальнейшие манипуляции бессмысленны, если выясняется, что сдвиг не нужен
            return array;

        int arraySeparatorIndex = array.length - step; // Этот сепаратор определяет длину шага в алгоритме трёх переворотов

        // Первый переворот - левая часть массива от 0 до arraySeparatorIndex - 1
        for (int i = 0, j = arraySeparatorIndex - 1; i < arraySeparatorIndex / 2; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        // Второй переворот - правая часть массива от arraySeparatorIndex до array.length - 1
        for (int i = arraySeparatorIndex, j = array.length - 1; i < arraySeparatorIndex + (array.length - arraySeparatorIndex) / 2; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        // Третий переворот
        return mirrorOf(array);
    }

    /**
     * Выводит в консоль содержимое одномерного Integer массива в прямом и обратном порядке без фактической перестановки
     *
     * @param array Одномерный массив типа int[]
     */
    public static void printDirectAndMirrorArray(int[] array) {
        System.out.print("Прямой порядок:");

        for (int i = 0; i < array.length; i++)
            System.out.print(" " + array[i]);

        System.out.println();

        System.out.print("Обратный порядок:");

        for (int i = array.length - 1; i >= 0; i--)
            System.out.print(" " + array[i]);

        System.out.println();
    }

    /**
     * Кастомные тесты класса с тестовыми данными по умолчанию
     *
     * @return Успешность тестов
     */
    public static boolean runTests() {
        return runTests(
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{7, 6, 5, 4, 3, 2, 1},
                new int[]{1, 7, 6, 5, 4, 3, 2},
                1
                );
    }

    /**
     * Кастомные тесты класса с указанием тестовых данных
     *
     * @param testArray  Тестовый одномерный массив с элементами int типа
     * @param mirroredArray Одномерный массив с ожидаемыемыми результатами после переворота testArray
     * @param shiftedArray Одномерный массив с ожидаемыми результатами после сдвига mirroredArray
     * @return Успешность тестов
     */
    public static boolean runTests(int[] testArray, int[] mirroredArray, int[] shiftedArray, int shiftStep) {
        try {
            printDirectAndMirrorArray(testArray);

            System.out.println("После переворота: " + Arrays.toString(mirrorOf(testArray)));
            if (!Arrays.equals(testArray, mirroredArray)) {
                ConsolePatterns.printTaskError();
                return false;
            }

            System.out.println("После сдвига вправо (N=%d шагов): %s".formatted(shiftStep, Arrays.toString(shiftOf(testArray, shiftStep))));
            if (!Arrays.equals(testArray, shiftedArray)) {
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

Задача 2. Класс ArrayOps. Обработка массива.
Объявите массив из 7 элементов.
Реализуйте:
    вывод массива в прямом и обратном порядке,
    переворот массива без использования Arrays.reverse (только через цикл с двумя указателями),
    сдвиг всех элементов на одну позицию вправо (последний элемент перемещается в начало).

Пример вывода (Тестовый массив [1, 2, 3, 4, 5, 6, 7]):
    Прямой порядок: 1 2 3 4 5 6 7
    Обратный порядок: 7 6 5 4 3 2 1
    После переворота: [7, 6, 5, 4, 3, 2, 1]
    После сдвига вправо: [1, 7, 6, 5, 4, 3, 2]

 */

/* РЕАЛИЗАЦИЯ РАЗВОРОТА #1
    Алгоритм сдвига без второго массива на 1 шаг вправо
    (Экономия ЦП и памяти, но малая универсальность)

        int tempCellLast = array[0];
        array[0] = array[array.length - 1];

        for (int i = 1; i < array.length; i++) {
            int tempCell = array[i];
            array[i] = tempCellLast;
            tempCellLast = tempCell;
        }

        return array;
        */

/* РЕАЛИЗАЦИЯ РАЗВОРОТА #2
    Алгоритм сдвига на любое количество шагов, но со вторым массивом
    (Экономия ЦП, но не памяти)

        step = step % array.length; // Убираем число шагов, которые фактически не повлияют на структуру массива, но при этом тратят ресурсы
        if (step < 0)
            step += array.length;

        if (step == 0)
            return array;

        int[] replacedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int new_position = i + step;
            if (new_position >= array.length)
                new_position -= array.length;
            replacedArray[new_position] = array[i];
        }

        return replacedArray;*/