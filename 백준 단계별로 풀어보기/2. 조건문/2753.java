import java.lang.System;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int result = (input%4==0 && (input%100!=0 || input%400 ==0)) ? 1: 0;
        System.out.println(result);
        sc.close();
    }

}