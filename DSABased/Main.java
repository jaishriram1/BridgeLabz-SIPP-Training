public interface ExpressionEvaluator {
    /**
     * Converts an infix expression string to a postfix expression string.
     * @param infixExpression The mathematical expression in infix notation.
     * @return The equivalent expression in postfix notation.
     */
    String infixToPostfix(String infixExpression);

    /**
     * Evaluates a postfix expression string.
     * @param postfixExpression The mathematical expression in postfix notation.
     * @return The result of the evaluation.
     */
    int evaluatePostfix(String postfixExpression);
}
// PostfixEvaluator.java

import java.util.Stack;

public class PostfixEvaluator implements ExpressionEvaluator {

    private int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1; // For non-operators
    }

    @Override
    public String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (String token : infixExpression.split("\\s+")) {
            char firstChar = token.charAt(0);

            if (Character.isDigit(firstChar)) {
                postfix.append(token).append(" ");
            } 
            else if (firstChar == '(') {
                operatorStack.push(firstChar);
            } 
            // If token is a closing parenthesis, pop and append until '(' is found
            else if (firstChar == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop(); // Pop the '('
            } 
            else {
                while (!operatorStack.isEmpty() && getPrecedence(firstChar) <= getPrecedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(firstChar);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    @Override
    public int evaluatePostfix(String postfixExpression) {
        Stack<Integer> operandStack = new Stack<>();

        for (String token : postfixExpression.split("\\s+")) {
            // If token is a number, push it to the stack
            if (token.matches("\\d+")) {
                operandStack.push(Integer.parseInt(token));
            } 
            // If token is an operator, pop two operands, perform operation, and push result
            else {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                switch (token.charAt(0)) {
                    case '+':
                        operandStack.push(operand1 + operand2);
                        break;
                    case '-':
                        operandStack.push(operand1 - operand2);
                        break;
                    case '*':
                        operandStack.push(operand1 * operand2);
                        break;
                    case '/':
                        operandStack.push(operand1 / operand2);
                        break;
                }
            }
        }
        // The final result is the only item left on the stack
        return operandStack.pop();
    }
}
// Main.java
public class Main {
    public static void main(String[] args) {
        // Polymorphism: We code against the interface.
        ExpressionEvaluator evaluator = new PostfixEvaluator();

        // Example expression (Note: tokens are space-separated)
        String infixExpression = "10 + 2 * ( 6 - 3 )";

        System.out.println("Infix Expression: " + infixExpression);

        // 1. Convert infix to postfix
        String postfixExpression = evaluator.infixToPostfix(infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        // 2. Evaluate the postfix expression
        int result = evaluator.evaluatePostfix(postfixExpression);
        System.out.println("Evaluation Result: " + result); // Expected: 16
        
        System.out.println("---");
        
        // Another example
        String infixExpression2 = "5 * ( 4 + 3 ) - 10 / 2";
        System.out.println("Infix Expression: " + infixExpression2);
        String postfixExpression2 = evaluator.infixToPostfix(infixExpression2);
        System.out.println("Postfix Expression: " + postfixExpression2);
        int result2 = evaluator.evaluatePostfix(postfixExpression2);
        System.out.println("Evaluation Result: " + result2); // Expected: 30
    }
}