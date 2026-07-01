package base;

/**
 * Точка входа в программу
 *
 * @author Артур Федьвереш
 */
public class Main {

    /**
     * Точка входа
     *
     * @param args Аргументы точки входа
     * @author Артур Федьвереш
     */
    public static void main(String[] args) {
        ArrayStats.getArray();
        System.out.println("- - - - - - -");
        ArrayOps.getArray();
        System.out.println("- - - - - - -");
        ArraySearch.find(3);
        System.out.println("- - - - - - -");
        ArrayMerge.merge(10, 13);

    }

    /**
     * Метод для упрощенного создания рандомных одномерных массивов
     *
     * @author Артур Федьвереш
     * @param arraySize Ожидаемая длина массива
     * @param randSize  Ожидаемая разрядность значений массива
     * @param randStep  Арифметический модификатор для достижения нужного диапазона значений
     * @return Рандомизированный одномерный массив int[] типа
     */
    public static int[] newArray(int arraySize, int randSize, int randStep) {
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++)
            array[i] = (int) ((Math.random() * randSize) + randStep); // Случайные числа

        return array;
    }

}