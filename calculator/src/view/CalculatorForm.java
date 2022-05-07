package view;

import PolishReverseNotationAlgorithm.IPolishReverseNotation;
import PolishReverseNotationAlgorithm.PolishReverseNotation;
import ShuntingYardAlgorithm.IShuntingYard;
import ShuntingYardAlgorithm.ShuntingYard;
import exceptions.DivisionByZero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorForm {
    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton plus;
    private JButton equalsButton;
    private JButton minus;
    private JButton multiplicate;
    private JButton numb_3;
    private JButton numb_6;
    private JButton numb_9;
    private JButton numb_8;
    private JButton numb_5;
    private JButton numb_2;
    private JButton numb_0;
    private JButton numb_7;
    private JButton numb_4;
    private JButton numb_1;
    private JButton clear;
    private JButton dot;
    private JButton divide;
    private JButton back;
    private JButton rightBracket;
    private JButton leftBracket;

    private IPolishReverseNotation prn = new PolishReverseNotation();
    private final IShuntingYard sy = new ShuntingYard();
    private String number = "";
    private String result = "";
    StringBuilder expression = new StringBuilder("");
    private final ArrayList<String> input = new ArrayList<>();
    private int countLeftBrackets = 0;
    private int countRightBrackets = 0;
    private int expressionSize = 0;
    private char lastSymbol;
    private boolean resultIsDisplayed = false;

    private static CalculatorForm form;

    public CalculatorForm() {
        numb_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += numb_0.getText();
                expression.append(numb_0.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        numb_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += numb_1.getText();
                expression.append(numb_1.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        numb_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += numb_2.getText();
                expression.append(numb_2.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        numb_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += numb_3.getText();
                expression.append(numb_3.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        numb_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += numb_4.getText();
                expression.append(numb_4.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        numb_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += numb_5.getText();
                expression.append(numb_5.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        numb_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += numb_6.getText();
                expression.append(numb_6.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        numb_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += numb_7.getText();
                expression.append(numb_7.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        numb_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += numb_8.getText();
                expression.append(numb_8.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        numb_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += numb_9.getText();
                expression.append(numb_9.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateDotButton();
                textArea.setText(String.valueOf(expression));
            }
        });
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(resultIsDisplayed) {
                    resultIsDisplayed = false;
                    input.add(result);
                    expression.append(result);
                    result = "";
                } else if(!number.isEmpty()){
                    pushNumberToInput();
                }
                validateOperator(plus.getText());
                input.add(plus.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(resultIsDisplayed) {
                    resultIsDisplayed = false;
                    input.add(result);
                    expression.append(result);
                    result = "";
                } else if(!number.isEmpty()) {
                    pushNumberToInput();
                }
                validateOperator(minus.getText());
                input.add(minus.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        multiplicate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(resultIsDisplayed) {
                    resultIsDisplayed = false;
                    input.add(result);
                    expression.append(result);
                    result = "";
                } else if(!number.isEmpty()) {
                    pushNumberToInput();

                }
                validateOperator(multiplicate.getText());
                input.add(multiplicate.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(resultIsDisplayed) {
                    resultIsDisplayed = false;
                    input.add(result);
                    expression.append(result);
                    result = "";
                } else if(!number.isEmpty()) {
                    pushNumberToInput();
                }
                validateOperator(divide.getText());
                input.add(divide.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        leftBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkIfNumber(expression.charAt(expression.length()-1)))
                    pushNumberToInput();
                validateBracket(leftBracket.getText());
                input.add(leftBracket.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        rightBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkIfNumber(expression.charAt(expression.length()-1)))
                    pushNumberToInput();
                validateBracket(rightBracket.getText());
                input.add(rightBracket.getText());
                textArea.setText(String.valueOf(expression));
            }
        });
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastSymbol = expression.charAt(expression.length()-1);
                if(!input.isEmpty() && !expression.isEmpty() && lastSymbol != '+' && lastSymbol != '-' && lastSymbol != '*' && lastSymbol != '/') {
                    if(checkIfNumber(lastSymbol))
                        pushNumberToInput();
                    try {
                        result = String.valueOf(prn.getSolution(sy.transformExpressionToPRN(input)));
                        textArea.setText(result);
                        clearInput();
                    } catch (DivisionByZero ex) {
                        textArea.setText(ex.getMessage());
                    }
                    resultIsDisplayed = true;
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateBackOperation();
                textArea.setText(String.valueOf(expression));
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInput();
                result = "";
                textArea.setText(String.valueOf(expression));
            }
        });
    }

    private void pushNumberToInput() {
        input.add(number);
        number = "";
    }

    private void clearInput() {
        expression.delete(0,expression.length());
        number = "";
        input.clear();
    }

    private void validateDotButton() {
        expressionSize = expression.length();
        if(expressionSize != 0)
            lastSymbol = expression.charAt(expressionSize - 1);
        if(!expression.isEmpty() && lastSymbol != '.' && !number.contains(".") && !number.isEmpty()) {
            number += dot.getText();
            expression.append(dot.getText());
        }
    }

    private void validateOperator(String sign) {
        expressionSize = expression.length();
        if(expressionSize != 0) {
            lastSymbol = expression.charAt(expressionSize - 1);
            if (lastSymbol != sign.charAt(0) && (lastSymbol == '*' || lastSymbol == '+' ||
                    lastSymbol == '-' || lastSymbol == '/')) {
                expression.replace(expressionSize - 1, expressionSize, sign);
            } else if (lastSymbol != sign.charAt(0)) {
                expression.append(sign);
            }
        }
    }

    private void validateBracket(String bracket) {
        expressionSize = expression.length();
        if (bracket.equals("(") && expressionSize == 0) {
            countLeftBrackets += 1;
            expression.append(bracket);
            return;
        }
        if(expressionSize != 0) {
            lastSymbol = expression.charAt(expressionSize-1);
            if (bracket.equals("(") && (lastSymbol == '+' || lastSymbol == '-' || lastSymbol == '*' ||
                    lastSymbol == '/' || lastSymbol == '(')) {
                countLeftBrackets += 1;
                expression.append(bracket);
            }
            if (lastSymbol != ')' && countLeftBrackets > countRightBrackets) {
                if (lastSymbol != '+' && lastSymbol != '-' && lastSymbol != '*' &&
                        lastSymbol != '/' && lastSymbol != '(') {
                    countRightBrackets += 1;
                    expression.append(bracket);
                }
            }
        }
    }

    private void validateBackOperation() {
        expressionSize = expression.length();
        if(expressionSize != 0 && !input.isEmpty()) {
            lastSymbol = expression.charAt(expressionSize-1);
            if (checkIfNumber(lastSymbol) || lastSymbol == '.') {
                number = number.substring(0,number.length()-1);
                expression.deleteCharAt(expressionSize-1);
            }
        }
    }

    private boolean checkIfNumber(char symbol) {
        switch(symbol) {
            case '*','/','+','-',')','(' -> { return false; }
            default -> { return true; }
        }
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Calculator");
        form = new CalculatorForm();
        mainFrame.setContentPane(form.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
}
