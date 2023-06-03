package model;

public enum HandValue {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14);


    public final String valueName;
    public final int rank;

    HandValue(String valueName, int rank) {
        this.valueName = valueName;
        this.rank = rank;
    }


    public static HandValue handValueByValueName(String valueName) {
        for (HandValue handValue : values()) {
            if (handValue.valueName.equals(valueName)) {
                return handValue;
            }
        }

        return null;
    }
}
