package algorithm;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        System.out.print("Enter any expression: ");
        Scanner input = new Scanner(System.in);
        String infixExp = "a*b+c*d";//input.nextLine();
        String postFixExp = convertToPostfix(infixExp);
        System.out.println("Given Expression: " + infixExp);
        System.out.println("Post Fix Expression: " + postFixExp);
        double value = evaluateValue(postFixExp, getValueMap());
        System.out.println("Post Fix Value: " + value);
    }

    private static double evaluateValue(String postFixExp, HashMap<Character, Integer> valueMap) {
        Stack<Double> stack = new Stack<>();
        for (char each : postFixExp.toCharArray()) {
            if (isOperator(each)) {
                double opd2 = stack.pop();
                double opd1 = stack.pop();
                double result = getResult(opd1, opd2, each);
                stack.push(result);
            } else {
                System.out.println("Getting each=" + each);
                stack.push(Double.valueOf(valueMap.get(each)));
            }
        }
        return stack.pop();
    }

    private static double getResult(double opd1, double opd2, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = opd1 + opd2;
                break;
            case '-':
                result = opd1 - opd2;
                break;
            case '*':
                result = opd1 * opd2;
                break;
            case '/':
                result = opd1 / opd2;
                break;
            case '^':
                result = Math.pow(opd1, opd2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        return result;
    }

    private static HashMap<Character, Integer> getValueMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 6);
        map.put('b', 2);
        map.put('c', 4);
        map.put('d', 3);
        return map;
    }

    private static String convertToPostfix(String infixExp) {
        StringBuffer postFix = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (char each : infixExp.toCharArray()) {
            if ((each >= 'a' && each <= 'z') || (each >= 'A' && each <= 'Z')) {
                postFix.append(each);
            } else {
                switch (each) {
                    case '*':
                    case '/':
                    case '+':
                    case '-':
                    case '^': {
                        int inPriority = getOperatorPriority(each);
                        if (stack.isEmpty() || getOperatorPriority(stack.peek()) < inPriority) {
                            stack.push(each);
                        } else {
                            while (!stack.isEmpty() && stack.peek() != '(' && getOperatorPriority(stack.peek()) >= inPriority) {
                                postFix.append(stack.pop());
                            }
                            stack.push(each);
                        }
                        break;
                    }
                    case '(': {
                        stack.push(each);
                        break;
                    }
                    case ')': {
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            postFix.append(stack.pop());
                        }
                        stack.pop(); // Pop and discard the open parenthesis
                        break;
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            postFix.append(stack.pop());
        }
        return postFix.toString();
    }

    private static boolean isOperator(Character stackEntry) {
        switch (stackEntry) {
            case '(':
            case '^':
            case '*':
            case '/' :
            case '+':
            case '-': {
                return true;
            }
        }
        return false;
    }

    private static int getOperatorPriority(char operand) {
        switch (operand) {
            case '(': {
                return 4;
            }
            case '^': {
                return 3;
            }
            case '*':
            case '/' :{
                return 2;
            }
            case '+':
            case '-': {
                return 1;
            }
        }
        throw new IllegalArgumentException("Invalid Operator");
    }
}
