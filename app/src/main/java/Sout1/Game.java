package Sout1;

import java.util.Scanner;

public class Game implements CliMessages{
    Player player;
    Ptimos ptimos;
    Scanner input = new Scanner(System.in);
    String s1 = "";
    static int sacbleuCaptured = 0;
    static int pyraliaCaptured = 0;
    static int pokrandCaptured = 0;



    public Game() {
        chooseName();
        startGame();
    }


    private void chooseName(){
        CliMessages.chooseName();
        s1 = input.nextLine();
        player = new Player(s1);
    }

    private void startGame(){
        CliMessages.hello(player);
        this.ptimos = new Sacbleu(); // TODO add factory method
        System.out.println("stress : " + ptimos.stress +", Dominance : " + ptimos.dominance);

        // meeting Ptimos choices
        CliMessages.ptimosToMeet(ptimos);
        s1 = input.nextLine().toLowerCase();
        switch (s1.toLowerCase()){
            case "o":
                CliMessages.playerPtimosInfo(player, ptimos);
                CliMessages.actions(player, ptimos);
                break;
            case "n": startGame();
                break;
            default: CliMessages.bye(player); //TODO add end of game logic
        }


        // interacting with Ptimos
        s1 = input.nextLine();
        switch (s1){
            case "1":
                player.observer(ptimos);
                break;
            default: break;
        }
    }
}
