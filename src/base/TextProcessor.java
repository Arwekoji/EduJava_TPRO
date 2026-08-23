package base;

/**
 * Класс для обработки входящих строк разными методами
 */
public class TextProcessor {
    /**
     * Метод для подсчета слов во фразе
     *
     * @param text Фраза для анализа
     * @return Число строк в формате int
     */
    public static int countWords(String text) {
        if (text.isBlank()) //isBlank включает в себя функцию isEmpty в контексте задачи
            return 0;

        String[] words = text.trim().split("\\s+"); // Просто " " не годится - пробелы могут быть разными
        return words.length;
    }

    /**
     * Метод для проверки введенного email на соответствие стандартам
     *
     * @param email Данные об email для анализа
     * @return Возвращает статус соответствия стандартам (Валидность)
     */
    public static boolean isValidEmail(String email) {
        if (email.contains("\s") || email.indexOf("@") != email.lastIndexOf("@")) // Проверка на число пробелов (0) и "@" (1)
            return false;

        if (email.indexOf("@") == 0 || email.indexOf("@") > email.lastIndexOf(".")) // Проверка на то, что до @ есть символ, а после есть точка
            return false;

        return true; // Если Ничего не затриггерилось раньше - метод вернет True
    }

    /**
     * Метод для проверки фразы на палиндромность с игнорированием пробелов и регистра
     *
     * @param word Фраза для анализа
     * @return Возвращает True если фраза является палиндромом
     */
    public static boolean isPalindrome(String word) {
        String wordCleaned = word.toLowerCase().replace("\s", ""); // Прежде всего нужно очистить фразу от пробелов и привести в нижний регистр
        return wordCleaned.equals(new StringBuilder(wordCleaned).reverse().toString()); // И только потом сравнивать с зеркальной версией
    }
}
