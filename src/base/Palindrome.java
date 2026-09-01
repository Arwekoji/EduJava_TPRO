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
    private static boolean isPalindrome(String input) {
        input = input.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();

        return input.equals(new StringBuilder(input).reverse().toString());
    }

    public static void checkAndShow (String input) {
        System.out.printf("Строка \"%s\" - %sпалиндром", input, Palindrome.isPalindrome(input) ? "" : "не ");
        System.out.println();
    }
}
