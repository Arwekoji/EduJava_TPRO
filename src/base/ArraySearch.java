package base;

import java.util.Arrays;

/**
 * Класс для демонстрации алгоритмов поиска элементов внутри массива
 *
 * @author Артур Федьвереш
 */
public class ArraySearch {

    /**
     * Метод для поиска элемента внутри рандомно сгенерированного одномерного массива, линейным и бинарным способами
     *
     * @param find Искомое число/элемент массива типа Int
     * @author Артур Федьвереш
     */
    public static void find(int find) {
        int[] array = Main.newArray(10, 10, 1);
        System.out.print("Массив: " + Arrays.toString(array) + " - ");

        int findIndex = -1;
        for (int i = 0; i < array.length; i++)
            if (array[i] == find) {
                findIndex = i;
                break;
            }

        if (findIndex >= 0) System.out.printf("Число \"%d\" было найдено под индексом %d\n", find, findIndex);
        else System.out.printf("Число \"%d\" не присутствует в нём!\n", find);

        Arrays.sort(array);
        System.out.println("Ниже бинарный поиск для отсортированного массива " + Arrays.toString(array));

        //Ручной бинарный поиск
        int leftIndex = 0, middleIndex = array.length / 2, rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            if (array[leftIndex] == find) {
                findIndex = leftIndex;
                break;
            }

            if (array[rightIndex] == find) {
                findIndex = rightIndex;
                break;
            }

            if (array[middleIndex] == find) {
                findIndex = middleIndex;
                break;
            }

            if (array[leftIndex] < find && array[middleIndex] > find) { // Поиск числа на левой половине отрезка
                rightIndex = middleIndex;
                middleIndex = (rightIndex + leftIndex) / 2;
                if (middleIndex == rightIndex) // Защита от бесконечного цикла
                    break;
            } else if (array[middleIndex] < find && array[rightIndex] > find) { // Поиск числа на правой половине отрезка
                leftIndex = middleIndex;
                middleIndex = (rightIndex + leftIndex) / 2;
                if (middleIndex == leftIndex) // Защита от бесконечного цикла
                    break;
            } else
                break;

            System.out.printf("Шаг с индексами Right|Middle|Left: [%d]|[%d]|[%d]\n", leftIndex, middleIndex, rightIndex);
        }

        if (findIndex >= 0) System.out.printf("Число \"%d\" было найдено под индексом %d\n", find, findIndex);
        else System.out.printf("Число \"%d\" не присутствует в массиве!\n", find);
    }

}