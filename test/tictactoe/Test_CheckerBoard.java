package tictactoe;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;


public class Test_CheckerBoard {


    @Test(expected = Test.None.class /* no exception expected */)
    public void checkerBoardIsFull() throws Exception {
        int size = 3;
        CheckerBoard checker = new CheckerBoard(3);

        for(int i = 0; i < size; i++) {
            for (int j=0; j < size; j++) {
                checker.put(i,j,'X');
            }
        }

        assertThat(checker.isBoardFull()).isTrue();
    }


    @Test(expected = Test.None.class /* no exception expected */)
    public void checkerBoardIsNotFull() throws Exception {
        int size = 3;
        CheckerBoard checker = new CheckerBoard(3);

        for(int i = 0; i < size; i++) {
                checker.put(i,i,'X');
        }

        assertThat(checker.isBoardFull()).isFalse();
    }



    @Test
    public void ABoardGameTest() {

        Throwable thrown = catchThrowable(() -> {
            CheckerBoard checker;
            checker = new CheckerBoard(9);
            int x=4;
            int y=5;
            checker.put(x, y, 'O');
        });

        assertThat(thrown).isNull();
    }


    @Test
    public void sizeExceptionTest() {
        assertThatThrownBy(() ->  {  CheckerBoard checker = new CheckerBoard(10); }).hasMessageContaining("Board size is not valid");
    }

    @Test
    public void positionYExceptionTest() throws Exception {
       assertThatThrownBy(() ->  {
            CheckerBoard checker = new CheckerBoard(6);
            int x=4;
            int y=6;
            checker.put(x, y, 'X');

        }).hasMessageContaining("Position is not valid");
    }

    @Test
    public void positionXExceptionTest() throws Exception {
        assertThatThrownBy(() ->  {
            CheckerBoard checker = new CheckerBoard(6);
            int y=4;
            int x=6;
            checker.put(x, y, 'X');

        }).hasMessageContaining("Position is not valid");
    }
}