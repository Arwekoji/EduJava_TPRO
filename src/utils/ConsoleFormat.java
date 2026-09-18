package utils;

import java.util.ArrayList;

import static base.Main.FLAG_ANSI_RENDER;

/**
 * Расширяемый набор инструментов для упрощенной отрисовки графических элементов в консоли
 */
public class ConsoleFormat {
    public static final String LINE_DEFAULT = "─";
    public static final short LINE_LENGTH = 55;

    /**
     * Набор правил для формирования тегов
     */
    private static class AnsiRules extends ConsoleFormat {
        public static final String SGR_BASE_START = "\u001B[";
        public static final String SGR_BASE_END = "m";
        private static final String RESET = "0";
        private static final int COLOR_FORETEXT_END = 39;
        private static final int COLOR_BACKTEXT_END = 49;
        private static final int SPECIAL_FONT_END = 10;

        public static final Rule[] TAGS = {
                // Кастомные шаблоны
                new Rule("---", 90 + SGR_BASE_END + LINE_DEFAULT.repeat(LINE_LENGTH) + SGR_BASE_START + String.valueOf(COLOR_FORETEXT_END),
                        RESET, false),  // Horisontal Rule
                // Discord-like Markdown теги
                new Rule("***", "1;3"),                     // Жирный курсив
                new Rule("**", 1),                          // Жирный или увеличение яркости
                new Rule("*", 3, 23),               // Курсив
                new Rule("__", 4, 24),              // Подчеркивание
                new Rule("||", 8, 28),              // Спойлер
                new Rule("~~", 9, 29),              // Зачеркивание
                new Rule("`", 90, COLOR_BACKTEXT_END),     // Тёмный фон
                // Дополнительные возможности ANSI SGR (Скорей всего не отобразятся)
                new Rule("<0>", 2, 22),                 // Блёклый
                new Rule("<$>", 5, 25),                 // Мигание, медленное
                new Rule("<$$>", 6, 25),                // Мигание, частое
                new Rule("<->", 7, 27),                 // Негатив (фон <-> текст)
                new Rule("<[]>", 51, 54),               // Обрамлённый текст
                new Rule("<()>", 52, 54),               // Окружённый текст
                new Rule("<|>", 53, 55),                // Надчёркнутый текст
                new Rule("<+>", 60, 65),                // Одинарное подчеркивание идеограммы
                new Rule("<++>", 61, 65),               // Двойное подчеркивание идеограммы
                new Rule("</>", 62, 65),                // Одинарное надчеркивание идеограммы
                new Rule("<//>", 63, 65),               // Двойное надчеркивание идеограммы
                new Rule("<'>", 64, 65),                // Обозначение ударения в идеограмме
                // Примитивные цвета текста и фона
                new Rule("<d>", 30, COLOR_FORETEXT_END), new Rule("<dd>", 40, COLOR_BACKTEXT_END),   // Black
                new Rule("<r>", 31, COLOR_FORETEXT_END), new Rule("<rr>", 41, COLOR_BACKTEXT_END),   // Red
                new Rule("<g>", 32, COLOR_FORETEXT_END), new Rule("<gg>", 42, COLOR_BACKTEXT_END),   // Green
                new Rule("<y>", 33, COLOR_FORETEXT_END), new Rule("<yy>", 43, COLOR_BACKTEXT_END),   // Yellow
                new Rule("<b>", 34, COLOR_FORETEXT_END), new Rule("<bb>", 44, COLOR_BACKTEXT_END),   // Blue
                new Rule("<m>", 35, COLOR_FORETEXT_END), new Rule("<mm>", 45, COLOR_BACKTEXT_END),   // Magenta
                new Rule("<c>", 36, COLOR_FORETEXT_END), new Rule("<cc>", 46, COLOR_BACKTEXT_END),   // Cyan
                new Rule("<w>", 37, COLOR_FORETEXT_END), new Rule("<ww>", 47, COLOR_BACKTEXT_END),   // White
                // Примитивные яркие цвета текста и фона
                new Rule("<D>", 90, COLOR_FORETEXT_END), new Rule("<DD>", 100, COLOR_BACKTEXT_END),   // Black
                new Rule("<R>", 91, COLOR_FORETEXT_END), new Rule("<RR>", 101, COLOR_BACKTEXT_END),   // Red
                new Rule("<G>", 92, COLOR_FORETEXT_END), new Rule("<GG>", 102, COLOR_BACKTEXT_END),   // Green
                new Rule("<Y>", 93, COLOR_FORETEXT_END), new Rule("<YY>", 103, COLOR_BACKTEXT_END),   // Yellow
                new Rule("<B>", 94, COLOR_FORETEXT_END), new Rule("<BB>", 104, COLOR_BACKTEXT_END),   // Blue
                new Rule("<M>", 95, COLOR_FORETEXT_END), new Rule("<MM>", 105, COLOR_BACKTEXT_END),   // Magenta
                new Rule("<C>", 96, COLOR_FORETEXT_END), new Rule("<CC>", 106, COLOR_BACKTEXT_END),   // Cyan
                new Rule("<W>", 97, COLOR_FORETEXT_END), new Rule("<WW>", 107, COLOR_BACKTEXT_END),   // White
                // Особые шрифты (Скорей всего не отобразятся)
                new Rule("<f1>", 11, SPECIAL_FONT_END),
                new Rule("<f2>", 12, SPECIAL_FONT_END),
                new Rule("<f3>", 13, SPECIAL_FONT_END),
                new Rule("<f4>", 14, SPECIAL_FONT_END),
                new Rule("<f5>", 15, SPECIAL_FONT_END),
                new Rule("<f6>", 16, SPECIAL_FONT_END),
                new Rule("<f7>", 17, SPECIAL_FONT_END),
                new Rule("<f8>", 18, SPECIAL_FONT_END),
                new Rule("<f9>", 19, SPECIAL_FONT_END),
                new Rule("<f10>", 20, SPECIAL_FONT_END)
        };

