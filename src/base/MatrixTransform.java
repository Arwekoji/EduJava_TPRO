package base;

import utils.ConsolePatterns;

import java.util.Objects;

/**
 * Представление транспонирования прямоугольных матриц
 */
public class MatrixTransform {

    /**
     * Транспонирует прямоугольную матрицу
     *
     * @return Возвращает перевернутую матрицу
     */
    public static int[][] transpositionOf(int[][] matrix) {
        if (matrix == null)
            throw new IllegalArgumentException("Массив не существует");

        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix[y].length; x++)
                transposedMatrix[x][y] = matrix[y][x];

        return transposedMatrix;
    }

    /**
     * Ищет координаты ячейки с максимальным элементом в заданной матрице
     *
     * @param matrix Матрица для анализа
     * @return Координаты ячейки в формате int[]
     */
    public static int[] searchMaxCell(int[][] matrix) {
        if (matrix == null)
            throw new IllegalArgumentException("Массив не существует");

        int maxX = 0;
        int maxY = 0;

        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix[y].length; x++)
                if (matrix[maxY][maxX] < matrix[y][x]) {
                    maxX = x;
                    maxY = y;
                }

        return new int[]{maxY, maxX};
    }

    /**
     * Выводит содержимое матрицы в консоль
     *
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        if (matrix == null)
            throw new IllegalArgumentException("Массив не существует");

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++)
                System.out.printf(" %d", matrix[y][x]);
            System.out.println();
        }
    }

    /**
     * Кастомные тесты класса с тестовыми данными по умолчанию
     *
     * @return Успешность тестов
     */
    public static boolean runTests() {
        return runTests(new int[][]{
                        {0, 1, 2, 3},
                        {4, 5, 6, 7},
                        {8, 3, 5, 2}
                },
                new int[][]{
                        {0, 4, 8},
                        {1, 5, 3},
                        {2, 6, 5},
                        {3, 7, 2}
                },
                2, 0
        );
    }

    /**
     * Кастомные тесты класса с указанием тестовых данных
     *
     * @param inputMatrix            Прямоугольная матрица для анализа
     * @param outputTransposedMatrix Ожидаемый вывод после транспонирования заданной матрицы
     * @param maxX                   Индекс наибольшего элемента внутри строки
     * @param maxY                   Индекс наибольшего элемента внутри столбца
     * @return Успешность тестов
     */
    public static boolean runTests(int[][] inputMatrix, int[][] outputTransposedMatrix, int maxX, int maxY) {
        try {
            System.out.printf("Analysed matrix (size %dx%d):%n", inputMatrix[0].length, inputMatrix.length);
            printMatrix(inputMatrix);
            System.out.println();

            System.out.println("Transposed matrix:");
            int[][] transposedMatrix = transpositionOf(inputMatrix);
            printMatrix(transposedMatrix);
            System.out.println();

            int[] maxCellCoord = searchMaxCell(transposedMatrix);
            System.out.printf("""
                    Maximum element of transposed matrix:
                    M[%d][%d] = %d
                    """, maxCellCoord[1], maxCellCoord[0], transposedMatrix[maxCellCoord[0]][maxCellCoord[1]]);

            if (!Objects.deepEquals(transposedMatrix, outputTransposedMatrix) || maxX != maxCellCoord[1] || maxY != maxCellCoord[0]) {
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
- транспонирование работает для прямоугольных матриц (не только квадратных)

------------------------------------------------------------------------------------------------------------------------

Задача 2. Класс MatrixTransform. Работа с матрицей.
Объявите матрицу 3x4.
Реализуйте:
    транспонирование матрицы (строки становятся столбцами, результат 4x3),
    вывод матрицы в красивом табличном формате через printf,
    поиск максимального элемента всей матрицы и вывод его строки и столбца.

Пример вывода:
    Не указан

------------------------------------------------------------------------------------------------------------------------

Замечание #1:
    В задаче 2 смешано наполнение и отрисовка матрицы.
    Отрисовка транспонированной и определение ее максимального элемента.
    Для отрисовки матрицы лучше отдельный метод написать.
 */