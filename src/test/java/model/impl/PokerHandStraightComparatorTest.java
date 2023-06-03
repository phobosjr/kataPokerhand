package model.impl;

import model.Hand;
import model.HandValue;
import model.PokerHandComparatorResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class PokerHandStraightComparatorTest {

    final PokerHandStraightComparator pokerHandStraightComparator = new PokerHandStraightComparator();

    @Test
    void shouldReturnFirstHandWinWithHighValue() {
        final Hand firstHand = new Hand("3H 4C 5S 6D 7D", "Black");
        final Hand secondHand = new Hand("2H 3C 4S 5D 6D", "White");
        PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, Collections.singletonList(HandValue.SEVEN));


        Assertions.assertEquals(expected, pokerHandStraightComparator.compare(firstHand, secondHand));
    }

    @Test
    void shouldReturnSecondHandWinWithHighValue() {
        final Hand firstHand = new Hand("2H 3C 4S 5D 6D", "Black");
        final Hand secondHand = new Hand("3H 4C 5S 6D 7D", "White");

        PokerHandComparatorResult expected = new PokerHandComparatorResult(secondHand, Collections.singletonList(HandValue.SEVEN));

        Assertions.assertEquals(expected, pokerHandStraightComparator.compare(firstHand, secondHand));
    }

    @Test
    void shouldReturnEmptyWhenItEquals() {
        final Hand firstHand = new Hand("2H 3C 4S 5D 6D", "Black");
        final Hand secondHand = new Hand("2C 3H 4D 5S 6S", "White");


        Assertions.assertEquals(new PokerHandComparatorResult(), pokerHandStraightComparator.compare(firstHand, secondHand));
    }
}