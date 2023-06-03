package model.impl;

import model.Hand;
import model.PokerHandComparatorResult;
import model.PokerHandComparator;

public class PokerHandFlushComparator implements PokerHandComparator {

    @Override
    public PokerHandComparatorResult compare(Hand firstHand, Hand secondHand) {


        return getPokerHandResultByHighestHandValue(firstHand, secondHand);
    }

}
