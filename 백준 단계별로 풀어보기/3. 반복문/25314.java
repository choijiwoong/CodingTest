import java.lang.System;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int input_byte = sc.nextInt();

        int repeat_count = input_byte%4==0 ? input_byte/4 : input_byte/4+1;

        for(int i=0; i<repeat_count; i++)
            System.out.printf("long ");
        System.out.println("int");
        sc.close();
    }
}