package base;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Прямоугольник с параметрами и методами для взаимодействия с ними
 */
public class Rectangle {
    private static int FACTOR_EXAMPLE = 2;

    double width, height;

    /**
     * Конструктор, базовый
     *
     * @param width  Ширина прямоугольника
     * @param height Высота прямоугольника
     */
    public Rectangle(double width, double height) {
        this.width = Math.max(width, 0);
        this.height = Math.max(height, 0);
    }

    /**
     * Конструктор, случайный
     */
    public Rectangle() {
        this(ThreadLocalRandom.current().nextDouble(0, 100), ThreadLocalRandom.current().nextDouble(0, 100));
    }

    /**
     * Вычисление площади прямоугольника
     *
     * @return Площадь прямоугольника
     */
    public double area() {
        return width * height;
    }

    /**
     * Вычисление длины периметра прямоугольника
     *
     * @return Длина периметра прямоугольника
     */
    public double perimeter() {
        return 2 * (width + height);
    }

    /**
     * Проверка на эквивалентность ширины и высоты
     *
     * @return Статус квадрата
     */
    public boolean isSquare() {
        return width == height;
    }

    /**
     * Масштабирование прямоугольника
     *
     * @param factor Множитель масштабирования
     */
    public void scale(double factor) {
        width *= factor;
        height *= factor;
    }

    /**
     * Вывод информации о прямоугольнике в консоль
     */
    public void printInfo() {
        System.out.printf("""
                        □ Прямоугольник (%.2f ширина, %.2f высота). Это %sквадрат
                        Площадь = W * H = %.2f
                        Периметр = 2 * (W + H) = %.2f
                        """,
                width, height,
                isSquare() ? "" : "не ",
                area(), perimeter()
        );
    }

    /**
     * Тестовый метод для демонстрации возможностей класса
     */
    public static void testClass() {
        Rectangle[] testRectangles = {new Rectangle(), new Rectangle(), new Rectangle(5, 5)}; // Третий прямоугольник точно является квадратом

        for (Rectangle rectangle : testRectangles) {
            rectangle.printInfo();
            System.out.println("*** Меняем масштаб прямоугольника модификатором х" + FACTOR_EXAMPLE + " ***");
            rectangle.scale(FACTOR_EXAMPLE);
            rectangle.printInfo();
            System.out.println();
        }
    }
}
