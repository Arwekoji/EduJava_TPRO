package base;

import java.util.ArrayList;

/**
 * Нахождение и вывод найденных простых чисел в заданном диапазоне
 */
public class PrimeNumbers {

    public static void searchAndShowPrimeNumbers (byte limit) {
        PrimeNumbers.printInfo(limit, PrimeNumbers.getSimpleNumbers(limit));
    }

    /**
     * Процедура поиска простых чисел в заданном диапазоне от 2 до n
     *
     * @param limit Граница диапазона поиска простых чисел
     */
    public static ArrayList<Integer> getSimpleNumbers(byte limit) {
        ArrayList<Integer> simpleNumbers = new ArrayList<>();

        for (byte i = 2; i <= limit; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= (byte) Math.sqrt(i); j++)
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }

            if (isPrime == true)
                simpleNumbers.add((int) i);
        }

        return simpleNumbers;
    }

    /**
     * Процедура вывода найденных в диапазоне простых чисел в консоль
     *
     * @param limit Верхняя граница диапазона поиска простых чисел
     * @param SimpleNumbers Динамический массив, содержащий найденные простые числа
     */
    public static void printInfo (byte limit, ArrayList<Integer> SimpleNumbers) {
        System.out.printf("""
                Простые числа в диапазоне {2 - %d}: %s
                """, limit, SimpleNumbers);
    }
}
