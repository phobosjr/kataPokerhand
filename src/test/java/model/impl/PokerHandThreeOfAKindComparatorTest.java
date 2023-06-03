package model.impl;

import model.Hand;
import model.HandValue;
import model.PokerHandComparatorResult;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerHandThreeOfAKindComparatorTest {


    PokerHandThreeOfAKindComparator pokerHandThreeOfAKindComparator = new PokerHandThreeOfAKindComparator();

    @Test
    void shouldReturnFirstHandWithHighestPairValue() {
        final Hand firstHand = new Hand("4H 4D 4S 5C KD", "Black");
        final Hand secondHand = new Hand("2H 2D 2S 5C TD", "White");
        PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, Collections.singletonList(HandValue.FOUR));

        assertEquals(expected, pokerHandThreeOfAKindComparator.compare(firstHand, secondHand));
    }

    @Test
    void shouldReturnSecondHandWithHighestPairValue() {
        final Hand firstHand = new Hand("2H 2D 2S 5C TD", "Black");
        final Hand secondHand = new Hand("4H 4D 4S 5C KD", "White");
        PokerHandComparatorResult expected = new PokerHandComparatorResult(secondHand, Collections.singletonList(HandValue.FOUR));

        assertEquals(expected, pokerHandThreeOfAKindComparator.compare(firstHand, secondHand));
    }


    @Test
    void shouldReturnEmptyWhenIsEquals() {
        final Hand firstHand = new Hand("2H 2D 2D 3C TD", "Black");
        final Hand secondHand = new Hand("2S 2C 2S 3H TC", "White");
        assertEquals(new PokerHandComparatorResult(), pokerHandThreeOfAKindComparator.compare(firstHand, secondHand));
    }
}