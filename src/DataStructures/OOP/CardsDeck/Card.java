package DataStructures.OOP.CardsDeck;

public abstract class Card {
    private int faceValue;
    private Suite cardType;
    private boolean cardAvailable = true;

    public Card(int faceValue, Suite cardType) {
        this.faceValue = faceValue;
        this.cardType = cardType;
    }

    public boolean isCardAvailable() {
        return cardAvailable;
    }

    public void setCardAvailable(boolean cardUsed) {
        cardAvailable = cardUsed;
    }
}
