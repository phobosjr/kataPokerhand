package model.impl;

import model.Hand;
import model.HandValue;
import model.PokerHandComparatorResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class PokerHandStraightFlushComparatorTest {

    final PokerHandStraightFlushComparator pokerHandStraightFlushComparator = new PokerHandStraightFlushComparator();

    @Test
    void shouldReturnFirstHandWithHighestValue() {
        final Hand firstHand = new Hand("3H 4H 5H 6H 7H", "Black");
        final Hand secondHand = new Hand("2S 3S 4S 5S 6S", "Black");

        PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, Collections.singletonList(HandValue.SEVEN));

        Assertions.assertEquals(expected, pokerHandStraightFlushComparator.compare(firstHand, secondHand));
    }

    @Test
    void shouldReturnSecondHandWithHighestValue() {
        final Hand firstHand = new Hand("2S 3S 4S 5S 6S", "Black");
        final Hand secondHand = new Hand("3H 4H 5H 6H 7H", "Black");

        PokerHandComparatorResult expected = new PokerHandComparatorResult(secondHand, Collections.singletonList(HandValue.SEVEN));

        Assertions.assertEquals(expected, pokerHandStraightFlushComparator.compare(firstHand, secondHand));
    }
}