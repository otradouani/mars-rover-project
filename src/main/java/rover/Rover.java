package rover;

public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private final Plateau plateau;

    public Rover(int x, int y, Direction direction, Plateau plateau) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.plateau = plateau;
    }

    public void processCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L': turnLeft(); break;
                case 'R': turnRight(); break;
                case 'M': moveForward(); break;
                default: throw new IllegalArgumentException("Invalid command: " + command);
            }
        }
    }

    private void turnLeft() {
        direction = direction.turnLeft();
    }

    private void turnRight() {
        direction = direction.turnRight();
    }

    private void moveForward() {
        int newX = x;
        int newY = y;

        switch (direction) {
            case N: newY++; break;
            case E: newX++; break;
            case S: newY--; break;
            case W: newX--; break;
        }

        if (plateau.isWithinBounds(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public String getPosition() {
        return String.format("%d %d %s", x, y, direction);
    }

}
