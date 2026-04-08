import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            딱 두 수가 한줄에 입력된다. 최소공배수를 구하면 된다.
            둘 다 1000 보다 작거나, 1000보다 크고 100,000,000 1억보다 작다.
            문제에서 큰 수 입력에 대해 변수를 64비트 정수. java에서 long을 사용하라고 명시되어있다.
            아하! 얼핏보면 int로 처리될 듯 하지만 두 수를 곱하는 순간 long이 필요해진다.
            역시 하라는 대로 해야한다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // swap
        long tmp;
        if(a<b){
            tmp=a;
            a=b;
            b=tmp;
        }

        int max_measure=1;
        for(int i=2; i<=b; i++)
            if(a%i==0 && b%i==0)
                max_measure=i;

        bw.write(String.valueOf(a*b/max_measure));

        bw.flush();
        bw.close();
        br.close();
    }
}