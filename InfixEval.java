/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infixexpeval;

import java.util.*;
import javax.swing.JOptionPane;

public class InfixEval {
    private Stack<String> expStack = new Stack<>(); //expression stack
    private Stack<Integer> numStack = new Stack<>(); //number Stack only integers
    private static final String OPERATORS="+-/*()"; // Operators

    //Map For Operator precedence
    Map<String, Integer> operatorOrder = new HashMap<>();

    //constructor
    public InfixEval(){
        //give operators precendence
        operatorOrder.put(")", 0);
        operatorOrder.put("*", 1);
        operatorOrder.put("/", 1);
        operatorOrder.put("+", 2);
        operatorOrder.put("-", 2);
        operatorOrder.put("(", 3);
    }
    public int infix(String input) {

        String eachNumber=""; //holds number values

        int charInput = input.length();

        input.replaceAll("\\s+",""); //removes spaces

        StringTokenizer tokens = new StringTokenizer(input, "()*/+-", true);

        //loops through input
        while(tokens.hasMoreTokens()){
            String eachChar = tokens.nextToken();
            //if operator is valid continue
            if (isOpValid(eachChar)){

                if (!isOpenParen(eachChar) && isNumeric(eachNumber)){
                    //if number, push to the number stack
                    numStack.push(Integer.parseInt(eachNumber));
                    eachNumber="";
                }

                if (expStack.isEmpty() || isOpenParen(eachChar)){ //if it's the first item or open parenthesis
                    //push expression in expression stack
                    expStack.push(eachChar);
                } else if (isCloseParen(eachChar)){
                    pushExpStack(numStack, expStack);
                }
                //if the current operator has precedence then push it
                else if (getPrecedenceOperator(eachChar, expStack.peek()).equals(eachChar)){
                    expStack.push(eachChar);
                }

                //if the current operator does not have precedence then evaluate last expression.
                else if(numStack.size() > 2){
                    //Evaluate expression if it has precendence
                    pushNumStack(numStack, expStack);
                    //push current expression
                    expStack.push(eachChar);
                }
            }
            else if (isNumeric(eachChar)){
                eachNumber+=eachChar;
                //last number
                if (charInput==0){
                    numStack.push(Integer.parseInt(eachNumber));
                }
            }
            //keep track of stack contents
            System.out.println ("Number Stack : "+numStack);
            System.out.println ("Expression Stack : "+expStack);
        }
        //display final operation
        System.out.println("\nFinal Expression stack " +expStack);
        System.out.println("Final Number stack : "+numStack);

        while (!expStack.empty()){
            pushNumStack(numStack,expStack);
        }
        //display final result
        System.out.println ("\nFinal result : "+numStack);

        return numStack.pop();
    }

    private boolean isCloseParen(String operator) {
        return (operator.equals(")"));
    }

    private boolean isOpenParen(String operator) {
        return (operator.equals("(")?true:false);
    }

    //pops evaluated section and pushes result into the number stack
    private void pushNumStack(Stack<Integer> numStack, Stack<String> expStack) {

        Integer a=numStack.pop();
        Integer b=numStack.pop();
        //displays numbers to be evaluated
        System.out.println ("Number stack : "+ a + " | "+ b );
        //pops evaluated numbers
        Integer poppedResult = this.calculator(b, a, expStack.pop());
        numStack.push(poppedResult);
    }

    //Evaluate current stack
    private void pushExpStack(Stack<Integer> numStack, Stack<String> expStack) {

        while (!expStack.empty()){

            if (isOpenParen(expStack.peek())){ //pop value when next ( is reached
                expStack.pop();
                break;
            }
            pushNumStack(numStack,expStack);
        }

    }

    //Checks if operator is valid
    private boolean isOpValid(String input) {
        return (OPERATORS.contains(input)?true:false);
    }

    //Check Precedence of operator
    private String getPrecedenceOperator(String firstOperator, String secondOperator){
        return (operatorOrder.get(firstOperator) < operatorOrder.get(secondOperator)?firstOperator:secondOperator);
    }
    //Check whether String is number or not
    private static boolean isNumeric(String str)  {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    //Caclulate result for 2 oprands and one operator
    private Integer calculator(Integer a, Integer b, String operator) throws ArithmeticException{
        Integer x = (int) 0;
        switch (operator) {
            case "+" :
                x=a+b;
                break;
            case "-" :
                x=a-b;
                break;
            case "*":
                x=a*b;
                break;
            case "/":
                //check for valid denomenator
                if (b==0){
                    x=(int) 0;
                    JOptionPane.showMessageDialog(null,"Can't divide by 0");
                    throw new ArithmeticException("Divide by zero");
                }
                else{
                    x = a/b;
                }
                break;
        }
        return x;
    }

}


