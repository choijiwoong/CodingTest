import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static boolean is_devil(int num){
        while(num>=666){
            if(num%1000==666)
                return true;
            num/=10;
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        /*
            종말의 수: 6이 3개이상 연속으로 들어가는 수. 666 1666 2666 3666...
            n을 입력 받으면 피보나치처럼 n번째 종말의 수를 출력하라.

            n은 10,000 이하의 자연수. 최대의 수는 계산해봐야 알 것 같기에 int대신 long으로 시작하자.
            일반적으로 6이 3개 이상인 경우는 666 6666 66666 등으로 비교적 단순해보이나, bruteforce인 것을 생각하면
            복잡한 전제조건이 들어갈 것 같다.
            666으로 만들 수 있는 수를 생각해보자. x666, xx666, xx666, xxx666 이랑 666x 666xx 666xxx가 있다.
            이 때 이들의 대소비교가 가능한가? 즉 x666과 666x를 생각해볼 때 대소비교가 불가능하다.
            즉, 모든 경우의 수를 bruteforce해야하지 666이나 6666을 조합해서 그 경우를 예측하기에, 또 최소값을 찾기 어렵다.

            그렇다면 1부터 모든 수를 체크해야하는가? 그게 가장 편한 방법이긴 하나, 666이 들어가려면 최소한 그 수가 666이상이기에
            666부터 시작하여 탐색 범위를 조금 줄일 수 있다.

            그리고 그 수를 악마의 수인지 판단하는 로직도 생각해보자.
            666은 연속해서 들어가야한다. long대신 String형식으로 보아, 666이 contains되는지 여부만 확인하면, 6666도 66666도 판단 가능하다.
            다만 문자열의 비교는 속도가 느리기에 숫자로의 비교는 못하는 것일까? 숫자를 쪼갠다 하더라도 결국 String으로 해야할 듯 하다.
            우선 초안을 String으로 해두고, Time Limit Exceeded가 발생하는지 확인한 후 최적화해보자.

            또한 구현 후 10,000을 넣어보아 최댓값이 몇인지도 확인한 후 최적화 시 이용이 가능한지 살펴보자.
            현재 로직이 맞다면, 10,000 번 째 종말의 수는 2,666,799이다. 이는 int로 포함되니 long에서 int로 바꾸고, Long.MAV_VALUE대신 사용하자.

            제출 결과, TLE가 발생하지는 않았으나 gemini에게 최적화 가능여부를 물어보자.
            현재 666포함 여부를 String으로 활용하나, 이는 객체 생성비용(시간초과)가 크다.

            gemini는 while를 활용한 최적화를 권하니, 현재의 코드를 주석처리한 후 최적화해보자.
            실행 시간을 백준에서 비교해보니 기존 String방식은 284ms가, %1000을 이용한 비교는 132ms로 2배 이상의 차이를 확인할 수 있었다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int MAX_DEVIL = 2666799;
        for(int i = 666; i <= MAX_DEVIL; i++){
            //String num = String.valueOf(i);
            //if(num.contains("666"))
            //    n--;
            if(is_devil(i))
                n--;
            if(n==0){
                bw.write(String.valueOf(i));
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}