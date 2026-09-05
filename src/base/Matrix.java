package base;

import java.util.Arrays;

/**
 * Матрица с базовыми операциями
 */
public class Matrix {
    public static final Matrix[] MATRIX_EXAMPLES = {
            new Matrix(3, 3),
            new Matrix(new int[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            })
    };

    int rows, cols;
    int[][] data;

    /**
     * Конструктор с автозаполнением матрицы нулями
     *
     * @param rows Число строк в матрице
     * @param cols Число столбцов в матрице
     */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        data = new int[rows][cols];
        for (int[] row : data)
            Arrays.fill(row, 0);
    }

    /**
     * Конструктор, копирующий заданный массив
     *
     * @param array Массив Integer[][] для копирования
     */
    public Matrix(int[][] array) {
        this.rows = array.length;
        this.cols = array[0].length;

        data = new int[array.length][];
        // this(array.length, array[0].length); // Формально, код выше можно заменить этой строчкой. Но это вызовет лишние действия с инициализацией нулей
        for (int i = 0; i < array.length; i++)
            data[i] = Arrays.copyOf(array[i], array[i].length);
    }

    /**
     * Копирующий конструктор
     *
     * @param copy Другая матрица для копирования
     */
    public Matrix(Matrix copy) {
        this(copy.data);
    }

    /**
     * Геттер для указанной ячейки матрицы
     *
     * @param i Номер строки
     * @param j Номер столбца
     * @return Значение указанной ячейки матрицы
     */
    public int get(int i, int j) {
        return data[i][j];
    }

    /**
     * Сеттер для указанной ячейки матрицы
     *
     * @param i        Номер строки
     * @param j        Номер столбца
     * @param newValue
     */
    public void set(int i, int j, int newValue) {
        data[i][j] = newValue;
    }

    /**
     * Сложение с указанной матрицей
     *
     * @param secondMatrix Матрица - слагаемое, должна быть того же размера, что и оригинал
     * @return Новая матрица - результат сложения
     */
    public Matrix add(Matrix secondMatrix) {
        if (data == null || secondMatrix.data == null || secondMatrix.rows != rows || secondMatrix.cols != cols) {
            System.out.println("Нельзя складывать матрицы разных размеров!");
            return this;
        }

        Matrix newMatrix = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                newMatrix.set(i, j, get(i, j) + secondMatrix.get(i, j));

        return newMatrix;
    }

    /**
     * Перемножение с указанной матрицей
     *
     * @param secondMatrix Матрица-множитель
     * @return Новая матрица - результат перемножения
     */
    public Matrix multiply(Matrix secondMatrix) {
        Matrix newMatrix = new Matrix(rows, secondMatrix.cols);

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < secondMatrix.cols; j++)
                for (int k = 0; k < secondMatrix.rows; k++)
                    newMatrix.set(i, j, newMatrix.get(i, j) + get(i, k) * secondMatrix.get(k, j));

        return newMatrix;
    }

    /**
     * Вывод текущей матрицы в консоль (С инвертированием X и Y)
     */
    public void printMatrix() {
        System.out.println("Матрица " + cols + "x" + rows + ":");
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++)
                System.out.print(STR."\{get(y, x)} ");

            System.out.println();
        }
    }

    /**
     * Тестовый метод для демонстрации возможностей класса
     */
    public static void testClass() {
        System.out.println("Для тестирования взяты 2 матрицы. Ниже показаны результат работы их методов");
        MATRIX_EXAMPLES[0].printMatrix();
        System.out.println();
        MATRIX_EXAMPLES[1].printMatrix();
        System.out.println();

        System.out.println("Работа копирующего конструктора для 2 матрицы:"); // Все другие конструкторы используются в коде напрямую
        Matrix copy = new Matrix(MATRIX_EXAMPLES[1]);
        copy.printMatrix();
        System.out.println();

        System.out.println("Результат сложения второй матрицы и её копии:");
        Matrix summary = MATRIX_EXAMPLES[1].add(copy);
        summary.printMatrix();
        System.out.println();

        System.out.println("Результат перемножения второй матрицы и её копии:");
        Matrix multiplication = MATRIX_EXAMPLES[1].multiply(copy);
        multiplication.printMatrix();
    }
}

/*
Задача 3. Класс Matrix.
Создайте класс Matrix с полями rows (int), cols (int), data (двумерный массив int[][]). Реализуйте конструкторы: принимает rows и cols и создаёт нулевую матрицу,
принимает готовый двумерный массив и копирует его (не ссылку, а содержимое), копирующий конструктор. Добавьте методы: get принимает i и j возвращает элемент,
set принимает i j и значение, printMatrix выводит матрицу в табличном виде, add принимает другую Matrix и возвращает новую матрицу-сумму,
multiply принимает другую Matrix и возвращает произведение. Проверьте что копирующий конструктор создаёт независимую копию.
 */