package factory;

import model.PokerHandCategory;
import model.PokerHandComparator;
import model.impl.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static model.PokerHandCategory.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class PokerHandComparatorFactoryTest {

    private final PokerHandComparatorFactory pokerHandComparatorFactory = new PokerHandComparatorFactory();

    @ParameterizedTest
    @ArgumentsSource(Params.class)
    void createPokerHandComparatorWhenPokerHandCategoryIsPair(Class<PokerHandPairComparator> expectedType, PokerHandCategory pokerHandCategory) {
        PokerHandComparator pokerHandComparator = pokerHandComparatorFactory.createPokerHandComparator(pokerHandCategory);
        assertInstanceOf(expectedType, pokerHandComparator);

    }

    private static class Params implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(PokerHandHighCardComparator.class, HIGH_CARD),
                    Arguments.of(PokerHandPairComparator.class, PAIR),
                    Arguments.of(PokerHandTwoPairsComparator.class, TWO_PAIRS),
                    Arguments.of(PokerHandThreeOfAKindComparator.class, THREE_OF_A_KIND),
                    Arguments.of(PokerHandStraightComparator.class, STRAIGHT),
                    Arguments.of(PokerHandFlushComparator.class, FLUSH),
                    Arguments.of(PokerHandFullHouseComparator.class, FULL_HOUSE),
                    Arguments.of(PokerHandFourOfAKindComparator.class, FOUR_OF_A_KIND),
                    Arguments.of(PokerHandStraightFlushComparator.class, STRAIGHT_FLUSH)
            );
        }
    }
}