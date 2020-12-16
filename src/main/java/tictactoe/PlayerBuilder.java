package tictactoe;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerBuilder {

    private Player build(String withName, Character withMark) {
        return new Player(withName, withMark);
    }

    public List<Player> buildAll() {
        Player p1 = new Player("JAN", Player.IS_X);
        Player p2 = new Player("BOB", Player.IS_O);
        List<Player> register = new ArrayList<>();
        register.add(p1);
        register.add(p2);

        return register;
    }
}
