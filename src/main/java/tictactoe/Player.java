package tictactoe;

public class Player {

    public static final Character IS_X= 'X';
    public static final Character IS_O= 'O';

    private String name;
    private Character mark;


    protected Player(String name, Character mark) {
        this.name = name;
        this.mark = mark;
    }


    public Character getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }


}
