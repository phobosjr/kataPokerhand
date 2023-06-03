package model.impl;

import model.*;

public class PokerHandStraightFlushComparator implements PokerHandComparator {
    @Override
    public PokerHandComparatorResult compare(Hand firstHand, Hand secondHand) {

        return getPokerHandResultByHighestHandValue(firstHand, secondHand);
    }
}
