package assignment1;

public class test {
	public static void main(String[] args) {
		// Array of different infix expressions to evaluate
		String[] infixExpressions = { "7", "6/2", "a+1", "1+4*7", "5+8-6", "5-0-9*6", "2+3+4-5/0", "6-(3*2+4)",
				"3+8-3*(4+8)", "4+3/3+9*2/1", "9*8+3/1)-5*2", "6+3+5+4-5*7*3", "(1+2+3)/(1*3)", "(4/2-1*8/2)/1",
				"4+(3-2+(7*3+3/1))", "5*(9+4-2+4*7)*3-5", "(9+7+9*2+5)*(2+6-4)", "8*8*5*3/2-9+2+6*(4+5)",
				"9/4+8-5*7-9+2/4(7+5*2)", "(5*8+3)(4*7*1/3)/(2+1-5-4/2)(2+6)-2*5+7*(8+9/3+6)+(5+4*(8+6/2+7/2)/3)",
				"5+3+6*(9+2*3*4)-5(2+3-4*7)-5*4(8/4)+2-3+7-4+9*0-(8+9/3)+(3*(8+6/2+7/2)/3)*(4+8-6+3)(2+5-3+9-2)(2+1-5-4/2)*(2+6)" };

		System.out.println("Test Case   T1\t\tT2\t\tLength of infix expression");
		for (int i = 0; i < infixExpressions.length; i++) {
			System.out.print(i + "\t    ");
			String infix = infixExpressions[i];

			// Get current time
			long startTime = System.nanoTime();

			try {
				// Convert to postfix and evaluate
				int op1 = PostfixEvaluator.evaluatePostfix(InfixToPostfixConversion.convertToPostfix(infix));

				// Get elapsed time
				long elapsedTime1 = System.nanoTime() - startTime;

				// Get current time
				startTime = System.nanoTime();

				// Evaluate infix directly
				int op2 = InfixEvaluator.evaluate(infix);

				// Get elapsed time
				long elapsedTime2 = System.nanoTime() - startTime;
				System.out.println(elapsedTime1 + "\t" + elapsedTime2 + "\t\t" + infix.length());
			} catch (ArithmeticException e) {
				System.out.println("-----Divide by zero error-----");
			} catch (Exception e) {
				System.out.println("---Invalid infix expression---");
			}

			// Print results for each expression
//            System.out.println("Expression " + (i + 1) + ": " + infix);
//            System.out.println("Converting to Postfix and then evaluating -- Output: " + op1 + " - Time: " + elapsedTime1 + " ms");
//            System.out.println("Evaluating infix expression directly      -- Output: " + op2 + " - Time: " + elapsedTime2 + " ms");
//            System.out.println("------------------------");
		}
	}
}