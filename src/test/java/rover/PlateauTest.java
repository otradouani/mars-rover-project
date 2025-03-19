package rover;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlateauTest {

    @Test
    public void withinBoundsTest() {
        Plateau plateau = new Plateau(5, 5);
        assertTrue(plateau.isWithinBounds(0, 0));
        assertTrue(plateau.isWithinBounds(3, 3));
        assertTrue(plateau.isWithinBounds(5, 5));
    }

    @Test
    public void outOfBoundsTest() {
        Plateau plateau = new Plateau(5, 5);
        assertFalse(plateau.isWithinBounds(6, 3));
        assertFalse(plateau.isWithinBounds(3, 6));
        assertFalse(plateau.isWithinBounds(-1, 0));
        assertFalse(plateau.isWithinBounds(0, -1));
    }
}
