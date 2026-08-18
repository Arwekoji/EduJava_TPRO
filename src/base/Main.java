package base;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Точка входа
 *
 * @author Артур Федьвереш
 */
public class Main {
    static final byte[] TESTING_GRADES = {95, 80, 65, 45, 100, 0, -5, 101}; // Пулл тестовых запросов для проверки класса GradeConverter в задаче #1
    static final String[] SMART_CALC_EXAMPLES = {"10", "6", "0"}; // Пулл тестовых членов арифметических выражений для SmartCalc
    static final int GUESS_GAME_TRY = 107;

    /**
     * Точка входа
     *
     */
    public static void main(String[] args) {
        //Задача №1
        for (byte grade : TESTING_GRADES)
            System.out.println(grade + " = " + GradeConverter.convert2TextByIf(grade) + " | " + GradeConverter.convert2TextBySwitch(grade));

        System.out.println("- - - - - -");

        //Задача №2
        TimeOfDay.analyse(LocalDateTime.now()); // Час, день недели

        System.out.println("- - - - - -");

        //Задача №3

        for (String aString : SMART_CALC_EXAMPLES) // Подставляются результаты из пулла примеров для быстрой проверки всех типов операций
            for (String bString : SMART_CALC_EXAMPLES) {
                BigDecimal a = new BigDecimal(aString);
                BigDecimal b = new BigDecimal(bString);
                for (char i : SmartCalc.OPERATORS) {
                    System.out.printf("   %s %s %s = %s   |", a, i, b, SmartCalc.calculate(a, i, b));
                }
                System.out.println();
            }

        System.out.println("- - - - - -");

        GuessGame.guess(GUESS_GAME_TRY);

    }
}

/* Задание 2.4 — Условная логика

Задача 1. Конвертер оценок.
Создайте класс GradeConverter. Реализуйте конвертер числовой оценки в текстовую двумя способами: способ 1 — через if / else if, способ 2 — через switch-expression с делением score / 10.

Шкала: 90–100 = Отлично, 70–89 = Хорошо, 50–69 = Удовлетворительно, 0–49 = Неудовлетворительно, любое другое значение = Недопустимая оценка.

Проверьте значения: 95, 80, 65, 45, 100, 0, -5, 101. Оба способа должны давать одинаковый результат.

Задача 2. Определение времени суток.
Создайте класс TimeOfDay. По номеру часа от 0 до 23 определите время суток: 5–11 = Утро, 12–17 = День, 18–22 = Вечер, 23 и 0–4 = Ночь. Дополнительно определите является ли сейчас рабочим временем: рабочим считается время с 9 до 18 в будние дни, где 1 = понедельник и 7 = воскресенье.

Задача 3. Калькулятор с операциями.
Создайте класс SmartCalc. Объявите два числа и символ операции ('+', '-', '*', '/', '%') как переменные. Реализуйте выбор операции через switch-expression и выведите результат. Обработайте деление на 0 и неизвестную операцию. Проверьте несколько комбинаций меняя значения переменных.

Пример вывода:
15 + 4 = 19
15 / 4 = 3 (целочисленное)
15.0 / 4 = 3.75
15 % 4 = 3
15 / 0 = Ошибка: деление на ноль

Задача 4. Угадай число.
Создайте класс GuessGame. Задайте загаданное число secret = 42. Объявите переменную guess с любым значением. Используя if/else выведите: Меньше, Больше или Угадал! Это 42. Цикл не нужен — одна проверка.

 */

/* ОЖИДАЕМЫЙ РЕЗУЛЬТАТ

- оба способа конвертера дают одинаковые результаты
- граничные значения проверены: 0, 100, -1, 101
- деление на ноль обработано
- код читаемый, без дублирования логики

 */