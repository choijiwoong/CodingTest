import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            양의 정수 n 4,000,000,000 40억이 주어졌을 때 n보다 크거나 같은 소수 중 가장 작은 소수를 찾자.
            unsigned int로 될 듯 하지만 안전하게 long 사용하자.

            첫째줄엔 TC 개수가 주어진다.
            +1부터 하나하나 확인하는 방법도 있지만 Collections을 활용할까 생각하니 40억개를 다 담긴 어차피 어렵다.
            최대한 빠르게 소수를 찾으라는 얘기로 보인다. 일반적인 접근으로는 해결이 안될 듯 하다! 정답  비율이 매우 낮다
            어쩌면 이전의 값을 저장하는게 나을 수도 있다. 어차피 다음 소수를 찾자마자 끝나니.

            하지만, 만약 이전 값을 저장한다고 해도 tc+1값이 아닌 이상 어차피 탐색해야한다.
            즉 이 문제는 그냥 소수를 최대한 효율적으로 찾는 문제이다.
            이전에 뭔가 기억상에 어렴풋이 sqrt(tc)까지만 탐색하면 되는거로 기억하는데 검토해보자.
            10이 소수인가?를 보기 위해 sqrt(10)은 약 3.3~이다.2에서 이미 아니라는게 나오긴하는데 좀 그렇다.
            ! 약수의 개수! 소수인가를 보기 위해 for i 1..n을 보기보다 약수를 구하는 방법을 이미 알고있다.
            mod를 활용하면 된다. 지금까지 직접적으로 유클리드 호제를 사용하지 않았지만 이를 활용해보자.
            최적화를 위해 약수가 1그리고 자기자신 외에 뭐가 더 있다면 바로 아니라도 판단할 수 있다.
            이는 for보다 훨씬 효율적일 것이다. 거의 O(logN)급일 것 같다는 직관적인 생각.
            그렇다면 일단 약수를 계산하되, 그 과정에서 prime인지 아닌지를 즉각적으로 반환하는 함수를 이용하면 된다.
            그리고 일단 정수가 0~이기에 0~2까지는 고정으로 2를 반환하게 하여 zero division방지 겸 하자.

            코딩하다보니 유클리드 호제법은 두 수의 최대공약수를 구하는 공식이다.
            일반 약수는 좀 변형해야할듯 한데..
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        while(n-->0){
            long num = Long.parseLong(br.readLine());
            long cand;
            for(cand = num; is_prime(cand); cand++){}
            bw.write(String.valueOf(cand));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean is_prime(long cand){

    }
}