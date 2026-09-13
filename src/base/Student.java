package base;

import assist.AdvancedArrays;
import assist.AdvancedText;
import assist.TestData;

import java.util.*;

/**
 * Класс, собирающий информацию о каком-либо ученике, демонстрируя при этом работу HashSet и переопределений equals, toString
 */
public class Student {
    String name, email;
    short age;

    /**
     * Базовый конструктор класса
     *
     * @param name  Имя ученика
     * @param age   Возраст ученика
     * @param email Электронная почта ученика
     */
    public Student(String name, short age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    /**
     * Конструктор со случайными параметрами
     */
    public Student() {
        this(AdvancedArrays.pick(TestData.FIRST_NAME_EXAMPLES) + " " + AdvancedArrays.pick(TestData.LAST_NAME_EXAMPLES),
                (short) new Random().nextInt(TestData.STUDENT_AGE_MIN, TestData.STUDENT_AGE_MAX),
                AdvancedArrays.pick(TestData.EMAIL_EXAMPLES));
    }

    /**
     * Скрипт для демонстрации работы HashSet и переопределений equals, toString, hashCode
     */
    public static void testClass() {
        HashSet<Student> group = new HashSet<>();
        Set<Object> identityGroup = Collections.newSetFromMap(new IdentityHashMap<>());

        AdvancedText.println(String.format("*Создали HashSet и IdentitySet.* [b]HashSet.size[b]=%d, [b]IdentitySet.size[b]=%d",
                group.size(), identityGroup.size()
        ));

        Student newStudentOriginal = new Student(TestData.STUDENT_DUPLICATE_NAME, TestData.STUDENT_DUPLICATE_AGE, TestData.STUDENT_DUPLICATE_EMAIL);
        AdvancedText.println("**Новый** " + newStudentOriginal);
        group.add(newStudentOriginal);
        identityGroup.add(newStudentOriginal);
        AdvancedText.println(String.format("*Добавили его в HashSet и в IdentitySet.* [b]HashSet.size[b]=%d, [b]IdentitySet.size[b]=%d",
                group.size(), identityGroup.size()
        ));

        Student newStudentDublicate = new Student(TestData.STUDENT_DUPLICATE_NAME, TestData.STUDENT_DUPLICATE_AGE, TestData.STUDENT_DUPLICATE_EMAIL);
        AdvancedText.println("**Новый** " + newStudentDublicate);
        group.add(newStudentDublicate);
        identityGroup.add(newStudentDublicate);
        AdvancedText.println(String.format("*Добавили его в HashSet и в IdentitySet.* [b]HashSet.size[b]=%d, [b]IdentitySet.size[b]=%d",
                group.size(), identityGroup.size()
        ));

        AdvancedText.println("__**Равны ли Student1 и Student2?**__ [b]equals[b]=" + newStudentOriginal.equals(newStudentDublicate));

        AdvancedText.printEmptyLine();

        AdvancedText.println("Добавляем второй дубликат первого студента и еще два рандомных студента. " +
                "Итого должно быть 5 экземпляров, но только 3 уникальных:");

        Student newStudentSecondDublicate = new Student(TestData.STUDENT_DUPLICATE_NAME, TestData.STUDENT_DUPLICATE_AGE, TestData.STUDENT_DUPLICATE_EMAIL);
        AdvancedText.println("**Новый** " + newStudentSecondDublicate);
        group.add(newStudentSecondDublicate);
        identityGroup.add(newStudentSecondDublicate);
        AdvancedText.println(String.format("*Добавили его в HashSet и в IdentitySet.* [b]HashSet.size[b]=%d, [b]IdentitySet.size[b]=%d",
                group.size(), identityGroup.size()
        ));

        for (int i = 0; i < TestData.STUDENT_RANDOM_EXAMPLES; i++) {
            Student newStudent = new Student();
            AdvancedText.println("**Новый** " + newStudent);
            group.add(newStudent);
            identityGroup.add(newStudent);
            AdvancedText.println(String.format("*Добавили его в HashSet и в IdentitySet.* [b]HashSet.size[b]=%d, [b]IdentitySet.size[b]=%d",
                    group.size(), identityGroup.size()
            ));
        }
    }

    /**
     * Переопределенный equals. Возраст учеников игнорируется при сравнении
     *
     * @param o the reference object with which to compare.
     * @return Факт эквивалентности данных учеников
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(email, student.email);
        //return age == student.age && Objects.equals(name, student.name) && Objects.equals(email, student.email);
    }

    /**
     * Переопределенный hashCode. Возраст ученика игнорируется при вычислении
     *
     * @return Хэш-код без учета возраста
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    /**
     * Переопределенный toString
     *
     * @return Вывод строку с отформатированным тегами markdown списком переменных обьекта
     */
    @Override
    public String toString() {
        return AdvancedText.renderMarkdown("**Студент:** " +
                "имя='" + name + '\'' +
                ", email='" + email + '\'' +
                ", возраст=" + age);
    }
}

/*Задание 4.4 — equals, hashCode, toString

### Задача 1
- Создайте класс `Student` (name, age, email).
- Переопределите equals (по name + email), hashCode и toString.
- Продемонстрируйте: два Student с одинаковыми данными → equals=true, HashSet.size()=1.

### Задача 2
- Создайте HashSet<Student>,
- добавьте 5 студентов (2 дубликата).
- Покажите что size=3.
- Уберите переопределение hashCode — покажите что size=5 (дубликаты не распознаются).

### Задача 3
- Сгенерируйте equals/hashCode через IntelliJ (Alt+Insert).
- Сравните с ручной реализацией.
 */

/* ОЖИДАЕМЫЙ РЕЗУЛЬТАТ
- equals сравнивает name+email, hashCode использует Objects.hash
- HashSet корректно распознаёт дубликаты с обоими переопределениями
- Без hashCode дубликаты не распознаются — объяснено почему
 */