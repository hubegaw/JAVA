package ShuntingYardAlgorithm;

import java.util.ArrayList;
import java.util.Stack;

public class ShuntingYard implements IShuntingYard {
    private final Stack<String> stack = new Stack<>();
    private final ArrayList<String> output = new ArrayList<>();

    @Override
    public ArrayList<String> transformExpressionToPRN(ArrayList<String> input) {
        stack.clear();
        output.clear();
        for (String s : input) {
            if (checkIfSymbolIsNumber(s)) {
                output.add(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && establishPrecedence(s) < establishPrecedence(stack.peek()) && hasLeftAssociativity(s)) {
                    output.add(stack.pop());
                }
                stack.push(s);
            }
        }

        while(!stack.isEmpty()) {
            if(stack.peek().equals("(") || stack.peek().equals(")")) {
                stack.pop(); // wyrzuć błąd, try..catch
            } else {
                output.add(stack.pop());
            }
        }
        return output;
    }

    @Override
    public boolean checkIfSymbolIsNumber(String symbol) {
        switch(symbol) {
            case "+","-","*","/","(",")" -> { return false; }
            default -> { return true; }
        }
    }

    @Override
    public int establishPrecedence(String symbol) {
        switch(symbol) {
            case "+", "-" -> { return 1; }
            case "*", "/" -> { return 2; }
            case "^" -> { return 3; }
            default -> { return -1; }
        }
    }

    @Override
    public boolean hasLeftAssociativity(String symbol) {
        switch(symbol) {
            case "+","-","*","/" -> { return true; }
            default -> { return false; }
        }
    }
}
