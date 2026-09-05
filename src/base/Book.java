package base;

/**
 * Класс 1 задачи, представляющий запись о книге
 */
public class Book {
    public static final int YEAR_MODERN = 1950;
    public static final Book[] BOOK_EXAMPLES = {
            new Book("Архимаг", "Александр Рудазов"),
            new Book("Основание", "Айзек Азимов", 1942),
            new Book("Высшая математика", "И.В. Виленкин", 2008, 415),
            new Book("Malleus Maleficārum", "Генрих Крамер, Якоб Шпренгер", 1487, 260, 35000)
    };

    String title, author;
    int year, pages;
    double price;

    /**
     * Конструктор с полным набором параметров
     *
     * @param title  Название книги
     * @param author Имя автора
     * @param year   Год издания
     * @param pages  Число страниц
     * @param price  Цена в рублях
     */
    public Book(String title, String author, int year, int pages, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    /**
     * Упрощенный конструктор, без цены
     *
     * @param title  Название книги
     * @param author Имя автора
     * @param year   Год издания
     * @param pages  Число страниц
     */
    public Book(String title, String author, int year, int pages) {
        this(title, author, year, pages, 0);
    }

    /**
     * Упрощенный конструктор, без цены и числа страниц
     *
     * @param title  Название книги
     * @param author Имя автора
     * @param year   Год издания
     */
    public Book(String title, String author, int year) {
        this(title, author, year, 0);
    }

    /**
     * Упрощенный конструктор, без цены, числа страниц и года издания
     *
     * @param title  Название книги
     * @param author ИМя автора
     */
    public Book(String title, String author) {
        this(title, author, 2004);
    }

    /**
     * Проверка на статус классики
     *
     * @return Статус классики в boolean формате
     */
    private boolean isClassic() {
        return year < YEAR_MODERN;
    }

    /**
     * Вывод записи о книге в консоль
     */
    public void printInfo() {
        System.out.printf("""
                        Книга "%s" (Автор - %s)
                        Число страниц - %d
                        Год издания - %d %s
                        Цена - %.2f ₽
                        """, title, author, pages, year,
                isClassic() ? "(Классика)" : "",
                price
        );
    }

    /**
     * Тестовый метод для демонстрации возможностей класса
     */
    public static void testClass() {
        for (Book book : BOOK_EXAMPLES) {
            System.out.println();
            book.printInfo();
        }
    }
}

/*
Задача 1. Класс Book.
Создайте класс Book с полями: название (String), автор (String), год издания (int), количество страниц (int), цена (double). Реализуйте четыре конструктора:
первый принимает только название и автора, второй добавляет год, третий добавляет страницы, четвёртый принимает все поля.
Используйте цепочку this() чтобы не дублировать код инициализации. Добавьте метод printInfo и метод isClassic возвращающий true если книга издана до 1950 года.
Создайте по одному объекту каждым конструктором и выведите информацию.
 */