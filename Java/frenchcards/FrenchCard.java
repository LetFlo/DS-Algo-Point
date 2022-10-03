package frenchcards;

import java.util.Arrays;

public class FrenchCard {

    public enum Type {
        DIAMONDS, HEARTS, SPADES, CLUBS, JOKER_RED, JOKER_BLACK;

        public String unicodeSymbol() {
            switch (this) {
                case SPADES:
                    return "♠";
                case HEARTS:
                    return "♥";
                case CLUBS:
                    return "♣";
                default:
                    return "♦️";
            }
        }
    }

    public enum Value {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        KNAVE(11), KNIGHT(12), KING(13), JOKER(-1);

        int numericValue;

        Value(int value) {
            this.numericValue = value;
        }

        public static Value getByNumericValue(int value) {
            return Arrays
                    .stream(Value.values())
                    .filter(c -> c.numericValue == value)
                    .findFirst()
                    .orElse(Value.ACE);
        }

        public String unicodePrefix() {
            switch (this) {
                case KNAVE:
                    return "J";
                case KNIGHT:
                    return "Q";
                case KING:
                    return "K";
                case JOKER:
                    return "JOKER";
                default:
                    return this.numericValue + "";
            }
        }

        public int getNumericValue() { return numericValue; }
    }

    private Type type;
    private Value value;

    public FrenchCard(Type type, Value value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }

    public Value getValue() { return value; }

    public void setValue(Value value) { this.value = value; }

    @Override
    public String toString() {
        if (this.value == Value.JOKER) {
            return String.format("(JOKER(%s))",
                    type == Type.JOKER_BLACK ? 'B' : 'R');
        }
        return String.format("(%s%s)",
                type.unicodeSymbol(), value.unicodePrefix());
    }
}

