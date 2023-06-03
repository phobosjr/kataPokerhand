package model.impl;

import model.Hand;
import model.HandValue;
import model.PokerHandComparatorResult;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerHandFourOfAKindComparatorTest {

    PokerHandFourOfAKindComparator pokerHandFourOfAKindComparator = new PokerHandFourOfAKindComparator();

    @Test
    void firstHandWinWithHighValue() {
        final Hand firstHand = new Hand("4H 4D 4S 4C 5D", "Black");
        final Hand secondHand = new Hand("2H 2D 2S 2C 5C", "White");
        PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, Collections.singletonList(HandValue.FOUR));

        assertEquals(expected, pokerHandFourOfAKindComparator.compare(firstHand, secondHand));
    }

    @Test
    void SecondHandWinWithHighValue() {
        final Hand firstHand = new Hand("2H 2D 2S 2C 5C", "Black");
        final Hand secondHand = new Hand("4H 4D 4S 4C 5D", "Black");

        PokerHandComparatorResult expected = new PokerHandComparatorResult(secondHand, Collections.singletonList(HandValue.FOUR));

        assertEquals(expected, pokerHandFourOfAKindComparator.compare(firstHand, secondHand));
    }
}