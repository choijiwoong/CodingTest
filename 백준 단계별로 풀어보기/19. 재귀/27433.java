import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        /*
            0!은 1이다. 개멍청 포인트 1.

            범위 20!인데 체크 제대로 안함. 20!은 2,432,902,008,176,640,000이다. 243경
            자바 long은 922경까지 가능하니까 초심좀 찾자. 한심하다.

         */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(factorial(n));
        sc.close();
    }

    public static long factorial(long n){
        if(n==0 || n==1)
            return 1;
        return n*factorial(n-1);
    }
}