package com.peirr.poker.deck;

import com.peirr.poker.models.Card;

/**
 * Created by kurt on 2016/02/08.
 * Command Pattern for shuffling cards.
 */
public interface CardShuffler {
    void shuffle(Card[] cards);
}
