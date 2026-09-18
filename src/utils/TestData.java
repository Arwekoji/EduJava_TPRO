package utils;

/**
 * Централизованная запись с тестовыми данными для разных задач
 */
public record TestData() {
    public static final String[] FIRST_NAME_EXAMPLES = {"Игорь", "Сергей", "Олег", "Артём", "Иван"};
    public static final String[] LAST_NAME_EXAMPLES = {"Петров", "Иванов", "Патрушев", "Овечкин", "Апполонов"};
    public static final int TOTAL_EXAMPLES_TASK_1 = 5; // Тестовый параметр, который применяется когда нужно сделать N экземпляров в указанной задаче

    /**
     * Генерирует случайное сочетание из имени и фамилии
     *
     * @return Сочетание из случайных имени и фамилии
     */
    public static String randomName() {
        return AdvancedArrays.pick(FIRST_NAME_EXAMPLES) + " " + AdvancedArrays.pick(LAST_NAME_EXAMPLES);
    }
}