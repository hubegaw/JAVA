package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import PolishReverseNotationAlgorithm.PolishReverseNotation;

import java.util.ArrayList;

public class PolishReverseNotationTests {

    private final PolishReverseNotation prn = new PolishReverseNotation();
    private final ArrayList<String> expression = new ArrayList<>();

    @Test
    void addition() {
        expression.add("1"); expression.add("1"); expression.add("+");
        assertEquals(2, prn.getSolution(expression));
    }

    @Test
    void subtraction() {
        expression.add("1"); expression.add("1"); expression.add("-");
        assertEquals(0, prn.getSolution(expression));
    }

    @Test
    void multiplication() {
        expression.add("2"); expression.add("1"); expression.add("*");
        assertEquals(2, prn.getSolution(expression));
    }

    @Test
    void division() {
        expression.add("2"); expression.add("2"); expression.add("/");
        assertEquals(1, prn.getSolution(expression));
    }

    @Test
    void advancedExpression1() {
        expression.add("2"); expression.add("1"); expression.add("-"); expression.add("3"); expression.add("*");
        assertEquals(3, prn.getSolution(expression));
    }

    @Test
    void advancedExpression2() {
        expression.add("10"); expression.add("6"); expression.add("9"); expression.add("3"); expression.add("+");
        expression.add("-11"); expression.add("*"); expression.add("/"); expression.add("*");
        expression.add("17"); expression.add("+"); expression.add("5"); expression.add("+");
        assertEquals(21.545454545454545454, prn.getSolution(expression));
    }

    @Test
    void advancedExpression3() {
        expression.add("4"); expression.add("13"); expression.add("5"); expression.add("/"); expression.add("+");
        assertEquals(6.6, prn.getSolution(expression));
    }
}
