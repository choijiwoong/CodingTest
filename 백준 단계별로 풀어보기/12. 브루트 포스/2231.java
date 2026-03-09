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
        */
        for(int i=1; i<num-1; i++){
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