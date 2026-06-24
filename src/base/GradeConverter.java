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
     * @author Артур Федьвереш
     * @param grade Оценка от 0 до 100
     * @return Возвращает текстовое описание данной оценки
     */
    public String convert2TextByIf(byte grade) {

        if (grade >=90 && grade <= 100)
            return "Отлично";
        else if (grade >=70 && grade <= 89)
            return "Хорошо";
        else if (grade >=50 && grade <= 69)
            return "Удовлетворительно";
        else if (grade >=0 && grade <= 49)
            return "Неудовлетворительно";
        else
            return "Недопустимая оценка";

    }

    /**
     * Метод, использующий конструкцию swich-expression для вывода результата
     *
     * @author Артур Федьвереш
     * @param grade Оценка от 0 до 100
     * @return Возвращает текстовое описание данной оценки
     */
    public String convert2TextBySwitch(byte grade) {

        String convertedGrade = switch (grade/10) {
            case 10, 9         -> "Отлично";
            case 8, 7          -> "Хорошо";
            case 6, 5          -> "Удовлетворительно";
            case 4, 3, 2, 1, 0 -> "Неудовлетворительно";
            default            -> throw new IllegalArgumentException("Недопустимая оценка");
        };

        if (grade > 100 || grade < 0)
            convertedGrade = "Недопустимая оценка";

        return convertedGrade;

    }

}
