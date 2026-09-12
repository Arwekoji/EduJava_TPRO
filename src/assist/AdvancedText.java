package assist;

/**
 * Класс для усовершенствованной отрисовки текста в консоли
 */
public class AdvancedText {
    private static final String RESET = "\u001B[0m";
    private static final String GRAY = "\u001B[90m";
    private static final String HORIZONTAL_RULE = GRAY + "─".repeat(42) + RESET;

    // Добавили цветовые правила в общий массив. Порядок не критичен, так как теги уникальны.
    private static final Rule[] RULES = {
            new Rule("***", "\u001B[1;3m"),
            new Rule("**", "\u001B[1m"),
            new Rule("*", "\u001B[3m"),
            new Rule("~~", "\u001B[9m"),
            new Rule("__", "\u001B[4m"),
            new Rule("[r]", "\u001B[31m"), // Red
            new Rule("[g]", "\u001B[32m"), // Green
            new Rule("[b]", "\u001B[34m")  // Blue
    };

    private static class Rule {
        final String tag;
        final String ansi;
        boolean isOpen = false;

        /**
         * Конструктор тега markdown
         *
         * @param tag  Условный тег
         * @param ansi Тег в формате ansi, который фактически вставляется в текст вместо тега
         */
        Rule(String tag, String ansi) {
            this.tag = tag;
            this.ansi = ansi;
        }
    }

    /**
     * Форматирование текста по правилам markdown с модификациями
     *
     * @param input Текст для форматирования с тегами
     * @return Отформатированный текст с ansi кодами вместо тегов
     */
    public static String renderMarkdown(String input) {
        if (input == null || input.isEmpty()) return "";

        for (Rule rule : RULES)
            rule.isOpen = false; // Перед каждым новым парсингом нужно сбросить флаги

        StringBuilder result = new StringBuilder(input.length() * 2);
        int i = 0;
        int len = input.length();

        while (i < len) {
            // А. Проверка на horizontal rule (---, ***, ___)
            if ((i == 0 || input.charAt(i - 1) == '\n') && (input.startsWith("---", i) ||
                    input.startsWith("***", i) || input.startsWith("___", i))) {
                char currentLineChar = input.charAt(i);
                int nextIdx = i;
                while (nextIdx < len && input.charAt(nextIdx) == currentLineChar) nextIdx++;

                if (nextIdx == len || input.charAt(nextIdx) == '\n' || input.charAt(nextIdx) == '\r') {
                    result.append(HORIZONTAL_RULE);
                    i = nextIdx;
                    continue;
                }
            }

            // Б. Проверка текстовых стилей и цветов через компактный цикл
            boolean tagProcessed = false;
            for (Rule rule : RULES) {
                if (input.startsWith(rule.tag, i)) {
                    result.append(rule.isOpen ? RESET : rule.ansi);
                    rule.isOpen = !rule.isOpen; // Переключаем состояние (открыт/закрыт)
                    i += rule.tag.length();     // Сдвигаем указатель на длину тега
                    tagProcessed = true;
                    break;                      // Выходим из цикла правил, переходим к следующему символу текста
                }
            }

            // В. Если ни одно правило не подошло — просто копируем текущий символ
            if (!tagProcessed) {
                result.append(input.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    /**
     * Унифицированный разделитель выводов разных задач
     *
     * @param taskNumber    Номер задачи
     * @param taskClassName Название класса в задаче
     */
    public static void printTaskSeparator(int taskNumber, String taskClassName) {
        print(String.format("""
                
                ---
                **[g]Задача #%d[g]** (Class *%s*):
                
                """, taskNumber, taskClassName)
        );
    }

    /**
     * Аналог System.out.print, но со встроенным markdown
     *
     * @param input Текст для форматирования и вывода
     */
    public static void print(String input) {
        System.out.print(renderMarkdown(input));
    }

    /**
     * Аналог System.out.println, но со встроенным markdown
     *
     * @param input Текст для форматирования и вывода
     */
    public static void println(String input) {
        System.out.println(renderMarkdown(input));
    }

    /**
     * Вывод пустой строки в консоль (Визуальный разделитель)
     */
    public static void printEmptyLine() {
        System.out.println();
    }
}
