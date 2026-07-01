package base;

import java.util.Arrays;

/**
 * Класс для получения данных по одномерному массиву
 *
 * @author Артур Федьвереш
 */
public class ArrayStats {

    /**
     * Метод для вывода данных в консоль по рандомно сгенерированному одномерному массиву
     *
     * @author Артур Федьвереш
     */
    public static void getArray() {
        int[] array = Main.newArray(8, 100, -50);
        System.out.println("Массив: " + Arrays.toString(array));

        int sum = 0, even = 0, odd = 0, positive = 0, negative = 0;
        int minIndex = 0, min = array[minIndex];
        int maxIndex = 0, max = array[maxIndex];

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }

            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }

            if (array[i] % 2 == 0)    even++;
            else                      odd++;

            if (array[i] >= 0)    positive++;
            else                  negative++;

        }

        System.out.print("Сумма: " + sum + " | ");
        System.out.printf("Среднее: %.2f | ", (double) sum / array.length);
        System.out.printf("Максимум: %d (индекс %d) | ", max, maxIndex);
        System.out.printf("Минимум: %d (индекс %d) | ", min, minIndex);
        System.out.printf("(Чётных: %d; Нечётных: %d) | ", even, odd);
        System.out.printf("(Положительных: %d; Отрицательных: %d)\n", positive, negative);

    }
}