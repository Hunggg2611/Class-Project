package minesweeper.model.state;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class GameStateTest {
    @Test
    public void hasCorrectPossibleVal() {
        //setup & invoke
        String inprog = GameState.IN_PROGRESS.toString();
        String nt_strtd = GameState.NOT_STARTED.toString();
        String wn = GameState.WON.toString();
        String los = GameState.LOST.toString();
        
        //assert
        assertEquals(wn, "WON"); assertEquals(los, "LOST");
        assertEquals(nt_strtd, "NOT_STARTED"); assertEquals(inprog, "IN_PROGRESS");
    }
}
