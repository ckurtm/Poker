package com.peirr.poker;

import com.peirr.poker.deck.DeckRepository;
import com.peirr.poker.hands.HandEvaluator;
import com.peirr.poker.models.Card;
import com.peirr.poker.models.Deck;

/**
 * Created by kurt on 2016/02/08.
 */
public class DealerPresenter implements DealerContract.Actions {

    private final DeckRepository cardRepository;
    private final DealerContract.View view;
    private final HandEvaluator handEvaluator;

    private Deck cardDeck;

    public DealerPresenter(final DeckRepository cardRepository, final DealerContract.View view, final HandEvaluator handEvaluator) {
        this.cardRepository = cardRepository;
        this.view = view;
        this.handEvaluator = handEvaluator;
        view.showLoadingDeck(true);
        cardRepository.loadDeck(new DeckRepository.OnDeckLoadCallback() {
            @Override
            public void onDeckLoaded(Deck deck, Exception e) {
                view.showLoadingDeck(false);
                if (e != null) {
                    view.showLoadingDeckError(true,e.getMessage());
                }else{
                    view.showLoadingDeckError(false,null);
                    cardDeck = deck;
                }
            }
        });
    }

    @Override
    public void shuffle() {
        if (cardDeck == null) {
            view.showShufflingError(true, "Deck was not loaded, cannot shuffle");
            return;
        }
        view.showShuffling(true);
        cardRepository.shuffleCards(cardDeck.getDeck(), new DeckRepository.OnCardsShuffledCallback() {
            @Override
            public void onCardsShuffled(Card[] cards, Exception e) {
                view.showShuffling(false);
                if (e != null) {
                    view.showShufflingError(true,e.getMessage());
                }else{
                    view.showShufflingError(false,null);
                }
            }
        });
    }

    @Override
    public void dealHand() {
        if (cardDeck == null) {
            view.showDealingHandError(true,"Deck was not loaded, cannot deal");
            return;
        }
        view.showDealingHand(true);
        cardRepository.dealHand(new DeckRepository.OnDealHandCallback() {
            @Override
            public void onHandDealt(Card[] cards, Exception exception) {
                view.showDealingHand(false);
                if (exception != null) {
                    view.showDealingHandError(true,exception.getMessage());
                }else{
                    view.showDealingHandError(false,null);
                    view.showDealtHand(cards, handEvaluator.handCategory(cards));
                }
            }
        });
    }
}
