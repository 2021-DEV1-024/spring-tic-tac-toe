package tictactoe;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Test_Game {

    public static List<Player> createMockPlayersRegister() {
        Player uno = new Player("UNO", Player.IS_X);
        Player bob = new Player("Bob", Player.IS_O);
        List<Player> register = new ArrayList<>();
        register.add(uno);
        register.add(bob);
        return register;
    }


    @Test(expected = Test.None.class /* no exception expected */)
    public void  testBuildGame() throws Exception {
        CheckerBoard checker = new CheckerBoard(3);
        Game g = new Game(createMockPlayersRegister(), checker);
    }

    @Test
    public void testGameWithNoWinner() {
        try {

            CheckerBoard checker = new CheckerBoard(3);
            checker.put(0,0, 'X');
            Game g = new Game(createMockPlayersRegister(), checker);
            assertThat(g.isWinner()).isFalse();

        } catch (Exception e ) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testGameWithWinner() {
        try {
            CheckerBoard checker = new CheckerBoard(3);
            checker.put(0,0, 'X');
            checker.put(1,1, 'X');
            checker.put(2,2, 'X');
            Game g = new Game(createMockPlayersRegister(), checker);
            assertThat(g.isWinner()).isTrue();

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
