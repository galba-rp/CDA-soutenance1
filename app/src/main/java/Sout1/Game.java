package Sout1;

import java.util.Scanner;

public class Game {
    Player player;
    Ptimos ptimos;
    Scanner input = new Scanner(System.in);



    public Game() {
        this.player = chooseName();
        startGame();
    }


    private Player chooseName(){
        CliMessages.hello();
        String s1 = input.nextLine();
        return new Player(s1);
    }

    private void startGame(){

        System.out.println("choose your player's name");
    }
}
