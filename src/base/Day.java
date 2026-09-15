package base;

import assist.AdvancedText;

/**
 * Перечисление дней недели с базовыми методами чтения
 */
public enum Day {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    private String rusName;

    /**
     * Конструктор с указанием названия дня недели на русском языке
     *
     * @param rusName Название данного дня недели на русском
     */
    Day(String rusName) {
        this.rusName = rusName;
    }

    /**
     * Геттер русского имени с соблюдением принципа инкапсуляции
     *
     * @return Копия русского имени данного дня недели
     */
    public String getRusName() {
        return new String(rusName);
    }

    /**
     * Метод проверки данного дня недели на статус выходного
     *
     * @return Статус выходного дня
     */
    public boolean isWeekend() {
        return this == Day.SATURDAY || this == Day.SUNDAY;
    }

    /**
     * Метод проверки данного дня недели на статус буднего
     *
     * @return Статус буднего (рабочего) дня
     */
    public boolean isWorkday() {
        return !isWeekend();
    }

    /**
     * Переопределение tiString на отформатированный вид с указанием русского названия и статуса буднего/выходного дня
     *
     * @return Отформатированная строка с описанием элемента enum Day (Т.е. дня недели)
     */
    @Override
    public String toString() {
        return AdvancedText.renderMarkdown(String.format("[g]%s[g] (%s): [b]isWorkday[b]=%b, [b]isWeekend[b]=%b",
                this.name(), this.getRusName(), isWorkday(), isWeekend()
        ));
    }

    /**
     * Скрипт для демонстрации возможностей данного класса / перечисления
     */
    public static void testClass() {
        for (Day day : Day.values())
            System.out.println(day);
    }
}

/* Задача 3 — Enum Day

 - Перечисление `Day` (7 дней)
 - с полем `rusName`,
 - конструктором,
 - методами `isWeekend()`,
 - `isWorkday()`.
 - Вывести все дни с русскими названиями и типом (рабочий/выходной).
*/

/*
- Enum с конструктором, полем, геттером, логикой isWeekend
 */