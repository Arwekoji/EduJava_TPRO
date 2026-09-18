package utils;

import java.util.Random;

/**
 * Расширяемый набор кастомных методов работы с массивами
 */
public class AdvancedArrays {

    /**
     * Выбирает случайный элемент из generic массива
     *
     * @param array         Массив generic типа
     * @param <GenericType> Массив с дженерик типом
     * @return Случайный элемент из заданного массива
     */
    public static <GenericType> GenericType pick(GenericType[] array) {
        return array[new Random().nextInt(0, array.length - 1)];
    }
}
