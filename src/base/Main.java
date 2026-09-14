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

/* Задание 2.7 — Методы строк: текстовый процессор

### Задача 1 — Счётчик слов

Метод `int countWords(String text)` — количество слов. Пробелы могут быть множественными. Пустая строка и null → 0.

### Задача 2 — Валидатор email

Метод `boolean isValidEmail(String email)` — проверяет: один @, точка после @, символ до @, нет пробелов. Только методы String, **без** regex.

### Задача 3 — Палиндром

Метод `boolean isPalindrome(String word)` — регистронезависимо, игнорируя пробелы. `"А роза упала на лапу Азора"` → true.
*/

/* Ожидаемый результат
- countWords: trim() + split("\\s+"), проверка null/empty
- isValidEmail: indexOf('@') == lastIndexOf('@'), все 5 условий
- isPalindrome: toLowerCase() + replace(" ","") + сравнение с reverse
- Все методы static, возвращают значение (не println)

 */