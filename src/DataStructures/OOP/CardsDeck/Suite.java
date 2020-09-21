package DataStructures.OOP.CardsDeck;

public enum Suite {
    DIAMOND(0), CLUB(1), SPADE(2), HEART(4);
    private int value;

    public int getValue() {
        return value;
    }

    public static Suite getSuiteFromValue(int value) {
        return Suite.values()[value];
    }

    Suite(int val) {
        this.value = val;
    }
}
