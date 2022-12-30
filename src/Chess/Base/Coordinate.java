package Chess.Base;

public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(int new_x, int new_y) {
        this.x = new_x;
        this.y = new_y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
