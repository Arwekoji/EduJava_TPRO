package base;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс для сложения одномерных массивов произвольной длины
 *
 * @author Артур Федьвереш
 */
public class ArrayMerge {

    /**
     * Метод для демонстрации алгоритма сложения одномерных массивов произвольной длины
     *
     * @param arraySize1
     * @param arraySize2
     * @author Артур Федьвереш
     */
    public static void merge(int arraySize1, int arraySize2) {

        int[] array1 = Main.newArray(arraySize1, 10, 1);
        int[] array2 = Main.newArray(arraySize2, 10, 1);
        int[] arraySum = new int[arraySize1 + arraySize2];
        ArrayList<Integer> listEven = new ArrayList<>(); // Формально, можно сперва посчитать число четных элементов, и под это число создать массив
                                                         // Но зачем, если списки тоже в своем роде массивы, но динамические?
        Arrays.sort(array1);
        Arrays.sort(array2);

        int counter1 = 0, counter2 = 0;
        for (int counterSum = 0; counterSum < arraySize1 + arraySize2; counterSum++) {

            if (counter1 < arraySize1 && (counter2 == arraySize2 || array1[counter1] <= array2[counter2]))
                arraySum[counterSum] = array1[counter1++];
            else
                arraySum[counterSum] = array2[counter2++];

            if (arraySum[counterSum] % 2 == 0)
                listEven.add(arraySum[counterSum]);

        }

        System.out.println("Первый массив: " + Arrays.toString(array1));
        System.out.println("Второй массив: " + Arrays.toString(array2));
        System.out.println("Сложенный массив: " + Arrays.toString(arraySum));
        System.out.println("Массив всех чётных чисел: " + listEven);
    }

}
