package model.impl;

import model.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokerHandTwoPairsComparator implements PokerHandComparator {

    @Override
    public PokerHandComparatorResult compare(Hand firstHand, Hand secondHand) {

        Map<HandValue, Long> firstHandValuesByCount = Arrays.stream(getHandValues(firstHand))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<HandValue, Long> secondHandValuesByCount = Arrays.stream(getHandValues(secondHand))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        List<HandValue> firstHighPairHandValue = getHandValuePairs(firstHandValuesByCount);
        List<HandValue> secondHighPairHandValue = getHandValuePairs(secondHandValuesByCount);

        if (firstHighPairHandValue.get(1).rank > secondHighPairHandValue.get(1).rank ||
                firstHighPairHandValue.get(0).rank > secondHighPairHandValue.get(0).rank) {
            return new PokerHandComparatorResult(firstHand, getHandValuePairs(firstHandValuesByCount));

        }
        if (firstHighPairHandValue.get(1).rank < secondHighPairHandValue.get(1).rank ||
                firstHighPairHandValue.get(0).rank < secondHighPairHandValue.get(0).rank) {
            return new PokerHandComparatorResult(secondHand, getHandValuePairs(secondHandValuesByCount));
        }

        return getPokerHandResultByHighestHandValue(firstHand, secondHand);
    }

    private List<HandValue> getHandValuePairs(Map<HandValue, Long> firstHandValuesByCount) {
        List<HandValue> pairs = new ArrayList<>();
        for (Map.Entry<HandValue, Long> handValueLongEntry : firstHandValuesByCount.entrySet()) {
            if (handValueLongEntry.getValue() == 2) {
                pairs.add(handValueLongEntry.getKey());
            }
        }
        return pairs;
    }

}
