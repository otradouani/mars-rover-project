package rover;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoverTest {

    @Test
    public void roverMovementExample1Test() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Direction.N, plateau);
        rover.processCommands("LMLMLMLMM");
        assertEquals("1 3 N", rover.getPosition());
    }

    @Test
    public void roverMovementExample2Test() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(3, 3, Direction.E, plateau);
        rover.processCommands("MMRMMRMRRM");
        assertEquals("5 1 E", rover.getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCommandTest() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 1, Direction.N, plateau);
        rover.processCommands("X");
    }

    @Test
    public void boundaryConditionTest() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(5, 5, Direction.N, plateau);
        rover.processCommands("M");
        assertEquals("5 5 N", rover.getPosition());
    }
}
