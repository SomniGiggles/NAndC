package noughtsandcrosses;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class MainTest extends TestCase {

    private Main main;

    @Before
    public void setUp() {
        main = new Main();
    }

    @Test
    public void testNotStarted() {
        main.runBoard("_________");
        assertEquals(Main.BoardState.NOT_STARTED, main.getState());
    }

    @Test
    public void testInProgress1() {
        main.runBoard("_____XO__");
        assertEquals(Main.BoardState.IN_PROGRESS, main.getState());
    }

    @Test
    public void testInProgress2() {
        main.runBoard("XOXXO_O_X");
        assertEquals(Main.BoardState.IN_PROGRESS, main.getState());
    }

    @Test
    public void testInProgress3() {
        main.runBoard("X__XO____");
        assertEquals(Main.BoardState.IN_PROGRESS, main.getState());
    }

    @Test
    public void testCrossesWins1() {
        main.runBoard("XOO_X_OXX");
        assertEquals(Main.BoardState.CROSSES_WIN, main.getState());
    }

    @Test
    public void testCrossesWins2() {
        main.runBoard("XXX___OO_");
        assertEquals(Main.BoardState.CROSSES_WIN, main.getState());
    }

    @Test
    public void testCrossesWins3() {
        main.runBoard("XOXOX_X_O");
        assertEquals(Main.BoardState.CROSSES_WIN, main.getState());
    }

    @Test
    public void testNoughtsWins1() {
        main.runBoard("X_OXO_O_X");
        assertEquals(Main.BoardState.NOUGHTS_WIN, main.getState());
    }

    @Test
    public void testNoughtsWins2() {
        main.runBoard("OOOX__XX_");
        assertEquals(Main.BoardState.NOUGHTS_WIN, main.getState());
    }

    @Test
    public void testNoughtsWins3() {
        main.runBoard("XOXXO__OX");
        assertEquals(Main.BoardState.NOUGHTS_WIN, main.getState());
    }

    @Test
    public void testDraw() {
        main.runBoard("OOXXXOOXX");
        assertEquals(Main.BoardState.DRAW, main.getState());
    }

    @Test
    public void testInputErrorLengthLong() {
        main.runBoard("OOXXXOOXX_X");
        assertEquals(Main.BoardState.INCORRECT_INPUT, main.getState());
    }

    @Test
    public void testInputErrorLengthShort() {
        main.runBoard("O___OOXX");
        assertEquals(Main.BoardState.INCORRECT_INPUT, main.getState());
    }

    @Test
    public void testInputErrorInputWrong1() {
        main.runBoard("o_xxx_oox");
        assertEquals(Main.BoardState.INCORRECT_INPUT, main.getState());
    }

    @Test
    public void testInputErrorInputWrong2() {
        main.runBoard("0_XXX_00X");
        assertEquals(Main.BoardState.INCORRECT_INPUT, main.getState());
    }

    @Test
    public void testInputErrorInputWrong3() {
        main.runBoard("O-XXX-OOX");
        assertEquals(Main.BoardState.INCORRECT_INPUT, main.getState());
    }

    @Test
    public void testInputErrorInputWrong4() {
        main.runBoard("X-OOO-XXO");
        assertEquals(Main.BoardState.INCORRECT_INPUT, main.getState());
    }
}