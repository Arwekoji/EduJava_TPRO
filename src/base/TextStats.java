package base;

/**
 * Класс для анализа заданных текстов
 */
public class TextStats {
    /**
     * Процедура, которая анализирует текст на количество слов и символов, после чего выводит собранные данные в консоль
     *
     * @param input Текст в формате String для анализа
     */
    public static void analyse(String input) {
        String[] words = input.split(" ");
        String wordLongest = words[0], wordShortest = words[0];
        int countSymbols = 0;

        for (String word : words) {
            countSymbols += word.length();
            if (word.length() > wordLongest.length())
                wordLongest = word;
            if (word.length() < wordShortest.length())
                wordShortest = word;
        }

        float middleLength = (float) countSymbols / words.length;

        System.out.println(String.format("""
                        "%s"
                        СТАТИСТИКА:
                        %d - # слов; %d - # символов без пробелов; %.2f - Средняя длина слова
                        "%s" - самое длинное слово; "%s" - самое короткое слово
                        """, input, words.length, countSymbols, middleLength, wordLongest, wordShortest
                )
        );
    }
}
