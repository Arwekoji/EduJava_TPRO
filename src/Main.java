//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}

/* Задание 4.3 — Инкапсуляция

Задача 1. Класс BankAccount с инкапсуляцией.
Переработайте класс BankAccount из задания 4.1 применив принципы инкапсуляции. Все поля сделайте private. Добавьте геттеры для всех полей.
Реализуйте сеттеры только там где это имеет смысл: имя владельца можно изменить, номер счёта — нельзя.
Добавьте валидацию в методы deposit (сумма должна быть положительной) и withdraw (сумма положительная и не превышает баланс).
Для истории транзакций добавьте private массив String[] transactionHistory на 100 записей и метод getTransactionHistory возвращающий копию заполненной части массива.
При каждом пополнении и снятии добавляйте запись в историю.

Задача 2. Класс Temperature с инкапсуляцией.
Создайте класс Temperature где единственное private поле celsius хранит температуру. Добавьте геттеры getCelsius, getFahrenheit,
getKelvin которые вычисляют значения на лету. Добавьте сеттеры setCelsius, setFahrenheit, setKelvin — каждый пересчитывает и сохраняет значение в celsius.
Добавьте валидацию: температура не может быть ниже абсолютного нуля (-273.15 по Цельсию). Реализуйте метод toString возвращающий строку вида "23.00°C / 73.40°F / 296.15K".

Задача 3. Неизменяемый класс Range.
Создайте неизменяемый класс Range представляющий числовой диапазон. Поля private final: min (double) и max (double).
В конструкторе проверьте что min <= max, иначе бросайте IllegalArgumentException. Реализуйте методы: getMin, getMax, getLength возвращает разницу max - min,
contains принимает double и возвращает true если число в диапазоне, overlaps принимает другой Range и возвращает true если диапазоны пересекаются,
intersection принимает другой Range и возвращает новый Range являющийся пересечением (или null если не пересекаются),
union принимает другой Range и возвращает новый Range охватывающий оба. toString возвращает "[min; max]".

Задача 4. Record для учебного курса.
Создайте record Course с полями: id (int), title (String), instructor (String), durationHours (int), price (double). Добавьте компактный конструктор с валидацией:
title не пустой, durationHours больше 0, price не отрицательная. Добавьте методы: isPremium возвращает true если price > 5000,
shortDescription возвращает строку вида "Java для начинающих (40ч) — Иван Иванов". Создайте несколько курсов и выведите информацию о каждом.
Проверьте что equals и toString работают автоматически.
 */

/*Критерии оценки:

- все поля в задачах 1-3 объявлены private
- валидация в сеттерах бросает IllegalArgumentException с понятным сообщением
- класс Range полностью неизменяемый: нет ни одного метода изменяющего поля
- record в задаче 4 использует компактный конструктор для валидации
 */