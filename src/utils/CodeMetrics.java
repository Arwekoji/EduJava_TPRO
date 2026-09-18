package utils;

import java.time.Duration;
import java.time.LocalTime;

import static utils.ConsoleFormat.printEmptyLine;
import static utils.ConsoleFormat.println;

/**
 * Кастомный регистратор технической информации разного вида
 */
public class CodeMetrics {
    private static LocalTime lastMeasure;

    /**
     * Устанавливает точку отсчета для таймера
     */
    public static void setTimer() {
        lastMeasure = LocalTime.now();
        ;
    }

    /**
     * Выводит значение таймера в консоль для отслеживания времени работы участка программы
     */
    public static void printTimer() {
        printEmptyLine();
        println("**Время выполнения:** ***[b]" + Duration.between(lastMeasure, LocalTime.now()).toMillis() + "[b]*** *мс*");
    }

    /**
     * Выводит в консоль сообщение об ошибке/записи заданного типа в консоль с автоопределением времени
     *
     * @param error   Ошибка неопределенного типа или её описание
     * @param logType Вид предупреждения
     */
    public static void printError(Object error, String logType) {
        if (error == null) {
            printMessage("Неверно указан аргумент ошибки");
            return;
        }

        switch (error.getClass().getSimpleName()) {
            case "String" -> printMessage((String) error, logType);
            default -> { // instance - проверить тип обьекта error. Если он принадлежит к Throwable, то создать переменную throwable. При ее наличии будет true
                if (error instanceof Throwable throwable)
                    printMessage(throwable.getMessage(), logType, getShortCode(throwable));
                else
                    printMessage("Неизвестная ошибка", logType);
            }
        }
    }

    /**
     * Выводит в консоль сообщение о записи вида "ERROR" в консоль
     *
     * @param error Ошибка или сообщение об ошибке
     */
    public static void printError(Object error) {
        printError(error, "<r>ERROR<r>");
    }

    /**
     * Выводит в консоль сообщение о записи вида "WARN" в консоль
     *
     * @param message Предупреждающее сообщение
     */
    public static void printWarn(String message) {
        printError(message, "<y>WARN<");
    }

    /**
     * Выводит в консоль сообщение о записи вида "LOG" в консоль
     *
     * @param message Запись для лога
     */
    public static void printLog(String message) {
        printError(message, "<c>LOG<c>");
    }

    /**
     * Выводит отформатированное сообщение об ошибке/записи в консоль
     *
     * @param message   Сообщение в логе
     * @param logType   Тип лога
     * @param errorType Кодировка ошибки
     */
    private static void printMessage(String message, String logType, String errorType) {
        println(String.format("[%s] <D>%s<D>%s: %s",
                logType,
                (errorType == null || errorType.isBlank()) ? "" : " (%s)".formatted(errorType),
                LocalTime.now().withNano(0),
                message
        ));
    }

    /**
     * Выводит отформатированное сообщение об ошибке/записи в консоль без кодировки ошибки
     *
     * @param message Сообщение лога
     * @param logType Тип лога
     */
    private static void printMessage(String message, String logType) {
        printMessage(message, logType, "");
    }

    /**
     * Выводит отформатированное сообщение об ошибке в консоль без указания её типа и кодировки
     *
     * @param message Сообщение лога
     */
    private static void printMessage(String message) {
        printMessage(message, "ERROR");
    }

    /**
     * Формирует из названия ошибки аббревиатуру
     *
     * @param error Ошибка для анализа
     * @return Аббревиатура / Закодированное название ошибки
     */
    private static String getShortCode(Throwable error) {
        StringBuilder shortName = new StringBuilder();

        for (char symbol : error.getClass().getSimpleName().toCharArray())
            if (Character.isUpperCase(symbol))
                shortName.append(symbol);

        return shortName.toString();
    }
}
