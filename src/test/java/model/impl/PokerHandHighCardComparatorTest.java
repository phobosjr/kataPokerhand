package model.impl;

import model.Hand;
import model.HandValue;
import model.PokerHandComparatorResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class PokerHandHighCardComparatorTest {


    private final PokerHandHighCardComparator pokerHandHighCardComparator = new PokerHandHighCardComparator();

    @Test
    void shouldReturnFirstHandWithHighestValue() {
        final Hand firstHand = new Hand("2H 5C 6S 9D KD", "Black");
        final Hand secondHand = new Hand("2H 5C 6S 9D TD", "White");
        PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, Collections.singletonList(HandValue.KING));

        Assertions.assertEquals(expected, pokerHandHighCardComparator.compare(firstHand, secondHand));
    }

    @Test
    void shouldReturnSecondHandWithHighestValue() {
        final Hand firstHand = new Hand("2H 5C 6S 9D TD", "Black");
        final Hand secondHand = new Hand("2H 5C 6S 9D KD", "White");
        PokerHandComparatorResult expected = new PokerHandComparatorResult(secondHand, Collections.singletonList(HandValue.KING));

        Assertions.assertEquals(expected, pokerHandHighCardComparator.compare(firstHand, secondHand));
    }

    @Test
    void shouldReturnEmptyWhenItEquals() {
        final Hand firstHand = new Hand("2H 5C 6S 9D TD", "Black");
        final Hand secondHand = new Hand("2H 5C 6S 9D TC", "White");
        PokerHandComparatorResult expected = new PokerHandComparatorResult();

        Assertions.assertEquals(expected, pokerHandHighCardComparator.compare(firstHand, secondHand));
    }
}