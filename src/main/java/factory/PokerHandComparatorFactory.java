package factory;

import model.PokerHandCategory;
import model.PokerHandComparator;
import model.impl.*;

public class PokerHandComparatorFactory {

    public PokerHandComparator createPokerHandComparator(PokerHandCategory pokerHandCategory) {
        PokerHandComparator pokerHandComparator;
        switch (pokerHandCategory) {
            case STRAIGHT:
                pokerHandComparator = new PokerHandStraightComparator();
                break;
            case FLUSH:
                pokerHandComparator = new PokerHandFlushComparator();
                break;
            case FOUR_OF_A_KIND:
                pokerHandComparator = new PokerHandFourOfAKindComparator();
                break;
            case FULL_HOUSE:
                pokerHandComparator = new PokerHandFullHouseComparator();
                break;
            case HIGH_CARD:
                pokerHandComparator = new PokerHandHighCardComparator();
                break;
            case PAIR:
                pokerHandComparator = new PokerHandPairComparator();
                break;
            case STRAIGHT_FLUSH:
                pokerHandComparator = new PokerHandStraightFlushComparator();
                break;
            case THREE_OF_A_KIND:
                pokerHandComparator = new PokerHandThreeOfAKindComparator();
                break;
            case TWO_PAIRS:
                pokerHandComparator = new PokerHandTwoPairsComparator();
                break;
            default:
                throw new IllegalArgumentException("Unknown Poker Hand Category");
        }
        return pokerHandComparator;
    }
}
