package base;

import assist.AdvancedText;
import assist.CodeMetrics;

/**
 * Класс для хранения констант приложения и демонстрации результата взаимодействия с ними
 */
public class AppConstants {
    public static final String APP_NAME = System.getProperty("user.dir"); //"Task-4.5";
    public static final float VERSION = 1.0f;
    public static final short MAX_USERS = 1024;
    public static final double PI = Math.PI; //3.14159265359;

    /**
     * Скрипт для демонстрации возможностей класса
     */
    public static void testClass() {
        AdvancedText.print(String.format("""
                __Класс обладает следующими константами:__
                [b]APP_NAME[b]=%s *// Название приложения*
                [b]VERSION[b]=%.4f *// Номер версии*
                [b]MAX_USERS[b]=%d *// Максимальное число пользователей*
                [b]PI[b]=%.9f *// Математическая константа Пи*
                
                *Ниже будет произведена попытка их изменить:*
                """, APP_NAME, VERSION, MAX_USERS, PI));
        try {
            // PI = 0;
            throw new UnsupportedOperationException(
                    "Константу невозможно изменить! " +
                            "Соблюдается принцип неизменяемости (immutable), который обозначается ключевым словом final при создании переменной. " +
                            "При данном принципе переменной может быть присвоено значение ровно 1 раз после объявления"
            );
        } catch (UnsupportedOperationException error) {
            CodeMetrics.printError(error);
        }
    }
}

/* Задача 2 — Константы

 - Класс `AppConstants` с `static final` полями:
 - APP_NAME,
 - VERSION,
 - MAX_USERS,
 - PI.
 - Попробовать изменить — описать ошибку в комментарии.

 */

/*
- Константы UPPER_SNAKE_CASE, final объяснён в комментарии
 */