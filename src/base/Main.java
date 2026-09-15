package base;

import assist.AdvancedText;

/**
 * Точка входа в программу по теме 4.5
 *
 * @author Arthur Fegyveres
 */
public class Main {

    /**
     * Точка входа в программу по теме 4.5
     *
     * @param args Аргументы точки входа
     */
    public static void main(String[] args) {
        AdvancedText.printTaskSeparator(1, "User");
        User.testClass();

        AdvancedText.printTaskSeparator(2, "AppConstants");
        AppConstants.testClass();

        AdvancedText.printTaskSeparator(3, "enum Day");
        Day.testClass();
    }
}

/*Задание 4.5 — static, final, enum

### Задача 1 — Счётчик экземпляров

Класс `User`: поля name, id.
 - Статическое `nextId` — автоинкремент.
 - Статический `getTotalCreated()`.
 - Переопределить `toString()`.

### Задача 2 — Константы

 - Класс `AppConstants` с `static final` полями:
 - APP_NAME,
 - VERSION,
 - MAX_USERS,
 - PI.
 - Попробовать изменить — описать ошибку в комментарии.

### Задача 3 — Enum Day

 - Перечисление `Day` (7 дней)
 - с полем `rusName`,
 - конструктором,
 - методами `isWeekend()`,
 - `isWorkday()`.
 - Вывести все дни с русскими названиями и типом (рабочий/выходной).
 */

/*
- static nextId как автоинкремент, getTotalCreated статический
- toString с @Override
- Константы UPPER_SNAKE_CASE, final объяснён в комментарии
- Enum с конструктором, полем, геттером, логикой isWeekend
 */