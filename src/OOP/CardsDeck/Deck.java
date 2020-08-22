package OOP.CardsDeck;

import java.util.ArrayList;

public class Deck<T extends Card> {
    private ArrayList<T> cardsDeck;

    public Deck(ArrayList<T> cards) {
        this.cardsDeck = cards;
    }

    public void addCardsToDeck(ArrayList<T> newCards) {
        cardsDeck.addAll(newCards);
    }

    public void addCardToDeck(T t) {
        cardsDeck.add(t);
    }


    public void removeCard(int faceValue, Suite cardType) {
        //O(n)
    }
}
