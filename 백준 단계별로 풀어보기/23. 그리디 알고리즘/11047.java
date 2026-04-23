import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            N종류 동전의 합을 K로 만들 때 최소로 필요한 개수. 각 동전 개수 제한은 없다.
            1차원적으로 가장 큰 금액의 동전을 먼저 사용하고 나머지를 챙기면 된다.
        */
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());
        for(int i=0; i<n; i++)
            heap.offer(Integer.parseInt(br.readLine()));

        int num = 0;
        for(int i=0; i<n; i++){
            int coin = heap.poll();
            num+=k/coin;
            k%=coin;
        }
        System.out.println(num);
        br.close();
    }
}