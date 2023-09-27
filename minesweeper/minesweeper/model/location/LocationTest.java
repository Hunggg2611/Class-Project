package minesweeper.model.location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class LocationTest {

    @Test
    public void getReturnCorrect() {
        //setup
        Location a_loc = new Location(5, 1);
        Location b_loc = new Location(7, 3);
        //invoke
        int a_row = 5; int a_col = 1;
        int b_row = 7; int b_col = 3;
        //assert
        assertEquals(a_row, a_loc.getRow()); assertEquals(a_col, a_loc.getCol());
        assertEquals(b_row, b_loc.getRow()); assertEquals(b_col, b_loc.getCol());
    }

    @Test
    public void hashcodeReturnCorrect() {
        //setup
        Location a_loc = new Location(5, 1);
        Location b_loc = new Location(7, 3);
        Location d_loc = new Location(0, 0);
        //invoke
        int d_loc_hash = 259;
        //assert
        assertNotEquals(a_loc.hashCode(), b_loc.hashCode());
        assertEquals(d_loc_hash, d_loc.hashCode());
    }

    @Test
    public void equalsReturnCorrect() {
        //setup & invoke
        Location a_loc = new Location(5, 1);
        Location c_loc = new Location(5, 1);
        //assert
        assertEquals(a_loc, c_loc);
    }

}
