package model;

public enum PokerHandCategory {
    HIGH_CARD("High card", 1),
    PAIR("Pair", 2),
    TWO_PAIRS("Two pairs", 3),
    THREE_OF_A_KIND("Three of a kind", 4),
    STRAIGHT("Straight", 5),
    FLUSH("Flush", 6),
    FULL_HOUSE("Full house", 7),
    FOUR_OF_A_KIND("Four of a kind", 8),
    STRAIGHT_FLUSH("Straight flush", 9);

    public String label;
    public int rank;

    PokerHandCategory(String label, int rank) {
        this.label = label;
        this.rank = rank;
    }
}
