package com.peirr.poker.hands;

import com.peirr.poker.models.Card;

/**
 * Created by kurt on 2016/02/08.
 * Command Pattern for evaluating the category of a hand
 */
public interface HandEvaluator {

    HandCategory handCategory(Card[] hand);
    int handRank(Card[] hand);

}
