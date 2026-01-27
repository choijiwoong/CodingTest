import java.lang.System;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int time = sc.nextInt();
        h = (h + (m+time)/60)%24;
        m = (m+time)%60;
        System.out.printf("%d %d", h, m);
        sc.close();
    }
}