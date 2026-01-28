import java.lang.System;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int total_price = sc.nextInt();
        int length = sc.nextInt();
        int sum_price = 0;
        for (int i=0; i<length; i++){
            int price = sc.nextInt();
            int amount = sc.nextInt();
            sum_price += price * amount;
        }

        if(total_price == sum_price)
            System.out.println("Yes");
        else
            System.out.println("No");
        sc.close();
    }
}