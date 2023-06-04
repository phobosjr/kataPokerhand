package model;

import java.util.List;
import java.util.Objects;

public class PokerHandComparatorResult {

    private Hand hand;
    private List<HandValue> handValues;

    public PokerHandComparatorResult(Hand hand, List<HandValue> handValues) {
        this.hand = hand;
        this.handValues = handValues;
    }

    public PokerHandComparatorResult() {

    }

    public Hand getHand() {
        return hand;
    }

    public List<HandValue> getHandValues() {
        return handValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerHandComparatorResult that = (PokerHandComparatorResult) o;
        return Objects.equals(hand, that.hand) && Objects.equals(handValues, that.handValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hand, handValues);
    }
}
