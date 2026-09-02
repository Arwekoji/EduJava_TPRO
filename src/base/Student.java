package base;

import java.util.concurrent.ThreadLocalRandom; // Быстрый и удобный генератор чисел

import static base.Main.FIRST_NAME_EXAMPLES;
import static base.Main.LAST_NAME_EXAMPLES;

/**
 * Класс для хранения и валидации данных о студентах
 */
public class Student {
    public static final int MINIMUM_AGE = 18;
    public static final String[] GROUP_NAME_EXAMPLES = {"А", "Б", "Дикие лебеди"};
    public static final short STUDENTS_QUANTITY = 3;

    String name, group;
    int age;
    double scoreAverage;

    /**
     * Конструктор
     *
     * @param name         Имя студента
     * @param age          Возраст студента
     * @param scoreAverage Средний балл успеваемости
     * @param group        Группа студента
     */
    public Student(String name, int age, double scoreAverage, String group) {
        this.name = name;
        this.group = group;
        this.age = age;
        this.scoreAverage = scoreAverage;
    }

    /**
     * Конструктор случайного студента
     */
    public Student() {
        this(
                FIRST_NAME_EXAMPLES[ThreadLocalRandom.current().nextInt(0, FIRST_NAME_EXAMPLES.length)] + " " +
                        LAST_NAME_EXAMPLES[ThreadLocalRandom.current().nextInt(0, LAST_NAME_EXAMPLES.length)],
                ThreadLocalRandom.current().nextInt(10, 60),
                ThreadLocalRandom.current().nextDouble(0, 10),
                GROUP_NAME_EXAMPLES[ThreadLocalRandom.current().nextInt(0, GROUP_NAME_EXAMPLES.length)]
        );
    }

    /**
     * Вывод информации о студенте в консоль
     */
    public void printInfo() {
        System.out.println(String.format("""
                        Профиль ученика:
                        Имя - %s (Группа "%s")
                        Возраст - %d (%s допускать к обучению)
                        Средний балл - %.1f (%s)
                        """, name, group, age,
                canGraduate(MINIMUM_AGE) ? "можно" : "нельзя",
                scoreAverage,
                isExcellent() ? "отличник" : "так себе"
        ));
    }

    /**
     * Возрастная проверка
     *
     * @param minimumAge Минимальный возраст в годах для допуска к обучению
     * @return Статус допуска
     */
    private boolean canGraduate(int minimumAge) {
        return age >= minimumAge;
    }

    /**
     * Проверка успеваемости
     *
     * @return Статус отличника
     */
    private boolean isExcellent() {
        return scoreAverage >= 4.5f;
    }

}
