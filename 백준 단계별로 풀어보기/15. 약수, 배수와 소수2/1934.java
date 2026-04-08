import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            A와 B의 최소공배수 구하기. 여러 줄 입력. 케이스는 10,000개까지, 수는 45,000까지.
            최소공배수의 최대는 두 수의 곱.
            최소공배수의 최소는 두 수 중 하나.
            그 사이의 규칙은 소수들의 곱.
            a<b라면 a에 곱해서 b보다 작은 소수들을 시도하면 될 듯 하다.
            여러 줄이 입력될 거라면, 입력수의 최댓값이 45,000이니 그 사이의 소수를 미리 저장해두는게 효율적이다.
            잠시 생각해보자. 만약 최악의 경우로 45,000 x 44,999라면 2,024,955,000 20억. int로 처리 가능하다.

            그런데 정말 45000까지의 소수를 전부 저장하는게 최선일까? 시간제한이 1분이니
            조금 규칙성을 도출해보자.

            2 14 일 경우 단순 곱은 28. 큰수를 작은수로 나눈 몫은 7. 큰수를 7로 나누면 2. 곱을 2로 나누면 14
            3 15 일 경우 단순 곱은 45. 큰수를 작은수로 나눈 몫은 5. 큰수를 5로 나누면 3. 곱을 3으로 나누면 15
            3 7 일 경우 단순 곱은 21. 큰수를 작은수로 나누면 몫이 2.33333... 그냥 곱 21
            12 15일 경우 단순 곱은 180. 큰수를 작은 수로 나누면 몫이 1.25. 곱을 1.25로 나누면 144
            규칙성을 찾기 굉장히 힘들다. 기껏해야 1인 경우 큰수로 만드는 처리만 가능할 듯.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 소수 풀 제작
        // int MAX = 45000;
        // int[] primes = new int[MAX/2];//대략적 소수 분포 추정
        // int prime_idx=0;
        // for(int i=2; i<MAX; i++){
        //     int measure_count=0;
        //     for(int j=1; j<=i; j++)
        //         if(measure_count%j==0)
        //             measure_count++;
        //     if(measure_count==2)
        //         primes[prime_idx++]=i;
        // }

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //2. a>b
            int tmp;
            if(a<b){
                tmp=a;
                a=b;
                b=tmp;
            }

            //3. 1처리
            int result;
            if(b==1){
                // case 1 해결
                result=a;
            } else{
                /*
                    생각보다 어렵네
                    사실 단순 b * 소수로 a가 만들어진다면 이상적이지만
                    쉽게 접근하지 못하는 이유는 a*소수1 == b*소수2인 경우이다.
                    일단 a>b이기에 b*소수로 a가 되는 경우를 나누고
                    안되면 서로 어차피 곱해지는 수가 상대방보다 작아야 최소 공배수이니 나누어 접근하자.

                    혹은 오히려 두 수의 곱에서 시작해서 소수를 나누며 둘 다 나눠지는 수를 찾으면 어떨까?
                    a와 같아질 때 까지.
                    즉 12 15이면 180에서 시작해서 2로 나누면 90(충족x) 3으로 나누면 60충족. 5로 나누면 36,
                    아 이것도 어렵다악..

                    TDD 방식으로 접근해보자. 우선 예제부터 해결하자.
                */
                // case 2 두 수의 곱을 최대공약수로 나누기
                // 최대 공약수 계산
                int max_measure=1;
                for(int j=2; j<=b; j++)
                    if(a%j==0 && b%j==0)
                        max_measure = j;
                // 최소 공배수 계산
                result = a*b/max_measure;
            }
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}