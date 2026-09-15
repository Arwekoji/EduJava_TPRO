package base;

import assist.AdvancedArrays;
import assist.AdvancedText;
import assist.TestData;

/**
 * Класс для хранения информации о пользователе приложения и демонстрации автоинкремента ID пользователя
 */
public class User {
    private static int totalId = 0;

    private String name;
    private int id;

    {
        id = nextId();
    }

    /**
     * Базовый конструктор с указанием имени
     *
     * @param name Имя пользователя
     */
    public User (String name) {
        this.name = name;
    }

    /**
     * Конструктор пользователя со случайным именем без указания параметров
     */
    public User () {
        this(AdvancedArrays.pick(TestData.FIRST_NAME_EXAMPLES) + " " + AdvancedArrays.pick(TestData.LAST_NAME_EXAMPLES));
    }

    /**
     * Сеттер-автоинкремент ID пользователей
     *
     * @return Новый ID после увеличения числа пользователей
     */
    private static int nextId() {
        return ++totalId;
    }

    /**
     * Геттер общего числа экземпляров класса User
     *
     * @return Число экземпляров класса User
     */
    public static int getTotalCreated() {
        return totalId;
    }

    /**
     * Переопределение toString на отформатированную строку с указанием id и имени пользователя
     *
     * @return Отформатированная строка с указанием id и имени пользователя
     */
    @Override
    public String toString() {
        return AdvancedText.renderMarkdown(String.format("Экземпляр класса **User**: [b]id[b]=%d, [b]name[b]='%s'", id, name));
    }

    /**
     * Скрипт для демонстрации возможностей класса
     */
    public static void testClass () {
        for (int i = 0; i < TestData.TOTAL_USERS; i++)
            System.out.println(new User());

        AdvancedText.println("**Всего пользователей:** " + getTotalCreated());
    }
}

/*Задание 4.5 — static, final, enum

### Задача 1 — Счётчик экземпляров

Класс `User`: поля name, id.
 - Статическое `nextId` — автоинкремент.
 - Статический `getTotalCreated()`.
 - Переопределить `toString()`.

/*
- static nextId как автоинкремент, getTotalCreated статический
- toString с @Override
 */