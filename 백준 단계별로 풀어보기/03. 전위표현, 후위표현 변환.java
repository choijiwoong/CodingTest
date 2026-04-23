import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Main {
    private static int getPriority(char op){
        if(op=='+'||op=='-')
            return 1;
        if(op=='*'||op=='/')
            return 2;
        return -1;
    }

    public static String infixToPostfix(String infix){
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : infix.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            } else if(c=='('){
                stack.push(c);
            } else if(c==')'){
                while(!stack.isEmpty()&&stack.peek()!='(')
                    sb.append(stack.pop());
                stack.pop();
            } else{
                while(!stack.isEmpty()&&getPriority(stack.peek())>=getPriority(c))
                    sb.append(stack.pop());
                stack.push(c);
            }
        }

        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    public static String postfixToInfix(String postfix){
        Deque<String> stack = new ArrayDeque<>();
        for(char c: postfix.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else{
                String op2 = stack.pop();
                String op1 = stack.pop();
                stack.push("("+op1+c+op2+")");
            }
        }
        return stack.pop();
    }

    public static String prefixToInfix(String prefix){
        Deque<String> stack = new ArrayDeque<>();
        for(int i=prefix.length()-1; i>=0; i--){
            char c = prefix.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else{
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("("+op1+c+op2+")");
            }
        }
        return stack.pop();
    }

    public static String infixToPrefix(String infix){
        StringBuilder reversed = new StringBuilder();
        for(int i=infix.length()-1; i>=0; i--){
            char c = infix.charAt(i);

            if(c=='(')
                reversed.append(')');
            else if(c==')')
                reversed.append('(');
            else
                reversed.append(c);
        }
        String postfix = infixToPostfix(reversed.toString());
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) throws IOException{
        String infixExp="A*(B+C)/D";

        System.out.println("[ 원본 중위 표기식 ] : " + infixExp);
        System.out.println("---------------------------------------");

        // 1. 중위 -> 후위 -> 다시 중위
        String post = infixToPostfix(infixExp);
        System.out.println("1. 후위로 변환: " + post);
        System.out.println("   다시 중위로: " + postfixToInfix(post));

        System.out.println("---------------------------------------");

        // 2. 중위 -> 전위 -> 다시 중위
        String pre = infixToPrefix(infixExp);
        System.out.println("2. 전위로 변환: " + pre);
        System.out.println("   다시 중위로: " + prefixToInfix(pre));
    }
}