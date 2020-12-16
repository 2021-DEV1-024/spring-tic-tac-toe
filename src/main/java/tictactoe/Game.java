package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Game {

    private CheckerBoard checker;
    private List<Player> playersRegister;
    private TupleReader reader;
    private int currentPlayerIdx;
    private int turn = 0;

    public Game(List<Player> playersRegister, CheckerBoard checker, TupleReader reader) {
        this.playersRegister = playersRegister;
        this.checker = checker;
        this.reader = reader;
        this.currentPlayerIdx = 0;
    }


    public boolean solveNextTurn() {
        // if there is a winner
        // if the board is full
        this.log("Turn #"+ turn + "Next Player " + getCurrentPlayer().getName());
        List<Character> marks = Arrays.asList('X', 'O');
        try {
            // read tuple
            String[] tuples = this.reader.getTuples();
            int x = Integer.parseInt(tuples[0]);
            int y = Integer.parseInt(tuples[2]);


            this.checker.put(x, y, marks.get(currentPlayerIdx));
        } catch(RuntimeException e) {
           System.out.println(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();

        }

        this.turn++;


        this.switchToNextPlayer();

        log(""+this.isWinner());
        log(""+this.checker.isBoardFull());


        if(this.isWinner() || this.checker.isBoardFull()) {
            log("Winner!");
            return false;
        } else
        {
          return true;
        }

    }

    public void log(String message) {
        System.out.println(message);
    }

    public Player getCurrentPlayer() {
        return this.playersRegister.get(currentPlayerIdx);
    }

    private void switchToNextPlayer() {

        if(currentPlayerIdx == 0) {
            this.currentPlayerIdx = 1;
        } else {
            this.currentPlayerIdx = 0;
        }
    }

    public boolean isWinner() {
        // requires this.checker is not null
        Objects.requireNonNull(this.checker);
        return (this._solverRow() || this._solverCol() || this._solverDiag0()|| this._solverDiag1());
    }

    private boolean _solverRow() {
        //  (i,0) row
        int n = this.checker.getSize() - 1;

        for(int i=0;i<=n;i++) {
            Character baseC= this.checker.getC(i, 0);
            for (int j=0;j<=n;j++) {
               Character cellToSolve = this.checker.getC(i, j);
               if(cellToSolve!=baseC || cellToSolve == ' ') {
                   // not or not yet won exit
                   break;
               }

               // if j equal total number of rows, we checked all: Winner
               if(j == n) {
                   return true;
               }
            }
        }

        return false;
    }


    private boolean _solverCol(){
        //  (0,i) column
        int n = this.checker.getSize() - 1;
        for(int i=0;i<=n;i++) {
            Character baseC= this.checker.getC(0, i);
            for (int j=0;j<=n;j++) {
                Character cellToSolve = this.checker.getC(j, i);
                if(cellToSolve!=baseC || cellToSolve == ' ') {
                    // not or not yet won exit
                    break;
                }

                // if j equal total number of cols, we checked all: Winner
                if(j == n) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean _solverDiag0() {
        int n = this.checker.getSize() - 1;
        char cell0 = this.checker.getC(0, 0);
        for (int i=0;i<=n;i++) {
            Character cellToSolve = this.checker.getC(i, i);
            if(cellToSolve!=cell0 || cellToSolve == ' ') {
                // not or not yet won exit
                break;
            }

            if(i == n) {
                return true;
            }
        }
        return false;
    }

    private boolean _solverDiag1() {
        int n = this.checker.getSize() - 1;
        char last  = this.checker.getC(0, n);
        for (int i=0;i<=n;i++) {
            int rewd = n-i;
            Character cellToSolve = this.checker.getC(i, rewd);
            if(cellToSolve!=last || cellToSolve == ' ') {
                // not or not yet won exit
                break;
            }

            if(i == n) {
                return true;
            }
        }
        return false;
    }
}
