package tictactoe;

import java.util.List;
import java.util.Objects;

public class Game {

    private CheckerBoard checker;
    private List<Player> playersRegister;

    public Game(List<Player> playersRegister, CheckerBoard checker) {
        this.playersRegister = playersRegister;
        this.checker = checker;
    }

    public void log(String message) {
        System.out.println(message);
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
