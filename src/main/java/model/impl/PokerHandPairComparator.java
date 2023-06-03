package model.impl;

import model.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokerHandPairComparator implements PokerHandComparator {

    @Override
    public PokerHandComparatorResult compare(Hand firstHand, Hand secondHand) {

        Map<HandValue, Long> firstHandValuesByCount = Arrays.stream(getHandValues(firstHand))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<HandValue, Long> secondHandValuesByCount = Arrays.stream(getHandValues(secondHand))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        HandValue firstPairHandValue = getHandValuePair(firstHandValuesByCount);
        HandValue secondPairHandValue = getHandValuePair(secondHandValuesByCount);

        if (firstPairHandValue.rank > secondPairHandValue.rank) {
            return new PokerHandComparatorResult(firstHand, Collections.singletonList(firstPairHandValue));
        }
        if (firstPairHandValue.rank < secondPairHandValue.rank) {
            return new PokerHandComparatorResult(secondHand, Collections.singletonList(secondPairHandValue));
        }

        return getPokerHandResultByHighestHandValue(firstHand, secondHand);
    }

    private HandValue getHandValuePair(Map<HandValue, Long> firstHandValuesByCount) {
        HandValue pair = null;
        for (Map.Entry<HandValue, Long> handValueLongEntry : firstHandValuesByCount.entrySet()) {
            if (handValueLongEntry.getValue() == 2) {
                pair = handValueLongEntry.getKey();
            }
        }
        return pair;
    }
}
