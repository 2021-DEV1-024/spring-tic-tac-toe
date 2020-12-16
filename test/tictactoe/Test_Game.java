package tictactoe;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.Silent.class)
public class Test_Game {

    public static List<Player> createMockPlayersRegister() {
        Player uno = new Player("UNO", Player.IS_X);
        Player bob = new Player("Bob", Player.IS_O);
        List<Player> register = new ArrayList<>();
        register.add(uno);
        register.add(bob);
        return register;
    }

    @Mock
    private TupleReader reader;


    @Test(expected = Test.None.class /* no exception expected */)
    public void  testBuildGame() throws Exception {

        Mockito.when(reader.getTuples()).thenReturn(new String[]{"1", "," ,"2"});

        CheckerBoard checker = new CheckerBoard(3);
        Game g = new Game(createMockPlayersRegister(), checker, reader);
    }

    @Test
    public void testGameWithNoWinner() {
        try {

            CheckerBoard checker = new CheckerBoard(3);
            checker.put(0,0, 'X');
            Game g = new Game(createMockPlayersRegister(), checker, reader);
            assertThat(g.isWinner()).isFalse();

        } catch (Exception e ) {
            Assert.fail(e.getMessage());
        }
    }


    private CheckerBoard buildWinCheckerBoard() throws Exception {
        CheckerBoard checker = new CheckerBoard(3);
        checker.put(0,0, 'X');
        checker.put(1,1, 'X');
        checker.put(2,2, 'X');

        return checker;
    }


    @Test
    public void testGameWithWinner() {
        try {

            Game g = new Game(createMockPlayersRegister(), this.buildWinCheckerBoard(), reader);
            assertThat(g.isWinner()).isTrue();

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void nextTurnTrueWhenStart() throws Exception {
        Game g = new Game(createMockPlayersRegister(), new CheckerBoard(3), reader);
        assertThat(g.solveNextTurn()).isTrue();
    }

    @Test
    public void nextTurnFalseWhenWin()  throws Exception {
        Game g = new Game(createMockPlayersRegister(), this.buildWinCheckerBoard(), reader);
        assertThat(g.solveNextTurn()).isFalse();
    }

    @Mock
    private CheckerBoard mockCB;

    @Test
    public void nextTurnFalseWhenBoardIsFull() throws Exception {
        Mockito.when(mockCB.isBoardFull()).thenReturn(true);
        Game g = new Game(createMockPlayersRegister(), mockCB, reader);
        assertThat(g.solveNextTurn()).isFalse();
    }


    @Test
    public void nextTurnnextPlayer() throws Exception {
        Game g = new Game(createMockPlayersRegister(), new CheckerBoard(3), reader);
        assertThat(g.getCurrentPlayer().getName()).isEqualTo("UNO");
        g.solveNextTurn();
        assertThat(g.getCurrentPlayer().getName()).isEqualTo("Bob");
    }
}
