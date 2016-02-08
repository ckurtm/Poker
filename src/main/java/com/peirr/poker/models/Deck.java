package com.peirr.poker.models;

import com.peirr.poker.hands.HandCategory;

/**
 * Created by kurt on 2016/02/08.
 */

/* -----------------------------------------------------
   Deck: a deck of cards
   ----------------------------------------------------- */

public class Deck {

    private Card[] deckOfCards;         // Contains all 52 cards
    private int currentCard;            // deal THIS card in deck

    public Card[] getDeck() {
        return deckOfCards;
    }

    public void setCurrentCard(int currentCard) {
        this.currentCard = currentCard;
    }

    public void setDeckOfCards(Card[] deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    /* -------------------------------------------
               deal(): deal deckOfCards[currentCard] out
               ------------------------------------------- */
    public Card deal(int maxCards) {
        if ( currentCard < maxCards ) {
            return ( deckOfCards[ currentCard++ ] );
        } else {
            System.out.println("Out of cards error");
            return ( null );  // Error;
        }
    }

    public String toString() {
        String s = "";
        int k;

        k = 0;
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 1; j <= 13; j++ )
                s += (deckOfCards[k++] + " ");

            s += "\n";
        }
        return ( s );
    }


    public static void printHand(Card[] hand){
        StringBuffer buffer = new StringBuffer();
        for ( int i = 0; i < 5; i++ ) {
            buffer.append(hand[i]).append(" ");
        }
        System.out.println("Your Hand: " + buffer.toString());
    }


    public static void printCategory(HandCategory category) {
        System.out.println("You Have: " +  category.getDescription());
    }


}