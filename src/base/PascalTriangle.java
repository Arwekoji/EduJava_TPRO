package base;

/**
 * Класс для представления треугольника Паскаля
 */
public class PascalTriangle {

    /**
     * Метод для отрисовки треугольника Паскаля
     *
     * @param n Число строк/уровней в треугольнике Паскаля
     */
    public static void getTriangle(int n) {
        int[][] triangle = new int[n][];

        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];
            int sum = 0;

            // Заполнить элементы так, чтобы они в сумме равнялись 2^i
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = Main.factorial(i) / (Main.factorial(j) * Main.factorial(i - j));
                sum += triangle[i][j];
            }

            System.out.printf("Sum(%d_row)=%d (2^%d=%d) | ", i, sum, i, (int) Math.pow(2, i));
        }

        System.out.println();

        for (int y = 0; y < triangle.length; y++) {
            System.out.print(" ".repeat(triangle.length - y));
            for (int x = 0; x < triangle[y].length; x++)
                System.out.print(triangle[y][x] + " ");
            System.out.println();
        }

    }

}
