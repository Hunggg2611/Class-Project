package minesweeper.model.exception;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class MineCountExceptionTest {
    @Test
    public void isSubclassException() throws MineCountException {
        //setup
        Exception exc = new MineCountException("Vaild Exception");
        //invoke
        String expected_msg = "Vaild Exception";
        String actual_msg = exc.getMessage();
        //assert
        assertEquals(expected_msg, actual_msg);
    }
}
