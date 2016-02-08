package com.peirr.poker.models;

/* -----------------------------------------------------------
   Encoding:

        Suit: 4 = Spade
              3 = Heart
              2 = Club
              1 = Diamond

        Rank:  A = 1
               2 = 2
               ...
               J = 11
               Q = 12
               K = 13

   Card:

         byte cardSuit;                -- contain 1, 2, 3, or 4
         byte cardRank;                -- contain 2, 3, ... 13, 14
   ----------------------------------------------------------- */

public class Card {
    public static final int SPADE = 4;
    public static final int HEART = 3;
    public static final int CLUB = 2;
    public static final int DIAMOND = 1;

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    // * , Diamonds , Club , Heart , Spade
    private static final String[] Suit = {"*", String.valueOf('\u2666'), String.valueOf('\u2663'), String.valueOf('\u2764'), String.valueOf('\u2660')};

    private static final String[] Rank = {"*", "*", "2", "3", "4","5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private byte cardSuit;
    private byte cardRank;

    public Card(int suit, int rank) {
        if (rank == 1)
            cardRank = 14;     // Give Ace the rank 14
        else
            cardRank = (byte) rank;

        cardSuit = (byte) suit;
    }

    public int suit() {
        return (cardSuit);         // This is a shorthand for:
        //   this.cardSuit
    }

    public String suitStr() {
        return (Suit[cardSuit]);  // This is a shorthand for:
        //   this.Suit[ this.cardSuit ]
    }

    public int rank() {
        return (cardRank);
    }



    public String toString() {
        return (Rank[cardRank] + Suit[cardSuit]);
    }
}