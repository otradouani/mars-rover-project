package rover;

import static org.junit.Assert.*;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void turnLeftTest() {
        assertEquals(Direction.W, Direction.N.turnLeft());
        assertEquals(Direction.S, Direction.W.turnLeft());
        assertEquals(Direction.E, Direction.S.turnLeft());
        assertEquals(Direction.N, Direction.E.turnLeft());
    }

    @Test
    public void turnRightTest() {
        assertEquals(Direction.E, Direction.N.turnRight());
        assertEquals(Direction.S, Direction.E.turnRight());
        assertEquals(Direction.W, Direction.S.turnRight());
        assertEquals(Direction.N, Direction.W.turnRight());
    }
}
