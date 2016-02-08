package com.peirr.poker.deck;

import com.peirr.poker.models.Card;
import com.peirr.poker.models.Deck;

/**
 * Created by kurt on 2016/02/08.
 * A Five hand card repository
 */
public class FiveHandDeckRepository implements DeckRepository {

    private final int NCARDS = 52;
    private Deck deck;
    private final CardShuffler shuffler;
    private final int HAND_SIZE = 5;

    public FiveHandDeckRepository(CardShuffler shuffler) {
        this.shuffler = shuffler;
    }

    @Override
    public void loadDeck(OnDeckLoadCallback callback) {
        deck = new Deck();
        Card[] cards = new Card[ NCARDS ];
        int i = 0;

        for ( int suit = Card.DIAMOND; suit <= Card.SPADE; suit++ ) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[i++] = new Card(suit, rank);
            }
        }

        deck.setDeckOfCards(cards);
        deck.setCurrentCard(0);

        if (callback != null) {
            callback.onDeckLoaded(deck,null);
        }
    }

    @Override
    public void shuffleCards(Card[] cards, OnCardsShuffledCallback callback) {
        try {
            shuffler.shuffle(cards);
            if (callback != null) {
                callback.onCardsShuffled(cards,null);
            }
        } catch (Exception e) {
            if (callback != null) {
                callback.onCardsShuffled(cards,e);
            }
        }
    }


    @Override
    public void dealHand(OnDealHandCallback callback) {
        Card[] hand = new Card[HAND_SIZE];
        for(int i = 0;i<HAND_SIZE;i++){
            hand[i] = deck.deal(NCARDS);
            if(hand[i] == null){
                if (callback != null) {
                    callback.onHandDealt(hand,new Exception("Out of Cards"));
                }
                return;
            }
        }
        if (callback != null) {
            callback.onHandDealt(hand,null);
        }
    }
}
