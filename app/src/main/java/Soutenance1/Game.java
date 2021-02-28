package Soutenance1;

import java.util.Scanner;

public class Game implements CliMessages {
    static Player player;
    static Ptimos ptimos;
    static Scanner input = new Scanner(System.in);
    static String s1 = "";
    static int sacbleuCaptured = 0;
    static int pyraliaCaptured = 0;
    static int pokrandCaptured = 0;



    public Game() {
        chooseName();
        CliMessages.hello(player);
        startGame();
    }


    private static void chooseName(){
        CliMessages.chooseName();
        s1 = input.nextLine();
        player = new Player(s1);
    }

    protected static void startGame(){
        ptimos = PtimosFactory.createPtimos(); // TODO add factory method
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
                reaction(player, ptimos);
                break;
            default: break;
        }
    }

    protected static void reaction(Player p, Ptimos ptimos){
        int d = p.getDistance();
        if(d > 15){
            Ptimos.escape(p, ptimos);
        } else if(d > 10){
            if(ptimos.getStressNum() < 54){
                if(Ptimos.stressDominanceRatio() == "stressed"){
                    if(Helpers.probabilityHigh() == 1){
                        Ptimos.getAway(player);
                    } else {
                        Ptimos.attack(player);
                    }
                }
            }
        }

        /*
        int probability = Helpers.probabilityHigh();
        if(this.stress > this.dominance){
            if(Player.distance > 3 && Player.distance < 10){
                if (probability == 1) {
                    this.rugir();
                } else {
                    this.attaquer();
                }
            }else if(Player.distance < 3){
                if (probability  == 1) {
                    this.attaquer();
                } else {
                    this.rugir();
                }
            } else{
                if (probability == 1) {
                    this.sEloigner();
                } else {
                    this.rugir();
                }
            }
        }else if (this.stress > this.dominance && Player.distance < 3) {
            this.attaquer();
        }else

         */
    }
}

