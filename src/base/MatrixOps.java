package base;

import utils.ConsolePatterns;

import java.util.Arrays;
import java.util.Objects;

/**
 * Представление квадратных матриц
 */
public class MatrixOps {

    /**
     * Запись, содержащая вычисленные параметры заданной матрицы
     *
     * @param sumTotal        Сумма содержимого всех ячеек матрицы
     * @param sumDiagonal     Сумма ячеек матрицы по диагонали
     * @param sumDiagonalAnti Сумма ячеек матрицы по обратной диагонали
     * @param maxByRows       Массив максимальных значений в каждой строке матрицы
     * @param sumByCols       Массив суммы ячеек в каждом столбце
     */
    public record MatrixStats(int sumTotal, int sumDiagonal, int sumDiagonalAnti, int[] maxByRows, int[] sumByCols) {
        /**
         * @return Сформированная запись со статистикой матрицы
         */
        @Override
        public String toString() {
            StringBuilder output = new StringBuilder("""
                    --- Matrix Statistics ---
                    Sums of Cells: %d (total), %d (diagonal), %d (anti-diagonal)
                    Maximum Cell by matrix rows:
                    """.formatted(sumTotal, sumDiagonal, sumDiagonalAnti));

            for (int i = 0; i < maxByRows.length; i++)
                output.append(" row_").append(i).append(" = ").append(maxByRows[i]).append(",");

            output.append("%nSum of Cells by matrix cols:%n".formatted());

            for (int i = 0; i < sumByCols.length; i++)
                output.append(" col_").append(i).append(" = ").append(sumByCols[i]).append(",");

            return output.toString();
        }

        /**
         * Переопределение, необходимое, чтобы корректно сравнивать поля-массивы
         *
         * @param o the reference object with which to compare.
         * @return Статус эквивалентности двух записей
         */
        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            MatrixStats that = (MatrixStats) o;
            return sumTotal == that.sumTotal && sumDiagonal == that.sumDiagonal && sumDiagonalAnti == that.sumDiagonalAnti && Objects.deepEquals(maxByRows, that.maxByRows) && Objects.deepEquals(sumByCols, that.sumByCols);
        }

        /**
         * Переопределение, необходимое, чтобы корректно вычислять хэш полей-массивов по их содержимому, а не по ссылке
         *
         * @return Хэш-код записи с учетом содержимого массивов
         */
        @Override
        public int hashCode() {
            return Objects.hash(sumTotal, sumDiagonal, sumDiagonalAnti, Arrays.hashCode(maxByRows), Arrays.hashCode(sumByCols));
        }
    }

    /**
     * Вычисляет и возвращает запись с параметрами заданной квадратной матрицы
     *
     * @param matrix Квадратная матрица с int элементами для анализа
     * @return Запись с вычисленными параметрами матрицы
     */
    public static MatrixStats getMatrixStats(int[][] matrix) {
        if (matrix == null)
            throw new IllegalArgumentException("Нельзя получить статистику у несуществующего массива");

        int sumTotal = 0;
        int sumDiagonal = 0;
        int sumDiagonalAnti = 0;
        int[] maxByRows = new int[matrix.length];
        int[] sumByCols = new int[matrix[0].length];

        for (int y = 0; y < matrix.length; y++) // Прежде чем искать максимум, нужно задать пример для сравнения.
            maxByRows[y] = matrix[y][0];        // 0 по умолчанию неприменим, т.к. все значения массива могут быть отрицательные и результат будет ложным

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                sumByCols[x] += matrix[y][x];   // Вычисляем сумму столбцов по отдельности
                sumTotal += matrix[y][x];       // Вычисляем сумму всех элементов матрицы
                maxByRows[y] = Math.max(maxByRows[y], matrix[y][x]);
            }

            sumDiagonal += matrix[y][y]; // Вычисляем сумму диагонали и анти-диагонали
            sumDiagonalAnti += matrix[matrix.length - y - 1][y];
        }

        return new MatrixStats(sumTotal, sumDiagonal, sumDiagonalAnti, maxByRows, sumByCols);
    }

    /**
     * Распечатывает в консоль содержимое матричного массива
     *
     * @param matrix Матричный массив (Квадратный, прямоугольный, зубчатый - любой)
     */
    public static void printMatrix(int[][] matrix) {
        System.out.printf("Analysed square matrix (size %dx%d):%n", matrix.length, matrix.length);
        for (int[] matrixRow : matrix)
            System.out.println(Arrays.toString(matrixRow));
    }

    /**
     * Кастомные тесты класса с тестовыми данными по умолчанию
     *
     * @return Успешность тестов
     */
    public static boolean runTests() {
        return runTests(new int[][]{
                        {0, 1, 2, 3},
                        {1, 2, 3, 4},
                        {2, 3, 4, 5},
                        {3, 4, 5, 6}
                },
                new MatrixStats(48, 12, 12, new int[]{3, 4, 5, 6}, new int[]{6, 10, 14, 18}));
    }

    /**
     * Кастомные тесты класса с указанием тестовых данных
     *
     * @param inputMatrix Квадратная матрица для анализа
     * @param outputStats Ожидаемый вывод после вычислений параметров заданной матрицы
     * @return Успешность тестов
     */
    public static boolean runTests(int[][] inputMatrix, MatrixStats outputStats) {
        try {
            MatrixStats actualStats = getMatrixStats(inputMatrix);

            printMatrix(inputMatrix);

            System.out.println();
            System.out.println(actualStats);

            if (!actualStats.equals(outputStats)) {
                ConsolePatterns.printTaskError();
                return false;
            }

            return true;
        } catch (Throwable throwable) {
            ConsolePatterns.printRuntimeError(throwable);
            return false;
        }
    }
}

/*
Критерии оценки:
- диагонали матрицы вычисляются корректно

------------------------------------------------------------------------------------------------------------------------

Задача 1. Класс MatrixOps. Матрица и её свойства.
Объявите квадратную матрицу 4x4 с произвольными числами.
Вычислите и выведите:
    сумму всех элементов,
    сумму элементов главной диагонали (левый верхний — правый нижний),
    сумму элементов побочной диагонали,
    максимальный элемент в каждой строке,
    сумму каждого столбца.

Пример вывода:
    Не указан

------------------------------------------------------------------------------------------------------------------------

Замечание #1:
    В задаче 1 смешано заполнение матрицы и вычисление данных по ней.
    Это плохая практика, нарушается принцип single responsibility.
    Для вычисления суммы по антидиагонали более правильная формула:
        antiDiagSum += matrix[rowIndex][matrix.length - 1 - rowIndex];
 */