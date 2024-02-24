package assignment1;

public class InfixEvaluator {
	public static int evaluate(String exp) {
		Stack<Integer> operands = new Stack<>(); // Operand stack
		Stack<Character> operators = new Stack<>(); // Operator stack
		
			for (int i = 0; i < exp.length(); i++) {
				char c = exp.charAt(i);
				if (Character.isDigit(c)) // check if it is number
				{
					operands.push(c-'0');
				} else if (c == '(') {
					operators.push(c);
				} else if (c == ')') {
					while (operators.peek() != '(') {
						int output = performOperation(operands, operators);
						operands.push(output); // push result back to stack
					}
					operators.pop();
				} else if (isOperator(c)) {
					while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
						int output = performOperation(operands, operators);
						operands.push(output); // push result back to stack
					}
					operators.push(c); // push the current operator to stack
				}
			}

			while (!operators.isEmpty()) {
				int output = performOperation(operands, operators);
				operands.push(output); // push final result back to stack
			}
		
		return operands.pop();
	}

	static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	public static int performOperation(Stack<Integer> operands, Stack<Character> operators) {
		int a = (int) operands.pop();
		int b = (int) operands.pop();
		char operation = (char) operators.pop();
		switch (operation) {
		case '+':
			return a + b;
		case '-':
			return b - a;
		case '*':
			return a * b;
		case '/':
			return b / a;
		}
		return 0;
	}

	public static boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
	}
}
