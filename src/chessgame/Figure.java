package chessgame;

import java.util.ArrayList;

/**
 * Шахматная фигура
 */
public class Figure {
    public final GameBoard board;
    public final String name;
    public final char graphic;
    public final boolean isWhite; // Определяет направление движения фигуры
    public final byte worth;

    Position position;
    ArrayList<GameBoard.Tile> moveAccess;
    public boolean onBoard;

    /**
     * Конструктор шахматной фигуры
     * @param name Название
     * @param isWhite Принадлежность к белой фракции
     * @param graphic Графическое (ASCII) отображение данной фигуры
     * @param worth Тактическая ценность (Необходимо для потенциальных расчетов ИИ)
     * @param position Координаты фигуры на шахматной доске
     * @param board Шахматное поле, к которому относится данная фигура
     */
    public Figure(String name, boolean isWhite, char graphic, byte worth, Position position, GameBoard board) {
        this.name = name;
        this.isWhite = isWhite;
        this.graphic = graphic; //  Определяется тернарным оператором в потомке
        this.worth = worth;
        this.position = position;
        this.onBoard = true;
        this.board = board;
        board.liveFigures.add(this);
    }

    /*
Правила хождения ферзем гласят, что он может бить любую вражескую фигуру в пределах прямой видимости на любом расстоянии по всем диагоналям и осям
Самый простой способ продемонстрировать выполнение этих правил: Сверка двух фигур
Учитывая, что задача гласит указать возможность атаки соседних фигур по горизонтали, их координаты и будут указаны
 */

    /**
     * Упрощенная проверка атаки по мувсету ферзя
     * @param targetPosition Координаты цели для проверки возможности атаки
     * @return Возможность атаки
     */
    public boolean checkSimpleAttack(Position targetPosition) {
        if(position.equals(targetPosition))
            return false;
        return (position.x == targetPosition.x) || (position.y == targetPosition.y) || (Math.abs(targetPosition.x - position.x) == Math.abs(targetPosition.y - position.y));
    }

    /**
     * Подвид фигуры, Королева, она же Ферзь
     */
    public static class Queen extends Figure {
        private static final String[] DIRECTIONS = {"N", "S", "W", "E", "NE", "NW", "SE", "SW"};

        /**
         * Конструктор для ферзя
         * @param isWhite Принадлежность к белой фракции
         * @param position Координаты фигуры на шахматной доске
         * @param board Шахматное поле, к которому относится данная фигура
         */
        public Queen(boolean isWhite, Position position, GameBoard board) {
            super("Queen", isWhite,
                    isWhite ? GraphicSettings.WHITE_QUEEN : GraphicSettings.BLACK_QUEEN,
                    (byte) 9, position, board);
        }
    }
}