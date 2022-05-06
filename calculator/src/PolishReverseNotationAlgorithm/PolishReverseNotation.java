package PolishReverseNotationAlgorithm;

import java.util.ArrayList;
import java.util.Stack;

public class PolishReverseNotation implements IPolishReverseNotation {

    private final Stack<String> stack = new Stack<>();

    @Override
    public double getSolution(ArrayList<String> input) {
        double x, y;
        String result;

        for (String s : input) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                y = Double.parseDouble(stack.pop());
                x = Double.parseDouble(stack.pop());
                switch(s) {
                    case "+" -> { result = Double.toString(x + y); stack.push(result); }
                    case "-" -> { result = Double.toString(x - y); stack.push(result); }
                    case "*" -> { result = Double.toString(x * y); stack.push(result); }
                    case "/" -> { result = Double.toString(x / y); stack.push(result); }
                    default -> {}
                }
            } else {
                stack.push(s);
            }
        }

        return Double.parseDouble(stack.pop());
    }
}
