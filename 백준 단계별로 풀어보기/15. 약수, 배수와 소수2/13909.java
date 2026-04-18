import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        /*
            - 문제 이해
            입력 21억까지의 양의 정수.
            1번째 사람은 1배수 index를 xor.
            2번째 사람은 2배수 index를 xor.
            초기에 모든 창문은 닫혀있음.

            수학적 규칙이 있을 듯 하지만 한 눈에 알아보기 쉽지 않다.

            시도 1.
            늘 그렇듯 우선 brute force하게 TDD접근한 뒤 최적화를 시도해보자.
            사실 간단하게만 생각하면 int[n]를 만들어서 직접 !시키는거다.
        */
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();

        int[] window = new int[n+1];
        for(int i=1; i<=n; i++){
            //i번째 사람은
            for(int j=1; i*j<=n; j++){
                window[i*j] = (window[i*j]==1)?0:1;
            }
        }

        int result = Arrays.stream(window).sum();

        System.out.println(result);
        sc.close();
    }
}