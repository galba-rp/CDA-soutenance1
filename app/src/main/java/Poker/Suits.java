package Poker;

import java.lang.reflect.Array;

public enum Suits {
    CLUBS ("c"),
    HEARTS ("h"),
    SPADES ("s"),
    DIAMONDS ("d");

    private final String suit;

    Suits(String suit) {
        this.suit = suit;
    }

    private static String[] suitLettersToArray(){
        String[]  suitLetters = new String[4];
        suitLetters[0] = Suits.CLUBS.getSuitName();
        suitLetters[1] = Suits.HEARTS.getSuitName();
        suitLetters[2] = Suits.SPADES.getSuitName();
        suitLetters[3] = Suits.DIAMONDS.getSuitName();
        return suitLetters;
    }

    public static String[] getSuitLetters(){
        return suitLettersToArray();
    }

    public String getSuitName(){
        return this.suit;
    }


}
