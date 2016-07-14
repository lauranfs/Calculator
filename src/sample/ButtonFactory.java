package sample;


import javafx.scene.control.Button;

/**
 * Created by codecadet on 22/06/16.
 */
public class ButtonFactory {

    public static Button[] make() {

        Button[] buttons = new Button[Buttons.values().length];

        for (int i = 0; i < buttons.length; i++) {

            buttons[i] = new Button(Buttons.values()[i].getRepresentation());
            buttons[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

            if(buttons[i].getText().matches("[0-9]")) {

                buttons[i].getStyleClass().add("button-number");
            } else {
                buttons[i].getStyleClass().add("button-special");
            }
        }

        return buttons;
    }
}
