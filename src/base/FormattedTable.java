package base;

/**
 * Класс для отображения табличных данных через псевдографику
 */
public class FormattedTable {
    final public static String LABEL_NAME = "Имя";
    final public static String LABEL_AGE = "Возр.";

    /**
     * Процедура для отрисовки заданных данных о студентах в формате таблицы
     *
     * @param students Массив данных о студентах типа StudentCard
     */
    public static void printFromList (StudentCard[] students) {
        byte longestNumber = (byte) String.valueOf(students.length + 1).length(); // Ширина колонки с номером строки
        byte longestName = 0;

        // Блок определения ширины столбца с именем
        for(StudentCard student : students)
            longestName = (longestName < (byte) student.name.length()) ? (byte) student.name.length() : longestName;

        StringBuilder output = new StringBuilder(String.format("""
                +--%s+-%s-+-%s-+-------+
                | №%s| %s%s| %s | Балл  |
                +--%s+-%s-+-%s-+-------+
                """,
                "-".repeat(longestNumber),                                              // Длина верхней черты первого столбца          (Длина ID студента)
                "-".repeat(Math.max(longestName,LABEL_NAME.length())),                  // Длина верхней черты второго столбца          (Длина имени студента)
                "-".repeat(LABEL_AGE.length()),                                         // Длина верхней черты третьего столбца         (Длина строки с возрастом студента)
                " ".repeat(longestNumber),                                              // Длина отступа в заголовке первого столбца
                LABEL_NAME,                                                             // Заголовок второго столбца                    (Обозначает имя студентов)
                " ".repeat(1 + Math.max(0, longestName - LABEL_NAME.length())),   // Длина отступа в заголовке второго столбца
                LABEL_AGE,                                                              // Заголовок третьего столбца                   (Обозначает возраст студентов)
                "-".repeat(longestNumber),                                              // Длина нижней черты первого столбца
                "-".repeat(Math.max(longestName,LABEL_NAME.length())),                  // Длина нижней черты второго столбца
                "-".repeat(LABEL_AGE.length())                                          // Длина нижней черты третьего столбца
        ));

        for(int i = 0; i < students.length; i++) {
            StudentCard student = students[i];
            output.append(String.format("""
                    | %d%s| %s%s| %d%s| %.2f%s|
                    """,
                    i + 1, " ".repeat(1 + longestNumber - String.valueOf(i).length()),                                        // Номер строки и отступ до черты справа
                    student.name, " ".repeat(1 + Math.max(LABEL_NAME.length(), longestName) - student.name.length()),         // Имя студента и отступ до черты справа
                    student.age,  " ".repeat(1 + Math.max(0, LABEL_AGE.length() - String.valueOf(student.age).length()) ),    // Возраст студента и отступ до черта справа
                    student.middleScore, " ".repeat(student.middleScore < 10 ? 2 : 1)                                               // Балл студента и отступ до черты справа
                    )
            );
        }

        output.append(String.format("""
                +--%s+-%s-+-%s-+-------+
                """,
                "-".repeat(longestNumber),                                  // Длина нижней черты первого столбца
                "-".repeat(Math.max(longestName,LABEL_NAME.length())),      // Длина нижней черты второго столбца
                "-".repeat(LABEL_AGE.length())                              // Длина нижней черты третьего столбца
                )
        );

        System.out.println(output.toString());
    }
}
