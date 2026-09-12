package base;

import assist.AdvancedText;

/**
 * Запись об обучающем курсе
 *
 * @param id Идентификатор курса
 * @param title Название курса
 * @param instructor Имя куратора курса
 * @param durationHours Длительность обучения
 * @param price Цена обучения
 */
public record Course(int id, String title, String instructor, int durationHours, double price) {

    /**
     * Компактный конструктор с валидацией
     */
    public Course {
        if(title.isEmpty() || durationHours <= 0 || price < 0)
            throw new IllegalArgumentException("Параметры курса не соответствуют базовым требованиям!");
    }

    /**
     * Функция оценки дороговизны курса
     *
     * @return Факт дороговизны курса
     */
    public boolean isPremium () {
        return price > 5000;
    }

    /**
     * Вывод строки с коротким описанием курса
     *
     * @return Строка с коротким описанием курса без ID и цены
     */
    public String shortDescription () {
        return AdvancedText.renderMarkdown(String.format("%s (%dч) — %s", title, durationHours, instructor));
    }

    /**
     * Вывод полной информации о курсе
     */
    public void printInfo () { // На случай если я неправильно понял ТЗ и требовалось переназначить toString. Также данный метод более полно отображает информацию
        System.out.println(String.format("%d. %s [%.2f рублей.%s]",
                id,
                shortDescription(),
                price,
                isPremium() ? " Платный курс" : ""
                )
        );
    }
}

/*
Задача 4. Record для учебного курса.
 - Создайте record Course с полями: id (int), title (String), instructor (String), durationHours (int), price (double).
 - Добавьте компактный конструктор с валидацией:
    title не пустой,
    durationHours больше 0,
    price не отрицательная.
 - Добавьте методы:
    isPremium возвращает true если price > 5000,
    shortDescription возвращает строку вида "Java для начинающих (40ч) — Иван Иванов".
 - Создайте несколько курсов и выведите информацию о каждом.
 - Проверьте что equals и toString работают автоматически.
 */