package tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTicTacToe implements CommandLineRunner {

    @Autowired
    private Game game;

    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(SpringTicTacToe.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (game.solveNextTurn());

    }
}