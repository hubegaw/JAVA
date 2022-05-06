package ShuntingYardAlgorithm;

import java.util.ArrayList;

public interface IShuntingYard {
    ArrayList<String> transformExpressionToPRN(ArrayList<String> input);
    boolean checkIfSymbolIsNumber(String symbol);
    int establishPrecedence(String symbol);
    boolean hasLeftAssociativity(String symbol);
}
