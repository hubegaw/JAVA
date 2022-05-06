package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ShuntingYardAlgorithm.ShuntingYard;

import java.util.ArrayList;

public class ShuntingYardTests {
    private final ShuntingYard sy = new ShuntingYard();
    private final ArrayList<String> result = new ArrayList<>();
    private final ArrayList<String> input = new ArrayList<>();

    @Test
    void addition() {
        input.add("1"); input.add("+"); input.add("1");
        result.add("1"); result.add("1"); result.add("+");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void subtraction() {
        input.add("1"); input.add("-"); input.add("1");
        result.add("1"); result.add("1"); result.add("-");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void multiplication() {
        input.add("2"); input.add("*"); input.add("1");
        result.add("2"); result.add("1"); result.add("*");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void division() {
        input.add("2"); input.add("/"); input.add("1");
        result.add("2"); result.add("1"); result.add("/");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void advancedExpression1() {
        input.add("("); input.add("2"); input.add("-"); input.add("1"); input.add(")"); input.add("*"); input.add("3");
        result.add("2"); result.add("1"); result.add("-"); result.add("3"); result.add("*");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void advancedExpression2() {
        input.add("("); input.add("("); input.add("10"); input.add("*"); input.add("("); input.add("6"); input.add("/"); input.add("(");
        input.add("("); input.add("9"); input.add("+"); input.add("3"); input.add(")"); input.add("*"); input.add("-11");
        input.add(")"); input.add(")"); input.add(")"); input.add("+"); input.add("17"); input.add(")"); input.add("+"); input.add("5");
        result.add("10"); result.add("6"); result.add("9"); result.add("3"); result.add("+");
        result.add("-11"); result.add("*"); result.add("/"); result.add("*");
        result.add("17"); result.add("+"); result.add("5"); result.add("+");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void advancedExpression3() {
        input.add("("); input.add("4"); input.add("+"); input.add("("); input.add("13");
        input.add("/"); input.add("5"); input.add(")"); input.add(")");
        result.add("4"); result.add("13"); result.add("5"); result.add("/"); result.add("+");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }
}
