package base;

/**
 * Класс для демонстрации транспонирования матриц произвольного размера
 */
public class MatrixTransform {

    /**
     * Метод для транспонирования матрицы и её демонстрации
     *
     * @return Возвращает перевернутую матрицу
     */
    public static int[][] transposition() {
        int[][] matrix = new int[4][3];

        for (int rowIndex = 0; rowIndex < 4; rowIndex++) {   // Заполнение матрицы случайными значения от 0 до 9
            for (int colIndex = 0; colIndex < 3; colIndex++) {
                matrix[rowIndex][colIndex] = (int) (Math.random() * 10);
                System.out.printf("%d ", matrix[rowIndex][colIndex]);
            }
            System.out.println();
        }

        int[][] transposed = new int[3][4];
        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix[y].length; x++)
                transposed[x][y] = matrix[y][x];

        System.out.println("После транспонирования, матрица стала выглядеть следующим образом:");
        int maxX = 0, maxY = 0;
        for (int y = 0; y < transposed.length; y++) {
            for (int x = 0; x < transposed[y].length; x++) {
                if (transposed[maxY][maxX] < transposed[y][x]) {
                    maxY = y;
                    maxX = x;
                }
                System.out.printf("%d ", transposed[y][x]);
            }
            System.out.println();
        }
        System.out.printf("Максимальный элемент matrix[%d][%d] = %d (Декартова система координат)\n",
                maxX + 1, transposed[0].length - maxY - 1, transposed[maxY][maxX]); // В традиционном восприятии используется Декартова система координат

        return transposed;
    }
}
