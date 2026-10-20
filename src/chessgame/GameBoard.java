package chessgame;

import utils.ConsolePatterns;

import java.util.ArrayList;

/**
 * Игровая доска с урезанной механикой шахмат
 */
public class GameBoard {
    public static final byte BOARD_SIZE = 8;
    public final Tile[][] tileMap;
    public final ArrayList<Figure> liveFigures = new ArrayList<>();

    /**
     * Объект-клетка на шахматной доске
     */
    public static class Tile {
        Figure figurine;
        Position position;
        char graphic;

        public Tile(byte x, byte y) {
            position = new Position(x, y);
            graphic = ((x + y) % 2 == 0) ? GraphicSettings.TILE_BLACK : GraphicSettings.TILE_WHITE;
        }
    }

    /**
     * Конструктор пустой доски
     */
    public GameBoard() {
        tileMap = new Tile[BOARD_SIZE][BOARD_SIZE];
        //System.out.println(-2);
        for (byte y = 0; y < BOARD_SIZE; y++)
            for (byte x = 0; x < BOARD_SIZE; x++) {
                //System.out.println(x + " " + y);
                tileMap[x][y] = new Tile(x, y);
            }
    }

    /**
     * Отрисовка текущей доски в консоли
     *
     * @param isWhiteTurn Статус права хождения для белого игрока
     */
    public void render(boolean isWhiteTurn) {
        System.out.println(""" 
                ⠀
                   a b c d e f g h
                  ┌────────────────┐""");
        if (!isWhiteTurn)
            for (int y = 0; y < BOARD_SIZE; y++) {       // Отображение текущего шахматного поля в консоли
                System.out.print((y + 1) + " │");
                for (int x = 0; x < BOARD_SIZE; x++)
                    if (tileMap[x][y].figurine == null)
                        System.out.print(tileMap[x][y].graphic + " ");
                    else
                        System.out.print(tileMap[x][y].figurine.graphic + " ");

                System.out.println("│ " + (y + 1));
            }
        else
            for (int y = BOARD_SIZE - 1; y >= 0; y--) {       // Отображение текущего шахматного поля в консоли
                System.out.print((y + 1) + " │");
                for (int x = 0; x < BOARD_SIZE; x++)
                    if (tileMap[x][y].figurine == null)
                        System.out.print(tileMap[x][y].graphic + " ");
                    else
                        System.out.print(tileMap[x][y].figurine.graphic + " ");

                System.out.println("│ " + (y + 1));
            }
        System.out.println("""
                  └────────────────┘
                   a b c d e f g h
                """);
    }

    /**
     * Кастомные тесты класса с тестовыми данными по умолчанию
     *
     * @return Успешность тестов
     */
    public static boolean runTests() {
        try {
            GameBoard board = new GameBoard();
            board.render(true);
            System.out.println("Заполняем весь 1 ряд (С точки зрения белого игрока) белыми ферзями:");

            for (byte x = 0; x < BOARD_SIZE; x++)
                board.tileMap[x][0].figurine = new Figure.Queen(true, new Position(x, (byte) 0), board);

            board.render(true);

            System.out.println("(Simple Check):");
            for (Figure figure : board.liveFigures) {
                System.out.printf("%s %s[%s] может атаковать/ходить на: ", figure.isWhite ? "White" : "Black", figure.name, figure.position);
                for (Figure comparedFigure : board.liveFigures) {
                    if (figure == comparedFigure)
                        continue;

                    System.out.printf("(%s %s[%s]) ", comparedFigure.isWhite ? "White" : "Black", comparedFigure.name, comparedFigure.position);
                }
                System.out.println();
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
- игровое поле выглядит как шахматная доска

------------------------------------------------------------------------------------------------------------------------

Задача 3. Класс GameBoard. Поле для игры.
Создайте игровое поле 8x8 (как шахматная доска).
Заполните его символами:
    нечётные клетки символом '#', чётные символом '.', где нечётность определяется суммой индексов (i + j) % 2.
    Выведите поле в консоль.
    Затем реализуйте расстановку 8 ферзей в первый ряд (просто заполните первую строку символом 'Q')
    и проверьте бьют ли они друг друга по горизонтали (все в одной строке — значит бьют, это учебный пример, не решение задачи 8 ферзей).


Пример вывода:
. # . # . # . #
# . # . # . # .
. # . # . # . #
...

------------------------------------------------------------------------------------------------------------------------

Замечание #1:
    В задаче 3 нужно разделить на метод заполнения матрицы, отрисовки и проверки взятия.
    Метод наименования get не может быть void.
 */