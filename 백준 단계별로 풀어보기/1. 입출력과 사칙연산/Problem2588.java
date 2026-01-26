import java.lang.System;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        String input2 = sc.next();
        int part1 = input2.charAt(0)-'0';
        int part2 = input2.charAt(1)-'0';
        int part3 = input2.charAt(2)-'0';

        int output3 = input1 * part3;
        int output4 = input1 * part2;
        int output5 = input1 * part1;
        int output6 = output3 + output4 * 10 + output5 * 100;
        System.out.printf("%d%n%d%n%d%n%d%n", output3, output4, output5, output6);
    }
}