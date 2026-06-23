package base;

import java.math.BigDecimal;

/**
 * Класс для демонстрации вычислений высокой точности. То есть, применимых в финансовой сфере и реализованных с помощью типа BigDecimal
 *
 * @author Артур Федьвереш
 */
public class Finance {

    /**
     * Метод для сложения 3 чисел типа double и вывода результата того же типа
     *
     * @param a - Первое число в сумме
     * @param b - Второе число в сумме
     * @param c - Третье число в сумме
     * @author Артур Федьвереш
     */
    public void inaccurateSumABC(double a, double b, double c) {
        double sum = a + b + c;
        System.out.println("Неточное сложение double " + a + " + " + b + " + " + c + " = " + sum);
    }

    /**
     * Метод для сверхточного сложения 3 чисел типа BigDecimal и вывода результата того же типа
     *
     * @param a - Первое число в сумме
     * @param b - Второе число в сумме
     * @param c - Третье число в сумме
     * @author Артур Федьвереш
     */
    public void sumABC(BigDecimal a, BigDecimal b, BigDecimal c) {
        BigDecimal accurateSum = new BigDecimal("0").add(a).add(b).add(c);
        System.out.println("Точное сложение BigDecimal " + a + " + " + b + " + " + c + " = " + accurateSum);
    }

}
