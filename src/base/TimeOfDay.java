package base;

/**
 * Класс для конвертации времени дня и дня недели в простое текстовое описание
 *
 * @author Артур Федьвереш
 */
public class TimeOfDay {

    /**
     * Класс для конвертации времени дня и дня недели в простое текстовое описание
     *
     * @param day  День недели от 1 до 7
     * @param hour Время суток в виде часа от 0 до 23
     * @author Артур Федьвереш
     */
    public void analyseTime(byte hour, byte day) {
        String answer = "Сейчас ";

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
            answer += ", рабочий час";
        else
            answer += ", выходной, пора для отдыха";

        System.out.println(hour + ":00 - " + answer);
    }
}
