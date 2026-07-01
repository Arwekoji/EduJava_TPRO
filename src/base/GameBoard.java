package base;

import java.util.Arrays;

/**
 * Класс для представления упрощённой шахматной доски
 */
public class GameBoard {

    /**
     * Метод для проверки возможности хождения ферзя на шахматном поле (Без учета препятствий)
     *
     * @param y1 Номер строки проверяемой фигуры
     * @param x1 Номер столбца проверяемой фигуры
     * @param y2 Номер строки атакуемой фигуры
     * @param x2 Номер столбца атакуемой фигуры
     * @return False/True что фигура может ходить по такому маршруту
     */
    private static boolean checkQueenAttack(int y1, int x1, int y2, int x2) {
        boolean isOnLine = (x1 == x2) || (y1 == y2) || (Math.abs(x2 - x1) == Math.abs(y2 - y1));
        // boolean isVisible = true; // Условия задачи пока не требуют такое усложнение
        return isOnLine;
    }

    /**
     * Метод для отрисовки упрощенного шахматного поля с линией ферзей
     */
    public static void getField() {
        char[][] chessField = new char[8][8];

        for (int y = 0; y < chessField.length; y++)
            for (int x = 0; x < chessField[y].length; x++)
                chessField[y][x] = ((y + x) % 2 == 0) ? '.' : '#'; // Прорисовка поля

        Arrays.fill(chessField[0], 'Q');

        for (int y = 0; y < chessField.length; y++) {       // Отображение текущего шахматного поля в консоли
            for (int x = 0; x < chessField[y].length; x++)
                System.out.print(chessField[y][x] + " ");
            System.out.println();
        }

        /*
        Правила хождения ферзем гласят, что он может бить любую вражескую фигуру в пределах прямой видимости на любом расстоянии по всем диагоналям и осям
        Самый простой способ продемонстрировать выполнение этих правил: Сверка двух фигур
        Учитывая, что задача гласит указать возможность атаки соседних фигур по горизонтали, их координаты и будут указаны
         */
        System.out.printf("Ферзь на клетке [0,0]%s может атаковать фигуру на клетке [0,7]\n", ((checkQueenAttack(0, 0, 0, 7)) ? "" : " НЕ"));
        System.out.printf("Ферзь на клетке [0,0]%s может атаковать фигуру на клетке [1,7]\n", ((checkQueenAttack(0, 0, 1, 7)) ? "" : " НЕ"));
    }

}
