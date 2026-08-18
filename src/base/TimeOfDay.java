package base;

import java.time.LocalDateTime;
import java.time.temporal.TemporalField;

/**
 * Класс для конвертации времени дня и дня недели в простое текстовое описание
 *
 * @author Артур Федьвереш
 */
public class TimeOfDay {

    /**
     * Класс для конвертации времени дня и дня недели в простое текстовое описание
     *
     * @param dateTime  Информация о реальных дате и времени в формате LocalDateTime
     * @author Артур Федьвереш
     */
    public static void analyse(LocalDateTime dateTime)  {//byte hour, byte day) {
        String answer = "Сейчас ";
        byte hour = (byte)dateTime.getHour();
        byte day = (byte) dateTime.getDayOfWeek().getValue();

        if (hour == 23 || (hour >= 0 && hour <= 4))
            answer += "ночь";
        else if (hour >= 5 && hour <= 11)
            answer += "утро";
        else if (hour >= 12 && hour <= 17)
            answer += "день";
        else if (hour >= 18 && hour <= 22)
            answer += "вечер";
        else
            answer += "время неизвестно";

        if (day >= 1 && day <= 5 && hour >= 9 && hour <= 18)
            answer += ", будний день, рабочий час";
        else if (day >= 1 && day <= 5)
            answer += ", будний день, пора для отдыха";
        else
            answer += ", выходной, пора для отдыха";

        System.out.println(hour + ":00 - " + answer);
    }
}
