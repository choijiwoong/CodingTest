import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static boolean[] is_prime = new boolean[1000001];

    public static void main(String[] args) throws IOException{
        /*
            귀찮으니 빠르게 두문제 컷하고 다음 단계로 넘어가자.
            개수(최대100개), 정수는 짝수이며 1,000,000이하.(백만)
            골드바흐 파티션: 짝수 N을 두 소수의 합으로 나타내는 표현.
            ex 2는 0개 4는 2+2 1개. 6은 3+3, 2+2+2 2개.

            DP를 사용해야할듯한데, DP는 내 기억 상 이전 결과를 이용하여 효율을 향상시키는 것.
            하지만 이전에 혹시 규칙이 있을까? 2는0, 4는1, 6은2, 8은 3(2222 332 53)
            아하! 문제를 잘못이해했다. "두 소수"이다.
            6은 ..왜 1이지? 222 33 인데.. 아 애초에 두 소수니까 222는 안되네

            다시. 4는 2+2 (1개), 2는 0개, 6은 3+3 (1개), 8은 5+3 (1개) 10은 5+5, 3+7(2개)
            ㅇㅋㅇㅋ

            시도1. bruteforce하게 접근하면, 2~n-2, n-2~2까지의 경우 중 두 수가 소수인 경우.
            이 때 2 이상의 짝수는 소수가 아니기에 +2를 하며 진행하여 최적화 가능.
            파티션 계산 시 두 수가 같은 경우, 다른 경우를 나누어 생각하면 최적화 가능.
            두 수가 같아질 때 까지 파티션 수 *2, 같다면 +1 다르다면 종료.

            디버깅1. +2하니까 같은 경우를 지나치기도 함. 우선 +1하며 TDD하자.
            순서 달라도 같은 파티션이래. 문제 잘 읽자.

            시도2. 우선 TLE가 발생하였다. 짝수인 경우 건너뛰는 로직을 이용해 최적화해보자.

            시도3. Gemini
            입력값이 1,000,000으로 고정되어있다고 미리 초기에 소수 배열을 저장해두라고 한다.

        */
        init_primeset();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            int num = Integer.parseInt(br.readLine());
            int count_partition = calc_partition(num);
            bw.write(String.valueOf(count_partition));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int calc_partition(int num){
        int a=2, b=num-2;
        int count=0;
        while(a<=b){
            if(is_prime[a] && is_prime[b])
                count++;
            a++;
            b--;
        }
        return count;
    }

    public static void init_primeset(){
        Arrays.fill(is_prime, true);
        is_prime[0] = is_prime[1] = false;

        //2부터 시작하여 약수로 가질 수 있는 최대의 크기까지 모든 소수들의 배수를 false로 지정
        for(int i=2; i*i<=1000000; i++)
            if(is_prime[i])//만약 소수로 지정되어있다면
                for(int j=i*i; j<=1000000; j+=i)//i*i에서 시작하는 이유는 i*(i-n)일 경우 이미 (i-n)의 배수단에서 처리가 완료됨.
                    is_prime[j]=false;//i의 배수를 찾기 위해 직접 더해서 9 12 15등 수행. 곱하면 9 27 81이 되니 3배수를 다 못찾음.
    }
}