package base;

/**
 * Класс для демонстрации примитивных арифметических операций
 *
 * @author Артур Федьвереш
 */
public class Calculator {

    /**
     * Метод для целочисленного сложения
     *
     * @param a - первое слагаемое
     * @param b - второе слагаемое
     * @author Артур Федьвереш
     */
    public void addNum(int a, int b) {
        System.out.println("Сложение: " + (a + b));
    }

    /**
     * Метод для целочисленного вычитания
     *
     * @param a - уменьшаемое
     * @param b - вычитаемое
     * @author Артур Федьвереш
     */
    public void subtract(int a, int b) {
        System.out.println("Вычитание: " + (a - b));
    }

    /**
     * Метод для целочисленного умножения
     *
     * @param a - первый множитель
     * @param b - второй множитель
     * @author Артур Федьвереш
     */
    public void multiply(int a, int b) {
        System.out.println("Умножение: " + (a * b));
    }

    /**
     * Метод для целочисленного деления
     *
     * @param a - делимое
     * @param b - делитель (Не должен быть равен 0)
     * @author Артур Федьвереш
     */
    public void divideInt(int a, int b) {
        System.out.println("Целочисленное деление: " + (a / b));
    }

    /**
     * Метод для вещественного деления
     *
     * @param a - делимое
     * @param b - делитель
     * @author Артур Федьвереш
     */
    public void divideDouble(double a, double b) {
        System.out.println("Вещественное деление: " + (a / b));
    }

    /**
     * Метод для получения остатка от целочисленного деления
     *
     * @param a - делимое
     * @param b - делитель
     * @author Артур Федьвереш
     */
    public void getRemainder(int a, int b) {
        System.out.println("Остаток: " + (a % b));
    }
}
