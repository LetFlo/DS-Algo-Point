package frenchcards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static frenchcards.FrenchCard.Type.*;

public class FrenchDeck {


    public LinkedList<frenchcards.FrenchCard> cards;

    public FrenchDeck() {
        cards = new LinkedList<>();
        initializeDeck();
        shuffleDeck();
    }

    public void initializeDeck() {
        cards.clear();
        addType(DIAMONDS);
        addType(CLUBS);
        addType(SPADES);
        addType(HEARTS);
        addJokers();
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public frenchcards.FrenchCard pull() throws NoSuchElementException {
        return cards.removeFirst();
    }

    public frenchcards.FrenchCard pick() {
        return cards.peek();
    }

    private void addType(frenchcards.FrenchCard.Type t) {
        for (int i = 1; i <= 13; i++) {
            cards.add(new frenchcards.FrenchCard(t, frenchcards.FrenchCard.Value.getByNumericValue(i)));
        }
    }

    private void addJokers() {
        cards.add(new frenchcards.FrenchCard(JOKER_RED, frenchcards.FrenchCard.Value.JOKER));
        cards.add(new frenchcards.FrenchCard(JOKER_BLACK, frenchcards.FrenchCard.Value.JOKER));
    }

    @Override
    public String toString() {
        return "FrenchDeck{" +
                "cards=" + cards + "\n" +
                "size=" + cards.size() + "\n" +
                '}';
    }
}
