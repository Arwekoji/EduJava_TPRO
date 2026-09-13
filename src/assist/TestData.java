package assist;

/**
 * Централизованная запись с тестовыми данными для разных задач
 */
public record TestData() {
    public static final String[] FIRST_NAME_EXAMPLES = {"Игорь", "Сергей", "Олег", "Артём", "Иван"};
    public static final String[] LAST_NAME_EXAMPLES = {"Петров", "Иванов", "Патрушев", "Овечкин", "Апполонов"};
    public static final String[] EMAIL_EXAMPLES = {"placeholder@mail.ru", "anonymous@gmail.com", "secret@mailfence.com"};

    public static final short STUDENT_DUPLICATE_AGE = 18;
    public static final String STUDENT_DUPLICATE_NAME = "Dublicate", STUDENT_DUPLICATE_EMAIL = "duplicate@mail.ru";

    public static final short STUDENT_AGE_MIN = 18, STUDENT_AGE_MAX = 50, STUDENT_RANDOM_EXAMPLES = 2;
}