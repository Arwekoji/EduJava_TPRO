package utils;

/**
 * Набор текстовых паттернов для вывода в консоль средствами System.out.print
 */
public final class ConsolePatterns {
    public static final int LINE_LENGTH = 127;
    public static final String LINE_SEGMENT = "─";

    /**
     * Генератор строки с длиной и типом по умолчанию
     *
     * @return Строка с длиной и типом по умолчанию
     */
    private static String createLine() {
        return LINE_SEGMENT.repeat(LINE_LENGTH);
    }

    /**
     * Выводит в консоль шаблон заголовка для обьявления начала выполнения списка задач по указанной теме
     *
     * @param taskTopicNumber Номер учебной темы
     * @param topicTitle      Название учебной темы
     */
    public static void printTaskHeader(double taskTopicNumber, String topicTitle) {
        System.out.printf("""
                
                ЗАДАНИЕ ПО ТЕМЕ %.1f "%s"
                Ниже выведены результаты тестов для каждой задачи
                """, taskTopicNumber, topicTitle);
    }

    /**
     * Выводит в консоль шаблон разделителя выводов между задач, включающий заголовок самой задачи
     *
     * @param taskNumber Номер задачи данной темы
     * @param taskType   Тип данной задачи (Class, Enum и прочие)
     * @param taskTitle  Название типа данной задачи
     */
    public static void printTaskSeparator(int taskNumber, String taskType, String taskTitle) {
        System.out.printf("""
                
                %s
                Задача #%d (%s "%s")
                
                """,createLine(), taskNumber, taskType, taskTitle);
    }

    /**
     * Выводит в консоль шаблон ошибки, сообщающий о том, что вывод не совпадает с правильным
     */
    public static void printTaskError() {
        System.out.println("[ERROR_1]: Вывод задачи не совпадает с тестовыми данными");
    }

    /**
     * Выводит в консоль шаблон критической ошибки, сообщающий о том, что код не был выполнен успешно
     */
    public static void printRuntimeError(Throwable throwable) {
        System.out.println("[ERROR_0]: При выполнении кода произошла критическая ошибка - " + throwable.getClass());
    }
}
