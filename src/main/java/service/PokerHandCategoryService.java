package service;

import model.Hand;
import model.PokerHandCategory;
import model.HandValue;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokerHandCategoryService {

    public static PokerHandCategory findPokerHandCategory(Hand hand) {
        if (isStraightFlush(hand.getCards())) {
            return PokerHandCategory.STRAIGHT_FLUSH;
        }
        if (isFourOfAKind(hand.getCards())) {
            return PokerHandCategory.FOUR_OF_A_KIND;
        }
        if (isFullHouse(hand.getCards())) {
            return PokerHandCategory.FULL_HOUSE;
        }
        if (isFlush(hand.getCards())) {
            return PokerHandCategory.FLUSH;
        }
        if (isStraight(hand.getCards())) {
            return PokerHandCategory.STRAIGHT;
        }
        if (isThreeOfAKind(hand.getCards())) {
            return PokerHandCategory.THREE_OF_A_KIND;
        }
        if (isTwoPairs(hand.getCards())) {
            return PokerHandCategory.TWO_PAIRS;
        }
        if (isPair(hand.getCards())) {
            return PokerHandCategory.PAIR;
        }
        return PokerHandCategory.HIGH_CARD;
    }

    private static boolean isStraightFlush(String[] cards) {
        return isStraight(cards) && isFlush(cards);
    }

    private static boolean isStraight(String[] cards) {
        List<HandValue> handValues = getHandValues(cards);


        for (int i = 0; i < handValues.size() - 1; i++) {
            if (handValues.get(i).rank + 1 != handValues.get(i + 1).rank) {
                return false;
            }
        }

        return true;
    }

    private static boolean isFlush(String[] cards) {
        long count = Arrays.stream(cards)
                .map(card -> card.charAt(1))
                .distinct()
                .count();
        return count == 1;
    }

    private static boolean isFourOfAKind(String[] cards) {
        return hasCountOfSameValue(cards, 4);
    }

    private static boolean isFullHouse(String[] cards) {
        return hasCountOfSameValue(cards, 3) && hasCountOfSameValue(cards, 2);
    }

    private static boolean isThreeOfAKind(String[] cards) {
        return hasCountOfSameValue(cards, 3);
    }

    private static boolean isTwoPairs(String[] cards) {
        return countPair(cards) == 2;
    }

    private static boolean isPair(String[] cards) {
        return countPair(cards) == 1;
    }

    private static long countPair(String[] cards) {
        Map<HandValue, Long> handValueByCount = groupedHandValueByCount(cards);
        return handValueByCount.values()
                .stream()
                .filter(value -> value.equals(2L))
                .count();
    }

    private static boolean hasCountOfSameValue(String[] cards, int countOfSameValue) {
        Map<HandValue, Long> handValueByCount = groupedHandValueByCount(cards);
        return handValueByCount.values().stream().anyMatch(value -> value == countOfSameValue);
    }

    private static Map<HandValue, Long> groupedHandValueByCount(String[] cards) {
        return getHandValues(cards)
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static List<HandValue> getHandValues(String[] cards) {
        return Arrays.stream(cards)
                .map(card -> HandValue.handValueByValueName(String.valueOf(card.charAt(0))))
                .collect(Collectors.toList());
    }
}
