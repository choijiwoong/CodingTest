import java.lang.System;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a=-1, b=-1;
        while(sc.hasNextInt()){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a+b);
        }
        sc.close();
    }
}