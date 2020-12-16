package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Payer {

    @Test
    public void testcheckName() {
        String name = "Bob";
        Player p  = new Player(name, ' ');
        assertThat(p.getName()).isEqualTo("Bob");
    }

    @Test()
    public void testCheckMark() {
        String name = "Bob";
        Player p  = new Player(name, Player.IS_X);
        assertThat(p.getMark()).isEqualTo(Player.IS_X);

    }

}
