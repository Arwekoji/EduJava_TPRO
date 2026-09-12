package base;

import assist.AdvancedText;
import assist.CodeMetrics;
import assist.TestData;

/**
 * Класс для математических операций с диапазонами
 */
public class Range {
    private final double min, max;

    /**
     * Базовый конструктор с параметрами диапазона
     *
     * @param min Минимальная / левая точка диапазона
     * @param max Максимальная / правая точка диапазона
     */
    public Range(double min, double max) {
        if (max < min)
            throw new IllegalArgumentException("Максимум не может быть меньше минимума!");

        this.min = min;
        this.max = max;
    }

    /**
     * Геттер минимальной точки диапазона
     *
     * @return Минимальная точка/значение диапазона
     */
    public double getMin() {
        return min;
    }

    /**
     * Геттер максимальной точки диапазона
     *
     * @return Максимальная точка / значение диапазона
     */
    public double getMax() {
        return max;
    }

    /**
     * Геттер длины диапазона
     *
     * @return Длина диапазона
     */
    public double getLength() {
        return getMax() - getMin();
    }

    /**
     * Метод проверки наличия указанного значения в заданном диапазоне
     *
     * @param value Искомое значение
     * @return Факт наличия искомого значения в заданном диапазоне
     */
    public boolean contains(double value) {
        return value >= getMin() && value <= getMax();
    }

    /**
     * Метод проверки пересечения данного диапазона с указанным
     *
     * @param secondRange Указанный диапазон
     * @return Факт пересечения
     */
    public boolean overlaps(Range secondRange) {
        return (secondRange.getMin() >= getMin() && secondRange.getMin() <= getMax()) || (secondRange.getMax() >= getMin() && secondRange.getMax() <= getMax());
    }

    /**
     * Метод вычисления смежных отрезков у двух заданных диапазонов
     *
     * @param secondRange Второй указанный диапазон
     * @return Смежный отрезок (Если есть, либо null)
     */
    public Range intersection(Range secondRange) {
        if (!overlaps(secondRange))
            return null;

        if (contains(secondRange.getMin()))
            return new Range(secondRange.getMin(), Math.min(secondRange.getMax(), getMax()));
        else
            return new Range(getMin(), secondRange.getMax());
    }

    /**
     * Метод для вычисления диапазона, охватывающего оба заданных
     *
     * @param secondRange Второй указанный диапазон
     * @return Общий диапазон, охватывающий оба заданных
     */
    public Range union(Range secondRange) {
        return new Range(Math.min(getMin(), secondRange.getMin()), Math.max(getMax(), secondRange.getMax()));
    }

    /**
     * Переопределение метода toString для вывода отформатированной информации о диапазоне
     *
     * @return Строка с отформатированной информацией о диапазоне
     */
    public String toString() {
        return String.format("[%.2f; %.2f]", getMin(), getMax());
    }

    /**
     * Тестовая процедура для демонстрации возможностей класса
     */
    public static void testClass() {
        AdvancedText.println("*Будет произведена попытка создать диапазон, где максимум меньше минимума.*");
        Range r1;
        try {
            r1 = new Range(5, 0);
        } catch (IllegalArgumentException error) {
            CodeMetrics.printError(error);
        }

        AdvancedText.printEmptyLine();
        AdvancedText.println("*Ниже будет произведен тестовый прогон по нескольким заранее определенным диапазонам.*");
        r1 = TestData.RANGE_ORIGIN_EXAMPLE;
        for (Range r2 : TestData.RANGE_EXAMPLES) {
            AdvancedText.println(String.format("""
                            1 диапазон [b]%s[b] (Длина %.2f), 2 диапазон [b]%s[b] (Длина %.2f)
                            Пересечение на отрезке %s
                            __Общий диапазон [b]**%s**[b]__
                            """,
                    r1, r1.getLength(),
                    r2, r2.getLength(),
                    r1.intersection(r2),
                    r1.union(r2)
            ));
        }
    }
}

/*
Задача 3. Неизменяемый класс Range.
Создайте неизменяемый класс Range представляющий числовой диапазон.
 - Поля private final: min (double) и max (double).
 - В конструкторе проверьте что min <= max, иначе бросайте IllegalArgumentException.
  - Реализуйте методы:
  getMin,
  getMax,
  getLength возвращает разницу max - min,
  contains принимает double и возвращает true если число в диапазоне,
  overlaps принимает другой Range и возвращает true если диапазоны пересекаются,
  intersection принимает другой Range и возвращает новый Range являющийся пересечением (или null если не пересекаются),
  union принимает другой Range и возвращает новый Range охватывающий оба.
  toString возвращает "[min; max]".
 */