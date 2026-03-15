import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            연립방정식 풀기. 유일해 존재. 입력은 -900~+900.
            x = (c-by)/a (a==0제외)
            y = (f-dx)/e (e==0제외)
            x = {c-b(f-dx)/e}/a
            x = (c-bf+dbx)/e/a
            eax = c-bf+bdx
            (ea-bd)x = c-bf
            x = (c-bf)/(ea-bd)
            y = {f-d(c-bf)/(ea-bd)}/e

            만약 a==0 && e==0이라면?
            by = c
            y = c/b
            dx = f
            x = f/d

            만약 a==0 && e!=0이면?
            y=c/b
            x = 0

            만약 a!=0 && e==0이면?
            x = f/d
            y = 0

            예제입력 2에서 오류가 나는데, 검토 결과 접근법은 이상이 없다.
            정수형 처리일지라도 처리 과정에서 실수가 필요할 수 있으니 int으로 전부 변경하자.
            그러니까 -2.73, 0.69나온다. 우선 계산 과정에서 int을 도입한 건 좋아보이지만 해가 근사치도 나오지 않는다.

            수기로 작성해보니 수많은 모든 나머지 과정에서 분모가 0이 되는 경우를 고려하기 어렵다.
            brute force하자. 범위 1800이니

            이중 반복문에서는 break 범위도 조심하기.

            AI 피드백:
            정답 변수를 별도의 변수로 빼고, 내부 iterator용 변수랑 분리하는 것이 좋다.
            이유는 현재 조건에서는 유일해가 존재하지만 만약 그렇지 않은 경우 x와 y는 범위 초과 값인 1000이 되며,
            uninitialized된 변수임으로 바로 문제상황을 알 수 있다. 즉, 예외나 에러 발생 시 조금이라도 인지할 수 있는가? 의 습관임.

            그리고 이 문제를 bruteforce로 해야하는 이유가 내가 위의 다항식에서 생각한
            zerodivision에러와 같은 경우가 굉장히 까다롭다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int MAX=999;
        int x=-MAX,y=-MAX;
        boolean result = false;
        for(x=-MAX; x<=MAX; x++){
            for(y=-MAX; y<=MAX; y++){
                result = (a*x+b*y==c) && (d*x+e*y==f);
                if(result)
                    break;
            }
            if(result)
                break;
        }

        bw.write(String.valueOf(x));
        bw.write(" ");
        bw.write(String.valueOf(y));
        bw.flush();
        bw.close();
        br.close();
    }
}