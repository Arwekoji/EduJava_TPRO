package base;

/**
 * Класс для обработки входящих строк разными методами
 */
public class TextProcessor {
    public static final String DISALLOWED_EDGE_SYMBOLS = "@-.";
    public static final String ALLOWED_CHARS = "@.-_+%"; // + isLetter() + isDigit()

    /**
     * Метод для подсчета слов во фразе
     *
     * @param text Фраза для анализа
     * @return Число строк в формате int
     */
    public static int countWords(String text) {
        if (text == null || text.isBlank()) //isBlank включает в себя функцию isEmpty в контексте задачи
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
        if (email == null) // null-safety
            return false;

        // email не может начинаться или заканчиваться на символы вроде '-', '.' или '@'
        if (DISALLOWED_EDGE_SYMBOLS.contains(email.charAt(0)) || DISALLOWED_EDGE_SYMBOLS.contains(email.charAt(email.length() - 1)))
            return false;

        if (email.indexOf("@") != email.lastIndexOf("@") || email.indexOf("@") > email.lastIndexOf("."))      // Проверка на число "@" (1) и наличие точки после неё
            return false;

        if (email.lastIndexOf(".") >= email.length() - 2 || email.lastIndexOf(".") - email.indexOf("@") < 3)  // Проверка на длину доменного имени
            return false;

        for (int i = 0; i < email.length(); i++) { // Проверка на соответствие разрешенными символам или дублирование особых символов в списке ALLOWED_CHARS
            char symbol = email.charAt(i);

            if (!ALLOWED_CHARS.contains(symbol) && !symbol.isLetter() && && !symbol.isDigit()) // Это также является аналогом email.contains("\s")
                return false;

            if (i > 0 && ALLOWED_CHARS.contains(symbol) && symbol.equals(email.charAt(i - 1)))
                return false;
        }

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

/*
В countWords по хорошему нужна проверка на null

isValidEmail - нужно дополнить следующими проверками
1) Состоит только из букв, цифр, '.', '_', '%', '+', '-'
2) Не может начинаться и оканчиваться на '-'
3) Корректный домен, т.е. должно заканчиваться на '.' и как минимум 2 буквы
4) Не должно быть 2х последовательных '.' - к
5) Не должно быть комбинации '@.'

isPalindrome по хорошему тоже лучше null-safety добавить
 */