        /**
         * Набор ANSI кодировок для тега псевдографики
         *
         * @param tag
         * @param ansiStart
         * @param ansiEnd
         * @param isPair
         */
        private record Rule(String tag, String ansiStart, String ansiEnd, boolean isPair) {

            /**
             * Конструктор правила/тега
             *
             * @param tagStart  Как выглядит тег до форматирования
             * @param ansiStart ANSI код тега, который открывает форматирование
             * @param ansiEnd   ANSI код тега, который закрывает форматирование
             */
            public Rule(String tagStart, int ansiStart, int ansiEnd) {
                this(tagStart, String.valueOf(ansiStart), String.valueOf(ansiEnd), true);
            }

            public Rule(String tagStart, String ansiStart) {
                this(tagStart, ansiStart, RESET, true);
            }

            public Rule(String tagStart, int ansiStart) {
                this(tagStart, String.valueOf(ansiStart), RESET, true);
            }

            @Override
            public String toString() {
                return SGR_BASE_START + ansiStart + SGR_BASE_END;
            }

            public String getStart() {
                return toString();
            }

            public String getEnd() {
                return SGR_BASE_START + ansiEnd + SGR_BASE_END;
            }
        }
    }

    /**
     * Возвращает строку со сформированным начальным тегом кастомного цвета текста
     *
     * @param red   Красный оттенок текста по RGB системе
     * @param green Зелёный оттенок текста по RGB системе
     * @param blue  Синий оттенок текста по RGB системе
     * @return Начальный тег для формирования текста с указанным цветом
     */
    public static String tagTextRGB(int red, int green, int blue) {
        red = Math.clamp(red, 0, 255);
        green = Math.clamp(green, 0, 255);
        blue = Math.clamp(blue, 0, 255);

        return String.format("%s38;2;%d;%d;%d%s", AnsiRules.SGR_BASE_START, red, green, blue, AnsiRules.SGR_BASE_END);
    }

