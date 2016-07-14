package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller implements EventHandler<ActionEvent> {

    private CalculatorUI ui;
    private CalculatorBrain brain;

    private void updateDisplay() {

        ((Label) ui.grid.lookup("#input-field")).setText(brain.getDisplayText());
    }

    @Override
    public void handle(ActionEvent event) {

        String buttonText = ((Button) event.getSource()).getText();

        if (buttonText.equals("=")) {

            if (brain.isReadyToCalculate()) {
                ((Label) ui.grid.lookup("#result")).setText(Integer.toString(brain.calculate()));
                return;
            }
        } else if (buttonText.equals("CE")) {

            brain.reset();

        } else if (buttonText.matches("[0-9]")) {
            brain.addNumber(buttonText);

        } else {
            brain.addOperator(buttonText);
        }
        updateDisplay();

    }

    void setUi(CalculatorUI ui) {
        this.ui = ui;
    }

    void setBrain(CalculatorBrain brain) {
        this.brain = brain;
    }
}

