package base;

/**
 * Класс для игры в угадайку
 *
 * @author Артур Федьвереш
 */
public class GuessGame {

    /**
     * Метод, позволяющий попробовать угадать ответ на самый главный вопрос
     *
     * @param secret предполагаемое число
     * @author Артур федьвереш
     */
    public void guess(int secret) {
        if (secret == 42)
            System.out.println("Верно, это 42!");
        else
            System.out.println("Нет, число " + secret + " не является верным");
    }
}
