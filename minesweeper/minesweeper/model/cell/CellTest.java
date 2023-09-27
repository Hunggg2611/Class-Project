package minesweeper.model.cell;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import minesweeper.model.location.Location;

@Testable
public class CellTest {
    @Test
    public void inti() {
        //setup & invoke & assert
        new Cell("2", new Location(3,2));
        new Cell("2", new Location(1,2));
    
    }

    @Test
    public void isNextTo() {
        //setup
        Cell a_cell = new Cell("2", new Location(3,2));
        Cell b_cell = new Cell("2", new Location(1,2));
        //invoke
        Location loc = new Location (1,1);
        //assert
        assertFalse(a_cell.isNextTo(loc));
        assertTrue(b_cell.isNextTo(loc));
    }

    @Test
    public void print() {
        //setup
        Cell b_cell = new Cell("2", new Location(1,2));
        //invoke
        b_cell.val("3");
        //assert
        assertEquals("-", b_cell.toString());
    }

    @Test
    public void isCovered() {
        //setup
        Cell b_cell = new Cell("2", new Location(1,2));
        //invoke
        b_cell.val("3");
        //assert
        assertTrue(b_cell.isCovered());
    }

    @Test
    public void reveal() {
        //setup
        Cell b_cell = new Cell("2", new Location(1,2));
        //invoke
        b_cell.val("3");
        //assert
        assertEquals("-", b_cell.toString());
        b_cell.reveal();
        assertEquals("3", b_cell.toString());
    }
    
}
