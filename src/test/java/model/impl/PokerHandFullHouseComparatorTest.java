package model.impl;

import model.Hand;
import model.HandValue;
import model.PokerHandComparatorResult;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerHandFullHouseComparatorTest {

    PokerHandFullHouseComparator pokerHandFullHouseComparator = new PokerHandFullHouseComparator();

    @Test
    void compareShouldReturnFirstHandWithHighValue() {
        final Hand firstHand = new Hand("4H 4D 4S 5C 5D", "Black");
        final Hand secondHand = new Hand("2H 2D 2S 5C 5D", "White");
        PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, Collections.singletonList(HandValue.FOUR));
        assertEquals(expected, pokerHandFullHouseComparator.compare(firstHand, secondHand));
    }

    @Test
    void compareShouldReturnSecondHandWithHighValue() {
        final Hand firstHand = new Hand("2H 2D 2S 5C 5D", "Black");
        final Hand secondHand = new Hand("4H 4D 4S 5C 5D", "White");
        PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, Collections.singletonList(HandValue.FOUR));
        assertEquals(expected, pokerHandFullHouseComparator.compare(firstHand, secondHand));
    }
}