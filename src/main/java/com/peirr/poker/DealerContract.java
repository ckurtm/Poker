package com.peirr.poker;

import com.peirr.poker.models.Card;
import com.peirr.poker.hands.HandCategory;

/**
 * Created by kurt on 2016/02/08.
 * This has the Contract between the UI and the presenter. its MVP architecture blueprint for the Dealer
 */
public interface DealerContract {

    /**
     * This is what gets reported to the view / whoever is listening for events
     */
    interface View {
        void showLoadingDeck(boolean show); // we dont know how efficient or where we are loading the deck from, so this will handle deck loading progress to UI
        void showLoadingDeckError(boolean show,String message); // if we fail to load a deck for a reason this notifies the VIEW layer
        void showShuffling(boolean show); // notify the view layer that we are shuffling the cards, might be slow depending on the CardShuffler implementation
        void showShufflingError(boolean show,String message); // if we encounter an error while shufflling or to clear one
        void showDealingHand(boolean show); // dealing card progress indicator
        void showDealingHandError(boolean show,String message); // if dealing cards encounters an error e.g. you try to deal more than the available cards
        void showDealtHand(Card[] hand, HandCategory category); // shows you the dealt cards hand
    }

    /**
     * These are the actions that the Presenter / UI can invoke the app to do
     */
    interface Actions {
        void shuffle(); // requests to shuffle the cards in repo
        void dealHand(); // requests to deal cards from repo
    }
}
