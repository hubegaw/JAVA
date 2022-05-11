package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ShuntingYardAlgorithm.ShuntingYard;

import java.util.ArrayList;
import java.util.Collections;

public class ShuntingYardTests {
    private final ShuntingYard sy = new ShuntingYard();
    private final ArrayList<String> result = new ArrayList<>();
    private final ArrayList<String> input = new ArrayList<>();

    @Test
    void addition() {
        Collections.addAll(input, "1", "+", "1");
        Collections.addAll(result, "1", "1", "+");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void subtraction() {
        Collections.addAll(input, "1", "-", "1");
        Collections.addAll(result, "1", "1", "-");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void multiplication() {
        Collections.addAll(input, "2", "*", "1");
        Collections.addAll(result, "2", "1", "*");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void division() {
        Collections.addAll(input, "2", "/", "1");
        Collections.addAll(result, "2", "1", "/");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void advancedExpression1() {
        Collections.addAll(input, "(", "2", "-", "1", ")", "*", "3");
        Collections.addAll(result, "2", "1", "-", "3", "*");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void advancedExpression2() {
        Collections.addAll(input, "(", "(", "10", "*", "(", "6", "/", "(", "(", "9", "+", "3", ")", "*", "-11", ")", ")", ")", "+", "17" , ")", "+", "5");
        Collections.addAll(result, "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }

    @Test
    void advancedExpression3() {
        Collections.addAll(input, "(", "4", "+", "(", "13", "/", "5", ")", ")");
        Collections.addAll(result, "4", "13", "5", "/", "+");
        assertEquals(result, sy.transformExpressionToPRN(input));
        result.clear();
    }
}