    /**
     * Возвращает строку с тегом, который закрывает тег кастомного цвета текста
     *
     * @return Закрывающий тег для формирования текста с кастомным цветом
     */
    public static String endTagTextRGB() {
        return AnsiRules.SGR_BASE_START + AnsiRules.COLOR_FORETEXT_END + AnsiRules.SGR_BASE_END;
    }

    /**
     * Возвращает строку со сформированным начальным тегом кастомного цвета фона текста
     *
     * @param red   Красный оттенок фона по RGB системе
     * @param green Зелёный оттенок фона по RGB системе
     * @param blue  Синий оттенок фона по RGB системе
     * @return Начальный тег для формирования фона текста с указанным цветом
     */
    public static String tagBackRGB(int red, int green, int blue) {
        red = Math.clamp(red, 0, 255);
        green = Math.clamp(green, 0, 255);
        blue = Math.clamp(blue, 0, 255);

        return String.format("%s48;2;%d;%d;%d%s", AnsiRules.SGR_BASE_START, red, green, blue, AnsiRules.SGR_BASE_END);
    }

    /**
     * Возвращает строку с тегом, который закрывает тег кастомного цвета фона текста
     *
     * @return Закрывающий тег для формирования текста с кастомным цветом
     */
    public static String endTagBackRGB() {
        return AnsiRules.SGR_BASE_START + AnsiRules.COLOR_BACKTEXT_END + AnsiRules.SGR_BASE_END;
    }
    /*Дублирование списка правил по элементам внутри метода, чтобы они работали как флаги*/

    /**
     * Парсит текст по системе тегов и рендерит кастомную псевдографику согласно заданным правилам. Отключается флагом FLAG_ANSI_RENDER
     *
     * @param input Текст для форматирования с тегами
     * @return Отформатированный текст с ansi кодами вместо тегов
     */
    public static String renderTags(String input) {
        if (input == null || input.isBlank()) return "";
        if (!FLAG_ANSI_RENDER) return input;

        ArrayList<AnsiRules.Rule> openRules = new ArrayList<>(); // Регистратор открытых тегов

        StringBuilder output = new StringBuilder(input.length() * 2); // Выделяем память с запасом, чтобы не тратить ресурс ЦП на операции расширения
        int i = 0;

        while (i < input.length()) {
            boolean isTag = false;

            for (AnsiRules.Rule rule : AnsiRules.TAGS)                   // Сперва цикл ищет подходящие теги или сдвигает символ на шаг вперед по изначальной строке
                if (input.startsWith(rule.tag, i)) {
                    boolean isOpen = false;                             // Если найден подходящий тег
                    isTag = true;

                    if (rule.isPair)
                        for (AnsiRules.Rule openRule : openRules)           // То идет проверка на "открытость" данного тега
                            if (rule.equals(openRule)) {                    // Если тег открыт, то он закрывается и вставляется Ansi завершения форматирования
                                isOpen = true;
                                break;
                            }

                    if (isOpen) {                                       // Если тег открыт, то он закрывается и вставляется Ansi завершения форматирования
                        openRules.remove(rule);
                        output.append(rule.getEnd());
                    } else {                                            // Иначе тег наоборот открывается и вставляется Ansi начала форматирования
                        if (rule.isPair)
                            openRules.add(rule);

                        output.append(rule.getStart());
                    }

                    i += rule.tag.length();                             // Незачем обрабатывать символы, лежащие внутри обработанного тега
                    break;
                }

            if (!isTag)
                output.append(input.charAt(i++));
        }

        return output.toString();
    }

    /**
     * Выводит в консоль блок текста с разделителем и заголовком задачи
     *
     * @param taskNumber    Номер задачи
     * @param taskClassName Название класса в задаче
     */
    public static void printTaskSeparator(int taskNumber, String taskClassName) {
        print(String.format("""
                
                ---
                **<g>Задача #%d<g>** (Class *%s*):
                
                """, taskNumber, taskClassName)
        );
    }

