package base;

/**
 * Информационный класс, симулирующий карточку успеваемости студента
 *
 * @author Артур Федьвереш
 */
public class StudentProfile {

    byte grade = 73;
    short studentTicket = 1013;
    int birthdayYear = 1996;
    long studentMobile = 89990001122L;
    float gradeMedium = 50.71f;
    double gradeResult = 50.72;
    boolean isEduPaid = true;
    char firstNameChar = 'A';


    /**
     * Метод вывода всех данных из карточки/класса в консоль
     *
     * @author Артур Федьвереш
     */
    public void returnStudentInfo() {
        StringBuilder answer = new StringBuilder("Профиль Студента:\n");
        answer.append("Инициал: ").append(firstNameChar).append(" | ");
        answer.append("Год рождения: ").append(birthdayYear).append(" | ");
        answer.append("Контактный телефон: ").append(studentMobile).append(" | ");
        answer.append("Статус оплаты за обучение: ").append(isEduPaid).append("\n");
        answer.append("№ билета: ").append(studentTicket).append(" | ");
        answer.append("Оценка: ").append(grade).append(" | ");
        answer.append("Средняя оценка: ").append(gradeMedium).append(" | ");
        answer.append("Итоговая оценка за семестр: ").append(gradeResult).append(" | ");

        System.out.println(answer);
    }
}
