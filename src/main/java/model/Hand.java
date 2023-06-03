package model;

import java.util.regex.Pattern;

public class Hand {

    private static final String HAND_INPUT_REGEX = "^([2-9TJQKA][CDHS]) ([2-9TJQKA][CDHS]) ([2-9TJQKA][CDHS]) ([2-9TJQKA][CDHS]) ([2-9TJQKA][CDHS])$";
    private final String[] cards;


    public Hand(String cards) {
        Pattern pattern = Pattern.compile(HAND_INPUT_REGEX);
        if (!pattern.matcher(cards).find()) {
            throw new HandInputFormatException();
        }

        this.cards = cards.split(" ");
    }

    public String[] getCards() {
        return cards;
    }
}
