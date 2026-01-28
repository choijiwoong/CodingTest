import java.lang.System;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] list = new int[length];
        for (int i=0; i<length; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[i] = a+b;
        }
        for (int i=0; i<length; i++)
            System.out.println(list[i]);
        sc.close();
    }
}