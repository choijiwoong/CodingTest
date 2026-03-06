import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        /*
            양의정수씌여진 카드 N개에서 3개를 골라서 합 M이하 최댓값 만들기.
            합의 범위는 최대 300,000으로 int범위로 가능
            3장으로 조건을 만족하는 경우가 있는 입력만 케이스.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            cards[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cards);
        //일단 원소 중 M을 넘는 수는 불필요.
    }
}