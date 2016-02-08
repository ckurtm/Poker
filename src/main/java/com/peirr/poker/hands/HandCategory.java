package com.peirr.poker.hands;

/**
 * Created by kurt on 2016/02/08.
 */
public enum HandCategory {

    HIGH_CARD("High card"),
    ONE_PAIR("One pair"),
    TWO_PAIR("Two pair"),
    THREE_OF_A_KIND("Three of a kind"),
    STRAIGHT("Straight"),
    FLUSH("Flush"),
    FULL_HOUSE("Full house"),
    FOUR_OF_A_KIND("Four of a kind"),
    STRAIGHT_FLUSH("Straight flush");

    private String description;

    private HandCategory(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
