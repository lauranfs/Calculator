package sample;

/**
 * Created by codecadet on 22/06/16.
 */
public enum Buttons {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    ADDITION("+"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SUBTRACTION("-"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    MULTIPLICATION("*"),
    RESET("CE"),
    ZERO("0"),
    EQUALS("="),
    DIVISION("/");

    private String representation;

    Buttons (String representation) {
        this.representation = representation;
    }

    public String getRepresentation () {
        return representation;
    }
}
