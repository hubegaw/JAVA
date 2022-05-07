package PolishReverseNotationAlgorithm;

import exceptions.DivisionByZero;

import java.util.ArrayList;
import java.util.Stack;

public class PolishReverseNotation implements IPolishReverseNotation {

    private final Stack<String> stack = new Stack<>();

    @Override
    public double getSolution(ArrayList<String> input) throws DivisionByZero {
        double x, y;
        String result;

        for (String s : input) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                y = Double.parseDouble(stack.pop());
                x = Double.parseDouble(stack.pop());

                if(s.equals("/") && y == 0) {
                    throw new DivisionByZero("Division by zero is not allowed!");
                }

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

        return ((long)(Double.parseDouble(stack.pop())*1e8))/1e8;
    }
}
