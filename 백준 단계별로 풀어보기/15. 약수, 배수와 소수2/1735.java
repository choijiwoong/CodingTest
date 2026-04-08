import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            분수가 들어오면 합을 계산.
            분모는 최소공배수. 30,000이하 자연수

            틀려서 확인해보니, 기약분수가 아닌 형태로 입력되면 마찬가지로 기약분수가 아닌 값이 나온다.
            결과 분모 분자의 최대공약수를 또 구하고 나눠야 하는건가..

            또틀렸네?? 도저히 모르겠다. 확인해보니 현재 최대공약수를 구하는 로직이 잘못되었다.
            gemini도 효율성은 높일 수 있지만(역순탐색 or 유클리드호제_나머지 재귀) 틀린게 없다고 한다.

            와 이거 gemini도 오류를 못찾고있다.. 와 GPT가 찾아줬다. 문제는 범위이다........
            30,000 자연수라고 간과했는데
            최소공배수를 찾고 이를 분자랑 곱하면 최악의 경우 30,000 * 30,000 * 30,000이 되어 9,000,000,000,000 90억이 된다.
            오류를 못찾은 이유는 작은 수의 case대입으론 발견되지 못하는 범위문제일 뿐 더러, 두 수의 곱 최소공배수를
            measure등의 변수로 지정하고 다시 곱하다보니 단순 두 수의 곱으로 보였기에 찾기 굉장히 어려웠다.. 반성할 포인트가 많은 문제이다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력값 추출
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numerator1 = Integer.parseInt(st.nextToken());
        int denominator1 = Integer.parseInt(st.nextToken());
        // 조심 자원 재활용은 우선 하지 말고 코드 다 하고 재활용 시도하자.
        st = new StringTokenizer(br.readLine());
        int numerator2 = Integer.parseInt(st.nextToken());
        int denominator2 = Integer.parseInt(st.nextToken());

        // 2. 공통분모를 찾기 위한 최소공배수 계산
        int max, min;
        if(denominator1>denominator2){
            max=denominator1;
            min=denominator2;
        } else{
            max=denominator2;
            min=denominator1;
        }

        long max_measure=1;
        for(int i=min; i>=1; i--){
            if(max%i==0 && min%i==0){
                max_measure=i;
                break;
            }
        }
        long min_common_multiple = max*min/max_measure;

        // 3. 최소공배수를 이용한 분수의 합 계산
        // 잘 실수하네.. 최대공약수를 그냥 나누는게 아니라 자기 분모로 나눈 나머지 값을 분자에 각각 곱해야한다..
        // 수학공식 type해서라도 수식화 하고 변수로 작성하는게 나을듯.
        long numerator3 = numerator1*min_common_multiple/denominator1+numerator2*min_common_multiple/denominator2;
        long denominator3 = min_common_multiple;

        // 4. 기약분수로 약분 계산
        long min2= numerator3<denominator3?numerator3:denominator3;
        max_measure=1;
        for(long i=min2; i>=1; i--){
            if(numerator3%i==0 && denominator3%i==0){
                max_measure = i;
                break;
            }
        }
        numerator3/=max_measure;
        denominator3/=max_measure;

        // 5. 결과 출력
        bw.write(String.valueOf(numerator3));
        bw.write(" ");
        bw.write(String.valueOf(denominator3));

        bw.flush();
        bw.close();
        br.close();
    }
}