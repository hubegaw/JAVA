package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import exceptions.DivisionByZero;
import org.junit.jupiter.api.Test;
import PolishReverseNotationAlgorithm.PolishReverseNotation;

import java.util.ArrayList;
import java.util.Collections;

public class PolishReverseNotationTests {

    private final PolishReverseNotation prn = new PolishReverseNotation();
    private final ArrayList<String> expression = new ArrayList<>();

    @Test
    void addition() throws DivisionByZero {
        Collections.addAll(expression, "1", "1", "+");
        assertEquals(2, prn.getSolution(expression));
    }

    @Test
    void subtraction() throws DivisionByZero {
        Collections.addAll(expression, "1", "1", "-");
        assertEquals(0, prn.getSolution(expression));
    }

    @Test
    void multiplication() throws DivisionByZero {
        Collections.addAll(expression, "1", "1", "*");
        assertEquals(2, prn.getSolution(expression));
    }

    @Test
    void division() throws DivisionByZero {
        Collections.addAll(expression, "1", "1", "/");
        assertEquals(1, prn.getSolution(expression));
    }

    @Test
    void advancedExpression1() throws DivisionByZero {
        Collections.addAll(expression, "2", "1", "-", "3", "*");
        assertEquals(3, prn.getSolution(expression));
    }

    @Test
    void advancedExpression2() throws DivisionByZero {
        expression.add("10"); expression.add("6"); expression.add("9"); expression.add("3"); expression.add("+");
        expression.add("-11"); expression.add("*"); expression.add("/"); expression.add("*");
        expression.add("17"); expression.add("+"); expression.add("5"); expression.add("+");
        Collections.addAll(expression, "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+");
        assertEquals(21.54545454, prn.getSolution(expression));
    }

    @Test
    void advancedExpression3() throws DivisionByZero {
        expression.add("4"); expression.add("13"); expression.add("5"); expression.add("/"); expression.add("+");
        Collections.addAll(expression, "4", "13", "5", "/", "+");
        assertEquals(6.6, prn.getSolution(expression));
    }
}
