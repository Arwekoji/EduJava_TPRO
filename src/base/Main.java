package base;

import chessgame.GameBoard;
import utils.ConsolePatterns;

/**
 * Точка входа
 */
public class Main {

    /**
     * Метод точки входа в программу
     *
     * @param args Аргументы точки входа
     */
    public static void main(String[] args) {
        ConsolePatterns.printTaskHeader(3.3, "Многомерные массивы");

        ConsolePatterns.printTaskSeparator(1, "Class", "MatrixOps");
        MatrixOps.runTests();

        ConsolePatterns.printTaskSeparator(2, "Class", "MatrixTransform");
        MatrixTransform.runTests();

        ConsolePatterns.printTaskSeparator(3, "Class", "GameBoard");
        GameBoard.runTests();

        ConsolePatterns.printTaskSeparator(4, "Class", "PascalTriangle");
        PascalTriangle.runTests();
    }
}

