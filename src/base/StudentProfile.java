package base;

/**
 * Информационный класс, симулирующий карточку успеваемости студента
 *
 * @author Артур Федьвереш
 */
public class StudentProfile {

    private char firstNameChar;
    private short studentTicket;
    private byte grade;
    private int birthdayYear;
    private long studentMobile;
    private float gradeMedium;
    private double gradeResult;
    private boolean isEduPaid;

    /**
     * Метод ввода данных в карточку студента
     *
     * @param firstNameChar Первая буква имени студента
     * @param studentTicket Номер студенческого билета
     * @param grade         Оценка
     * @param birthdayYear  Год рождения данного студента
     * @param studentMobile Номер телефона студента
     * @param gradeMedium   Средняя оценка за семестр
     * @param gradeResult   Итоговая оценка
     * @param isEduPaid     Статус оплаты за семестр
     * @author Артур Федьвереш
     */
    public void setStudentInfo(char firstNameChar, short studentTicket, byte grade, int birthdayYear, long studentMobile, float gradeMedium, double gradeResult, boolean isEduPaid) {

        this.firstNameChar = firstNameChar;
        this.studentTicket = studentTicket;
        this.grade = grade;
        this.birthdayYear = birthdayYear;
        this.studentMobile = studentMobile;
        this.gradeMedium = gradeMedium;
        this.gradeResult = gradeResult;
        this.isEduPaid = isEduPaid;

    }

    /**
     * Метод вывода всех данных из карточки/класса в консоль
     */
    public String toString() {

        StringBuilder answer = new StringBuilder("Профиль Студента:\n");
        answer.append("Инициал: ").append(firstNameChar).append(" | ");
        answer.append("Год рождения: ").append(birthdayYear).append(" | ");
        answer.append("Контактный телефон: ").append(studentMobile).append(" | ");
        answer.append("Статус оплаты за обучение: ").append(isEduPaid).append("\n");
        answer.append("№ билета: ").append(studentTicket).append(" | ");
        answer.append("Оценка: ").append(grade).append(" | ");
        answer.append("Средняя оценка: ").append(gradeMedium).append(" | ");
        answer.append("Итоговая оценка за семестр: ").append(gradeResult).append(" | ");

        return answer.toString();

    }
}
