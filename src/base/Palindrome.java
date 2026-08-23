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
    public static void check(String input) {
        System.out.printf("Строка \"%s\" - ", input);

        input = input.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();

        System.out.println(
                input.equals(new StringBuilder(input).reverse().toString()) ? "палиндром" : "не палиндром"
        );
    }
}
