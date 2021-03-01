package Soutenance1;

import Poker.Combo;
import Poker.Deal;

public class Pokrand extends Ptimos{

    Pokrand(){
        super();
        this.stress = stressLevel();
        this.dominance = dominanceLevel();
    }

    // Generating stress level of less then 65 in 75% of cases.
    // Percentage can be adjusted in probability function
    public int stressLevel(){
        if(Helpers.probabilityHigh() == 1){
            return Helpers.randomValue(50, 65);
        } else return Helpers.randomValue(70, 81);
    }

    // Generating dominance level of more then 75 in 75% of cases.
    // Percentage can be adjusted in probability function
    public int dominanceLevel(){
        if(Helpers.probabilityHigh() == 1){
            return Helpers.randomValue(75, 81);
        } else return Helpers.randomValue(50, 65);
    }

    // reduces player's life
//TODO add messages with cardds and result
    public static void magic(Player p, Ptimos ptimos){
        Deal deal = new Deal();
        String hand = deal.getHand();
        Combo hand1 = new Combo(hand);
        String result = hand1.getHighestCombo();
        switch (result){
            case "brelan":
            case "quinte flush":
            case "flush":
                CliMessages.pokerandEscapes();
                Game.startGame();
                break;
            case "paire":
            case "double paire":
                Ptimos.magic(p, ptimos);
                break;
            case "carte haute":
                ptimos.reduceDominance(10);
                break;
            default:
                CliMessages.pokerandWins();
                Game.startGame();
        }
    }

    private static void cardsResultReaction(){


    }
}
