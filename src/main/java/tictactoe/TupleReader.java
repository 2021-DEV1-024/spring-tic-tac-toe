package tictactoe;

import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.IOException;

public class TupleReader {
    private BufferedReader buffer;
    public TupleReader(BufferedReader buffer) {
        this.buffer = buffer;
    }

    String[] getTuples() {
        return getCandidate(readTuples());
    }

    private String readTuples() {
        String s;
        do {
            s = readLine();
        } while (isTuple(s) == false);
        return s;
    }


    private String readLine() {
        String s;
        try {
            s = buffer.readLine();
        } catch (IOException e) {
            s = "";
        }
        return s;
    }

    private boolean isTuple(String strToCheck) {
            try {
                String[] candidateToCheck = this.getCandidate(strToCheck);
                if(candidateToCheck.length !=3) return false;
                int x = Integer.parseInt(candidateToCheck[0]);
                int y = Integer.parseInt(candidateToCheck[2]);

            } catch( NumberFormatException e ) {
                return false;
            }
        return true;
    }

    public String[] getCandidate(String str) {
        String[] candidate = split(str);
        return candidate;
    }

    private String[] split(String strToCheck) {
        String regex = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";
        return  strToCheck.split(regex);
    }
}
