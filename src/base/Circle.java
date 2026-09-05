package base;

/**
 * Окружность как геометрическая фигура и операции с ней
 */
public class Circle {
    public static final Circle[] EXAMPLE_CIRCLES = {
            new Circle(),
            new Circle(95)
    };
    public static final Circle EXAMPLE_SECOND_CIRCLE = new Circle(10, 50, 50);
    public static final double EXAMPLE_POINT_X = 10, EXAMPLE_POINT_Y = 10;

    double radius, centerX, centerY;

    /**
     * Конструктор со всеми параметрами
     *
     * @param radius  Радиус окружности
     * @param centerX Координата Х центра окружности
     * @param centerY Координата Y центра окружности
     */
    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Упрощенный конструктор окружности в нулевых координатах с указанием только радиуса
     *
     * @param radius Радиус окружности
     */
    public Circle(double radius) {
        this(radius, 0, 0);
    }

    /**
     * Базовый конструктор окружности в нулевых координатах и с радиусом 1
     */
    public Circle() {
        this(1);
    }

    /**
     * Копирующий конструктор
     *
     * @param copyCircle Окружность, которую нужно скопировать
     */
    public Circle(Circle copyCircle) {
        this(copyCircle.radius, copyCircle.centerX, copyCircle.centerY);
    }

    /**
     * Метод для вычисления площади круга
     *
     * @return Площадь круга
     */
    public double area() {
        return Math.pow(Math.PI * radius, 2);
    }

    /**
     * Метод для вычисления длины окружности
     *
     * @return Длина окружности
     */
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Проверка на наличие указанной точки внутри круга методом Пифагора
     *
     * @param x Координата Х данной точки
     * @param y Координата Y данной точки
     * @return Статус наличия указанной точки в пределах круга
     */
    public boolean contains(double x, double y) {
        return hypotenuse(x, y, centerX, centerY) <= radius;
    }

    /**
     * Проверка на пересечение с другой окружностью
     *
     * @param secondCircle Другая окружность для сравнения
     * @return Статус пересечения данных двух окружностей
     */
    public boolean intersects(Circle secondCircle) {
        return hypotenuse(secondCircle.centerX, secondCircle.centerY, centerX, centerY) <= radius + secondCircle.radius;
    }

    /**
     * Вычисления расстояния между двумя точками методом Пифагора
     *
     * @param x1 Х координата первой точки
     * @param y1 Y координата первой точки
     * @param x2 X координата второй точки
     * @param y2 Y координата второй точки
     * @return Расстояние между точками
     */
    public static double hypotenuse(double x1, double y1, double x2, double y2) {
        double leg1 = Math.abs(x2 - x1);
        double leg2 = Math.abs(y2 - y1);

        return Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2));
    }

    /**
     * Вывод информации об окружности и результатов операций с тестовыми экземплярами
     */
    public void printInfo() {
        System.out.printf("""
                        ————————————————————————————————————————————————————————————————————————————————————
                        ○ (Круг), [%.2f, %.2f], R = %.2f
                        S = %.2f, C = %.2f
                        Точка [%.2f, %.2f] %sрасположена внутри данного круга
                        Второй ○ ([%.2f, %.2f], R=%.2f) %sпересекается с данным
                        ————————————————————————————————————————————————————————————————————————————————————
                        """, centerX, centerY, radius, area(), perimeter(),
                EXAMPLE_POINT_X, EXAMPLE_POINT_Y, contains(EXAMPLE_POINT_X, EXAMPLE_POINT_Y) ? "" : "не ",
                EXAMPLE_SECOND_CIRCLE.centerX, EXAMPLE_SECOND_CIRCLE.centerY, EXAMPLE_SECOND_CIRCLE.radius,
                intersects(EXAMPLE_SECOND_CIRCLE) ? "" : "не "
        );
    }

    /**
     * Тестовый метод для демонстрации возможностей класса
     */
    public static void testClass() {
        for (Circle circle : EXAMPLE_CIRCLES)
            circle.printInfo();
    }
}

/*
Задача 2. Класс Circle.
Создайте класс Circle с полями radius (double), centerX (double), centerY (double). Реализуйте конструкторы:
без параметров создаёт единичную окружность в начале координат, с одним параметром принимает радиус, с тремя параметрами принимает радиус и координаты центра,
копирующий конструктор принимает другой Circle. Реализуйте методы: area, perimeter, contains принимает координаты точки и возвращает true если точка внутри окружности,
intersects принимает другой Circle и возвращает true если окружности пересекаются (расстояние между центрами меньше суммы радиусов). Проверьте все методы.
 */