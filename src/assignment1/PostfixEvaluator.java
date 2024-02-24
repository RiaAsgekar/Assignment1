package assignment1;

import java.util.Stack;

public class PostfixEvaluator {

	public static int evaluatePostfix(String postfixExpression) {
		Stack<Integer> stack = new Stack<>();

		for (char c : postfixExpression.toCharArray()) {
			if (Character.isDigit(c)) {
				// If the character is a digit, push it onto the stack
				stack.push(c - '0'); // Convert char to int
			} else if (isOperator(c)) {
				// If the character is an operator, pop the required number of operands
				// Perform the operation and push the result back onto the stack
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				int result = performOperation(c, operand1, operand2);
				stack.push(result);
			}
		}

		// The final result will be the only item left on the stack
		return stack.pop();
	}

	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private static int performOperation(char operator, int operand1, int operand2) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}
}
