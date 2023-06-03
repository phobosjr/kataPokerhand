package service;

import model.Hand;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerHandsServiceTest {

    @Nested
    class CompareHands {

        @ParameterizedTest
        @CsvSource(value = {
                "2H 3H 4H 5H 6H,2H 3D 5S 9C KD,Black wins. - with Straight flush",
                "2H 3D 5S 9C KD,2H 3H 4H 5H 6H,White wins. - with Straight flush",
                "4H 4D 4S 4C KD,2S 3D 5H 9C KD,Black wins. - with Four of a kind",
                "7H 7D 7S 5C 5D,2S 3D 5H 9C KD,Black wins. - with Full house",
                "2H 5H 6H TH KH,2H 3D 5S 9C KD,Black wins. - with Flush",
                "4C 5H 6D 7H 8S,2H 3D 5S 9C KD,Black wins. - with Straight",
                "2H 3D 5S 9C KD,4C 5H 6D 7H 8S,White wins. - with Straight",
                "4C 4H 4D 7H 8S,2H 3D 5S 9C KD,Black wins. - with Three of a kind",
                "4C 4H 5D 5H 8S,2H 3D 5S 9C KD,Black wins. - with Two pairs",
                "4C 4H 5D 7H 8S,2H 3D 5S 9C KD,Black wins. - with Pair"
        })
        void shouldReturnExpectedLabel(String cards1, String cards2, String expectedLabel) {
            Hand firstHand = new Hand(cards1, "Black");
            Hand secondHand = new Hand(cards2, "White");

            assertEquals(expectedLabel, PokerHandsService.compareHands(firstHand, secondHand));
        }

        @ParameterizedTest
        @CsvSource(value = {
                "9H 2C 7S AD KH,9H 2C 7S AD KH",
                "2H 2C 6S 8D 3H,2H 2C 6S 8D 3H",
                "2H 2C 6S 6D 3H,2H 2C 6S 6D 3H",
                "4H 4C 4S 9D 9H,4H 4C 4S 9D 9H",
        })
        void shouldReturnExpectedLabelWhenItEquals(String cards1, String cards2) {
            Hand firstHand = new Hand(cards1, "Black");
            Hand secondHand = new Hand(cards2, "White");
            assertEquals("Tie", PokerHandsService.compareHands(firstHand, secondHand));
        }
    }
}