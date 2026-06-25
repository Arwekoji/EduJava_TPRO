package base;

/**
 * Точка входа в программу
 *
 * @author Артур Федьвереш
 */
public class Main {

    /**
     * Точка входа в программу
     *
     * @param args аргументы точки входа
     * @author Артур Федьвереш
     */
    public static void main(String[] args) {

        // ЗАДАЧА №1
        System.out.println("Число слов: " + TextProcessor.countWords(""));
        System.out.println("Число слов: " + TextProcessor.countWords(" "));
        System.out.println("Число слов: " + TextProcessor.countWords("Мир "));
        System.out.println("Число слов: " + TextProcessor.countWords("Привет, мир"));
        System.out.println("Число слов: " + TextProcessor.countWords("В мире очень много хорошего"));
        System.out.println("Число слов: " + TextProcessor.countWords("   Один Два    "));

        System.out.println("- - - - - -");

        // ЗАДАЧА №2
        System.out.println("\"arwekoji@gmail.com\" это email? " + TextProcessor.isValidEmail("arwekoji@gmail.com"));
        System.out.println("\"ar wekoji@gmail.com\" это email? " + TextProcessor.isValidEmail("ar wekoji@gmail.com"));
        System.out.println("\"arwe@koji@gmailcom\" это email? " + TextProcessor.isValidEmail("arwe@koji@gmailcom"));
        System.out.println("\"arwekoji@gmailcom\" это email? " + TextProcessor.isValidEmail("arwekoji@gmailcom"));

        System.out.println("- - - - - -");

        // ЗАДАЧА №3
        System.out.println("\"А роза упала на лапу Азора\" это палиндром? " + TextProcessor.isPalindrome("А роза упала на лапу Азора"));
        System.out.println("\"А роза не упала на лапу Азора\" это палиндром? " + TextProcessor.isPalindrome("А роза не упала на лапу Азора"));
    }
}