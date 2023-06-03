package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {


    @Test
    void shouldCreateHandFromString() {
        String[] expectedCards = {"2H", "3D", "5S", "9C", "KD"};
        Hand hand = new Hand("2H 3D 5S 9C KD");
        assertArrayEquals(expectedCards, hand.getCards());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2H", "2H 3D", "2H 3D 5S", "2H 3D 5S 9C", "2H3D5S9CKD", "invalidString"})
    void shouldThrowHandInputFormatExceptionWhenHandInputNotValid(String input) {
        assertThrows(HandInputFormatException.class, () -> new Hand(input));
    }

}