package base;

/**
 * Класс для демонстрации последствий переполнения переменной типа Int
 *
 * @author Артур Федьвереш
 */
public class Overflow {
    final short SECONDS_IN_HOUR = 3600;
    final short HOURS_IN_DAY = 24;
    final short DAYS_IN_YEAR = 365;
    final long YEARS_IN_CENTURY = 100L;
    final long LEAP_DAYS_IN_CENTURY = 25L;

    int intMaxValue = Integer.MAX_VALUE;

    /**
     * Метод, демонстрирующий на примерах в консоли последствия переполнения (aka выхода за границы) переменной типа int
     *
     * @author Артур Федьвереш
     */
    public void integerDemonstrations() {
        System.out.println("Переполнение типов:");
        System.out.println("Результат переполнения int на +1 = " + (intMaxValue + 1)); //Вывод результата переполнения в консоль
        long centurySecs = SECONDS_IN_HOUR * HOURS_IN_DAY * (DAYS_IN_YEAR * YEARS_IN_CENTURY + LEAP_DAYS_IN_CENTURY);
        System.out.println("100 лет в секундах как int (Wrong): " + (int) centurySecs);
        System.out.println("100 лет в секундах как long int: " + centurySecs);
    }
}
