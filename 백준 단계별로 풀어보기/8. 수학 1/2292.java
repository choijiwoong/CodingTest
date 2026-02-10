import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        if(n==1){
            System.out.println(1);
            return;
        }

        int sum=1;
        int i;
        for(i=1; sum<n; i++)
            sum+=6*(i-1);

        System.out.println(i-1);
        sc.close();
    }
}