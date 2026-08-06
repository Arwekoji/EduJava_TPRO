package base;

/**
 * Класс для демонстрации последствий переполнения переменной типа Int
 *
 * @author Артур Федьвереш
 */
public class Overflow {
    static final long SECONDS_IN_HOUR = 3600L;
    static final short HOURS_IN_DAY = 24;
    static final short DAYS_IN_YEAR = 365;
    static final short YEARS_IN_CENTURY = 100;
    static final short LEAP_DAYS_IN_CENTURY = 25;

    /**
     * Метод, демонстрирующий на примерах в консоли последствия переполнения (aka выхода за границы) переменной типа int
     *
     * @author Артур Федьвереш
     */
    public void integerDemonstrations() {
        System.out.println("Переполнение типов:");
        System.out.println("Максимальное значение типа int = " + Integer.MAX_VALUE);
        System.out.println("Результат переполнения int на +1 = " + (Integer.MAX_VALUE + 1)); //Вывод результата переполнения в консоль
        long centurySecs = SECONDS_IN_HOUR * HOURS_IN_DAY * (DAYS_IN_YEAR * YEARS_IN_CENTURY + LEAP_DAYS_IN_CENTURY);
        System.out.println("100 лет в секундах как int (Wrong): " + (int) centurySecs);
        System.out.println("100 лет в секундах как long int: " + centurySecs);
        /*
            Результат отличается по причине того, что 100 лет в секундах - слишком большое число для типа int.
            При попытке записать его таким образом произойдет переполнение, из-за которого произойдёт искажение числа.
            Искаженный результат получается вследствие битовых операций.
            Чтобы не было переполнения используется тип long, у которого диапазон допустимых значений достаточно большой,
            чтобы 100 лет в секундах не вызывали переполнение.
         */
    }
}
