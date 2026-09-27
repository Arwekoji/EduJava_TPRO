package utils;

/**
 * Генератор случайных сущностей
 */
public final class Randomizer {

    /**
     * Возвращает случайное число, основанное на Math.random()
     *
     * @param randomMathModifier Множитель для дробного числа, получаемого от Math.random()
     * @param shift              Сдвиг итогового числа для получения более продвинутых диапазонов чисел
     * @return Случайное целое число в диапазоне rand(0, 1) * randomMathModifier + shift
     */
    public static int getRandomInt(int randomMathModifier, int shift) {
        return (int) (Math.random() * randomMathModifier) + shift;
    }

    /**
     * Возвращает одномерный массив указанного размера из случайных чисел в заданном диапазоне для Math.random()
     *
     * @param arraySize          Размер ожидаемого массива
     * @param randomMathModifier Аргумент для getRandomInt, множитель для Math.random()
     * @param resultShift        Аргумент для getRandomInt, сдвиг результата перед выводом
     * @return Одномерный массив, который содержит N=arraySize случайных элементов Integer типа
     */
    public static int[] createArray(int arraySize, int randomMathModifier, int resultShift) {
        int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++)
            array[i] = getRandomInt(randomMathModifier, resultShift);

        return array;
    }
}
