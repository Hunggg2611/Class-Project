package minesweeper.model.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import minesweeper.model.exception.MineCountException;
import minesweeper.model.main.Minesweeper;

@Testable
public class MinesweeperObserverTest {
    @Test
    public void inti() throws MineCountException {
        //setup & invoke
        Minesweeper game = new Minesweeper(10, 10, 2);
        MinesweeperObserver observer = new MinesweeperObserver(game, null);
        //assert
        assertEquals(observer.getClass(), MinesweeperObserver.class);
    }
}
