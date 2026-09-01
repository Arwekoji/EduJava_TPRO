package base;

/**
 * Класс для анализа и сбора статистики из полученных переменных класа String
 */
public class StringAnalyser {
    /**
     * Процедура, которая анализирует и выводит статистику строки в консоль
     *
     * @param input Вводные данные типа String для анализа и демонстрации статистики
     */
    public static void analyse(String input) {
        int spacesCount = 0, digitCount = 0, letterCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') spacesCount++;
            else if (Character.isDigit(input.charAt(i))) digitCount++;
            else if (Character.isLetter(input.charAt(i))) letterCount++;
        }

        System.out.println(String.format("""
                Строка:"%s"
                Длина:%d
                В верхнем регистре:"%s"
                В нижнем регистре:"%s"
                Без пробелов по краям:"%s"
                Количество пробелов:%d
                Количество цифр:%d
                Количество букв:%d
                Содержит "World":%s
                Первое вхождение "o":%d
                Последнее вхождение "o":%d
                Подстрока [0, 5]:"%s"
                После замены "World" на "Java":"%s"
                """, input, input.length(), input.toUpperCase(), input.toLowerCase(), input.trim(), spacesCount, digitCount, letterCount,
                (input.contains("World")) ? "да" : "нет", input.indexOf('o'), input.lastIndexOf('o'), input.substring(0, Math.min(5, input.length())),
                input.replace("World", "Java")));
    }
}
