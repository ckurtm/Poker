package com.peirr.poker;

import com.peirr.poker.deck.CardShuffler;
import com.peirr.poker.deck.TwoRandomSwapCardShuffler;
import com.peirr.poker.deck.FiveHandDeckRepository;
import com.peirr.poker.hands.HandCategory;
import com.peirr.poker.hands.HandEvaluator;
import com.peirr.poker.models.Card;
import com.peirr.poker.models.Deck;
import com.peirr.poker.hands.variant.FiveHandEvaluator;

/**
 * Created by kurt on 2016/02/08.
 * This is the main entry of the app
 */
public class Dealer implements DealerContract.View {

    boolean DEBUG = false;

    public static void main(String[] args) {
        Dealer dealer = new Dealer();

        //The card shuffling algorithm, you can inject your own by implementing a CardShuffler class
        CardShuffler shuffler = new TwoRandomSwapCardShuffler();

        //The repository handles issues of fetching the deck , shuffling & dealing cards
        FiveHandDeckRepository repository = new FiveHandDeckRepository(shuffler);

        //This handles the card ranking and category evaluation you would replace this to say implement Badugi
        HandEvaluator handEvaluator = new FiveHandEvaluator();

        //The presenter handles the actual logic of the app and deals with calls between the View and the data layer
        DealerPresenter presenter = new DealerPresenter(repository, dealer, handEvaluator);

        //Shuffle the cards based on rules from the implementing CardShuffler class
        presenter.shuffle();

        //Deal the hands based on rules from the implementing DeckRepository class
        presenter.dealHand();
    }

    @Override
    public void showLoadingDeck(boolean show) {
        if (!DEBUG) {
            return;
        }
        if (show) {
            System.out.println("loading card deck...");
        } else {
            System.out.println("done loading Deck.");
        }
    }

    @Override
    public void showLoadingDeckError(boolean show, String message) {
        if (!DEBUG) {
            return;
        }
        if (show) {
            System.out.println("DECK LOADING ERROR: " + message);
        }
    }

    @Override
    public void showShuffling(boolean show) {
        if (show) {
            System.out.println("Shuffling ... Shuffling ... Shuffling ...\n");
        }
    }

    @Override
    public void showShufflingError(boolean show, String message) {
        if (!DEBUG) {
            return;
        }
        if (show) {
            System.out.println("SHUFFLING ERROR: " + message);
        }
    }

    @Override
    public void showDealingHand(boolean show) {
        if (!DEBUG) {
            return;
        }
        if (show) {
            System.out.println("dealing hand...");
        }
    }

    @Override
    public void showDealingHandError(boolean show, String message) {
        if (!DEBUG) {
            return;
        }
        if (show) {
            System.out.println("DEALING HAND ERROR: " + message);
        }
    }

    @Override
    public void showDealtHand(Card[] hand, HandCategory category) {
        Deck.printHand(hand);
        Deck.printCategory(category);
        System.out.println("");
    }


}
