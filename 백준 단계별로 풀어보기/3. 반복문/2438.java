import java.lang.System;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        for(int i=0; i<length; i++){
            for(int j=0; j<=i; j++)
                System.out.print("*");
            System.out.println();
        }
        sc.close();
    }
}