package base;

/**
 * Точка входа
 *
 * @author Артур Федьвереш
 */
public class Main {

    /**
     * Метод точки входа в программу
     *
     * @param args Аргументы точки входа
     * @author Артур Федьвереш
     */
    public static void main(String[] args) {
        // 1 Задача
        MatrixOps.getMatrix();
        System.out.println("- - - - - - - -");

        // 2 задача
        MatrixTransform.transposition();
        System.out.println("- - - - - - - -");

        // 3 задача
        GameBoard.getField();
        System.out.println("- - - - - - - -");

        // 4 задача
        PascalTriangle.getTriangle(8);
    }

    /**
     * Функция факториала
     *
     * @param n Число, необходимое возвести в факториал
     * @return Число после возведения в факториал
     */
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}