import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int get_prev_constructor(int num){
        /*

            정의를 다시 읽어봐라. 단순 자릿수 뺼셈이 아니라 self + self.split.sum() = next 인 구조다. 즉
            num보다 작은 수들 중 n+n.split.sum()이 num과 같은 수를 찾으면 된다.

            쉽게 생각하면 일단 0이 아닌 이상(조건에 N은 1이상), 생성자는 num보다 작다.
            1~num-1을 전부 반복하며 테스트 하는 방법이 있다.
            하지만 생성자는 특정 규칙성이 있을 것이라고 판단, 우선 위의 방식대로 구현하고
            생성자를 출력하여 규칙성을 찾아보자.

            1부터 입력 중인데 5의 생성자가 2로 나온다. 2의 분해합은 2+2로 4인데 왜?
            6의 생성자는 3으로 이해가 된다.
            9도 4가 나오는데 4+4=8인데..왜?
            10은 5 ok

            현재 홀수에 대해서 오류값이 발생하고 있는데, 분해합은 최소 자기 자신이 2번 나오기에
            애초에 홀수 num은 생성자가 존재하지 않는다. 속도 최적을 위해서 홀수일 경우 return 0하는 예외처리를 추가하자.
            오답처리된다. 생각을 좀 더 해보니 자기자신*2생각하면 짝수인게 맞지만 자리수 중 홀수가 홀수개 있으면 홀수값도 생성자를 가질 수 있다.

            왜 짝수로직에서 문제의 조건을 처리하지 못하는지, 그리고 백준에선 왜 정답처리 했는지를 ai에게 검토요청하자.

            1. 효율성 최적화
            N은 최대 1,000,000이며, 각 자리수의 합이 최대일 때 999,999 9*6=54이다.
            즉, 생성자는 아무리 작아도 N-54보다는 크다.

            2. 5, 9 생성자 오류
            웹 컴파일러 오류. 재실행하니 안뜸.
        */
        int MAX_SUM = 53;
        for(int i=num-MAX_SUM; i<num; i++){
            int result = i;
            int var;
            for(var = i; var>0; var/=10)
                result += var%10;
            if(result == num)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        /*
            N의 생성자 M : M+M의 각 자리수 합이 N인 경우
            245의 분해합은 245+2+4+5 = 256, 245는 256의 생성자.
            생성자가 존재하지 않거나, 여러개인 자연수도 존재.

            N이 주어졌을때 생성자 중 가장 작은 값을 계산.
            생성자가 없을 경우 0출력

            각 자리수를 역으로 빼면서 최소의 생성자를 계산.
            입력은 1,000,000까지의 자연수 범위이니 int로 해결 가능.
            각 자리수를 빼서 생성자로 만드는 작업을 별도의 함수로 분리.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(get_prev_constructor(input)));
        bw.flush();
        bw.close();
        br.close();
    }
}