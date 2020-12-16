package tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Player uno = new Player("JAN", Player.IS_X);
        Player bob = new Player("BOB", Player.IS_O);
        List<Player> register = new ArrayList<>();
        register.add(uno);
        register.add(bob);

        BufferedReader buffer = new BufferedReader( new InputStreamReader(System.in));

        Game game = new Game(register, new CheckerBoard(4), new TupleReader(buffer));

        while (game.solveNextTurn());
    }
}