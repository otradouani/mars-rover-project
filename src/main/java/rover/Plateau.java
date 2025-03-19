package rover;

public class Plateau {
    private final int xMax;
    private final int yMax;

    public Plateau(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x <= xMax && y >= 0 && y <= yMax;
    }
}
