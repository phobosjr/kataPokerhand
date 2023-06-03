package service;

import model.Hand;
import model.PokerHandCategory;
import factory.PokerHandComparatorFactory;
import model.PokerHandComparator;
import model.PokerHandComparatorResult;

public class PokerHandsService {

    public static final String S_WINS_WITH_S = "%s wins. - with %s";
    public static final String TIE_LABEL = "Tie";

    public static String compareHands(Hand firstHand, Hand secondHand) {
        PokerHandCategory firstPokerHandCategory = PokerHandCategoryService.findPokerHandCategory(firstHand);
        PokerHandCategory secondPokerHandCategory = PokerHandCategoryService.findPokerHandCategory(secondHand);

        if (firstPokerHandCategory.rank > secondPokerHandCategory.rank) {
            return String.format(S_WINS_WITH_S, firstHand.getPlayerName(), firstPokerHandCategory.label);
        }

        if (firstPokerHandCategory.rank < secondPokerHandCategory.rank) {
            return String.format(S_WINS_WITH_S, secondHand.getPlayerName(), secondPokerHandCategory.label);
        }

        PokerHandComparatorFactory pokerHandComparatorFactory = new PokerHandComparatorFactory();
        PokerHandComparator pokerHandComparator = pokerHandComparatorFactory.createPokerHandComparator(firstPokerHandCategory);

        PokerHandComparatorResult pokerHandComparatorResult = pokerHandComparator.compare(firstHand, secondHand);

        if (pokerHandComparatorResult.getHand() == null) {
            return TIE_LABEL;
        }

        PokerHandCategory pokerHandCategory = PokerHandCategoryService.findPokerHandCategory(pokerHandComparatorResult.getHand());


        return String.format(S_WINS_WITH_S, pokerHandComparatorResult.getHand().getPlayerName(), pokerHandCategory.label);
    }
}
