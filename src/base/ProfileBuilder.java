package base;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Класс для хранения данных о личностном профиле
 *
 * @author Артур Федьвереш
 */
public class ProfileBuilder {
    String firstName;
    String lastName;
    int age = -1;
    String locality;
    int birthYear;
    int beforePension;

    /**
     * Метод, при вызове которого профиль перезаполняется новыми данными
     *
     * @author Артур Федьвереш
     */
    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Создание нового профиля. Пожалуйста, введите информацию в соответствующие поля");

        System.out.print("Имя: ");
        firstName = scanner.next();
        scanner.nextLine();

        System.out.print("Фамилия: ");
        lastName = scanner.next();
        scanner.nextLine();

        while (age < 0 || age > 150) { //Валидация на правильность данных
            System.out.print("Возраст: ");
            age = scanner.nextInt();
            scanner.nextLine();
            beforePension = 65 - age;
            int currentYear = LocalDate.now().getYear();
            birthYear = currentYear - age;
        }

        System.out.print("Город: ");
        locality = scanner.nextLine(); // Существуют города с названием из более чем одного слова, поэтому использован метод nextLine, а не next

    }

    /**
     * Метод, при вызове которого в консоль выдается информация из профиля
     *
     * @author Артур Федьвереш
     */
    public String toString() {

        return String.format("""
                
                === Профиль ===
                Имя, фамилия: %s %s
                Возраст: %d
                Год рождения: %d
                Город: %s
                До пенсии (65 лет) осталось: %d лет
                """,
                firstName, lastName, age, birthYear, locality, beforePension);

    }

}
