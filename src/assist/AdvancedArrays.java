package assist;

import java.util.Random;

/**
 * Набор усовершенствованных (компактных) методов работы с массивами
 */
public class AdvancedArrays {

    /**
     * Метод для случайного выбора из заданного массива
     *
     * @param array Массив generic типа
     * @return Случайный элемент из заданного массива
     * @param <GenericType> Generic тип массива
     */
    public static <GenericType> GenericType pick (GenericType[] array) {  // <Type> - Дженерик для ввода массива неопределенного типа Type
        return array[new Random().nextInt(0, array.length - 1)];
    }
}
