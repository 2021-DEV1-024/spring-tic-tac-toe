package tictactoe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class Test_BufferedReaderForTuple {
    @Mock
    private BufferedReader bufferedReader;

    @Test
    public void bufferedReaderTuple() throws IOException {
        String tupleStr = "1,2";
        Mockito.when(bufferedReader.readLine()).thenReturn(tupleStr);
        TupleReader tupleReader = new TupleReader(bufferedReader);
        String[] expected = {"1",",","2"};
        assertThat(tupleReader.getTuples()).isEqualTo(expected);
    }
}