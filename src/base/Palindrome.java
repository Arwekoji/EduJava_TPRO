package base;

/**
 * Класс для проверки входящих строк на статус палиндрома
 */
public class Palindrome {
    /**
     * Процедура, которая проверяет строку на статус палиндрома и выводит результат в консоль
     *
     * @param input Вводные данные в формате String для анализа
     */
    public static boolean check(String input) {
        input = input.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();

        return input.equals(new StringBuilder(input).reverse().toString());
    }
}
