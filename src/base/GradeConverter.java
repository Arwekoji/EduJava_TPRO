package base;

/**
 * Класс для конвертации оценки в текстовое описание разными методами
 *
 * @author Артур Федьвереш
 */
public class GradeConverter {

    /**
     * Метод, использующий конструкцию IF ELSE для вывода результата
     *
     * @param grade Оценка от 0 до 100
     * @return Возвращает текстовое описание данной оценки
     * @author Артур Федьвереш
     */
    public static String convert2TextByIf(byte grade) {
        String answer;

        if (grade >= 90 && grade <= 100)
            answer = "Отлично";
        else if (grade >= 70 && grade <= 89)
            answer = "Хорошо";
        else if (grade >= 50 && grade <= 69)
            answer = "Удовлетворительно";
        else if (grade >= 0 && grade <= 49)
            answer = "Неудовлетворительно";
        else
            answer = "Недопустимая оценка";

        return answer + " (If)";
    }

    /**
     * Метод, использующий конструкцию swich-expression для вывода результата
     *
     * @param grade Оценка от 0 до 100
     * @return Возвращает текстовое описание данной оценки
     * @author Артур Федьвереш
     */
    public static String convert2TextBySwitch(byte grade) {
        if (grade > 100 || grade < 0)
            return "Недопустимая оценка";

        String convertedGrade = switch (grade / 10) {
            case 10, 9 -> "Отлично";
            case 8, 7 -> "Хорошо";
            case 6, 5 -> "Удовлетворительно";
            case 4, 3, 2, 1, 0 -> "Неудовлетворительно";
            default -> throw new IllegalArgumentException("ERROR: Недопустимая оценка");
        };

        return convertedGrade + " (Switch)";
    }
}
