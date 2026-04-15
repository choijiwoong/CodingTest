import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            두 수 사이의 소수 모두 구하기 문제. 수는 1이상 1,000,000이하.
            마찬가지로 ~3까지 예외처리하고 홀수에 한해서 i*i<=cand 유무 확인하자.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        for(int num=m; num<=n; num++){
            if(num<2)
                continue;
            if(num==2 || num==3){
                bw.write(String.valueOf(num));
                bw.newLine();
            } else if(is_prime(num)){
                bw.write(String.valueOf(num));
                bw.newLine();
                //현재 범위가 홀수면 +2하여 다음 홀수로 이동. 최적화.
                if(num%2!=0)
                    num++;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean is_prime(int num){
        boolean result = true;
        for(int i=2; i*i<=num; i++)
            if(num%i==0)
                result=false;
        return result;
    }
}