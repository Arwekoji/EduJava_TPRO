package base;

/**
 * Точка входа в программу
 *
 * @author Артур Федьвереш
 */
public class Main {
    public static String[] EXAMPLE_PHRASES = {
            "",
            " ",
            "Мир ",
            "Привет, мир",
            "В мире очень много хорошего",
            "   Один Два    "
    };
    public static String[] EXAMPLE_EMAILS = {
            "arwekoji@gmail.com",
            "ar wekoji@gmail.com",
            "arwe@koji@gmailcom",
            "arwekoji@gmailcom"
    };
    public static String[] EXAMPLE_PALINDROMES = {
            "А роза упала на лапу Азора",
            "А роза не упала на лапу Азора"
    };

    /**
     * Точка входа в программу
     *
     * @param args аргументы точки входа
     */
    public static void main(String[] args) {
        // ЗАДАЧА №1
        for (String examplePhrase : EXAMPLE_PHRASES)
            System.out.println("Фраза \"" + examplePhrase + "\". Число слов в ней: " + TextProcessor.countWords(examplePhrase));

        System.out.println("- - - - - -");

        // ЗАДАЧА №2
        for (String exampleEmail : EXAMPLE_EMAILS)
            System.out.println("\"" + exampleEmail + "\" это email? " + TextProcessor.isValidEmail(exampleEmail));

        System.out.println("- - - - - -");

        // ЗАДАЧА №3
        for (String examplePalindrome : EXAMPLE_PALINDROMES)
            System.out.println("\"" + examplePalindrome + "\" это палиндром? " + TextProcessor.isPalindrome(examplePalindrome));
    }
}