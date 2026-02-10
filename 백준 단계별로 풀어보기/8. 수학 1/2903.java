import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int prev = 3;

        while(--n > 0)
            prev+=prev-1;

        System.out.println(prev*prev);
        sc.close();
    }
}