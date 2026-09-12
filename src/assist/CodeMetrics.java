package assist;

import java.time.Duration;
import java.time.LocalTime;

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
        System.out.println("Время выполнения: " + Duration.between(lastMeasure, LocalTime.now()).toMillis() + " мс");
    }

    /**
     * Отформатированный вывод ошибки в консоль
     *
     * @param error Пойманная ошибка
     */
    public static void printError(IllegalArgumentException error) {
        AdvancedText.println("[[r]ERROR[r]] " + LocalTime.now().withNano(0) + ": " + error.getMessage());
    }
}
