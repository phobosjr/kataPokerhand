package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public interface PokerHandComparator {

    PokerHandComparatorResult compare(Hand firstHand, Hand secondHand);

    default PokerHandComparatorResult getPokerHandResultByHighestHandValue(Hand firstHand, Hand secondHand) {
        HandValue[] firstHandValues = getHandValues(firstHand);

        HandValue[] secondHandValues = getHandValues(secondHand);
        for (int i = firstHandValues.length - 1; i >= 0; i--) {
            if (firstHandValues[i] != secondHandValues[i]) {
                if (Integer.compare(firstHandValues[i].rank, secondHandValues[i].rank) == 1) {
                    return new PokerHandComparatorResult(firstHand, Collections.singletonList(firstHandValues[i]));
                }
                if (Integer.compare(firstHandValues[i].rank, secondHandValues[i].rank) == -1) {
                    return new PokerHandComparatorResult(secondHand, Collections.singletonList(secondHandValues[i]));
                }

            }
        }
        return new PokerHandComparatorResult();
    }

    default HandValue[] getHandValues(Hand hand) {
        return Arrays.stream(hand.getCards())
                .map(card -> HandValue.handValueByValueName(String.valueOf(card.charAt(0))))
                .sorted(Comparator.comparing(handValue -> handValue.rank))
                .toArray(HandValue[]::new);
    }

}
