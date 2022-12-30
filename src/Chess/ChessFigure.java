package Chess;

import Chess.Base.Coordinate;

public abstract class ChessFigure {
    public static boolean isLog;

    static {
        isLog = true;
    }

    protected boolean colorIsWhite; // true = white, false = black
    protected boolean isOnBoard;  // true = onBoard
    protected char symbol; // '\u2654'..'\u265f';
    protected Coordinate coordinateFrom;

    public ChessFigure(boolean colorIsWhite, char symbol, Coordinate coordinateFrom) {
        this.colorIsWhite = colorIsWhite;
        this.isOnBoard = true;
        this.symbol = symbol;
        this.coordinateFrom = coordinateFrom;
    }

    public ChessFigure() {
        this.isOnBoard = false;
    }

    @Override
    public String toString() {
        if (isLog) return symbol + " " + coordinateFrom;
        else return String.valueOf(symbol);
    }

    public void move(Coordinate coordinateTo) {
        this.coordinateFrom = coordinateTo;
    }

    public abstract boolean canMove(Coordinate coordinateTo);

}
