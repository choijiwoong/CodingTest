import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        int day;
        if (a==v)//안하면 아래 division by zero뜸.
            day=1;
        else
            day = (v-a + a-b -1)/(a-b)+1;
        //day = ((v-a)/(a-b)<1?1:(v-a)/(a-b) )+1;
        // 현재의 방식은 마지막 결정의 날을 +1로 빼고, 범용적으로 접근해본 식이다.
        // 다만, (v-a)/(a-b)즉, 하루 전체에 올라가는 값이 1보다 작은 경우 즉 나머지가 있는경우
        // 버리고 있는데, 이 부분에서 모순이 발생한다.
        // 마지막 날 + 즉, 도달하는 날을 제외하고도 나머지가 있기에 실질적으로 하루가 더 필요한 것이다.
        // 그런데, 그래서 그런 경우에 싸잡아서 하루를 더해줬었다.그래서 어차피 1보다 작으니 1을 한거다.
        // 놓친 부분은 3.3처럼 1보다 큰데 나머지가 발생한 경우이다. 근데 그런 경우를 위해서 +1을 했지만
        // 뭐가 문제노? ㅇㅎ 마지막날 하루를 고려해서 싸잡아 하루를 더했다 치더라도, 소수점이
        // 남은건 그대로기 때문에 어차피 하루가 더 필요하다! 이미 마지막에 딱 하루 남도록 v-a했기에
        // +1일이 완충 역활을 해주지 못한다.
        // 올림은 정수연산으로 빠르게 하기 위해 a/b를 (a+b-1)/b로 표현이 가능하다.
        // 나머지가 없는 경우 몫+1-1/b은 몫
        // 나머지가 있는 경우 몫+나머지소수+1-1/b==몫+1+나머지소수-1/b에서 나머지 소수가 1/b보다 작다면?
        // 나머지 분수는 최소 1/b이상이다. 그래서 이를 빼줌.

        System.out.println(day);
        br.close();
    }
}