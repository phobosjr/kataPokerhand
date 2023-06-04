package model;

public enum HandValue {
    TWO("Two", "2", 2),
    THREE("Three", "3", 3),
    FOUR("Four", "4", 4),
    FIVE("Five", "5", 5),
    SIX("Six", "6", 6),
    SEVEN("Seven", "7", 7),
    EIGHT("Eight", "8", 8),
    NINE("Nine", "9", 9),
    TEN("Ten", "T", 10),
    JACK("Jack", "J", 11),
    QUEEN("Queen", "Q", 12),
    KING("King", "K", 13),
    ACE("Ace", "A", 14);


    public String label;
    public final String valueName;
    public final int rank;

    HandValue(String label, String valueName, int rank) {
        this.label = label;
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
