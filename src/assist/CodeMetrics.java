package assist;

import java.time.Duration;
import java.time.LocalTime;

import static assist.AdvancedText.*;

/**
 * Отслеживание технических данных по коду
 */
public class CodeMetrics {
    private static LocalTime lastMeasure;

    /**
     * Сеттер таймера, который отслеживает время работы программы
     */
    public static void setTimer () {
        lastMeasure = LocalTime.now();;
    }

    /**
     * Вывод информации о таймере, который отслеживает время работы программы
     */
    public static void printTimer () {
        printEmptyLine();
        println("**Время выполнения:** ***[b]" + Duration.between(lastMeasure, LocalTime.now()).toMillis() + "[b]*** *мс*");
    }

    /**
     * Отформатированный вывод ошибки IllegalArgumentException в консоль
     *
     * @param error Пойманная ошибка неправильного аргумента
     */
    public static void printError(IllegalArgumentException error) {
        println("[[r]ERROR[r]] " + LocalTime.now().withNano(0) + ": " + error.getMessage());
    }

    /**
     * Отформатированный вывод ошибки UnsupportedOperationException в консоль
     *
     * @param error Пойманная ошибка недопустимой операции
     */
    public static void printError(UnsupportedOperationException error) {
        println("[[r]ERROR[r]] " + LocalTime.now().withNano(0) + ": " + error.getMessage());
    }
}
