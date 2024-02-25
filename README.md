# Expression Conversion and Evaluation Using Stack (Assignment 1)
In this assignment, we are evaluating the time taken for infix and postfix notations to evaluate mathematical expressions. We are evaluating infix expressions against their converted postfix counterparts. 

Stack is the data structure chosen because it works best with the nature of mathematical expressions and the requirement to maintain the order of operations and handling parentheses.

# Table Of Contents
InfixEvaluator.java: Contains the main class to evaluate infix expressions. It utilizes the InfixToPostfixConversion class to convert infix expressions to postfix notation and PostfixEvaluator class to evaluate the resulting postfix expression.

InfixToPostfixConversion.java: This class is responsible for converting infix expressions to postfix notation.

PostfixEvaluator.java: This class evaluates postfix expressions.

Stack.java: Contains the implementation of a stack data structure, which is used in the conversion process and expression evaluation.

test.java: Contains some test cases to demonstrate the functionality of the classes.

Video Recording: Explanation of code implementation.

Project Report


# Usage:
To use the expression conversion and evaluator:

Compile all the .java files: javac *.java

Run the test.java file to get output of table of evaluation times.
