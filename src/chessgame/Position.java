package chessgame;

/**
 * Представление 2D координаты
 */
public class Position {
    byte x;
    byte y; // Этот параметр преобразуется в букву в классических шахматах

    public Position(byte x, byte y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return Character.toString(97 + y) + (x + 1); // 97 - 'a' в ASCII
    }
}
