import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력값 추출 (계산 과정의 안전을 위해 처음부터 long으로 받음)
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n1 = Long.parseLong(st.nextToken());
        long d1 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long n2 = Long.parseLong(st.nextToken());
        long d2 = Long.parseLong(st.nextToken());

        //2. 분모의 최대공약수(GCD) 계산
        long gcd1 = getGCD(d1, d2);
        //3. 최소공배수(LCM) 계산. 순서는 상관없음
        long lcm = (d1/gcd1)*d2; // d1*d2/gcd로 하면 수가 더 커지니 안정성을 위해 교환법칙되면 나누기부터.

        //4. 분모분자 합 계산
        long finalNumerator = n1*(lcm/d1)+n2*(lcm/d2);
        long finalDenominator = lcm;

        //5. 기약분수 만들기
        long gcd2 = getGCD(finalNumerator, finalDenominator);
        finalNumerator/=gcd2;
        finalDenominator/=gcd2;

        bw.write(finalNumerator+" "+finalDenominator);

        bw.flush();
        bw.close();
        br.close();
    }

    public static long getGCD(long a, long b){
        //최대공약수 구하기. 유클리드 호제법. 두 수를 나눈 나머지만 이용하여 계산.
        while(b!=0){
            long r = a%b;
            a=b;
            b=r;
        }
        return a;
    }
}