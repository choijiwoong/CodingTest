import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            숫자의 각 자리수를 분해하여 정리하자.
            수는 1,000,000,000으로 10억. int범위는 벗어나기에 String형식으로 분해해서 처리하자
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] num = br.readLine().toCharArray();
        int n = num.length;

        StringBuilder sb = new StringBuilder();
        Arrays.sort(num);
        for(int i=n-1; i>=0; i--)
            sb.append(num[i]);
        System.out.println(sb.toString());
        br.close();
    }
}