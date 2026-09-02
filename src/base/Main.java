package base;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Точка входа в программу по заданию 4.1 темы
 *
 * @author
 */
public class Main {
    public static final String[] FIRST_NAME_EXAMPLES = {"Игорь", "Сергей", "Олег", "Артём", "Иван"};
    public static final String[] LAST_NAME_EXAMPLES = {"Петров", "Иванов", "Патрушев", "Овечкин", "Апполонов"};

    /**
     * Точка входа
     *
     * @param args Аргументы точки входа
     */
    public static void main(String[] args) {
        // Задача #1
        for (short i = 0; i < Student.STUDENTS_QUANTITY; i++) {
            Student student = new Student();
            student.printInfo();
        }

        printLine();

        // Задача #2
        BankAccount.testClass();

        printLine();

        // Задача #3

        Rectangle.testClass();

        printLine();

        // Задача #4
        Temperature.testClass();
    }

    /**
     * Метод для помощи в оформлении блоков заданий в выводе
     */
    public static void printLine() {
        System.out.println();
        System.out.println(" - - - - - - - - - - - - - - - ");
        System.out.println();
    }
}

/* Задание 4.1 — Классы и объекты

Задача 1. Класс Student.
Создайте класс Student с полями: имя (String), возраст (int), средний балл (double), группа (String). Создайте метод printInfo выводящий всю информацию о студенте.
Создайте метод isExcellent возвращающий boolean — является ли студент отличником (балл >= 4.5). Создайте метод canGraduate принимающий int minimumAge и возвращающий true
если возраст не меньше минимального. В методе main создайте не менее трёх объектов Student с разными данными и вызовите все методы.

Задача 2. Класс BankAccount.
Создайте класс BankAccount с полями: номер счёта (String), владелец (String), баланс (double). Реализуйте методы: deposit принимает сумму и увеличивает баланс,
withdraw принимает сумму и уменьшает баланс (если средств достаточно, иначе выводит сообщение об ошибке), getBalance возвращает текущий баланс,
printStatement выводит информацию о счёте. Статическое поле totalAccounts считает сколько счетов было создано. Создайте несколько счетов и проверьте все операции.

Задача 3. Класс Rectangle.
Создайте класс Rectangle с полями width и height типа double. Реализуйте методы: area возвращает площадь, perimeter возвращает периметр, isSquare возвращает true
если ширина равна высоте, scale принимает double factor и изменяет оба размера умножением на factor, printInfo выводит все характеристики прямоугольника.
Создайте несколько прямоугольников и проверьте все методы включая масштабирование.

Задача 4. Класс Temperature.
Создайте класс Temperature с единственным полем value типа double хранящим температуру в градусах Цельсия. Реализуйте статические методы-фабрики:
fromCelsius принимает double и возвращает объект Temperature, fromFahrenheit принимает double, переводит в Цельсий и возвращает объект,
fromKelvin принимает double, переводит в Цельсий и возвращает объект.
Реализуйте методы экземпляра: toCelsius, toFahrenheit, toKelvin — каждый возвращает значение в нужных единицах. Метод printAll выводит температуру во всех трёх шкалах.
 */

/* КРИТЕРИИ ОЦЕНКИ
Критерии оценки:
- у каждого класса есть осмысленные поля и методы
- статическое поле totalAccounts в BankAccount корректно считает объекты
- withdraw не позволяет уйти в минус и выводит понятное сообщение
- статические методы-фабрики в Temperature работают корректно
 */