package assist;

import base.Course;
import base.Range;

/**
 * Централизованная запись с тестовыми данными для разных задач
 */
public record TestData() {
    public static final String[] FIRST_NAME_EXAMPLES = {"Игорь", "Сергей", "Олег", "Артём", "Иван"};
    public static final String[] LAST_NAME_EXAMPLES = {"Петров", "Иванов", "Патрушев", "Овечкин", "Апполонов"};
    public static final short BANK_ACCOUNTS_QUANTITY = 3;

    public static final double[] TEMPERATURE_RANGE = {-273.15, 2000};
    public static final double[] TEMPERATURE_EXAMPLES = {296.15, -300, 36.6, 0};

    public static final Range RANGE_ORIGIN_EXAMPLE = new Range(0, 10);
    public static final Range[] RANGE_EXAMPLES = {new Range(-5, 1), new Range(3, 5), new Range(8, 14), new Range(20, 30)};

    public static final Course[] COURSES = {
            new Course(1, "Курсы Блендера (Blender 3D)", "Польщикова Ксения", 20, 37500),
            new Course(1, "Курсы Блендера (Blender 3D)", "Польщикова Ксения", 20, 37500),
            new Course(2, "Курс «DevOps для эксплуатации и разработки»", "Г. Т. Алимов", 315, 114660),
            new Course(3, "Гейм-дизайнер", "Сергей Праздничнов", 560, 155350)
    };
}