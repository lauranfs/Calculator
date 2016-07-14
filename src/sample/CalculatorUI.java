package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

import java.util.LinkedList;

/**
 * Created by codecadet on 21/06/16.
 */
public class CalculatorUI {

    GridPane grid;

    public CalculatorUI (EventHandler<ActionEvent> eventHandler) {

        grid = new GridPane();
        Label display = new Label();
        display.getStyleClass().add("display");
        display.setId("input-field");
        display.setFont(Font.font("Arial", 40));
        grid.add(display, 0, 0, 4, 1);

        Label result = new Label();
        result.getStyleClass().add("display");
        result.setId("result");
        result.setFont(Font.font("Arial", 20));
        grid.add(result, 0, 1, 4, 1);

        Button[] buttons = ButtonFactory.make();

        int currentRow = 2;
        int columns = 4;
        int rows = currentRow + (buttons.length/columns);

        for (int i = 0; i <buttons.length ; i++) {

            buttons[i].setOnAction(eventHandler);

            if (i != 0 && i%columns == 0) {
                currentRow++;
            }

            grid.add(buttons[i], i  % 4, currentRow, 1, 1);

            GridPane.setFillWidth(buttons[i], true);
            GridPane.setFillHeight(buttons[i], true);
        }

        for (int i = 0; i < columns; i++) {

            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100/columns);
            grid.getColumnConstraints().add(columnConstraints);
        }

        for (int i = 0; i < rows; i++) {

            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100/rows);
            grid.getRowConstraints().add(rowConstraints);
        }
    }
}
