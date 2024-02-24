package assignment1;

public class InfixToPostfixConversion {

	public static String convertToPostfix(String infixExpression) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < infixExpression.length(); i++) {
			char c = infixExpression.charAt(i);

			if (Character.isDigit(c)) {
				postfix.append(c); // adding operands to the output string
			} else if (c == '(') {
				operators.push(c); //adding open parenthesis to the stack
			} else if (c == ')') { //if the parenthesis is over, evaluate the sub-expression in it
				while (!operators.isEmpty() && operators.peek() != '(') {
					postfix.append(operators.pop()); //add the operators to the output by popping from stack until we reach the respective bracket 
				}
				if (!operators.isEmpty() && operators.peek() != '(') { //if an unexpected parenthesis is encountered
					throw new IllegalArgumentException("Invalid expression: has unbalanced parentheses");
				} else {
					operators.pop();
				}
			} else {
				while (!operators.isEmpty() && (precedence(c) <= precedence(operators.peek()))) {
					if (operators.peek() == '(') {
						throw new IllegalArgumentException("Invalid expression: has unbalanced parentheses");
					}
					postfix.append(operators.pop()); //pop higher precedence operators
				}
				operators.push(c);
			}
		}

		while (!operators.isEmpty()) {
			if (operators.peek() == '(') {
				throw new IllegalArgumentException("Invalid expression: has unbalanced parentheses");
			}
			postfix.append(operators.pop()); //pop remaining operators in stack and add to the output postfix expression
		}

		return postfix.toString();
	}

	private static int precedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return 0;
		}
	}
}