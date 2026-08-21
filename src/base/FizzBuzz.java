package base;

/**
 * Класс для проверки чисел на кратность в заданном диапазоне
 *
 * @author Артур Федьвереш
 */
public class FizzBuzz {

    /**
     *
     * Метод, который показывает все числа в диапазоне от 1 до 100 и заменяет их на особые имена, если они кратны 3, 5 или 3 и 5 одновременно
     *
     * @author Артур Федьвереш
     */
    public static void getReplacedByteRow() {
        for (byte i = 1; i <= 100; i++) {
            if ((i % 3 == 0) && (i % 5 == 0))
                System.out.print("FizzBuzz");
            else if (i % 3 == 0)
                System.out.print("Fizz");
            else if (i % 5 == 0)
                System.out.print("Buzz");
            else
                System.out.print(i);

            System.out.print(", ");
        }

        System.out.println();
    }
}
