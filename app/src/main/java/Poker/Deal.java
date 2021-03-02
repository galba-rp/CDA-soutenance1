package Poker;

import java.util.ArrayList;

public class Deal extends Deck{
    private static  String hand;
    private static ArrayList<Card> deck;


    public Deal(){
        //this.numberOfPlayers = Player.getPlayers().size();
        //this.hands = dealCards();
        this.deck = createDeck();
        this.hand = formHand();

    }

    private static String formHand(){
        String s = "";
        for(int j = 0; j < 5; j++){
            s = s +  deck.get(j).value + deck.get(j).color + " ";
        }
        return s;
    }

    public static String getHand() {
        return hand;
    }
}
