package com.peirr.poker.deck;

import com.peirr.poker.models.Card;

/**
 * Created by kurt on 2016/02/08.
 * This has a simple card shuffling algorithm based on swapping 2 random elements 1000 times
 */
public class TwoRandomSwapCardShuffler implements CardShuffler {

    @Override
    public void shuffle(Card[] cards) {
        int i, j, k;
        int cardCount = cards.length;

        for ( k = 0; k < 1000; k++ ) {
            i = (int) ( cardCount * Math.random() );  // Pick 2 random cards
            j = (int) ( cardCount * Math.random() );  // in the deck
	  /* ---------------------------------
	     swap these randomly picked cards
	     --------------------------------- */
            Card tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
    }
}
