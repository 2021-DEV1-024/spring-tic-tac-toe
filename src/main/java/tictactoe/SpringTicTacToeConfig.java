package tictactoe;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class SpringTicTacToeConfig {
    @Bean
    TupleReader tupleReader() {
        return new TupleReader(new BufferedReader(new InputStreamReader(System.in)));
    }
}
