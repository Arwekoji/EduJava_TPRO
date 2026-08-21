package base;

/**
 * Класс для нахождения простых чисел
 *
 * @author Артур Федьвереш
 */
public class PrimeNumbers {

    /**
     * Метод для отображения в консоли простых чисел в диапазоне от 2 до заданного числа
     *
     * @param n Максимум диапазона для поиска
     * @author Артур Федьвереш
     */
    public static void getSimpleNumber(byte n) {
        for (byte i = 2; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= (byte) Math.sqrt(i); j++)
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }

            if (isPrime == true)
                System.out.print(i + " ");
        }
    }
}
