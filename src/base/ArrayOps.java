package base;

import java.util.Arrays;

/**
 * Класс для реализации переворота массива или его сдвига
 *
 * @author Артур Федьвереш
 */
public class ArrayOps {

    /**
     * Метод для демонстрации ручного переворота массивов и его сдвига
     *
     * @author Артур Федьвереш
     */
    public static void getArray() {
        int[] array = Main.newArray(7, 100, -50);
        System.out.println("Массив: " + Arrays.toString(array));

        StringBuilder reverseOutput = new StringBuilder("");
        System.out.print("Порядок, прямой: (");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);                 // В задаче массив довольно короткий и можно было бы для демонстрации показать обратный порядок в отдельном цикле
            reverseOutput.append(array[array.length - i - 1] + " "); // Но будь он длиннее на порядок, то несколько циклов подряд плохо сказались бы на производительности
        }                                               // Поэтому решение спроектировано так, чтобы система делала меньше действий
        System.out.println(") | обратный: (" + reverseOutput + ")");

        for (int i = 0; i < array.length / 2; i++) { // Форма записи компактнее, чем через цикл While
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.println("Массив, перевёрнутый: " + Arrays.toString(array));

        int tempCellLast = array[0];
        array[0] = array[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            int tempCell = array[i];
            array[i] = tempCellLast;
            tempCellLast = tempCell;
        }

        System.out.println("Массив сдвинут вправо на 1: " + Arrays.toString(array));

    }

}
