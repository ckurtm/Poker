package com.peirr.poker.deck;

import com.peirr.poker.models.Card;
import com.peirr.poker.models.Deck;

/**
 * Created by kurt on 2016/02/08.
 * This handles how we fetch the Deck . it follows the Repository Pattern
 */
public interface DeckRepository {

    /**
     * Callback for when we are done loading a deck of cards
     */
    public interface OnDeckLoadCallback {
        void onDeckLoaded(Deck deck,Exception e);
    }

    /**
     * Callback for when we are done shuffling a deck of cards
     */
    public interface OnCardsShuffledCallback {
        void onCardsShuffled(Card[] cards,Exception e);
    }

    /**
     * Callback for when we are done dealing a hand of cards.
     */
    public interface OnDealHandCallback {
        void onHandDealt(Card[] cards,Exception exception);
    }

    /**
     * load a deck of cards from somewhere
     * @param callback
     */
    void loadDeck(OnDeckLoadCallback callback);

    /**
     * shuffle a deck of cards somehow
     * @param cards
     * @param callback
     */
    void shuffleCards(Card[] cards,OnCardsShuffledCallback callback);

    /**
     * deal some cards somehow
     * @param dealCallback
     */
    void dealHand(OnDealHandCallback dealCallback);
}
