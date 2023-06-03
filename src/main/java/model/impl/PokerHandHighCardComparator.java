package model.impl;

import model.*;

public class PokerHandHighCardComparator implements PokerHandComparator {
    @Override
    public PokerHandComparatorResult compare(Hand firstHand, Hand secondHand) {

        return getPokerHandResultByHighestHandValue(firstHand, secondHand);
    }
}
