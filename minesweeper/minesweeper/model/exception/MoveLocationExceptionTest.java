package minesweeper.model.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class MoveLocationExceptionTest {
    @Test
    public void isSubclassException() throws MoveLocationException {
        //setup
        Exception exc = new MoveLocationException("Vaild Exception");
        //invoke
        String expected_msg = "Vaild Exception";
        String actual_msg = exc.getMessage();
        //assert
        assertEquals(expected_msg, actual_msg);
    }
}
