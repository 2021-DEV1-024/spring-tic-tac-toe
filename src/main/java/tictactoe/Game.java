package tictactoe;

import java.util.List;

public class Game {

    private CheckerBoard checker;
    private List<Player> playersRegister;

    public Game(List<Player> playersRegister, CheckerBoard checker) {
        this.playersRegister = playersRegister;
        this.checker = checker;
    }




    public boolean isWinner() {
        return false;
    }
}
