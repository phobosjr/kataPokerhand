package model.impl;

import model.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokerHandThreeOfAKindComparator implements PokerHandComparator {
    @Override
    public PokerHandComparatorResult compare(Hand firstHand, Hand secondHand) {

        Map<HandValue, Long> firstHandValuesByCount = Arrays.stream(getHandValues(firstHand))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<HandValue, Long> secondHandValuesByCount = Arrays.stream(getHandValues(secondHand))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<Map.Entry<HandValue, Long>> first = firstHandValuesByCount.entrySet().stream()
                .filter(count -> count.getValue() == 3)
                .findFirst();

        Optional<Map.Entry<HandValue, Long>> second = secondHandValuesByCount.entrySet().stream()
                .filter(count -> count.getValue() == 3)
                .findFirst();

        if (first.isPresent() && second.isPresent()) {
            HandValue firstHandValue = first.get().getKey();
            HandValue secondhandValue = second.get().getKey();
            if (firstHandValue.rank > secondhandValue.rank) {
                return new PokerHandComparatorResult(firstHand, Collections.singletonList(firstHandValue));
            }
            if (firstHandValue.rank < secondhandValue.rank) {
                return new PokerHandComparatorResult(secondHand, Collections.singletonList(secondhandValue));
            }
        }
        return new PokerHandComparatorResult();
    }

}
