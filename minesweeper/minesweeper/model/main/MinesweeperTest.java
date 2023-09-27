package minesweeper.model.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import minesweeper.model.exception.MineCountException;
import minesweeper.model.state.GameState;
 
@Testable
public class MinesweeperTest {
    @Test
    public void inti() throws MineCountException {
        //setup & invoke & assert
        Minesweeper msc_1 = new Minesweeper(15,12,1);
        Minesweeper msc_2 = new Minesweeper(9,18,1);
        //assert
        assertEquals(msc_1.size(), 180);
        assertEquals(msc_2.size(), 162);
        assertEquals(msc_1.getGameState(), GameState.NOT_STARTED);
        assertEquals(msc_1.getMoveCount(),0);
    }

    @Test
    public void move() {
        
    }
}