    /**
     * Выводит через System.out.print отформатированный текст по правилам тегов
     *
     * @param input Текст для форматирования и вывода
     */
    public static void print(String input) {
        System.out.print(renderTags(input));
    }

    /**
     * Выводит через System.out.println отформатированный текст по правилам тегов
     *
     * @param input Текст для форматирования и вывода
     */
    public static void println(String input) {
        System.out.println(renderTags(input));
    }


    public static String getLine(String lineSegment, int lineLength) {
        return lineSegment.repeat(lineLength);
    }

    public static String getLine(String lineSegment) {
        return lineSegment.repeat(LINE_LENGTH);
    }

    public static String getLine() {
        return LINE_DEFAULT.repeat(LINE_LENGTH);
    }

    /**
     * Выводит в консоль линию из указанных символов указанного количества
     *
     * @param lineSegment Повторяющийся элемент линии
     * @param lineLength  Длина линии повторяющихся элементов
     */
    public static void printLine(String lineSegment, int lineLength) {
        System.out.println(lineSegment.repeat(lineLength));
    }

    /**
     * Выводит в консоль линию из указанных символов, которые повторяются дефолтное количество раз
     *
     * @param lineSegment Повторяющийся элемент линии
     */
    public static void printLine(String lineSegment) {
        printLine(lineSegment, LINE_LENGTH);
    }

    /**
     * Выводит в консоль линию дефолтного типа и длины
     */
    public static void printLine() {
        printLine(LINE_DEFAULT);
    }

    /**
     * Выводит пустую строку в консоль, действуя как визуальный вертикальный разделитель
     */
    public static void printEmptyLine() {
        System.out.println();
    }

    /**
     * Выводит N пустых строк в консоль, действуя как визуальный вертикальный разделитель
     */
    public static void printEmptyLine(int quantity) {
        for (int i = 0; i < quantity; i++)
            System.out.println();
    }

    /**
     * Парсит заданную строку по настраиваемым тегам, формируя строку таблицы с заданными параметрами ширины столбцов
     *
     * @param input        Строка для парсинга
     * @param separatorTag Набор символов, которые парсер воспринимает как тег
     * @param separatorCol Комбинация символов, которая заменяет тег-сепаратор
     * @param colsSize     Массив с набором размеров для каждого столбца. Не может быть меньше 1, но может быть меньше числа столбцов
     * @return Отформатированная по правилам таблицы строка
     */
    public static String getCols(String input, String separatorTag, String separatorCol, int[] colsSize) {
        if (input == null || input.isEmpty() || colsSize.length < 1)
            return input;

        String[] cols = input.split(separatorTag);

        StringBuilder output = new StringBuilder(input.length() * 2);

        for (int i = 0; i < cols.length; i++) {
            int colSize = colsSize[Math.min(colsSize.length - 1, i)];
            output.append(
                    String.format("%-" + colSize + "s" + separatorCol, cols[i])
            );
        }

        return output.toString();
    }

    /**
     * Парсит заданную строку по настраиваемым тегам, формируя строку таблицы с заданным параметром ширины столбцов
     *
     * @param input        Строка для парсинга
     * @param separatorTag Набор символов, которые парсер воспринимает как тег
     * @param separatorCol Комбинация символов, которая заменяет тег-сепаратор
     * @param colsSize     Фиксированный размер ширины каждого столбца
     * @return Отформатированная по правилам таблицы строка
     */
    public static String getCols(String input, String separatorTag, String separatorCol, int colsSize) {
        return getCols(input, separatorTag, separatorCol, new int[]{colsSize});
    }
}

/*
Карта тегов:
* * - курсив
** ** - жирный текст
*** *** - жирный курсив
--- - Длинная линия в чате

 */