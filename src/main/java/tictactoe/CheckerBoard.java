package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckerBoard {
    private static final int MIN_CHECKERBOARD_S = 3;
    private static final int MAX_CHECKERBOARD_S = 9;

    private static final String  SIZE_IS_INVALID = "Board size is not valid";
    private static final String INVALID_POSITION = "Position is not valid";
    Character[][] checker;

    public CheckerBoard(int size) throws Exception {
        if( size < MIN_CHECKERBOARD_S || size > MAX_CHECKERBOARD_S ) {
            throw new Exception(SIZE_IS_INVALID);
        }

        checker = new Character[size][size];

        // initialize checker game
        for (int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                checker[i][j] = ' ';
            }
        }
    }

    public int getSize() {
        return this.checker.length;
    }
    Character getC(int x, int y) {
        return this.checker[x][y];
    }


    final public void put(int x, int y, Character mark) throws Exception {
        if (x < 0 || x >= checker.length) {
            throw new Exception(INVALID_POSITION);
        }

        if (y < 0 || y >= checker.length) {
            throw new Exception(INVALID_POSITION);
        }

        if (checker[x][y] != ' ') {
            throw new Exception(INVALID_POSITION);
        }

        checker[x][y] = mark;
    }


    public boolean isBoardFull() {
    // check for a cell that contains ' '

        for(int i=0;i<checker.length; i++) {

            List<Character> r = (List<Character>) Arrays.stream(checker[i])
                    .filter(cell -> (' ' == cell))
                    .collect(Collectors.toList());


            if(r.isEmpty() == false) return false;
        }

        return true;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Checker Board Status:     -----    \n");
        for (Character[] characters : checker) {
            sb.append('|');
            for (Character character : characters) {
                sb.append(String.valueOf(character)).append('|');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
