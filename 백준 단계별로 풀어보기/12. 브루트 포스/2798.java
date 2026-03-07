import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
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
        int SIZE = 3;
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            cards[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cards);
        //일단 원소 중 M을 넘는 수는 불필요.
        //1~M까지의 카드 중 3장을 모두 골랐을 때 최대 값이 되는 합을 출력.
        //3중 for을 쓸건데, 만약 3개원소 뿐이라면 필히 그 합이 답이 된다.

        int result=0, sum=0;

        if(N==SIZE){
            result = cards[0] + cards[1] + cards[2];
        } else{
            for(int i=0; i<N-2; i++){
                for(int j=i+1; j<N-1; j++){
                    for(int k=j+1; k<N; k++){
                        sum = cards[i]+cards[j]+cards[k];
                        if(sum>M){
                            break;
                        } else if(sum>result){
                            result = sum;
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}