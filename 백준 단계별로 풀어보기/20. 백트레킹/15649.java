import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            N과 M이 있을 때, 1부터 N까지 자연수 중 중복없이 M개를 고른 모든 수열을 출력.
            수열은 오름차순으로 출력.
            1~N까지 중 M개 중복없이 고른 경우.

            직관적으로 바로 M번의 반복문이 생각나지만 일반적인 방식으론 불가능하다. 이게 백트레킹이라 부르는거구나.
            컴공시절을 생각해보자. 어떻게 해결했지? 핵심은 M개를 고르는 것이다. 사실 난 이런경우 다 쌩까고 for로 풀긴했었다. 하지만 어케했는지 기억안남.

            인덱스의 조합으로 생각을 해볼까 M개의 int배열로 각 숫자를 가리킴.
            오름차순 정렬 및 중복을 피하며 뒤에서부터 ++하며 조합의 경우를 출력.
            이 방법도 어떻게든 푸는 것이니 시도해보자. 조금 어렵다.... 나 과거에 배열 고수였구나.
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //m개의 숫자를 동시컨트롤해야한다.
        int[] num = new int[m];
        for(int i=0; i<m; i++)
            num[i]=i+1;
        //중복안되게 기본 초기값 1, 2, 3, ... , m 세팅 완료.

        // 반복문 설계: 맨 첫자리는 n-m번 반복해서 움직여야 한다. 첫자리가 움직이면 나머지도 전부 +1되야한다.
        // 맨 뒷자리가 n을 초과하는 타이밍이 그 앞자리를 움직일 때다.


    }
}