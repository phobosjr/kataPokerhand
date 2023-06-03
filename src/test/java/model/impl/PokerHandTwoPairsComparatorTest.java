package model.impl;

import model.Hand;
import model.HandValue;
import model.PokerHandComparatorResult;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static model.HandValue.SIX;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerHandTwoPairsComparatorTest {
    PokerHandTwoPairsComparator pokerHandTwoPairsComparator = new PokerHandTwoPairsComparator();

    @Test
    void shouldReturnFirstHandWithHighPair() {
        final Hand firstHand = new Hand("4H 4D 5S 5C KD", "Black");
        final Hand secondHand = new Hand("2H 2D 5S 5C TD", "White");
        PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, asList(HandValue.FOUR, HandValue.FIVE));


        assertEquals(expected, pokerHandTwoPairsComparator.compare(firstHand, secondHand));
    }


    @Test
    void shouldReturnFirstHandWhenPairIsEqualsAndHaveHighestValue() {
        final Hand firstHand = new Hand("4H 4D 6S 9C 9D", "Black");
        final Hand secondHand = new Hand("4H 4D 5S 9C 9D", "White");

        PokerHandComparatorResult expected = new PokerHandComparatorResult(firstHand, Collections.singletonList(SIX));

        assertEquals(expected, pokerHandTwoPairsComparator.compare(firstHand, secondHand));
    }


    @Test
    void shouldReturnSecondHandWithHighPair() {
        final Hand firstHand = new Hand("2H 2D 5S 5C TD", "Black");
        final Hand secondHand = new Hand("4H 4D 5S 5C KD", "White");

        PokerHandComparatorResult expected = new PokerHandComparatorResult(secondHand, asList(HandValue.FOUR, HandValue.FIVE));


        assertEquals(expected, pokerHandTwoPairsComparator.compare(firstHand, secondHand));
    }


    @Test
    void shouldReturnSecondHandWhenPairIsEqualsAndHaveHighestValue() {
        final Hand firstHand = new Hand("4H 4D 5S 9C 9D", "Black");
        final Hand secondHand = new Hand("4H 4D 6S 9C 9D", "White");

        PokerHandComparatorResult expected = new PokerHandComparatorResult(secondHand, Collections.singletonList(SIX));

        assertEquals(expected, pokerHandTwoPairsComparator.compare(firstHand, secondHand));
    }


    @Test
    void shouldReturn0WhenIsEquals() {
        final Hand firstHand = new Hand("2H 2D 3D 3C TD", "Black");
        final Hand secondHand = new Hand("2S 2C 3S 3H TC", "Black");
        assertEquals(new PokerHandComparatorResult(), pokerHandTwoPairsComparator.compare(firstHand, secondHand));
    }
}