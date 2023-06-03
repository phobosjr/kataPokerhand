package model.impl;

import model.Hand;
import model.HandValue;
import model.PokerHandComparatorResult;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerHandPairComparatorTest {

    PokerHandPairComparator pokerHandPairComparator = new PokerHandPairComparator();

    @Nested
    class CompareReturnFirstHandWithHighestValue {

        @Test
        void whenHighPair() {
            final Hand firstHand = new Hand("4H 4D 5S 8C KD", "Black");
            final Hand secondHand = new Hand("2H 2D 3S 5C TD", "White");
            PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, Collections.singletonList(HandValue.FOUR));

            assertEquals(expected, pokerHandPairComparator.compare(firstHand, secondHand));
        }


        @Test
        void whenPairIsEqualsAndHaveHighestValue() {
            final Hand firstHand = new Hand("4H 4D 5S 8C KD", "Black");
            final Hand secondHand = new Hand("4H 4D 5S 8C TD", "White");
            PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, Collections.singletonList(HandValue.KING));
            assertEquals(expected, pokerHandPairComparator.compare(firstHand, secondHand));
        }
    }


    @Nested
    class CompareReturnSecondHandWithHighestValue {

        @Test
        void whenHighPair() {
            final Hand firstHand = new Hand("2H 2D 3S 5C TD", "Black");
            final Hand secondHand = new Hand("4H 4D 5S 8C KD", "Black");
            PokerHandComparatorResult expected = new PokerHandComparatorResult(secondHand, Collections.singletonList(HandValue.FOUR));
            assertEquals(expected, pokerHandPairComparator.compare(firstHand, secondHand));
        }


        @Test
        void whenPairIsEqualsAndHaveHighestValue() {
            final Hand firstHand = new Hand("4H 4D 5S 8C TD", "Black");
            final Hand secondHand = new Hand("4H 4D 5S 8C KD", "Black");
            PokerHandComparatorResult expected = new PokerHandComparatorResult(secondHand, Collections.singletonList(HandValue.KING));
            assertEquals(expected, pokerHandPairComparator.compare(firstHand, secondHand));
        }
    }

    @Test
    void shouldReturn0WhenIsEquals() {
        final Hand firstHand = new Hand("2H 2D 3S 5C TD", "Black");
        final Hand secondHand = new Hand("2H 2D 3S 5C TD", "Black");

        assertEquals(new PokerHandComparatorResult(), pokerHandPairComparator.compare(firstHand, secondHand));
    }

}