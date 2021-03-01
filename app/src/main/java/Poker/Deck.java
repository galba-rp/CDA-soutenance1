
package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    final static int NBR_OF_CARDS = 52;
    ArrayList<Card> deck;
    String[] cards;

    protected Deck() {
        this.cards = new String[]{"A", "K","Q", "J","T", "9","8", "7","6", "5","4", "3","2"};
        createDeck();
    }

    public ArrayList<Card> createDeck() {
        this.deck = new ArrayList<Card>();
        int i = 0;
        while (i < Suits.values().length){
            int j = 0;
            while (j < cards.length) {
                this.deck.add(new Card(cards[j], Suits.getSuitLetters()[i]));
                j++;
            }
            i++;
        }
        Collections.shuffle(this.deck);
        return this.deck;
    }
}
