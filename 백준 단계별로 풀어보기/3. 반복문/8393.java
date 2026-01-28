import java.lang.System;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = (1+n)*n/2;
        System.out.println(result);

        sc.close();
    }
}