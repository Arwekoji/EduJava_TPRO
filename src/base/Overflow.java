package base;

/**
 * Класс для демонстрации последствий переполнения переменной типа Int
 *
 * @author Артур Федьвереш
 */
public class Overflow {
    int intMaxValue = Integer.MAX_VALUE;

    /**
     * Метод, демонстрирующий на примерах в консоли последствия переполнения (aka выхода за границы) переменной типа int
     *
     * @author Артур Федьвереш
     */
    public void integerDemonstrations() {
        System.out.println("Переполнение типов:");
        System.out.println("Результат переполнения int на +1 = " + (intMaxValue + 1)); //Вывод результата переполнения в консоль
        long centurySecs = 60 * 60 * 24 * 365 * 100L;
        System.out.println("100 лет в секундах как int (Wrong): " + (int) centurySecs);
        System.out.println("100 лет в секундах как long int: " + centurySecs);
    }
}
