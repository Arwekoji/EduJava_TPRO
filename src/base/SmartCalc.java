package base;

import java.math.BigDecimal;

/**
 *
 * Класс - сверхточный калькулятор, вычисляющий с точностью до 5-6 знаков после запятой (Легко расширяется переменной Scale)
 *
 * @author Артур Федьвереш
 */
public class SmartCalc {
    static final char[] OPERATORS = {'+', '-', '*', '/', ':', '%'}; // Список возможных операций SmartCalc

    /**
     * Функция для получения результата арифметического действия в виде строки
     *
     * @param a        - Первый участник выражения в формате BigDecimal
     * @param operator - Примитивный арифметический оператор в формате char
     * @param b        - Второй участник выражения в формате BigDecimal
     * @return Возвращает результат в виде строки
     * @author Артур Федьвереш
     */
    public static String calculate(BigDecimal a, char operator, BigDecimal b) {
        if (b.equals(new BigDecimal("0")) && (operator == '/' || operator == ':' || operator == '%'))
            return "Нельзя делить на ноль!";

        BigDecimal result = switch (operator) { // BigDecimal выбран по причине наибольшей точности и доступных диапазонов, которые необходимы в калькуляторе
            case '+' -> a.add(b);
            case '-' -> a.subtract(b);
            case '*' -> a.multiply(b);
            case '/' -> a.divide(b, 6, BigDecimal.ROUND_UP);
            case ':' -> a.divide(b, 0, BigDecimal.ROUND_DOWN); // Целочисленное деление
            case '%' -> a.remainder(b);
            default -> throw new IllegalArgumentException("Неверно введён оператор");
        };

        return result.stripTrailingZeros().toPlainString(); // Использован метод stripTrailingZeros для избавления от лишних нулей
    }
}
