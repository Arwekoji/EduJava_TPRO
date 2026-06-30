package base;

/**
 * Класс, частично заменяющий Math для демонстрации алгоритмов базовых математических функций
 *
 * @author Артур Федьвереш
 */
public class MathUtils {

    /**
     * Метод, определяющий наименьшее из двух чисел
     *
     * @param a Первое число типа INT для сравнения
     * @param b Второе число типа INT для сравнения
     * @return Возвращает меньшее число
     * @author Артур Федьвереш
     */
    public static int min(int a, int b) {
        // return Math.min(a, b); // Для демонстрации, что можно проще и быстрее
        return (a < b) ? a : b;
    }

    /**
     * Метод, определяющий наибольшее из двух чисел
     *
     * @param a Первое число типа INT для сравнения
     * @param b Второе число типа INT для сравнения
     * @return Возвращает наибольшее число
     * @author Артур Федьвереш
     */
    public static int max(int a, int b) {
        // return Math.max(a, b); // Для демонстрации, что можно проще и быстрее
        return (a > b) ? a : b;
    }

    /**
     * Метод, корректирующий число, если оно выходит за указанный диапазон
     *
     * @param value Число для сравнения с диапазоном
     * @param low   Нижняя граница диапазона
     * @param high  Верхняя граница диапазона
     * @return Скорректированное число
     * @author Артур Федьвереш
     */
    public static int clamp(int value, int low, int high) {
        // return Math.clamp(value, low, high); //Для демонстрации, что можно проще и быстрее

        return Math.max(Math.min(value, high), low); // Использование нахождения максимума и минимума через методы Math
    }

    /**
     * Метод, определяющий является ли указанный год високосным по григорианскому календарю
     *
     * @param year Данный год
     * @return False/True на вопрос является ли год високосным
     * @author Артур Федьвереш
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0; // По григорианскому календарю на 400 лет всего 97 високосных лет
    }

    /**
     * Конвертер температур из Цельсия в фаренгейты
     *
     * @param c Температура по шкале Цельсия
     * @return Температура по шкале Фаренгейта
     * @author Артур Федьвереш
     */
    public static double celsiusToFahrenheit(double c) {
        return 32 + c * 9 / 5;
    }

    /**
     * Конвертер температур из фаренгейта в цельсии
     *
     * @param f Температура по шкале Фаренгейта
     * @return Температура по шкале Цельсия
     * @author Артур Федьвереш
     */
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    /**
     * Возвращает факториал указанного число
     *
     * @param n Число для вычисления его факториала. Аналог записи n!
     * @return Факториал числа n
     * @author Артур Федьвереш
     */
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n не может быть меньше 0!");
        if (n < 2) return 1; // Зачем выполнять лишние операции?

        int factorial = 1;
        for (int i = 2; i <= n; i++)
            factorial *= i;

        return factorial;
    }

    /**
     * Метод, возводящий целое число в степень
     *
     * @param base Основание
     * @param exp  Степень
     * @return Основание, возведенное в степень
     * @author Артур Федьвереш
     */
    public static long power(int base, int exp) {
        int answer = base;
        if (base == 0) return 1; // 0 в любой степени равен 1

        for (int i = 2; i <= exp; i++)
            answer *= base;

        return answer;
    }
}
