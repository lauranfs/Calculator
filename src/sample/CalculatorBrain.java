package sample;

import java.util.LinkedList;

/**
 * Created by codecadet on 21/06/16.
 */
public class CalculatorBrain {

    private LinkedList<Integer> numbers;
    private LinkedList<String> operators;
    private boolean lastAddedNumber;
    private boolean currentNumberIsResult;

    public CalculatorBrain() {

        numbers = new LinkedList<>();
        operators = new LinkedList<>();
    }

    public int calculate() {

        while (operators.contains("*") || operators.contains("/")) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i).equals("*") || operators.get(i).equals("/")) {
                    if (operators.get(i).equals("*")) {
                        numbers.add(i, (multiply(numbers.get(i), numbers.get(i + 1))));
                    } else if (operators.get(i).equals("/")) {
                        numbers.add(i, (divide(numbers.get(i), numbers.get(i + 1))));
                    }
                    removeUsedElements(i);
                    break;
                }
            }
        }

        while (operators.contains("+") || operators.contains("-")) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i).equals("+") || operators.get(i).equals("-")) {
                    if (operators.get(i).equals("+")) {
                        numbers.add(i, (add(numbers.get(i), numbers.get(i + 1))));
                    } else if (operators.get(i).equals("-")) {
                        numbers.add(i, (subtract(numbers.get(i), numbers.get(i + 1))));
                    }
                    removeUsedElements(i);
                    break;
                }
            }
        }
        currentNumberIsResult = true;
        return (numbers.getFirst());
    }

    private int add(int num, int num2) {
        return num + num2;
    }

    private int subtract(int num, int num2) {
        return num - num2;
    }

    private int multiply(int num, int num2) {
        return num * num2;
    }

    private int divide(int num, int num2) {
        return num / num2;
    }

    void addNumber(String buttonText) {

        if (getDisplayText().length() < 9) {
            if (currentNumberIsResult) {
                numbers.clear();
                numbers.add(Integer.parseInt(buttonText));
                currentNumberIsResult = false;
            } else if (lastAddedNumber) {
                String x = Integer.toString(numbers.getLast());
                x = x + buttonText;
                numbers.removeLast();
                numbers.add(Integer.parseInt(x));
            } else {
                numbers.add(Integer.parseInt(buttonText));
            }

            currentNumberIsResult = false;
            lastAddedNumber = true;
        }
    }

    void addOperator(String buttonText) {

        currentNumberIsResult = false;

        if (getDisplayText().length() < 9 && numbers.size() < 10 && numbers.size() > 0) {
            if (!lastAddedNumber) {
                operators.removeLast();
            }

            operators.add(buttonText);
            lastAddedNumber = false;
        }
    }

    public String getDisplayText() {

        String displayText = "";
        for (int i = 0; i < numbers.size(); i++) {

            if (operators.size() == 0 || i >= operators.size()) {
                displayText = displayText + numbers.get(i);

            } else {
                displayText = displayText + numbers.get(i) + operators.get(i);
            }
        }
        return displayText;
    }

    void reset() {
        numbers.clear();
        operators.clear();
        lastAddedNumber = false;
        currentNumberIsResult = false;
    }

    boolean isReadyToCalculate() {
        return (operators.size() > 0 && numbers.size() > operators.size());
    }

    private void removeUsedElements(int index) {
        operators.remove(index);
        numbers.remove(index + 1);
        numbers.remove(index + 1);
    }
}

