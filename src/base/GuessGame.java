package base;

/**
 * Класс для игры в угадайку
 *
 * @author Артур Федьвереш
 */
public class GuessGame {
    private static final int SECRET = 42;

    /**
     * Метод, позволяющий попробовать угадать ответ на самый главный вопрос
     *
     * @param guess предполагаемое число
     */
    public static void guess(int guess) {
        if (guess == SECRET)
            System.out.println("Верно, это 42!");
        else if (guess < SECRET)
            System.out.println("Не угадал! Число " + guess + " меньше загаданного");
        else
            System.out.println("Не угадал! Число " + guess + " больше загаданного");
    }
}
