package base;

/**
 * Класс для хранения данных о студентах
 */
public class StudentCard {
    String name;
    byte age;
    float middleScore;

    /**
     * Метод инициализации объекта
     *
     * @param name        Имя студента
     * @param age         Возраст студента
     * @param middleScore Средний балл успеваемости студента
     */
    public StudentCard(String name, byte age, float middleScore) {
        this.name = name;
        this.age = age;
        this.middleScore = middleScore;
    }
}
