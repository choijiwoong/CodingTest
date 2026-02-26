import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
       /*
         MenOfPassion알고리즘은 나누고, 배열 탐색의 연산을 수행한다.
         큰 수가 아니라면 나누는 경우 O(1), 배열탐색은 비정렬 배열에서 O(n)이다.
         시간복잡도는 반복적인 작업을 효율적으로 처리하는 것이다.
         문제에서 반복적으로 men_of_passion을 수행한다고 직접적인 설명은 안되어있지만,
         그렇게 이해하면 예제 입출력을 이해할 수 있다.
         n == 1 일때 함수는 1회 실행되기에 첫째줄에 1이 된다.
         복잡도는 O(n+1)이지만 최고차항 차수가 의미하는 것은 아닌  것 같다.
         문제에서 요구하는 것은 수행횟수를 다항식으로 나타내고, 최고차항의 차수.
         수행횟수는 n이 자연수일 때 2분법적으로 감소하기에 재귀호출로 카운트가 가능하나,
         필요한 것은 다항식이다. n에 /2를 하다가 0이 될때 까지의 횟수를 어떻게 다항식으로 나타낼 수 있을까?
         규칙이 바로 생각이 안나니 얘를 들어보자.
         n==1, 1/2=0 (1회)
         n==2, 2/2=1, 1/2=0 (2회)
         n==3, 3/2=1, 1/2=0 (2회)
         n==4, 4/2=2, 2/2=1, 1/2=0 (3회)
         n==5, 5/2=2, 2/2=1, 1/2=0 (3회)
         n==6, 6/2=3, 3/2=1, 1/2=0 (3회)
         n==7, 7/2=3, 3/2=1, 1/2=0 (3회)
         n==8, 8/2=4, 4/2=2, 2/2=1, 1/2=0 (4회)

         2^1이상이면 2회
         2^2이상이면 3회
         2^3이상이면 4회
         2^k이상이면 k+1회

         n개의 배열이 주어졌을 때 n이 2^k이상이며 2^(k+1)미만일 때 실행횟수는 k+1번이다.
         2^k<=n<2^(k+1)일 때, 실행횟수는 k+1

         근데 문제에서 요구하는 다항식과 차수는 x^2이런 식을 의미하는 것 같은데..

         질문게시판을 보고 힌트를 얻었다. 재귀호출이 아닌 문제 그대로의 O(n+1)이라는 것이다.
         그렇다면 수행횟수는.. n이 몇이던간에 1이 되고 수행횟수는 상수이기에 그냥 0이 되는건가?

        */
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int input = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("1");
        bw.newLine();
        bw.write("0");
        bw.flush();
        bw.close();
    }
}