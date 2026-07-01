package base;

/**
 * Класс для демонстрации квадратной матрицы и работы с ней
 */
public class MatrixOps {

    /**
     * Метод для вывода данных о случайной квадратной матрице на экран
     */
    public static void getMatrix() {
        int[][] matrix = new int[4][4];
        int[] rowsMax = new int[4]; // Максимальные значения в каждой из строк матрицы
        int[] colsSum = new int[4]; // Суммы каждого столбца

        int sum = 0;

        for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
            rowsMax[rowIndex] = matrix[rowIndex][0];
            for (int colIndex = 0; colIndex < 4; colIndex++) {
                matrix[rowIndex][colIndex] = (int) (Math.random() * 10);
                sum += matrix[rowIndex][colIndex];
                rowsMax[rowIndex] = Math.max(matrix[rowIndex][colIndex], rowsMax[rowIndex]);
                colsSum[colIndex] += matrix[rowIndex][colIndex];
            }
        }

        int mainDiagSum = 0, antiDiagSum = 0;
        System.out.printf("Матрица 4х4 с суммой всех элементов %d:\n", sum);
        for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
            for (int col : matrix[rowIndex])
                System.out.print(col + " ");
            System.out.printf("(max=%d)\n", rowsMax[rowIndex]);
            mainDiagSum += matrix[rowIndex][rowIndex];
            antiDiagSum += matrix[rowIndex][3 - rowIndex];
        }

        System.out.printf("Сумма диагоналей: главная (%d), побочная (%d)\n", mainDiagSum, antiDiagSum);
        System.out.printf("Суммы столбцов: | %d | %d | %d | %d |\n", colsSum[0], colsSum[1], colsSum[2], colsSum[3]);

    }
}
